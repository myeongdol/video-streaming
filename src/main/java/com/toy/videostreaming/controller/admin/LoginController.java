package com.toy.videostreaming.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "adminLoginController")
@RequestMapping("/admin-page/login")
public class LoginController {

    @GetMapping
    public String index() {
        return "admin/login";
    }
}
