package com.toy.videostreaming.controller;

import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.service.MemberService;
import com.toy.videostreaming.service.SiteService;
import com.toy.videostreaming.support.MemberLogics;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private SiteService siteService;

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
        if(memberInfo == null) {
            logger.debug("로그인 실패");
            return "redirect:/";
        }
        logger.debug("로그인 성공");

        MemberLogics.setMemberInfo(session, memberInfo);
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        MemberLogics.removeMemberInfo(session);
        return "redirect:/";
    }

    @GetMapping("/join")
    public String joinFrom() {
        String joinStatus = siteService.findJoinStatus();
        if (StringUtils.equals(joinStatus, "N")) {
            return "redirect:/";
        }
        return "join";
    }

    @PostMapping("/mem/join")
    public String joinAction(Member member, Model model) {
        boolean duplicated = memberService.checkDuplicated(member.getMemId());
        if (duplicated) {
            model.addAttribute("responseMessage", "아이디 중복입니다.");
            return "redirect:/join";
        }
        int result = memberService.addMember(member);

        return "hello";
    }

}
