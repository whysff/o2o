package io.whysff.o2o.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
@Controller
@RequestMapping(value = "shopadmin", method = {RequestMethod.GET})
public class ShopAdminController {


    @RequestMapping("/shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping("/shoplist")
    public String shopList() {
        return "shop/shoplist";
    }

    @RequestMapping("/shopmanagement")
    public String shopManagement() {
        return "shop/shopmanagement";
    }

    @RequestMapping("/productcategorymanagement")
    public String productCategoryManagement() {
        return "shop/productcategorymanagement";
    }

    @RequestMapping("/productoperation")
    public String productOperation() {
        // 转发至商品添加编辑界面
        return "shop/productoperation";
    }

    @RequestMapping("/productmanagement")
    public String productManagement() {
        // 转发至商品管理页面
        return "shop/productmanagement";
    }
}
