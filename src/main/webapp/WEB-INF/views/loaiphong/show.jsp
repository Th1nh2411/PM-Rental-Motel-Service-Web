<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
        .red-icon{
        color:red;
        }
</style>
<body class="booking_table banner_area d_flex align-items-center">
	<%@ include file="/WEB-INF/include/menu.jsp" %>
      <div class="   box " style="width: 1113px; ">
      	<div class="qlpt-head">QUẢN LÝ LOẠI PHÒNG</div>
          <!-- Main component for a primary marketing message or call to action -->
            <a class="btn btn-primary " href="insert.htm" role="button">Thêm loại phòng</a>
            <table class="table text-white text-center">
              <thead>
                <tr>
                  <th scope="col">Mã loại phòng</th>
                  <th scope="col">Tên loại phòng</th>
                  <th scope="col">Đơn giá</th>
                  <th scope="col">Số người tối đa</th>
                  <th scope="col">Cập nhật</th>
                </tr>
              </thead>
              <tbody>
            <c:forEach var="u" items="${loaiphongs}">
				<tr>
				<td>${u.MALOAIPHONG}</td>
				<td>${u.TENLOAIPHONG}</td>
				<td>${u.DONGIA}</td>
				<td>${u.SONGUOITOIDA}</td>
				</td>
				<td><a href="loaiphong/update/${u.MALOAIPHONG}.htm"><i class="bi bi-eraser-fill"></i></a></td>
				</tr>
			</c:forEach>
              </tbody>
            </table>
          </div>
</body>
</html>