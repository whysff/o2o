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

    @GetMapping
    private String index() {
        return "frontend/index";
    }
}
