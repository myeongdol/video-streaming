<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="grid-wrap">
    <ul class="grid swipe-down" id="grid">
        <li class="title-box">
            <h2><a href="/board/write">UPLOAD</a>YOUR VIDEO</h2>
        </li>
        <c:forEach var="naver" items="${naverResult}">
            <li><a onclick="popupNaver('${naver.link}');"><img src="${naver.img}"><h3>${naver.title}</h3></a></li>
        </c:forEach>

    </ul>
</section>