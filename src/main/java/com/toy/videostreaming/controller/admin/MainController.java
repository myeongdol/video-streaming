package com.toy.videostreaming.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "adminMainController")
@RequestMapping("/admin-page")
public class MainController {

    @GetMapping
    public String index() {
        return "admin/index";
    }
}
