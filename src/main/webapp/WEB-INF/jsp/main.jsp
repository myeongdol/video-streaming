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
    </c:if>
    </div>

    <section class="grid-wrap">
        <ul class="grid swipe-down" id="itemList">
            <li class="title-box">
                <h2>Pictures of Bill Murray</h2>
            </li>
            <li><a href="http://www.behance.net/gallery/15944679/Kenpo-News-April-2014-issue"><img src="//www.fillmurray.com/300/524" alt="img01"><h3>Kenpo News April 2014 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/15758125/SQUET-April-2014-issue"><img src="//www.fillmurray.com/300/343" alt="img02"><h3>SQUET April 2014 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/15586227/MONOCLE-issue-72"><img src="//www.fillmurray.com/300/306" alt="img03"><h3>MONOCLE issue 72</h3></a></li>
            <li><a href="http://www.behance.net/gallery/11880495/TOWN-Winter-2013"><img src="//www.fillmurray.com/300/400" alt="img04"><h3>TOWN Winter 2013</h3></a></li>
            <li><a href="http://www.behance.net/gallery/11455333/Quarterly-Musashino-autumn-of-2013-issue"><img src="//www.fillmurray.com/300/560" alt="img05"><h3>Quarterly Musashino autumn of 2013 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/12866129/MONOCLE-issue-69"><img src="//www.fillmurray.com/300/330" alt="img06"><h3>MONOCLE issue 69</h3></a></li>
            <li><a href="http://www.behance.net/gallery/16631085/Real-Simple-May-2014"><img src="//www.fillmurray.com/300/430" alt="img07"><h3>Real Simple May 2014</h3></a></li>
            <li><a href="http://www.behance.net/gallery/11727343/The-65th-Book-Week"><img src="//www.fillmurray.com/300/410" alt="img08"><h3>The 65th Book Week</h3></a></li>
            <li><a href="http://www.behance.net/gallery/16631085/Real-Simple-May-2014"><img src="//www.fillmurray.com/300/440" alt="img09"><h3>Real Simple May 2014</h3></a></li>
            <li><a href="http://www.behance.net/gallery/15566747/Quarterly-Musashino-spring-of-2014-issue"><img src="//www.fillmurray.com/300/450" alt="img10"><h3>Quarterly Musashino spring of 2014 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/11134427/MAJESTY-express-vol-01"><img src="//www.fillmurray.com/300/460" alt="img11"><h3>MAJESTY express vol. 01</h3></a></li>
            <li><a href="http://www.behance.net/gallery/13329103/Shitamachi-Rocket"><img src="//www.fillmurray.com/300/465" alt="img12"><h3>Shitamachi Rocket</h3></a></li>
            <li><a href="http://www.behance.net/gallery/13285315/Quarterly-Musashino-winter-of-2013-issue"><img src="//www.fillmurray.com/300/435" alt="img13"><h3>Quarterly Musashino winter of 2013 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/16541811/MAINICHI-CHUUGOKUGO-May-2014"><img src="//www.fillmurray.com/300/425" alt="img14"><h3>MAINICHI CHUUGOKUGO April 2014</h3></a></li>
            <li><a href="http://www.behance.net/gallery/15944679/Kenpo-News-April-2014-issue"><img src="//www.fillmurray.com/300/415" alt="img01"><h3>Kenpo News April 2014 issue</h3></a></li>


            <li><a href="http://www.behance.net/gallery/15944679/Kenpo-News-April-2014-issue"><img src="//www.fillmurray.com/300/444" alt="img01"><h3>Kenpo News April 2014 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/15758125/SQUET-April-2014-issue"><img src="//www.fillmurray.com/300/443" alt="img02"><h3>SQUET April 2014 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/15586227/MONOCLE-issue-72"><img src="//www.fillmurray.com/300/406" alt="img03"><h3>MONOCLE issue 72</h3></a></li>
            <li><a href="http://www.behance.net/gallery/11880495/TOWN-Winter-2013"><img src="//www.fillmurray.com/300/500" alt="img04"><h3>TOWN Winter 2013</h3></a></li>
            <li><a href="http://www.behance.net/gallery/11455333/Quarterly-Musashino-autumn-of-2013-issue"><img src="//www.fillmurray.com/300/360" alt="img05"><h3>Quarterly Musashino autumn of 2013 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/12866129/MONOCLE-issue-69"><img src="//www.fillmurray.com/300/336" alt="img06"><h3>MONOCLE issue 69</h3></a></li>
            <li><a href="http://www.behance.net/gallery/16631085/Real-Simple-May-2014"><img src="//www.fillmurray.com/300/433" alt="img07"><h3>Real Simple May 2014</h3></a></li>
            <li><a href="http://www.behance.net/gallery/11727343/The-65th-Book-Week"><img src="//www.fillmurray.com/300/418" alt="img08"><h3>The 65th Book Week</h3></a></li>
            <li><a href="http://www.behance.net/gallery/16631085/Real-Simple-May-2014"><img src="//www.fillmurray.com/300/442" alt="img09"><h3>Real Simple May 2014</h3></a></li>
            <li><a href="http://www.behance.net/gallery/15566747/Quarterly-Musashino-spring-of-2014-issue"><img src="//www.fillmurray.com/300/450" alt="img10"><h3>Quarterly Musashino spring of 2014 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/11134427/MAJESTY-express-vol-01"><img src="//www.fillmurray.com/300/462" alt="img11"><h3>MAJESTY express vol. 01</h3></a></li>
            <li><a href="http://www.behance.net/gallery/13329103/Shitamachi-Rocket"><img src="//www.fillmurray.com/300/462" alt="img12"><h3>Shitamachi Rocket</h3></a></li>
            <li><a href="http://www.behance.net/gallery/13285315/Quarterly-Musashino-winter-of-2013-issue"><img src="//www.fillmurray.com/300/433" alt="img13"><h3>Quarterly Musashino winter of 2013 issue</h3></a></li>
            <li><a href="http://www.behance.net/gallery/16541811/MAINICHI-CHUUGOKUGO-May-2014"><img src="//www.fillmurray.com/300/424" alt="img14"><h3>MAINICHI CHUUGOKUGO April 2014</h3></a></li>
            <li><a href="http://www.behance.net/gallery/15944679/Kenpo-News-April-2014-issue"><img src="//www.fillmurray.com/300/516" alt="img01"><h3>Kenpo News April 2014 issue</h3></a></li>
        </ul>
    </section>
</div><!-- /container -->

<script src="resources/js/modernizr.js"></script>
<script src="resources/js/isotope.pkgd.min.js"></script>
<script src="resources/js/imagesloaded.pkgd.min.js"></script>
<script src="resources/js/main.js"></script>

<%@ include file = "bottom.jsp" %>
