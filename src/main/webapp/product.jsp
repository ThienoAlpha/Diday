<%@page import="model.GioHang"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.SanPham"%>
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
</head>
<body>



	<%
	
		SanPhamDaoImpl sanPhamDao = new SanPhamDaoImpl();
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(0);
		
		GioHang cart =(GioHang) session.getAttribute("cart");
		if(cart == null){
			cart = new GioHang();
			session.setAttribute("cart", cart);
		}
		
	%>
	<div class="col-sm-9 padding-right">
		<div class="features_items">
			<!--features_items-->
			<h2 class="title text-center">Sản Phẩm</h2>
			<%for(SanPham sp: sanPhamDao.getListProductByCategory(request.getParameter("ma_danh_muc"))){ %>
			<div class="col-sm-4">
				<div class="product-image-wrapper">
					<div class="single-products">
						<div class="productinfo text-center">
							<img src="<%=sp.getHinh_anh() %>" alt="" style="width:241.750px;height:161.156px;"/>
							<h2><%=nf.format(sp.getDon_gia())%> VNĐ</h2>
							<p><%=sp.getTen_san_pham()%></p>
							<a href="GioHangController?command=insert&ma_san_pham=<%=sp.getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>" class="btn btn-default add-to-cart"><i
								class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
						</div>
						<div class="product-overlay">
							<div class="overlay-content">
								<h2><%=nf.format(sp.getDon_gia())%>VNĐ</h2>
								<p><%=sp.getTen_san_pham()%></p>
								<a href="GioHangController?command=insert&ma_san_pham=<%=sp.getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>" class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
							</div>
						</div>
					</div>
					<div class="choose">
						<ul class="nav nav-pills nav-justified">
							<li><a href="#"><i class="fa fa-plus-square"></i>Thêm so sánh</a></li>
							<li><a href="product-details.jsp?ma_san_pham=<%=sp.getMa_san_pham()%>"><i class="fa fa-plus-square"></i>Xem chi tiết</a></li>
						</ul>
					</div>
				</div>
			</div>
			<%
				}
			%>

		</div>
		<!--features_items-->





	</div>
</body>
</html>