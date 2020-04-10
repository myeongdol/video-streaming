package com.toy.videostreaming.service.admin;

import com.toy.videostreaming.dao.BoardDao;
import com.toy.videostreaming.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminBoardService")
public class BoardService {

    @Autowired
    BoardDao boardDao;

    public List<Board> listAll() {
        return boardDao.selectAll();
    }

    public Board getOne(int no) {
        return boardDao.selectOneByNo(no);
    }

    public int findCount() {
        return boardDao.selectCount();
    }
}
