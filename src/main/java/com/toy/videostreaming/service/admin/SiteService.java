package com.toy.videostreaming.service.admin;

import com.toy.videostreaming.dao.SiteDao;
import com.toy.videostreaming.domain.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminSiteService")
public class SiteService {

    @Autowired
    private SiteDao dao;

    public List<Site> findInfo() {
        return dao.selectInfo();
    }

    public int update(Site site) {
        return dao.updateInfo(site);
    }
}
