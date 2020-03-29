package com.toy.videostreaming.controller;

import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/action/login")
    public String loginAction(@RequestParam(name = "memId") String id,
                              @RequestParam(name = "memPw") String pw,
                              HttpSession session) {
        if (StringUtils.isBlank(id) && StringUtils.isBlank(pw)) {
            return "redirect:/login";
        }
        Member memberInfo = memberService.getMemberInfo(id, pw);

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
