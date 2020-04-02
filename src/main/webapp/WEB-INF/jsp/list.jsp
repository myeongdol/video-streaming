<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "top.jsp" %>

<div class="container">
    <div style="float:right;padding-right:2em;">
    <c:if test='${sessionScope.memInfo.memId eq null}' >
    <button type="button" class="btn btn-secondary" onclick="location.href='/login'">로그인</button>
    <button type="button" class="btn btn-primary" onclick="location.href='/join'">회원가입</button>
    </c:if>
    <c:if test='${sessionScope.memInfo.memId ne null}' >
    <u> ${sessionScope.memInfo.memName} </u>님 반갑습니다.
    <button type="button" class="btn btn-outline-secondary" onclick="location.href='/logout'">로그아웃</button>
    <button type="button" class="btn btn-outline-success" onclick="location.href='/board/write'">글쓰기</button>
    </c:if>
    </div>

    <section class="grid-wrap">
        <ul class="grid swipe-down" id="itemList">
            <li class="title-box">
                <h2>Pictures of Bill Murray</h2>
            </li>
            <c:forEach var="board" items="${boardList}">
                <li><a href=""><img src="/attach/${board.videoNo}" alt="img01"><h3>${board.title}</h3></a></li>
            </c:forEach>
        </ul>
    </section>
</div><!-- /container -->

<script src="resources/js/modernizr.js"></script>
<script src="resources/js/isotope.pkgd.min.js"></script>
<script src="resources/js/imagesloaded.pkgd.min.js"></script>
<script src="resources/js/colorfinder-1.1.js"></script>
<script src="resources/js/main.js"></script>

<%@ include file = "bottom.jsp" %>
