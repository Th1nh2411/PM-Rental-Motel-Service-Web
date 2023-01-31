<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div class=" p-3  box ml-3 mx-auto " style="width: 600px;height: 720px">
		<a class="btn btn-primary" href="/QuanLyNhaTro/khach/show.htm"
			role="button"><i class="bi bi-backspace-fill"></i></a>
		<div class="qlpt-head form-group mt-4 mb-4">CẬP NHẬT KHÁCH</div>
		

		<form:form action="updated.htm" modelAttribute="khach">

			<div class=" col-md-9 mx-auto mb-4">
				<div class="form-group row">
					<label class=" col-sm-3 col-form-label">Mã khách :</label>
					<div class="col-sm-3">

						<form:input readonly="true" class="form-control" path="MAKHACH"
							required="required" />
					</div>
				</div>
				<div class="form-group row">
					<label class=" col-sm-3 col-form-label">Tên :</label>
					<div class="col-sm-9">

						<form:input placeholder="Nhập họ và tên" class="form-control"
							path="HOVATEN" required="required" />
					</div>
				</div>
				<div class="form-group row">
					<label class=" col-sm-3 col-form-label">Email :</label>
					<div class="col-sm-9">

						<form:input placeholder="Nhập Email" class="form-control"
							path="EMAIL" required="required" />
					</div>
				</div>
				<div class="form-group row">
					<label class=" col-sm-3 col-form-label">Số CMND :</label>
					<div class="col-sm-9">

						<form:input placeholder="Nhập số CMND" class="form-control"
							path="SOCMND" required="required" />
					</div>
				</div>
				<div class="form-group row">
					<label class=" col-sm-3 col-form-label">Ngày sinh :</label>
					<div class="col-sm-6">

						<form:input placeholder="Nhập ngày sinh" class="form-control"
							path="NGAYSINH" required="required" />
					</div>
				</div>

				<label class="form-label">Giới tính :</label>
				<div class="form-check form-check-inline ml-5 mt-2">
					<form:radiobutton id="gt1" class="form-check-input" path="GIOITINH"
						value="Nam" />
					<label for="gt1">Nam</label>
				</div>
				<div class="form-check form-check-inline ml-3 mt-2">
					<form:radiobutton id="gt2" class="form-check-input" path="GIOITINH"
						value="Nữ" />
					<label for="gt2">Nữ</label>
				</div>
				<%-- <div class="form-check form-check-inline">
					<form:radiobutton class="form-check-input" type="radio" path="GIOITINH id="inlineRadio1" value="option1"/>
					<label class="" for="inlineRadio1"/>Nam</label>
				</div>
				<div class="form-check form-check-inline">
					<form:radiobutton class="form-check-input" type="radio"
						path="GIOITINH id="inlineRadio2" value="option2"/>
					<label class="" for="inlineRadio2"/>Nữ</label>
				</div> --%>
				<div class="form-group row">
					<label class=" col-sm-3 col-form-label">Địa chỉ :</label>
					<div class="col-sm-9">

						<form:input placeholder="Nhập địa chỉ" class="form-control"
							path="DIACHI" required="required" />
					</div>
				</div>

				<div class="form-group row">
					<label class=" col-sm-3 col-form-label">SĐT :</label>
					<div class="col-sm-9">

						<form:input placeholder="Nhập số điện thoại" class="form-control"
							path="SDT" required="required" />
					</div>
				</div>


				<div class="form-group row">
					<label class=" col-sm-3 col-form-label">Nghề nghiệp:</label>
					<div class="col-sm-6">

						<form:input placeholder="Nhập nghề nhiệp" class="form-control"
							path="NGHENGHIEP" required="required" />
					</div>
				</div>
			</div>
			<div class="mt-2 text-center">
				<button type="submit" class="btn btn-primary ">Cập nhật</button>
			</div>
		</form:form>
	</div>
</body>
</html>