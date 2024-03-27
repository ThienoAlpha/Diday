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
	<div id="contact-page" class="container">
		<div class="bg">

			<div class="row">
				<div class="col-sm-8">
					<div class="contact-form">
						<h2 class="title text-center">Góp ý</h2>
						<div class="status alert alert-success" style="display: none"></div>
						<form id="main-contact-form" class="contact-form row" action="<%=request.getContextPath() %>/PhanHoiControl"
							name="contact-form" method="post">
							<div class="form-group col-md-6">
								<input type="text" name="ho_va_ten" class="form-control "  autocomplete="off"
									required="required" placeholder="Họ và tên">
							</div>
							<div class="form-group col-md-6">
								<input type="text" name="so_dien_thoai" class="form-control"  autocomplete="off"
									required="required" placeholder="SDT">
							</div>
							<div class="form-group col-md-12">
								<input type="text" name="titlle" class="form-control"  autocomplete="off"
									required="required" placeholder="Tiêu đề">
							</div>
							<div class="form-group col-md-12">
								<textarea name="loi_nhan" id="message" required="required"
									class="form-control" rows="8" placeholder="Để lại lời nhắn của bạn"></textarea>
							</div>
							<div class="form-group col-md-12">
								<input type="submit" name="submit"
									class="btn btn-primary pull-right" value="Gửi">
							</div>
						</form>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="contact-info">
						<h2 class="title text-center">Contact Info</h2>
						<address>
							<p>Shop đểu bán hàng xịn</p>
							<p>082 Hàm Nghi - Kim Tân - Lào Cai</p>
							<p>LaoKay City</p>
							<p>Điện thoại: 0968000675</p>
							<p>Fax: 1900100Có</p>
							<p>Email: thieno.pic@gmail.com</p>
						</address>
						<div class="social-networks">
							<h2 class="title text-center">Social Networking</h2>
							<ul>
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#"><i class="fa fa-youtube"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/#contact-page-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>