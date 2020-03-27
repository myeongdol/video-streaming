package com.toy.videostreaming.controller;

import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/action/login")
    public String loginAction(HttpServletRequest request, HttpSession session) {
        Member memberInfo = memberService.getMemberInfo(request.getParameter("memId"), request.getParameter("memPw"));

        session.setAttribute("memInfo", memberInfo);

        return "redirect:/";
    }

    @RequestMapping("/join")
    public String joinFrom() {
        return "join";
    }

    @RequestMapping("/mem/join")
    public String joinAction(Member member) {
        int result = memberService.addMember(member);

        return "hello";
    }

}
