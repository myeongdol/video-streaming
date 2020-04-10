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
            <th>Member Id</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="board" items="${boardList}">
            <tr>
              <td>${board.boardNo}</td>
              <td>${board.videoNo}</td>
              <td>${board.title}</td>
              <td>${board.memId}</td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
    <div class=" text-center">
        <ul class="pagination">
          <li><a href="#">&lt;</a></li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li><a href="#">&gt;</a></li>
        </ul>
    </div>
</div>

<%@ include file = "../layout/bottom.jsp" %>
