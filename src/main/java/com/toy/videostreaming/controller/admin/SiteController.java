package com.toy.videostreaming.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "adminSiteController")
@RequestMapping("/admin-page/site")
public class SiteController {

    @GetMapping
    public String index() {
        return "admin/site/index";
    }
}
