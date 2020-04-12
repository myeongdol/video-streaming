<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="/resources/js/jquery.js"></script>
    <script src="/resources/bootstrap/js/admin/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/admin/bootstrap.min.css" />
    <title>admin page</title>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
          margin-bottom: 0;
          border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 100%}

        /* Set gray background color and 100% height */
        .sidenav {
          padding-top: 20px;
          background-color: #f1f1f1;
          height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
          background-color: #555;
          color: white;
          padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
          .sidenav {
            height: auto;
            padding: 15px;
          }
          .row.content {height:auto;}
        }

        .info-label {
          width: 100px;
          display: inline-block;
        }
    </style>
</head>

<body class="hold-transition skin-blue sidebar-mini">
    <script>
        $(function(){
            var responseMessage = "<c:out value="${responseMessage}" />";
            if(responseMessage != ""){
                alert(responseMessage)
            }

            var pathName = window.location.pathname;
            var adminNav = document.querySelector('#adminNav');
            if (pathName.includes('board')) {
                document.querySelector('#adminNavBoard').classList.add('active');
            } else if (pathName.includes('member')) {
                document.querySelector('#adminNavMember').classList.add('active');
            } else if (pathName.includes('site')) {
                document.querySelector('#adminNavSite').classList.add('active');
            } else {
                document.querySelector('#adminNavHome').classList.add('active');
            }
        })
    </script>

    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/admin-page">Admin Page</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav" id="adminNav">
            <li id="adminNavHome"><a href="/admin-page">Home</a></li>
            <li id="adminNavBoard"><a href="/admin-page/board">Board</a></li>
            <li id="adminNavMember"><a href="/admin-page/member">Member</a></li>
            <li id="adminNavSite"><a href="/admin-page/site">Site</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/admin-page/login">Login</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid text-center">
      <div class="row content">
        <div class="col-sm-2 sidenav">
          <p><a href="#">Link</a></p>
          <p><a href="#">Link</a></p>
          <p><a href="#">Link</a></p>
        </div>