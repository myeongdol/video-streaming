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
        int rs = dao.insert(member);
        return rs;
    }

    public Member getMemberInfo(String id, String pw) {
        Member memberInfo = dao.getOneById(id,pw);

        if(memberInfo == null) {
            System.out.print("로그인 실패");
            return null;
        }
        System.out.print("로그인 성공");

        return memberInfo;
    }
}
