<%@page import="DAO.SanPhamDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	SanPhamDaoImpl sanDaoImpl = new SanPhamDaoImpl();
%>
<jsp:include page="header.jsp"></jsp:include>
 <div align="center" style="padding-bottom:40px;">
  <h1 style="color:#888888; font-weight:500;">Thêm sản phẩm</h1>
  <p>100002: Nokia<br>100003: Samsung<br>100004: LG<br>100006: Lap Asus<br>100007: Lap HP<br>Số lượng trong kho: <%=sanDaoImpl.getSoLuongSanPham().size() %> </p>
  
  <form action="<%= request.getContextPath() %>/AddProductControl" method="post">
   <table style="with: 80%">
   <tr>
     <td>Loại hàng</td>
     <td><input type="text" name="loai_hang"/></td>
    </tr>
    <tr>
     <td>Tên thể loại hàng</td>
     <td><input type="text" name="ten_the_thoai"/></td>
    </tr>
    <tr>
     <td>Tên sản phẩm</td>
     <td><input type="text" name="ten_san_pham" /></td>
    </tr>
    <tr>
     <td>Hình ảnh</td>
     <td><input type="text" name="hinh_anh" /></td>
    </tr>
    <tr>
     <td>Số lượng</td>
     <td><input type="number" name="so_luong" /></td>
    </tr>
    <tr>
     <td>Mô tả</td>
     <td><input type="text" name="mo_ta" /></td>
    </tr>
    <tr>
     <td>Đơn giá</td>
     <td><input type="number" name="don_gia" /></td>
    </tr>
    <tr>
     <td>Giảm giá</td>
     <td><input type="number" name="giam_gia" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>