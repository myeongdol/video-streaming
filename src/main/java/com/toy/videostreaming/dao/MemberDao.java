package com.toy.videostreaming.dao;

import com.toy.videostreaming.code.MemberPermit;
import com.toy.videostreaming.domain.Member;
import com.toy.videostreaming.support.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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
                new Object[]{id, pw},
                new RowMapper<Member>() {
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member mem = new Member();
                        mem.setMemId(rs.getString("id"));
                        mem.setMemName(rs.getString("name"));
                        mem.setMemEmail(rs.getString("email"));
                        return mem;
                    }
                });
    }

    public List<Member> selectList(Pager pager) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM member ORDER BY id desc Limit ?, ?");

        return template.query(queryBuilder.toString(), new Object[]{pager.getStart(), pager.getPagePerCount()}, new MemberMapper());
    }

    public int selectCount() {
        return template.queryForObject("SELECT count(*) FROM member", int.class);
    }

    public int selectCountById(String id) {
        return template.queryForObject("SELECT count(*) FROM member where id = ?", new Object[]{id}, int.class);
    }

    public Member getOneById(String id) {
        return template.queryForObject(
                "select * from member where id=?",
                new Object[]{id},
                new RowMapper<Member>() {
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member m = new Member();
                        m.setMemId(rs.getString("id"));
                        m.setMemPw(rs.getString("password"));
                        m.setMemName(rs.getString("name"));
                        m.setMemEmail(rs.getString("email"));
                        m.setActiveStatus(rs.getString("active_status"));
                        Timestamp loginTime = rs.getTimestamp("login_time");
                        m.setLastLoginTime(loginTime.toLocalDateTime());
                        m.setMemPermit(rs.getString("permit"));
                        return m;
                    }
                });
    }

    public int update(String activeStatus, MemberPermit permit, String memberId) {
        String SQL = "update member set active_status = ?, permit = ? where id = ?";
        return template.update(SQL, new Object[]{activeStatus, permit.name(), memberId});
    }

    public class MemberMapper implements RowMapper<Member> {
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member m = new Member();
            m.setMemId(rs.getString("id"));
            m.setMemPw(rs.getString("password"));
            m.setMemName(rs.getString("name"));
            m.setMemEmail(rs.getString("email"));
            m.setActiveStatus(rs.getString("active_status"));
            Timestamp loginTime = (Timestamp) rs.getTimestamp("login_time");
            m.setLastLoginTime(loginTime.toLocalDateTime());
            m.setMemPermit(rs.getString("permit"));
            return m;
        }
    }
}
