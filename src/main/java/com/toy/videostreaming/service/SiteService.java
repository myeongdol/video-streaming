package com.toy.videostreaming.service;

import com.toy.videostreaming.dao.SiteDao;
import com.toy.videostreaming.domain.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    @Autowired
    private SiteDao dao;

    public String findJoinStatus() {
        return dao.selectJoinStatus();
    }

    public String findLayoutType() {
        return dao.selectLayoutType();
    }
}
