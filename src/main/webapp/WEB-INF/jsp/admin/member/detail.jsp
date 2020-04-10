<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "../layout/top.jsp" %>

<div class="col-sm-10 text-left">
    <h1>${member.memId}님 상세정보</h1>
    <hr>
    <form action="/admin-page/member/edit/${member.memId}" method="POST">
        <ul class="list-group">
            <li class="list-group-item"><span class="info-label">ID</span> ${member.memId}</li>
            <li class="list-group-item"><span class="info-label">Name</span> ${member.memName}</li>
            <li class="list-group-item"><span class="info-label">Email</span> ${member.memEmail}</li>
            <li class="list-group-item">
                <span class="info-label">Status</span>
                <label class="radio-inline">
                    <input type="radio" name="activeStatus" value="Y" <c:if test='${member.activeStatus eq "Y"}' > checked </c:if>>Y
                </label>
                <label class="radio-inline">
                    <input type="radio" name="activeStatus" value="N" <c:if test='${member.activeStatus eq "N"}' > checked </c:if>> N
                </label>
            </li>
            <li class="list-group-item"><span class="info-label">Permit</span> ${member.memPermit}</li>
        </ul>
        <div class="text-right">
            <button type="submit" class="btn btn-primary">수정</button>
        </div>
    </form>
</div>

<%@ include file = "../layout/bottom.jsp" %>
