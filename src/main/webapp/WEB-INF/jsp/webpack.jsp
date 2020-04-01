<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/resources/js/jquery.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css" />

    <link rel="stylesheet" type="text/css" href="resources/css/test/normalize.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/test/demo.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/test/component.css" />
    <script src="resources/js/test/modernizr.custom.js"></script>
    <title>VS Project</title>
</head>
<body>
    <script>
        $(function(){
            var responseMessage = "<c:out value="${responseMessage}" />";
            if(responseMessage != ""){
                alert(responseMessage)
            }
        })
    </script>

<div class="container">
  <span>Hello Webpack!</span>

  <!-- Top Navigation -->
  <div class="codrops-top clearfix">
    <a class="codrops-icon codrops-icon-prev" href="http://tympanus.net/Development/ButtonComponentMorph/"><span>Previous Demo</span></a>
    <span class="right"><a class="codrops-icon codrops-icon-drop" href="http://tympanus.net/codrops/?p=19069"><span>Back to the Codrops Article</span></a></span>
  </div>
  <header class="codrops-header">
    <h1>Grid Loading and Hover Effect <span>Recreating <a href="http://design.samsung.com/">Samsung's</a> grid loading effect</span></h1>
    <nav class="codrops-demos">
      <a href="index.html">Swipe right</a>
      <a class="current-demo" href="index2.html">Swipe Down</a>
      <a href="index3.html">Rotate</a>
    </nav>
  </header>
  <section class="grid-wrap">
    <ul class="grid swipe-down" id="grid">
      <li class="title-box">
        <h2>Illustrations by <a href="http://ryotakemasa.com/">Ryo Takemasa</a></h2>
      </li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
      <li><a href="#"><img src="resources/img/dummy.png" alt="dummy"><h3>A fantastic title</h3></a></li>
    </ul>
  </section>
  <section class="related">
    <p>If you enjoyed this demo you might also like:</p>
    <a href="http://tympanus.net/Development/ThumbnailGridAnimations/">
      <img src="http://tympanus.net/codrops/wp-content/uploads/2013/10/ThumbnailGridAnimations1-300x162.jpg" />
      <h3>Animations for Thumbnail Grids</h3>
    </a>
    <a href="http://tympanus.net/Development/GridLoadingEffects/">
      <img src="http://tympanus.net/codrops/wp-content/uploads/2013/07/GridLoadingEffects-300x162.png" />
      <h3>Grid Loading Effects</h3>
    </a>
  </section>
</div>

<script src="resources/js/test/masonry.pkgd.min.js"></script>
<script src="resources/js/test/imagesloaded.pkgd.min.js"></script>
<script src="resources/js/test/classie.js"></script>
<script src="resources/js/test/colorfinder-1.1.js"></script>
<script src="resources/js/test/gridScrollFx.js"></script>
<script>
    new GridScrollFx( document.getElementById( 'grid' ), {
      minDuration : 0.4,
    	maxDuration : 0.7,
      viewportFactor : 0.4
    } );
</script>

<script src="resources/dist/webpack-test.bundle.js"></script>

<%@ include file = "bottom.jsp" %>
