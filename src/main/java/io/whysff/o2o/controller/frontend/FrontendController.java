package io.whysff.o2o.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/20
 */
@Controller
@RequestMapping("/frontend")
public class FrontendController {

    /**
     * 前端展示系统首页路由
     *
     * @return
     */
    @GetMapping("/index")
    private String index() {
        return "frontend/index";
    }

    /**
     * 商店列表页路由
     *
     * @return
     */
    @GetMapping("/shoplist")
    private String shopList() {
        return "frontend/shoplist";
    }

    /**
     * 店铺详情页路由
     *
     * @return
     */
    @GetMapping("/shopdetail")
    private String shopDetail() {
        return "frontend/shopdetail";
    }

    /**
     * 商品详情页路由
     *
     * @return
     */
    @GetMapping("/productdetail")
    private String productDetail() {
        return "frontend/productdetail";
    }
}
