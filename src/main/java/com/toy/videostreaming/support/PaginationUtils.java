package com.toy.videostreaming.support;

import com.google.common.collect.Lists;

import java.util.List;

public class PaginationUtils {
    private final int DEFAULT_PAGE_PER_GROUP = 5;

    public boolean hasNext(int totalCount, int pagePerCount, int currentPage) {
        int pageGroupPerTotalCount = DEFAULT_PAGE_PER_GROUP * pagePerCount;
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        int currentGroupTotalCount = totalCount - (pageGroupPerTotalCount * currentGroup);
        if (currentGroupTotalCount > pageGroupPerTotalCount) {
            return true;
        }
        return false;
    }

    public boolean hasPrevious(int currentPage) {
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        if (currentGroup < 1) {
            return false;
        }
        return true;
    }

    public int nextGroupPage(int currentPage) {
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        return currentGroup * DEFAULT_PAGE_PER_GROUP;
    }

    public int previousGroupPage(int currentPage) {
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        return (currentGroup * DEFAULT_PAGE_PER_GROUP) - 1;
    }

    public List<Integer> pages(int totalCount, int pagePerCount, int currentPage) {
        if (totalCount <= 0) {
            return Lists.newArrayList();
        }
        List<Integer> pages = Lists.newArrayList();

        int pageGroupPerTotalCount = DEFAULT_PAGE_PER_GROUP * pagePerCount;
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        int currentGroupTotalCount = totalCount - (pageGroupPerTotalCount * currentGroup);
        int currentGroupMax = currentGroupTotalCount / DEFAULT_PAGE_PER_GROUP;

        for (int i = currentGroup; i <= currentGroupMax; i++) {
            pages.add(i);
        }

        return pages;
    }

}
