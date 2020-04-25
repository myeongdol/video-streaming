package com.toy.videostreaming.controller.admin;

import com.toy.videostreaming.code.TemplateLayout;
import com.toy.videostreaming.domain.Site;
import com.toy.videostreaming.service.admin.SiteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller(value = "adminSiteController")
@RequestMapping("/admin-page/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @GetMapping
    public String index(Model model) {
        List<Site> siteInfos = siteService.findInfo();

        model.addAttribute("layoutList", TemplateLayout.layoutList());
        if (siteInfos.isEmpty() || siteInfos == null) {
            return "admin/site/index";
        }

        Site info = siteInfos.get(0);
        model.addAttribute("info", info);
        return "admin/site/index";
    }

    @PostMapping("/update")
    public String updateAction(Site site) {
        if (StringUtils.isNotBlank(site.getJoinStatus()) || StringUtils.isNotBlank(site.getLayoutType())) {
            siteService.update(site);
        }
        return "redirect:/admin-page/site";
    }
}
