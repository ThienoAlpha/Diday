<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<%
	if(session.getAttribute("username")==null){
		
	
%>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	}else{
		if((Integer)session.getAttribute("quyen_truy_cap")==1){
	
%>
	<jsp:include page="header_admin.jsp"></jsp:include>
	<%
		}else{
%>

	<jsp:include page="header_account.jsp"></jsp:include>
	<%
		}
%>

	<%
	}
%>
	<div class="container text-center">
		<div class="logo-404">
			<a href="index.jsp"><img src="images/home/logo.png" alt="" /></a>
		</div>
		<div class="content-404">
			<img src="images/404/404.png" class="img-responsive" alt="" />
			<h1>
				<b>OPPS!</b> We Couldn’t Find this Page
			</h1>
			<p>Uh... So it looks like you brock something. The page you are
				looking for has up and Vanished.</p>
			<h2>
				<a href="index.jsp">Bring me back Home</a>
			</h2>
			<div style="clear: both; margin-bottom: 80px;"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>


	<script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
</body>
</html>