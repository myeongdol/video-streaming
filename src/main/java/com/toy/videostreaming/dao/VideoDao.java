package com.toy.videostreaming.dao;

import com.toy.videostreaming.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;


@Repository
public class VideoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(Video video) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(
                        "insert into video(origin_file_name,extension,file_path,file_name,file_url) values(?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                        pstmt.setString(1,video.getOriginFileName());
                        pstmt.setString(2,video.getExtension());
                        pstmt.setString(3,video.getFilePath());
                        pstmt.setString(4,video.getFileName());
                        pstmt.setString(5,video.getFileUrl());
                return pstmt;
            }
        }, keyHolder);

        //video의 no값 리턴
        return keyHolder.getKey().intValue();
    }

    public Video selectOneByNo(int no) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM video WHERE NO=?",
                new Object[]{no},
                new RowMapper<Video>() {
                    @Override
                    public Video mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Video video = new Video();
                        video.setFileName(rs.getString("file_name"));
                        video.setFilePath(rs.getString("file_path"));
                        video.setExtension(rs.getString("extension"));
                        return video;
                    }
                });
    }
}
