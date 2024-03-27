<%@page import="model.TTCN"%>
<%@page import="Tools.MaHoa"%>
<%@page import="DAO.TaiKhoanDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập, đăng ký thành viên</title>
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
<%
	TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();
	String mtk = String.valueOf(session.getAttribute("mtk"));
	TTCN ttcn = (TTCN)taiKhoanDAO.getTTCN(mtk);
%>
<section id="form" style="margin-top:100px;border-box:1px;">
		<!--form-->
		<div class="container">
			<h2>Cập nhật thông tin cá nhân</h2>
			<form action="TTCNControl" method="post">
			<input type="hidden" placeholder="" name="mtk" value="<%=mtk%>">
			<div class="row">
					<div class="col-sm-4 col-sm-offset-1">
						<p>Avatar</p>
						<img src="<%=ttcn.getHinh_anh()%>" alt="" style="width:240px;height:240px;"/>
						<input class="form-control" type="file" id="formFile" style="width:240px;background-color:#F0F0E9;" name="hinh_anh">
					</div>
					<div class="col-sm-1">
						<div style="margin-top:20px;">
							<p style="width:200px;margin-bottom:0px">Tên người dùng</p>
							<input style="padding:5px;background-color:#F0F0E9;" type="text"  value="<%=ttcn.getHoten()%>" name="ho_ten" />
						</div>
						<div style="margin-top:20px;">
							<p style="width:200px;margin-bottom:0px">Địa chỉ</p>
							<input style="padding:5px;background-color:#F0F0E9;"  type="text"  value="<%=ttcn.getDiachi()%>" name="dia_chi" />
						</div>
						<div style="margin-top:20px;">
							<p style="width:200px;margin-bottom:0px">Số điện thoại</p>
							<input style="padding:5px;background-color:#F0F0E9;"  type="text"  value="<%=ttcn.getSdt()%>" name="so_dien_thoai" />
						</div>
						<div style="float:left;margin-top:30px;display: flex;">
						<button style="color:white;background-color:orange;" type="submit" class="btn btn-default">Cập nhật</button>
						<a href="index.jsp"><button style="margin-left:10px;color:white;background-color:orange;" type="button" class="btn btn-default">Đổi mật khẩu</button></a>
						</div>
					</div>
					
			</div>
			</form>
			
			
		</div>
		
		
</section>	
	<!--/form-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>