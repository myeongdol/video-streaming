package com.toy.videostreaming.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "adminVideoController")
@RequestMapping("/admin-page/video")
public class VideoController {

    @GetMapping
    public String list() {
        return "admin/video/list";
    }
}
