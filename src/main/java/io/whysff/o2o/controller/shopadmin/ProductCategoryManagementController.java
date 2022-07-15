package io.whysff.o2o.controller.shopadmin;

import io.whysff.o2o.dao.ProductCategoryDao;
import io.whysff.o2o.dto.Result;
import io.whysff.o2o.entity.ProductCategory;
import io.whysff.o2o.entity.Shop;
import io.whysff.o2o.enums.ProductCategoryStateEnum;
import io.whysff.o2o.service.ProductCategoryService;
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
 * @create 2022/07/15
 */
@Controller
@RequestMapping("shopadmin")
public class ProductCategoryManagementController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/getproductcategorylist")
    @ResponseBody
    private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request)  {
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        List<ProductCategory> list = null;
        if (currentShop != null && currentShop.getShopId() > 0) {
            list = productCategoryService.getProductCategoryList(currentShop.getShopId());
            return new Result<List<ProductCategory>>(true,list);
        } else {
            ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
            return new Result<List<ProductCategory>>(false, ps.getState(), ps.getStateInfo());
        }
    }
}
