<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "../layout/top.jsp" %>

<div class="col-sm-10 text-left">
    <h1>비디오 목록</h1>
    <hr>
    <p>${totalCount}개</p>
    <table class="table table-hover">
        <thead>
          <tr>
            <th>No.</th>
            <th>Video No</th>
            <th>Title</th>
            <th>Writer</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="board" items="${boardList}">
            <tr>
              <td>${board.boardNo}</td>
              <td>${board.videoNo}</td>
              <td><a href="/admin-page/board/detail/${board.boardNo}">${board.title}</a></td>
              <td>${board.memId}</td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
    <div class=" text-center">
        <%@ include file = "../layout/pagination.jsp" %>
    </div>
</div>

<%@ include file = "../layout/bottom.jsp" %>
