package io.whysff.o2o.controller.frontend;

import io.whysff.o2o.dto.ProductExecution;
import io.whysff.o2o.entity.Product;
import io.whysff.o2o.entity.ProductCategory;
import io.whysff.o2o.entity.Shop;
import io.whysff.o2o.service.ProductCategoryService;
import io.whysff.o2o.service.ProductService;
import io.whysff.o2o.service.ShopService;
import io.whysff.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/21
 */
@Controller
@RequestMapping("/frontend")
public class ShopDetailController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 获取店铺信息以及该店铺下面的商品类别列表
     *
     * @param request
     * @return
     */
    @GetMapping("/listshopdetailpageinfo")
    @ResponseBody
    private Map<String, Object> listShopDetailPageInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        // 获取前台传过来的shopId
        long shopId = HttpServletRequestUtil.getLong(request, "shopId");
        Shop shop = null;
        List<ProductCategory> productCategoryList = null;
        if (shopId != -1) {
            shop = shopService.getByShopId(shopId);
            productCategoryList = productCategoryService.getProductCategoryList(shopId);
            modelMap.put("shop", shop);
            modelMap.put("productCategoryList", productCategoryList);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty shopId");
        }
        return modelMap;
    }

    /**
     * 依据查询条件分页列出该店铺下面的所有商品
     *
     * @param request
     * @return
     */
    @GetMapping("/listproductsbyshop")
    @ResponseBody
    private Map<String, Object> listProductsByShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        // 获取页码
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        // 获取一页 需要显示的条数
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        // 获取店铺Id
        long shopId = HttpServletRequestUtil.getLong(request, "shopId");

        if ((pageIndex > -1) && (pageSize > -1) && (shopId > -1)) {
            // 尝试获取商品类别Id
            long productCategoryId = HttpServletRequestUtil.getLong(request, "productCategoryId");
            // 模糊查询商品名
            String productName = HttpServletRequestUtil.getString(request, "productName");
            Product productCondition = compactProductCondition4Serach(shopId,productCategoryId,productName);
            // 按照传入的查询条件以及分页信息返回相应的商品列表以及总数
            ProductExecution pe = productService.getProductList(productCondition,pageIndex,pageSize);
            modelMap.put("productList", pe.getProductList());
            modelMap.put("count", pe.getCount());
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageIndex or pageSize or shopId");
        }
        return modelMap;
    }

    /**
     * 组合查询条件，并将条件封装到ProductCondition对象里返回
     *
     * @param shopId
     * @param productCategoryId
     * @param productName
     * @return
     */
    private Product compactProductCondition4Serach(long shopId, long productCategoryId, String productName) {
        Product productCondition = new Product();
        Shop shop = new Shop();
        shop.setShopId(shopId);
        productCondition.setShop(shop);

        if (productCategoryId != -1L) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductCategoryId(productCategoryId);
            productCondition.setProductCategory(productCategory);
        }
        if (productName != null) {
            productCondition.setProductName(productName);
        }

        productCondition.setEnableStatus(1);
        return productCondition;
    }
}
