<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="DAO.DanhMucDAO"%>
<%@page import="model.DanhMuc"%>
<%@page import="DAO.DanhMucDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		DanhMucDaoImpl danhMucDAO = new DanhMucDaoImpl();
	%>
	<div class="col-sm-3">
		<div class="left-sidebar">
			<h2>Danh Mục</h2>
			<div class="panel-group category-products" id="accordian">
				<%for(DanhMuc danh_muc_cha:danhMucDAO.getListDanhMucCha()){ %>
				<!--category-productsr-->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordian" href="#cate">
								<span class="badge pull-right"><i class="fa fa-plus"></i></span>
								<%=danh_muc_cha.getTen_danh_muc() %>
							</a>
						</h4>
					</div>

					<div class="panel-body">
						<ul>
							<%
								for(DanhMuc danh_muc_con : danhMucDAO.getListDanhMucCon(danh_muc_cha.getMa_danh_muc())){ 
							%>
							<li><a
								href="index.jsp?ma_danh_muc=<%=danh_muc_con.getMa_danh_muc()%>"><%=danh_muc_con.getTen_danh_muc() %></a></li>
							<%
								}
							%>
						</ul>
					</div>

				</div>
				<%
		}
		%>

				<div class="brands_products">
					<!--brands_products-->
					<h2>Brands</h2>
					<div class="brands-name">
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#"> <span class="pull-right">(50)</span>Acne
							</a></li>
							<li><a href="#"> <span class="pull-right">(56)</span>Grüne
									Erde
							</a></li>
							<li><a href="#"> <span class="pull-right">(27)</span>Albiro
							</a></li>
							<li><a href="#"> <span class="pull-right">(32)</span>Ronhill
							</a></li>
							<li><a href="#"> <span class="pull-right">(5)</span>Oddmolly
							</a></li>
							<li><a href="#"> <span class="pull-right">(9)</span>Boudestijn
							</a></li>
							<li><a href="#"> <span class="pull-right">(4)</span>Rösch
									creative culture
							</a></li>
						</ul>
					</div>
				</div>
				<!--/brands_products-->

			</div>
			<!--/price-range-->

			<div class="shipping text-center">
				<!--shipping-->
				<img src="images/home/shipping.jpg" alt="" />
			</div>
			<!--/shipping-->
			<div style="clear: both; margin-bottom: 40px"></div>
		</div>
	</div>


</body>
</html>