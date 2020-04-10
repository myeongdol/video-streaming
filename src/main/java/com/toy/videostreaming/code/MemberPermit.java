package com.toy.videostreaming.code;

import com.google.common.collect.ImmutableList;

import java.util.List;

public enum MemberPermit {
    A("super admin"), B("board admin"), C("member admin");

    private String description;

    MemberPermit(String description) {
        this.description = description;
    }

    public String getDesc() {
        return this.description;
    }

    public static List<MemberPermit> permitList() {
        return ImmutableList.of(A, B, C);
    }
}
