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
	<div class="   box " style="width: 1113px;">

		<div class="">
			<div class="qlpt-head">QUẢN LÝ PHÒNG</div>
			<jsp:useBean id="pagedListHolder" scope="request"
				type="org.springframework.beans.support.PagedListHolder" />
			<c:url value="/phong/show.htm" var="pagedLink">
				<c:param name="p" value="~" />
			</c:url>
			<!-- Main component for a primary marketing message or call to action -->
			<div class="">
				<a class="btn btn-primary" href="/QuanLyNhaTro/phong/insert.htm"
					role="button">Thêm phòng</a> <a class="btn btn-success"
					href="/QuanLyNhaTro/phong/show2.htm" role="button">Danh sách
					phòng trống</a>
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
							<th scope="col">Mã phòng</th>
							<th scope="col">Loại phòng</th>
							<th scope="col">Số người hiện tại</th>
							<th scope="col">Trạng thái</th>
							<th scope="col">Cập nhật</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${pagedListHolder.pageList}">
							<tr>
								<td>${u.MAPHONG}</td>
								<td>${u.loaiphong.TENLOAIPHONG}</td>
								<td>${u.SONGUOIHIENTAI}</td>
								<td>${u.TRANGTHAI?'Đang hoạt động':'Ngưng hoạt động'}</td>
								<td><a href="phong/update/${u.MAPHONG}.htm"><i
										class="bi bi-eraser-fill"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	

</body>
</html>