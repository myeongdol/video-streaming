package com.toy.videostreaming.support;

import com.google.common.collect.Lists;

import java.util.List;

public class PaginationUtils {
    private static final int DEFAULT_PAGE_PER_GROUP = 5;

    public static boolean hasNext(int totalCount, int pagePerCount, int currentPage) {
        int pageGroupPerTotalCount = DEFAULT_PAGE_PER_GROUP * pagePerCount;
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        int currentGroupTotalCount = totalCount - (pageGroupPerTotalCount * currentGroup);
        if (currentGroupTotalCount > pageGroupPerTotalCount) {
            return true;
        }
        return false;
    }

    public static boolean hasPrevious(int currentPage) {
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        if (currentGroup < 1) {
            return false;
        }
        return true;
    }

    public static int nextGroupPage(int currentPage) {
        int nextGroup = (currentPage / DEFAULT_PAGE_PER_GROUP) + 1;
        return nextGroup * DEFAULT_PAGE_PER_GROUP;
    }

    public static int previousGroupPage(int currentPage) {
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        return (currentGroup * DEFAULT_PAGE_PER_GROUP) - 1;
    }

    public static List<Integer> pages(int totalCount, int pagePerCount, int currentPage) {
        if (totalCount <= 0) {
            return Lists.newArrayList();
        }
        List<Integer> pages = Lists.newArrayList();

        int pageGroupPerTotalCount = DEFAULT_PAGE_PER_GROUP * pagePerCount;
        int currentGroup = currentPage / DEFAULT_PAGE_PER_GROUP;
        int remainTotalCount = totalCount - (pageGroupPerTotalCount * currentGroup);

        int currentGroupMaxPage = 1;
        if (remainTotalCount > pageGroupPerTotalCount) {
            currentGroupMaxPage = DEFAULT_PAGE_PER_GROUP;
        } else {
            if ((remainTotalCount % pagePerCount) > 0) {
                currentGroupMaxPage = (remainTotalCount / pagePerCount) + 1;
            } else {
                currentGroupMaxPage = remainTotalCount / pagePerCount;
            }
        }

        for (int i = 0; i < currentGroupMaxPage; i++) {
            int pageNum = (currentGroup * DEFAULT_PAGE_PER_GROUP) + i;
            pages.add(pageNum);
        }

        return pages;
    }

}
