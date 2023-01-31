<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Nhà Trọ</title>
<base href="${pageContext.servletContext.contextPath}/">
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

.middle {
	width: 250px;
	margin: 0 auto;
	font-size: 24px;
	padding-top: 100px;
}
</style>
<body class="booking_table banner_area d_flex align-items-center">
	<%@ include file="/WEB-INF/include/menu.jsp"%>
	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
		fill="currentColor" class="bi bi-backspace-fill" viewBox="0 0 16 16">
  <path
			d="M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z" />
</svg>
	<div class=" p-3  box ml-3 mx-auto "
		style="width: 500px; height: 200px">
		<a class="btn btn-primary" href="/QuanLyNhaTro/hopdong/show.htm"
			role="button"><i class="bi bi-backspace-fill"></i></a>
		<div class="qlpt-head form-group mx-auto text-center"> ${message }</div>

		




	</div>
	</div>

</body>
</html>