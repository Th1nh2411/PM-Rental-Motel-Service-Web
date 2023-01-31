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
</style>
<body class="booking_table banner_area d_flex align-items-center">
	<%@ include file="/WEB-INF/include/menu.jsp" %>
      <div class="   box " style="width: 1113px; ">
      	<div class="qlpt-head">QUẢN LÝ DỊCH VỤ</div>
          <!-- Main component for a primary marketing message or call to action -->
            <a class="btn btn-primary" href="insert.htm" role="button">Thêm dịch vụ mới</a>
            <table class="table text-white text-center">
              <thead>
                <tr>
                  <th scope="col">Mã dịch vụ</th>
                  <th scope="col">Tên dịch vụ</th>
                  <th scope="col">Đơn giá</th>
                  <th scope="col">Cập nhật</th>
                  <th scope="col">Xoá</th>
                </tr>
              </thead>
              <tbody>
            <c:forEach var="u" items="${dichvus}">
				<tr>
				<td>${u.MADV}</td>
				<td>${u.TENDV}</td>
				<td>${u.DONGIA}</td>
				</td>
				<td><a href="dichvu/update/${u.MADV}.htm"><i class="bi bi-eraser-fill"></i></a></td>
				<td>
				<a href="dichvu/delete/${u.MADV}.htm" onclick="return confirm('Bạn có muốn xoá dịch vụ này?');">
				<i class="red-icon bi bi-trash"></i>
				</a></td>
				</tr>
			</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
</body>
</html>