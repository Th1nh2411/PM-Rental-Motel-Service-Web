<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
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
	<div class="   box ">
		<div class="qlpt-head">QUẢN LÝ KHÁCH</div>
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/khach/show.htm" var="pagedLink">
			<c:param name="k" value="~" />
		</c:url>
		<!-- Main component for a primary marketing message or call to action -->
		<a class="btn btn-primary" href="insert.htm" role="button">Thêm
			khách mới</a>
		<div class="d-flex flex-row justify-content-between mt-3">
			<div>
				<span id="result1"></span>

				<form class="d-inline-flex" action ="search.htm">
					<input name="searchInput" id="searchInput"
						class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<!-- 			<input name="searchInput" id="searchInput" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search" onkeyup="searchValue()"> -->

					<button  id="searchInput"
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
					<th scope="col">Mã khách</th>
					<th scope="col">Họ và tên</th>
					<th scope="col">Email</th>
					<th scope="col">CMND</th>
					<th scope="col">Ngày sinh</th>
					<th scope="col">Giới tính</th>
					<th scope="col">Địa chỉ</th>
					<th scope="col">SDT</th>
					<th scope="col">Nghề nghiệp</th>
					<th scope="col">Cập nhật</th>
					<th scope="col">Xoá</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${pagedListHolder.pageList}">
					<tr>
						<td>${u.MAKHACH}</td>
						<td>${u.HOVATEN}</td>
						<td>${u.EMAIL}</td>
						<td>${u.SOCMND}</td>
						<td>${u.NGAYSINH}</td>
						<td>${u.GIOITINH}</td>
						<td>${u.DIACHI}</td>
						<td>${u.SDT}</td>
						<td>${u.NGHENGHIEP}</td>
						<td><a href="khach/update/${u.MAKHACH}.htm"><i
								class="bi bi-eraser-fill"></i></a></td>
						<td><a href="khach/delete/${u.MAKHACH}.htm"
							onclick="return confirm('Bạn có muốn xoá khách này?');"> <i
								class="red-icon bi bi-trash"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>