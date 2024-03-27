<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	if(session.getAttribute("1") == null && session.getAttribute("2")== null && session.getAttribute("3")==null){
		session.setAttribute("1", true);
	}
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

	<jsp:include page="slider.jsp"></jsp:include>
	<section>
		<div class="container">
			<div class="row">
				<jsp:include page="category.jsp"></jsp:include>
				<%
					if(request.getParameter("ma_danh_muc")==null){
						if((Boolean)session.getAttribute("1")==true){
				%>
							<jsp:include page="menu_product.jsp"></jsp:include>
							
					<%
						}else if((Boolean)session.getAttribute("2")==true){
					%>
							<jsp:include page="menu_product2.jsp"></jsp:include>
					<%
						}else if((Boolean)session.getAttribute("3")==true){
					%>
	 						<jsp:include page="menu_product3.jsp"></jsp:include>
					<%
						}else{
					%>
						<jsp:include page="menu_product.jsp"></jsp:include>
					<%  
						}
					%>
				<%
					}else{
				%>
				<jsp:include page="product.jsp"></jsp:include>
				<%
					}
				%>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>