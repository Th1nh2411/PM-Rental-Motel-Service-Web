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
	<div class=" p-3  box ml-3 mx-auto "
		style="width: 500px; height: 550px">
		<a class="btn btn-primary" href="/QuanLyNhaTro/loaiphong/show.htm"
			role="button"><i class="bi bi-backspace-fill"></i></a>
		<div class="qlpt-head form-group mt-4 mb-4">THÊM LOẠI PHÒNG</div>
		<c:choose>
			<c:when test="${check==null}">

			</c:when>
			<c:otherwise>
				<div class="alert alert-success border-0 mx-auto col-md-6 "
					role="alert">
					<strong>${message}</strong>
				</div>
			</c:otherwise>
		</c:choose>
		<div>
			<!-- Main component for a primary marketing message or call to action -->

			<form:form action="insert.htm" modelAttribute="loaiphong">
				<div class=" col-md-6 mx-auto mb-2">
					<label >Tên loại phòng</label>

					<form:input placeholder="Nhập tên loại phòng" class="form-control " path="TENLOAIPHONG"
						required="required" />
				</div>
				<div class=" col-md-6 mx-auto mb-2">
					<label  class="form-label">Đơn giá</label>

					<form:input placeholder="Nhập đơn giá"  class="form-control w-75" path="DONGIA" required="required" />
				</div>
				<div class=" col-md-6 mx-auto mb-4">
					<label class="form-label">Số người tối đa</label>

					<form:input class="form-control col-md-4" path="SONGUOITOIDA"
						required="required" />
				</div>
				<div class="text-center ">
					<button type="submit" class="btn btn-primary">Thêm</button>
				</div>
			</form:form>
		</div>

	</div>


	</div>
	</div>
	<%-- <div class=" p-3  box ml-3" style="width: 1113px; height: 750px">
      	<div class="qlpt-head">QUẢN LÝ LOẠI PHÒNG</div>
          <!-- Main component for a primary marketing message or call to action -->
            <a class="btn btn-primary" href="/QuanLyNhaTro/loaiphong/show.htm" role="button">Quay lại</a>
          <form:form action="insert.htm" modelAttribute="loaiphong">
  			<div class=" mt-2">
   				 <label for="exampleInputEmail1" class="form-label">Tên loại phòng</label>
  			</div>
  			<form:input path= "TENLOAIPHONG" required="required"/>
  			
 			<div class="">
    			<label for="exampleInputPassword1" class="form-label">Đơn giá</label>	
  			</div>
  			<form:input path= "DONGIA" required="required"/>
  			
  			<div class="">
    			<label for="exampleInputPassword1" class="form-label">Số người tối đa</label>	
  			</div>
  			<form:input path= "SONGUOITOIDA" required="required"/>
  			<div class="mt-2"><button type="submit" class="btn btn-primary">Thêm</button></div>
		</form:form>
          </div> --%>

</body>
</html>