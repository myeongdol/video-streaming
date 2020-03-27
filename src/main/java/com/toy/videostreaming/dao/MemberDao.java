package com.toy.videostreaming.dao;

import com.toy.videostreaming.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
public class MemberDao {

    @Autowired
    private JdbcTemplate template;

    public int insert(Member member) {
        String sql = "insert into member(id,password,name,email,login_time) values(?,?,?,?,?)";
        return template.update(sql, member.getMemId(), member.getMemPw(), member.getMemName(), member.getMemEmail(), LocalDateTime.now());
    }

    public Member getOneById(String id, String pw) {
        return template.queryForObject(
                "select * from member where id=? and password=?",
                new Object[]{id,pw},
                new RowMapper<Member>() {
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member mem = new Member();
                        mem.setMemId(rs.getString("id"));
                        mem.setMemName(rs.getString("name"));
                        mem.setMemEmail(rs.getString("email"));
                        mem.setMemPermit(rs.getString("permit"));
                        return mem;
                    }
                });
    }

}
