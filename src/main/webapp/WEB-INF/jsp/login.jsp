<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "top.jsp" %>

<div class="container">
    <div class="input-group input-group-lg" style="width:60%;padding-top:2em;margin:auto;">
        <input type="text" class="form-control" name="memId" placeholder="아이디">
    </div>
    <div class="input-group input-group-lg" style="width:60%;padding-top:2em;margin:auto;">
        <input type="password" class="form-control" name="memPw" placeholder="비밀번호">
    </div>

    <div style="width:10em;padding-top:2em;margin:auto;">
        <button type="button" class="btn btn-outline-primary btn-lg" onclick="location.href='/action/login'">로그인</button>
    </div>
</div>

<%@ include file = "bottom.jsp" %>
