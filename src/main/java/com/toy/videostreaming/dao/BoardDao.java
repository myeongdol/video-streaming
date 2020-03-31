package com.toy.videostreaming.dao;

import com.toy.videostreaming.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class BoardDao {

    @Autowired
    private JdbcTemplate template;

    public int insert(Board board, int videoNo, String memId) {
        return template.update(
                "insert into board(member_id,title,contents,save_time,video_no) values(?,?,?,?,?)",
                memId, board.getTitle(), board.getContents(), LocalDateTime.now(), videoNo
        );
    }
}
