<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "top.jsp" %>

<div class="container">

    <form action="/mem/join" method="POST">

        <div class="input-group" style="width:80%;padding-top:1em;margin:auto;">
            <input type="text" class="form-control" name="memId" placeholder="아이디를 입력하세요.">
        </div>
        <div class="input-group" style="width:80%;padding-top:1em;margin:auto;">
            <input type="password" class="form-control" name="memPw" placeholder="비밀번호를 입력하세요.">
        </div>
        <div class="input-group" style="width:80%;padding-top:1em;margin:auto;">
            <input type="text" class="form-control" name="memName" placeholder="이름을 입력하세요.">
        </div>
        <div class="input-group" style="width:80%;padding-top:1em;margin:auto;">
            <input type="text" class="form-control" name="memEmail" placeholder="이메일을 입력하세요.">
        </div>

        <div style="width:10em;padding-top:2em;margin:auto;">
            <button type="submit" class="btn btn-outline-primary btn-lg">가입하기</button>
        </div>

    </form>

</div>

<%@ include file = "bottom.jsp" %>
