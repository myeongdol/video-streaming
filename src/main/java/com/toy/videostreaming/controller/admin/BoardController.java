package com.toy.videostreaming.controller.admin;

import com.toy.videostreaming.domain.Board;
import com.toy.videostreaming.service.admin.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller(value = "adminBoardController")
@RequestMapping("/admin-page/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public String list(Model model) {
        List<Board> boardList = boardService.listAll();
        int totalCount = boardService.findCount();

        model.addAttribute("boardList", boardList);
        model.addAttribute("totalCount", totalCount);
        return "admin/board/list";
    }
}
