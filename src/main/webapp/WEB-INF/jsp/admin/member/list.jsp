<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "../layout/top.jsp" %>

<div class="col-sm-10 text-left">
    <h1>멤버 목록</h1>
    <hr>
    <p>${totalCount}개</p>
    <table class="table table-hover">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Active Status</th>
            <th>Permit</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="member" items="${memberList}">
            <tr>
              <td>
                <a href="/admin-page/member/detail/${member.memId}">${member.memId}</a>
              </td>
              <td>${member.memName}</td>
              <td>${member.memEmail}</td>
              <td>${member.activeStatus}</td>
              <td>${member.memPermit}</td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <%@ include file = "../layout/pagination.jsp" %>
    </div>
</div>

<%@ include file = "../layout/bottom.jsp" %>
