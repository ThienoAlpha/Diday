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
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</head>
<body>
	<%
	//Sử dụng session lấy user name của người dùng đang đăng nhập để gán cho mục header
	if(session.getAttribute("username")==null){
		
	
%>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	}else{
		//Sử dụng session chia quyền truy cập
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
	<jsp:include page="slider.jsp"></jsp:include>
	<section>
		<div class="container">
			<div class="row">
				<jsp:include page="category.jsp"></jsp:include>
				<jsp:include page="menu_product.jsp"></jsp:include>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>