package com.toy.videostreaming.support;

public class Pager {
    private int currentPage;
    private int pagePerCount;

    private final int DEFAULT_PAGE_PER_COUNT = 10;

    public Pager(int currentPage) {
        this.currentPage = currentPage;
        this.pagePerCount = DEFAULT_PAGE_PER_COUNT;
    }

    public Pager(int currentPage, int pagePerCount) {
        this.currentPage = currentPage;
        this.pagePerCount = pagePerCount;
    }

    public int getStart() {
        if (this.currentPage <= 0) {
            return 0;
        }
        return this.currentPage * this.pagePerCount;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getPagePerCount() {
        return this.pagePerCount;
    }
}
