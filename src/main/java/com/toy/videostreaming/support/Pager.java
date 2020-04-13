package com.toy.videostreaming.support;

public class Pager {
    int start;
    int pagePerCount;

    private final int DEFAULT_PAGE_PER_COUNT = 10;

    public Pager(int start) {
        this.start = start;
        this.pagePerCount = DEFAULT_PAGE_PER_COUNT;
    }

    public Pager(int start, int pagePerCount) {
        this.start = start;
        this.pagePerCount = pagePerCount;
    }

    public int getStart() {
        if (this.start <= 0) {
            return 0;
        }
        return this.start * this.pagePerCount + 1;
    }

    public int getPagePerCount() {
        return this.pagePerCount;
    }
}
