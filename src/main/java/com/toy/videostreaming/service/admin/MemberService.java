package com.toy.videostreaming.service.admin;

import com.toy.videostreaming.code.MemberPermit;
import com.toy.videostreaming.dao.MemberDao;
import com.toy.videostreaming.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminMemberService")
public class MemberService {

    @Autowired
    private MemberDao dao;

    public List<Member> findList() {
        return dao.selectList();
    }

    public int findCount() {
        return dao.selectCount();
    }

    public int update(String activeStatus, MemberPermit permit, String memberId) {
        return dao.update(activeStatus, permit, memberId);
    }

    public Member findOne(String memberId) {
        return dao.getOneById(memberId);
    }
}
