<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "top.jsp" %>

<link rel="stylesheet" type="text/css" href="/resources/css/layout/normalize.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/layout/component.css" />
<script src="/resources/js/layout/modernizr.custom.js"></script>

<div class="container">
  <!-- Top Navigation -->
  <div class="codrops-top clearfix">
    <div class="search-bar">
        <input type="text" name="search" placeholder="검색어를 입력하세요">
        <div class="search"></div>
    </div>
    <c:if test='${sessionScope.__MEMBER_INFO.memId eq null}' >
        <span class="right"><a class="codrops-icon codrops-icon-drop" href="/join"><span>회원가입</span></a></span>
        <span class="right"><a class="codrops-icon codrops-icon-drop" href="/login"><span>로그인</span></a></span>
    </c:if>
    <c:if test='${sessionScope.__MEMBER_INFO.memId ne null}' >
        <span class="right"><a class="codrops-icon codrops-icon-drop" href="/logout"><span>로그아웃</span></a></span>
        <span class="right"><u>${sessionScope.__MEMBER_INFO.memName}</u>님 반갑습니다.</span>
    </c:if>
  </div>
  <header class="codrops-header">
    <h1><a href="/">Video Streaming</a></h1>
  </header>
  <section class="grid-wrap">
    <ul class="grid swipe-down" id="grid">
        <li class="title-box">
            <h2><a href="/board/write">UPLOAD</a>YOUR VIDEO</h2>
            <input type="text" id="naver-search" name="query" placeholder="네이버 검색 기능 확인용">
        </li>
        <c:forEach var="board" items="${boardList}">
            <li id="li${board.boardNo}"><a id="a${board.boardNo}" onclick="streamIt('${board.boardNo}');"><img src="/attach/${board.videoNo}" alt="img01"><h3>${board.title}</h3></a></li>
        </c:forEach>
    </ul>
  </section>
  <section class="related">
    <p>소스 코드 관리 <a href="https://github.com/myeongdol/video-streaming">github.com/myeongdol/video-streaming</a></p>
  </section>
</div>

<script src="/resources/js/layout/masonry.pkgd.min.js"></script>
<script src="/resources/js/layout/imagesloaded.pkgd.min.js"></script>
<script src="/resources/js/layout/classie.js"></script>
<script src="/resources/js/layout/colorfinder-1.1.js"></script>
<script src="/resources/js/layout/gridScrollFx.js"></script>
<script>
    loading();

    function loading() {
        new GridScrollFx( document.getElementById( 'grid' ), {
            minDuration : 0.4,
            maxDuration : 0.7,
            viewportFactor : 0.4
        } );
    }

    function streamIt(id) {
        document.getElementById("a"+id).style.display = "none";

        var video = document.createElement("video");
        video.setAttribute("id","v"+id);
        video.setAttribute("width","100%");
        video.setAttribute("style","margin:7px;");
        video.autoplay = true;
        video.controls = true;

        var source = document.createElement("source");
        source.type = "video/mp4";
        source.src = "/play/"+id;

        video.appendChild(source);

        document.getElementById("li"+id).appendChild(video);
    }

    $(".search-bar input[type=text]").keypress(function(e) {
        if (e.keyCode == 13){
            var word = $(".search-bar input[type=text]").val().trim();

            if(word == "") {
                alert("검색어를 입력하시기 바랍니다.");
                $(".search-bar input[type=text]").focus();
                return false;
            }

            $.ajax({
                type: "GET",
                url: "/search",
                data: {"search":word},
                success: function(data) {
                    var result = $(data).find(".grid-wrap").html();
                    $(".grid-wrap").html(result);
                    loading();
                }
            });
        }
    });

    $("#naver-search").keypress(function(e) {
        if (e.keyCode == 13){
            var word = $("#naver-search").val().trim();

            if(word == "") {
                alert("검색어를 입력하시기 바랍니다.");
                $("#naver-search").focus();
                return false;
            }

            $.ajax({
                type: "GET",
                url: "/search/naver",
                data: {"query":word},
                success: function(data) {
                    $(".grid-wrap").html(data);
                }
            });
        }
    });
</script>

<%@ include file = "bottom.jsp" %>
