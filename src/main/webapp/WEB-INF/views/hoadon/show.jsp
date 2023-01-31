<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Nhà Trọ</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link href="<c:url value='/resource/assets/dist/css/sidebar.css'/>"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<style>
.sidebar-navigation li a {
	text-decoration: none;
}

.red-icon {
	color: red;
}
</style>
<body class="booking_table banner_area d_flex align-items-center">
	
	<%@ include file="/WEB-INF/include/menu.jsp"%>
	<div class="   box" style="width: 1113px;">
		<div class="qlpt-head">QUẢN LÝ HOÁ ĐƠN</div>
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/hoadon/show.htm" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		
		<!-- Main component for a primary marketing message or call to action -->
		<a class="btn btn-primary" href="insert.htm" role="button">Thêm
			hoá đơn</a> <a class="btn btn-success"
			href="/QuanLyNhaTro/hoadon/show2.htm" role="button">Hoá đơn đã
			thanh toán</a>
		<div class="d-flex flex-row justify-content-between mt-3">
			<div>
				<span id="result1"></span>

				<form class="d-inline-flex" action="search.htm">
					<input name="searchInput" id="searchInput"
						class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<!-- 			<input name="searchInput" id="searchInput" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search" onkeyup="searchValue()"> -->

					<button name="btnsearch" id="searchP"
						class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
			<div>
				<tg:paging pagedListHolder="${pagedListHolder}"
					pagedLink="${pagedLink}" />
			</div>



		</div>
		<table class="table text-white text-center">
			<thead>
				<tr>
					<th scope="col">Mã hoá đơn</th>
					<th scope="col">Mã hợp đồng</th>
					<th scope="col">Ngày lập hoá đơn</th>
					<th scope="col">Hình thức thanh toán</th>
					<th scope="col">Tiền dịch vụ</th>
					<th scope="col">Tiền phòng</th>
					<th scope="col">Tổng tiền</th>
					<th scope="col">Trạng thái</th>
					<th scope="col">Thanh toán</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${pagedListHolder.pageList}">
					<tr>
						<td>${u.MAHOADON}</td>
						<td>${u.hopdong.MAHOPDONG}</td>
						<td>${u.NGAYLAPHD}</td>
						<td>${u.HTTT}</td>
						<td>${u.TIENDICHVU}</td>
						<td>${u.TIENPHONG}</td>
						<td>${u.TONGTIEN}</td>
						<td>${u.TRANGTHAI?'Chưa thanh toán':'Đã thanh toán'}</td>
						<td><a href="hoadon/thanhtoan/${u.MAHOADON}.htm"><i class="bi bi-currency-dollar"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>