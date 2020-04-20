package com.toy.videostreaming.support;

public class Pager {
    private int currentPage;
    private int pagePerCount;
    private String baseUrl;

    private final int DEFAULT_PAGE_PER_COUNT = 10;

    public Pager(int currentPage, String baseUrl) {
        this.currentPage = currentPage;
        this.pagePerCount = DEFAULT_PAGE_PER_COUNT;
        this.baseUrl = baseUrl;
    }

    public Pager(int currentPage, int pagePerCount, String baseUrl) {
        this.currentPage = currentPage;
        this.pagePerCount = pagePerCount;
        this.baseUrl = baseUrl;
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

    public String getBaseUrl() {
        return this.baseUrl;
    }
}
