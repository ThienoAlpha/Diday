<%@page import="DAO.SanPhamDaoImpl"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.TreeMap"%>
<%@page import="model.GioHang"%>
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
		SanPhamDaoImpl sanPhamDao = new SanPhamDaoImpl();
		GioHang cart = (GioHang)session.getAttribute("cart");
		if(cart==null)
		{
			cart=new GioHang();
			session.setAttribute("cart", cart);
		}
		TreeMap<SanPham, Integer> list = cart.getList();
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(0);
		
	%>
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
	<section id="cart_items" >
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info" style="margin-bottom:10px;">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<%
					//Tìm hiểu sau
						for(Map.Entry<SanPham,Integer>ds:list.entrySet()){ 
					%>
						
						<tr>
							<td class="cart_product"><div class="img110" style="display: inline-block; width:110px; height:80px;">
								<a class="img110img" href=""><img 
									src="<%=ds.getKey().getHinh_anh() %>" alt="" style="width:100%; height:100%"></a>
							</div></td>
							<td class="cart_description">
								<div class="idontknowtoo" style="margin-left:60px;">
									<h4>
									<a href=""><%=ds.getKey().getTen_san_pham() %></a>
								</h4>
								<p>Mã sản phẩm: <%=ds.getKey().getMa_san_pham() %></p>
								</div>
							</td>
							<td class="cart_price">
								<p><%=nf.format(ds.getKey().getDon_gia()) %> VNĐ</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a
										class="cart_quantity_down" href="GioHangController?command=sub&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"> - </a> <input
										class="cart_quantity_input" type="text" name="quantity"
										value="<%=ds.getValue()%>" autocomplete="off" size="2"> 
								<a class="cart_quantity_up" href="GioHangController?command=plus&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"> + </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price"><%=nf.format(sanPhamDao.nhan2so(ds.getKey().getDon_gia(), ds.getValue() )) %> VNĐ</p>
							</td>
							<td class="cart_delete"><a class="cart_quantity_delete"
								href="GioHangController?command=remove&ma_san_pham=<%=ds.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"><i class="fa fa-times"></i></a></td>
						</tr>
						<%
						}
						%>
						
					</tbody>
				</table>
				
			</div>
			<div class="btn_checkout" style=" float:right; margin-right:170px; margin-bottom:50px;">
			<a class="btn btn-default check_out" href="ThanhToanControl">Thanh toán</a>
		</div>
		</div>
		
	</section>
	<!--/#cart_items-->
	
	<!--/#do_action-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>