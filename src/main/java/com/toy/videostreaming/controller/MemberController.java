package com.toy.videostreaming.controller;

import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/join")
    public String joinForm() {
        return "join";
    }

    @RequestMapping("/mem/join")
    public String joinAction(Member member) {
        memberService.addMember(member);
        return "hello";
    }

}
