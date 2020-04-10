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
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <script>
        $(function(){
            var responseMessage = "<c:out value="${responseMessage}" />";
            if(responseMessage != ""){
                alert(responseMessage)
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
          <a class="navbar-brand" href="/admin-page">Admin</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/admin-page">Home</a></li>
            <li><a href="/admin-page/board">Board</a></li>
            <li><a href="/admin-page/member">Member</a></li>
            <li><a href="/admin-page/site">Site</a></li>
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