package com.toy.videostreaming.service;

import com.toy.videostreaming.dao.MemberDao;
import com.toy.videostreaming.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberDao dao;

    public String addMember(Member member) {
        dao.insert(member);
        return null;
    }
}
