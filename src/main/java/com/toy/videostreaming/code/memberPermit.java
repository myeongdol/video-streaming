package com.toy.videostreaming.code;

public enum memberPermit {
    A("super admin"), B("board admin"), C("member admin");

    private String description;

    memberPermit(String description) {
        this.description = description;
    }
}
