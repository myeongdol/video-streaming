package com.toy.videostreaming.dao;

import com.toy.videostreaming.domain.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SiteDao {

    @Autowired
    private JdbcTemplate template;

    public List<Site> selectInfo() {
        List<Site> siteInfos = new ArrayList();
        List<Map<String,Object>> rows = template.queryForList("SELECT * FROM site");

        for(Map row : rows) {
            Site s = new Site();
            s.setLayoutType((String) row.get("layout_type"));
            s.setJoinStatus((String) row.get("join_status"));
            siteInfos.add(s);
        }
        return siteInfos;
    }

    public int updateInfo(Site site) {
        return template.update(
                "update site set join_status=?, layout_type=?",
                site.getJoinStatus(), site.getLayoutType()
        );
    }

    public String selectJoinStatus() {
        return template.queryForObject("SELECT join_status FROM site limit 0,1", String.class);
    }

    public String selectLayoutType() {
        return template.queryForObject("SELECT layout_type FROM site limit 0,1", String.class);
    }
}
