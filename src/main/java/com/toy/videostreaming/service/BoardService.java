package com.toy.videostreaming.service;

import com.toy.videostreaming.dao.BoardDao;
import com.toy.videostreaming.domain.Board;
import com.toy.videostreaming.domain.Video;
import com.toy.videostreaming.support.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;

    public int add(Board board, int videoNo, String memId) {
        return boardDao.insert(board, videoNo, memId);
    }

    public List<Board> listAll(String permit, Pager pager) {return boardDao.selectAll(permit, pager);}

    public List<Board> getListByTitle(String word) {return boardDao.selectListByTitle(word);}

    public Board getOne(int no) { return boardDao.selectOneByNo(no); }
}
