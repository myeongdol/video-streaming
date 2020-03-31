package com.toy.videostreaming.service;

import com.toy.videostreaming.dao.BoardDao;
import com.toy.videostreaming.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;

    public int add(Board board, int videoNo, String memId) {
        return boardDao.insert(board, videoNo, memId);
    }
}
