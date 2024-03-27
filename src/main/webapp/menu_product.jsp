<%@page import="java.util.TreeMap"%>
<%@page import="model.GioHang"%>
<%@page import="model.SanPham"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="DAO.SanPhamDaoImpl"%>
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
		SanPhamDaoImpl sanPhamDao = new SanPhamDaoImpl();
		GioHang cart = (GioHang)session.getAttribute("cart");
		//Khi chuyển hướng đến trang này sẽ tạo mới một đối tượng giỏ hàng để sử dụng
	if(cart==null)
	{
		//Đưa giá trị(value) giỏ hàng vào session để sử dụng ở phía máy chủ 
		//Giỏ hàng của phiên đăng nhập
		cart=new GioHang();
		session.setAttribute("cart", cart);
	}
		//Chuyển kiểu số thành dạng tiền có dấu chấm
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(0);
	%>

				

				<div class="col-sm-9 padding-right">
					<div class="features_items">
						<!--features_items-->
						<h2 class="title text-center">Sản Phẩm</h2>
						<%
							for(SanPham sp:sanPhamDao.getListProductByCateGoryForShop()){
						%>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="<%=sp.getHinh_anh() %>" alt="" style="width:241.750px;height:161.156px;"/>
										<h2><%=nf.format(sp.getDon_gia()) %> VNĐ</h2>
										<p><%=sp.getTen_san_pham() %></p>
										<a href="GioHangController?command=insert&ma_san_pham=<%=sp.getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>" class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2><%=nf.format(sp.getDon_gia()) %> VNĐ</h2>
											<p><%=sp.getTen_san_pham() %></p>
											<a href="GioHangController?command=insert&ma_san_pham=<%=sp.getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>" class="btn btn-default add-to-cart"><i
												class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
										</div>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-plus-square"></i>Thêm so sánh</a></li>
										<li><a href="product-details.jsp?ma_san_pham=<%=sp.getMa_san_pham()%>"><i class="fa fa-plus-square"></i>Xem chi tiết</a></li>
									</ul>
								</div>
							</div>
						</div>
						<%
							}
						%>
						

						
					</div>
					<div class="fix" style="display:flex; justify-content: center;">
						<ul class="pagination">
							<li class="active"><a href="MenuProductController?commandd=trang1">1</a></li>
							<li><a href="MenuProductController?commandd=trang2">2</a></li>
							<li><a href="MenuProductController?commandd=trang3">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>
					</div>
					<!--features_items-->
				</div>

	<script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
</body>
</html>