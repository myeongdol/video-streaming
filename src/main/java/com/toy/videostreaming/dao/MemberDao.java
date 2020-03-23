package com.toy.videostreaming.dao;

import com.toy.videostreaming.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class MemberDao {

    @Autowired
    JdbcTemplate template;

    public int insert(Member member) {
        String sql = "insert into member(id,password,name,email,login_time) values(?,?,?,?,?)";
        return template.update(sql, member.getMemId(), member.getMemPw(), member.getMemName(), member.getMemEmail(), LocalDateTime.now());
    }

}
