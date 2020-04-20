package com.toy.videostreaming.controller.admin;

import com.toy.videostreaming.code.MemberPermit;
import com.toy.videostreaming.domain.Board;
import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.service.admin.BoardService;
import com.toy.videostreaming.support.MemberLogics;
import com.toy.videostreaming.support.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller(value = "adminBoardController")
@RequestMapping("/admin-page/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    private final static String PAGE_BASE_URL = "/admin-page/board";

    @GetMapping
    public String list(Model model,
                       HttpSession session,
                       @RequestParam(value = "p", required = false, defaultValue = "0") int p ) {
        // 회원권한
        Member memberInfo = MemberLogics.getMemberInfo(session);
        String permit = memberInfo.getMemPermit();

        // 페이지
        Pager pager = new Pager(p, PAGE_BASE_URL);

        List<Board> boardList = boardService.listAll(permit,pager);
        int totalCount = boardService.findCount();

        model.addAttribute("boardList", boardList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pager);
        return "admin/board/list";
    }

    @GetMapping("/detail/{bno}")
    public String detail(@PathVariable("bno") int bno, Model model) {
        Board board = boardService.getOne(bno);
        model.addAttribute("board", board);
        return "admin/board/detail";
    }

    @PostMapping("/edit/{bno}")
    public String editAction(@PathVariable("bno") int bno,
                             @RequestParam("status") String status,
                             Model model) {
        int rs = boardService.updateStatus(bno,status);

        Board board = boardService.getOne(bno);
        model.addAttribute("board",board);
        return "redirect:/admin-page/board/detail/"+bno;
    }
}
