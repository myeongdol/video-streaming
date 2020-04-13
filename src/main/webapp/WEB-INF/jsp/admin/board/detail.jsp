<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.apache.commons.lang3.StringUtils" %>

<%@ include file = "../layout/top.jsp" %>

<div class="col-sm-10 text-left">
    <h1>No.${board.boardNo} 게시글 상세정보</h1>
    <hr>
    <form action="/admin-page/board/edit/${board.boardNo}" method="POST">
        <ul class="list-group">
            <li class="list-group-item"><span class="info-label">No</span> ${board.boardNo}</li>
            <li class="list-group-item"><span class="info-label">Video No</span> ${board.videoNo}</li>
            <li class="list-group-item"><span class="info-label">Title</span> ${board.title}</li>
            <li class="list-group-item"><span class="info-label">Contents</span> ${board.contents}</li>
            <li class="list-group-item"><span class="info-label">Writer</span> ${board.memId}</li>
            <li class="list-group-item"><span class="info-label">Save Time</span> ${board.saveTime}</li>
            <li class="list-group-item">
                            <span class="info-label">Status</span>
                            <label class="radio-inline">
                                <input type="radio" name="status" value="Y" <c:if test='${board.status eq "Y"}' > checked </c:if>>Y
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="status" value="N" <c:if test='${board.status eq "N"}' > checked </c:if>> N
                            </label>
                        </li>
            <li class="list-group-item">
                <video width="80%" controls>
                    <source type="video/mp4" src="/play/${board.boardNo}" />
                </video>
            </li>
        </ul>
        <div class="text-right">
            <a href="/admin-page/board" class="btn btn-default">목록</a>
            <button type="submit" class="btn btn-primary">수정</button>
        </div>
    </form>
</div>

<%@ include file = "../layout/bottom.jsp" %>
