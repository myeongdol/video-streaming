package com.toy.videostreaming.support;

import com.toy.videostreaming.domain.Member;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberLogics {

    private static final String MEMBER_SESSION_KEY = "__MEMBER_INFO";

    public static void setMemberInfo(HttpSession session, Member member) {
        session.setAttribute(MEMBER_SESSION_KEY, member);
    }

    public static Member getMemberInfo(HttpSession session) {
        return (Member) session.getAttribute(MEMBER_SESSION_KEY);
    }

    public static void removeMemberInfo(HttpSession session) {
        session.removeAttribute(MEMBER_SESSION_KEY);
    }
}
