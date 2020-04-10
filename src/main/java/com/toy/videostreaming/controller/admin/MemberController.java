package com.toy.videostreaming.controller.admin;

import com.toy.videostreaming.code.MemberPermit;
import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.service.admin.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/detail/{memberId}")
    public String detail(@PathVariable("memberId") String memberId, Model model) {
        Member member = memberService.findOne(memberId);
        model.addAttribute("member", member);
        model.addAttribute("permitList", MemberPermit.permitList());
        return "admin/member/detail";
    }

    @PostMapping("/edit/{memberId}")
    public String editAction(@PathVariable("memberId") String memberId,
                             @RequestParam("activeStatus") String activeStatus,
                             @RequestParam("permit") MemberPermit permit,
                             Model model) {
        int result = memberService.update(activeStatus, permit, memberId);

        Member member = memberService.findOne(memberId);
        model.addAttribute("member", member);
        return "redirect:/admin-page/member/detail/" + memberId;
    }
}
