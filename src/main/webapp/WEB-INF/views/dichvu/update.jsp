<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Nhà Trọ</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link href="<c:url value='/resource/assets/dist/css/sidebar.css'/>"
	rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
        .sidebar-navigation li a{
            text-decoration: none;
        }
        .middle{
        	width:250px;
        	margin: 0 auto;
        	font-size:24px;
        	padding-top:100px;
        }
</style>
<body class="booking_table banner_area d_flex align-items-center">
	<%@ include file="/WEB-INF/include/menu.jsp" %>
      <div class=" p-3  box ml-3" style="width: 1113px; height: 750px">
      	<div class="qlpt-head">QUẢN LÝ DỊCH VỤ</div>
          <!-- Main component for a primary marketing message or call to action -->
            <a class="btn btn-primary" href="/QuanLyNhaTro/dichvu/show.htm" role="button">Quay lại</a>
          <form:form action="updated.htm" modelAttribute="dichvu">
  			<form:input type="hidden" path = "MADV" readonly="true"/>
  			
 			<div class="mt-2">
    			<label for="exampleInputPassword1" class="form-label">Tên dịch vụ</label>
    				
  			</div>
  			<form:input path= "TENDV" required="required"/>
  			
  			 			<div class="">
    			<label for="exampleInputPassword1" class="form-label">Đơn giá</label>
    				
  			</div>
  			<form:input path= "DONGIA" required="required"/>
  			<div class="mt-2"><button type="submit" class="btn btn-primary">Cập nhật</button></div>
		</form:form>
          </div>
</body>
</html>