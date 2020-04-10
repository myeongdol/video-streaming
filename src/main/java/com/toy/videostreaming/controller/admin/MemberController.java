package com.toy.videostreaming.controller.admin;

import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.service.admin.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller(value = "adminMemberController")
@RequestMapping("/admin-page/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public String list(Model model) {
        List<Member> memberList = memberService.findList();
        int totalCount = memberService.findCount();

        model.addAttribute("memberList", memberList);
        model.addAttribute("totalCount", totalCount);
        return "admin/member/list";
    }
}