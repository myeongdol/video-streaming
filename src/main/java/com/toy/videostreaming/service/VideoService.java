package com.toy.videostreaming.service;

import com.toy.videostreaming.dao.VideoDao;
import com.toy.videostreaming.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    VideoDao videoDao;

    public int add(Video video) {
        return videoDao.insert(video);
    }
    public Video getOne(int no) { return videoDao.selectOneByNo(no); }
}
