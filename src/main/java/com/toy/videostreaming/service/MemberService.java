package com.toy.videostreaming.service;

import com.toy.videostreaming.dao.MemberDao;
import com.toy.videostreaming.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {

    @Autowired
    private MemberDao dao;

    public int addMember(Member member) {
        return dao.insert(member);
    }

    public Member getMemberInfo(String id, String pw) {
        return dao.getOneById(id,pw);
    }

    public boolean checkDuplicated(String id) {
        return dao.selectCountById(id) > 0;
    }
}
