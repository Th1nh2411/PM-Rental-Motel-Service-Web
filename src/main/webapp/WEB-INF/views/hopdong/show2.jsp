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
	<div class="  box " style="width: 1220px;">
		<div class="qlpt-head">QUẢN LÝ HỢP ĐỒNG</div>
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/hopdong/show2.htm" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		<!-- Main component for a primary marketing message or call to action -->
		<a class="btn btn-primary" href="insert.htm" role="button">Thêm
			hợp đồng</a> <a class="btn btn-success"
			href="/QuanLyNhaTro/hopdong/show.htm" role="button">Hợp đồng còn hạn</a>
		<div class="d-flex flex-row justify-content-between mt-3">
			<div>
				<span id="result1"></span>
	
				<form class="d-inline-flex" action="search2.htm">
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
					<th scope="col">Mã hợp đồng</th>
					<th scope="col">Mã phòng</th>
					<th scope="col">Mã khách</th>
					<th scope="col">Ngày thuê</th>

					<th scope="col">Tiền cọc</th>
					<th scope="col">Trạng thái</th>
					<th scope="col">Ghi chú</th>
					<th scope="col">Xóa hợp đồng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${pagedListHolder.pageList}">
					<tr>
						<td>${u.MAHOPDONG}</td>
						<td>${u.phong.MAPHONG}</td>
						<td>${u.khach.MAKHACH}</td>
						<td>${u.NGAYTHUE}</td>

						<td>${u.TIENCOC}</td>
						<td>${u.TRANGTHAI?'Còn hiệu lực':'Hết hạn'}</td>
						<td>${u.GHICHU}</td>
				<td>
				<a href="hopdong/delete/${u.MAHOPDONG}.htm" onclick="return confirm('Bạn có muốn xoá hợp đồng này?');">
				<i class="red-icon bi bi-trash"></i>
				</a></td>
				</tr>
			</c:forEach>
              </tbody>
            </table>
            <c:choose>
			<c:when test="${check==null}">

			</c:when>
			<c:otherwise>
				<div class="alert alert-success border-0 mx-auto col-md-6 w-25"
					role="alert">
					<strong>${message}</strong>
				</div>
			</c:otherwise>
		</c:choose>
          </div>
</body>
</html>