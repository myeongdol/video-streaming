<%@ page import="com.toy.videostreaming.support.PaginationUtils" %>

<ul class="pagination">
    <c:choose>
        <c:when test="${PaginationUtils.hasPrevious(pager.currentPage)}">
            <li><a href="${pager.baseUrl}?p=${PaginationUtils.previousGroupPage(pager.currentPage)}">&lt;</a></li>
        </c:when>
        <c:otherwise>
            <li class="disabled"><a href="#">&lt;</a></li>
        </c:otherwise>
    </c:choose>

    <c:forEach var="item" items="${PaginationUtils.pages(totalCount, pager.pagePerCount, pager.currentPage)}">
        <li><a href="${pager.baseUrl}?p=${item}">${item + 1}</a></li>
    </c:forEach>

    <c:choose>
        <c:when test="${PaginationUtils.hasNext(totalCount, pager.pagePerCount, pager.currentPage)}">
            <li><a href="${pager.baseUrl}?p=${PaginationUtils.nextGroupPage(pager.currentPage)}">&gt;</a></li>
        </c:when>
        <c:otherwise>
            <li class="disabled"><a href="#">&gt;</a></li>
        </c:otherwise>
    </c:choose>
</ul>