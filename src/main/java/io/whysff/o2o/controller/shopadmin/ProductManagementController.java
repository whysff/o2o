package io.whysff.o2o.controller.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.whysff.o2o.dto.ImageHolder;
import io.whysff.o2o.dto.ProductExecution;
import io.whysff.o2o.entity.Product;
import io.whysff.o2o.entity.Shop;
import io.whysff.o2o.enums.ProductStateEnum;
import io.whysff.o2o.exceptions.ProductOperationException;
import io.whysff.o2o.service.ProductService;
import io.whysff.o2o.util.CodeUtil;
import io.whysff.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/19
 */
@Controller
@RequestMapping("/shopadmin")
public class ProductManagementController {

    @Autowired
    private ProductService productService;

    // 支持上传商品详情图的最大数量
    private static final int IMAGEMAXCOUNT = 6;

    @PostMapping("/addproduct")
    @ResponseBody
    private Map<String, Object> addProduct(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        // 验证码校验
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        // 接收前端参数的变量的初始化，包括商品、缩略图、详情图列表实体类
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        String productStr = HttpServletRequestUtil.getString(request, "productStr");
        MultipartHttpServletRequest multipartRequest = null;
        ImageHolder thumbnail = null;
        List<ImageHolder> productImgList = new ArrayList<>();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        try {
            // 若请求中存在文件流，则取出相关的文件（包括缩略图和详情图）
            if (multipartResolver.isMultipart(request)) {
                multipartRequest = (MultipartHttpServletRequest) request;
                // 取出缩略图并构建ImageHolder对象
                CommonsMultipartFile thumbnailFile = (CommonsMultipartFile) multipartRequest.getFile("thumbnail");
                thumbnail = new ImageHolder(thumbnailFile.getOriginalFilename(),thumbnailFile.getInputStream());
                // 取出详情图列表并构建List<ImageHolder>列表对象，最多支持上传6张图片
                for (int i = 0; i < IMAGEMAXCOUNT; i++) {
                    CommonsMultipartFile productImgFile = (CommonsMultipartFile) multipartRequest
                            .getFile("productImg" + i);
                    if (productImgFile != null) {
                        // 若取出的第 i 个详情图片文件流不为空，则将其加入详情图列表
                        ImageHolder productImg = new ImageHolder(productImgFile.getOriginalFilename(),
                                productImgFile.getInputStream());
                        productImgList.add(productImg);
                    } else {
                        // 若取出的第 i 个详情图片文件流为空，则终止循环
                        break;
                    }
                }
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "上传图片不能为空");
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }

        try {
            // 尝试和获取前端传过来的表单string流并将其转换成Product实体类
            product = mapper.readValue(productStr, Product.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        // 若Product信息、缩略图以及详情图列表为非空，则开始进行商品的添加操作
        if (product != null && thumbnail != null && productImgList.size() > 0) {
            try {
                // 从session中获取当前店铺的Id并赋值为product，钱少对前端数据的依赖
                Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
                product.setShop(currentShop);
                // 执行添加操作
                ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
                if (pe.getState() == ProductStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", pe.getStateInfo());
                }
            } catch (ProductOperationException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入商品信息");
        }
        return modelMap;
    }
}
