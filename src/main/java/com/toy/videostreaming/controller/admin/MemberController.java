package com.toy.videostreaming.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "adminMemberController")
@RequestMapping("/admin-page/member")
public class MemberController {

    @GetMapping
    public String list() {
        return "admin/member/list";
    }
}
