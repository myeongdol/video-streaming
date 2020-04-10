package com.toy.videostreaming.dao;

import com.toy.videostreaming.domain.Board;
import com.toy.videostreaming.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<Board> selectAll() {
        List<Board> board = new ArrayList();

        List<Map<String,Object>> rows = template.queryForList(
                "SELECT * FROM board WHERE save_status='Y' ORDER BY save_time desc");

        for(Map row : rows) {
            Board ob = new Board();
            ob.setBoardNo((Integer)row.get("no"));
            ob.setVideoNo((Integer)row.get("video_no"));
            ob.setMemId((String)row.get("member_id"));
            ob.setTitle((String)row.get("title"));
            ob.setContents((String)row.get("contents"));
            ob.setSaveTime(((Timestamp)row.get("save_time")).toLocalDateTime());
            board.add(ob);
        }
        return board;
    }

    public Board selectOneByNo(int no) {
        return template.queryForObject(
                "SELECT * FROM board WHERE NO=?",
                new Object[]{no},
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();
                        board.setBoardNo(rs.getInt("no"));
                        board.setVideoNo(rs.getInt("video_no"));
                        board.setMemId(rs.getString("member_id"));
                        board.setTitle(rs.getString("title"));
                        board.setContents(rs.getString("contents"));
                        return board;
                    }
                });
    }

    public int selectCount() {
        return template.queryForObject("SELECT count(*) FROM board", int.class);
    }
}
