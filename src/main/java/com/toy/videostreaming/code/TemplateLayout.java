package com.toy.videostreaming.code;

import com.google.common.collect.ImmutableList;

import java.util.List;

public enum TemplateLayout {
    right("swipe-right"), down("swipe-down"), rotate("swipe-rotate");

    private String detail;

    TemplateLayout(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return this.detail;
    }

    public static List<TemplateLayout> layoutList() {
        return ImmutableList.of(right, down, rotate);
    }
}
