<%@page import="DAO.SanPhamDaoImpl"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.NumberFormat"%>
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
		Double TongTien=0.0;
		Double PhiShip=15000.0;
		Double ThanhTien=0.0;
		GioHang cart = (GioHang)session.getAttribute("cart");
		if(cart==null)
		{
			cart=new GioHang();
			session.setAttribute("cart", cart);
		}
		TreeMap<SanPham, Integer> list = cart.getList();
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(0);
		session.setAttribute("danh_sach_don_hang", list);
		
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
<%String ma_tai_khoan =String.valueOf(session.getAttribute("ma_tai_khoan")); 
int sl = 0;%>
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs" style="margin-bottom:0px;">
				<ol class="breadcrumb"  style="margin-bottom:0px;">
					<li><a href="#">Home</a></li>
					<li class="active">Check out</li>
				</ol>
			</div>
			<!--/breadcrums-->
			<div class="review-payment" >
				<h2>Review & Payment</h2>
			</div>

			<div class="table-responsive cart_info" style="margin-bottom:80px;">
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
						for(Map.Entry<SanPham,Integer>sp: list.entrySet()){
					%>
						<tr>
							<td class="cart_product"><div class="img110" style="display: inline-block; width:110px; height:80px;">
								<a class="img110img" href=""><img 
									src="<%=sp.getKey().getHinh_anh() %>" alt="" style="width:100%; height:100%"></a>
							</div></td>
							<td class="cart_description" >
							<div class="idontknow" style="margin-left:60px;">
								<h4>
									<a href=""><%=sp.getKey().getTen_san_pham() %></a>
								</h4>
								<p>Mã sản phẩm: <%=sp.getKey().getMa_san_pham() %></p>
								</div>
							</td>
							<td class="cart_price">
								<p><%=nf.format(sp.getKey().getDon_gia()) %> VNĐ</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href="GioHangController?command=pluscheckout&ma_san_pham=<%=sp.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"> + </a> <input
										class="cart_quantity_input" type="text" name="quantity"
										value="<%=sp.getValue() %>" autocomplete="off" size="2"> <a
										class="cart_quantity_down" href="GioHangController?command=subcheckout&ma_san_pham=<%=sp.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price"><%=nf.format(sanPhamDao.nhan2so(sp.getKey().getDon_gia(), sp.getValue() )) %> VNĐ</p>
							</td>
							<td class="cart_delete"><a class="cart_quantity_delete"
								href="GioHangController?command=removecheckout&ma_san_pham=<%=sp.getKey().getMa_san_pham()%>&cartID=<%=System.currentTimeMillis()%>"><i class="fa fa-times"></i></a></td>
						</tr>
						<%
							TongTien +=sanPhamDao.nhan2so(sp.getKey().getDon_gia(), sp.getValue() );
							sl = sp.getValue();
						%>
					<%
						}
					%>
						
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Tổng tiền</td>
										<td><%=nf.format(TongTien) %> VNĐ</td>
									</tr>
									
									<tr class="shipping-cost">
										<td>Phí ship</td>
										<td><%=nf.format(PhiShip) %> VNĐ</td>
									</tr>
									<tr>
										<td>Tổng Tiền</td>
										<%ThanhTien = TongTien+PhiShip;%>
										<td><span><%=nf.format(ThanhTien) %> VNĐ</span></td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			

			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info">
							<p>Thông tin người nhận</p>
							<form action="<%= request.getContextPath() %>/ThanhToanControl" method="post">
								<input type="text" placeholder="Họ và tên người nhận" name="ho_ten">
								<input type="hidden" placeholder="" name="thanh_tien" value="<%=ThanhTien%>">
								<input type="hidden" placeholder="" name="ma_tai_khoan" value="<%=ma_tai_khoan%>">
								<input type="hidden" placeholder="" name="so_luong" value="<%=sl%>"> <input
									type="text" placeholder="Địa chỉ giao hàng" name="dia_chi"> <input
									type="text" placeholder="Số điện thoại" name="so_dien_thoai"> <select name="thanh_toan" style="padding-top:15px;padding-bottom:15px">
									<option selected>Chọn phương thức thanh toán</option>
									<option value="Thanh toán tại nhà">Thanh toán tại nhà</option>
									<option value="Thanh toán Visa ">Thanh toán Visa</option>
									<option>---------------------------------------------------------</option>
									</select>
									<select name="don_vi_van_chuyen" style="margin-top:10px;padding-top:15px;padding-bottom:15px">
									<option selected>Chọn đơn vị vận chuyển</option>
									<option value="EpressXXX">EpressXXX</option>
									<option value="Grab">Grab</option>
									<option>---------------------------------------------------------</option>
									</select>
									 <input class="btn btn-primary" type="submit" value="Trỏa Tiền" />
							</form>
							
						</div>
					</div>
					
						
					<div class="col-sm-4">
						<div class="order-message">
							<p>Ghi chú!</p>
							<textarea name="message"
								placeholder="Ghi chú cho người giao hàng."
								rows="16" style="width:700px;"></textarea>
							
						</div>
					</div>
				
			</div>
			
			
		</div>
	</section>
	<!--/#cart_items-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>