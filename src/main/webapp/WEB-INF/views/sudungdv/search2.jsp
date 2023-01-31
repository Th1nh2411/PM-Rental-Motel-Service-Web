<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="tg" tagdir="/WEB-INF/tags/"%>
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
      <div class="  box " style="width: 1113px; ">
      	<div class="qlpt-head">QUẢN LÝ PHIẾU SỬ DỤNG DỊCH VỤ</div>
      	<jsp:useBean id="pagedListHolder" scope="request"
				type="org.springframework.beans.support.PagedListHolder" />
			<c:url value="/sudungdv/search2.htm" var="pagedLink">
				<c:param name="p" value="~" />
			</c:url>
          <!-- Main component for a primary marketing message or call to action -->
            <a class="btn btn-primary" href="insert.htm" role="button">Thêm phiếu dịch vụ</a>
            <a class="btn btn-danger" href="/QuanLyNhaTro/sudungdv/show2.htm" role="button">Phiếu dịch vụ hết hạn</a>
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
                  <th scope="col">Mã phòng</th>
                  <th scope="col">Mã dịch vụ</th>
                  <th scope="col">Ngày bắt đầu sử dụng</th>
                  <th scope="col">Ngày kết thúc sử dụng</th>
                  <th scope="col">Số lượng</th>
                </tr>
              </thead>
              <tbody>
            <c:forEach var="u" items="${pagedListHolder.pageList}">
				<tr>
				<td>${u.phong.MAPHONG}</td>
				<td>${u.dichvu.MADV}</td>
				<td>${u.NGAYBATDAUSDDV}</td>
				<td>${u.NGAYKETTHUCSDDV}</td>
				<td>${u.SOLUONG}</td>
				</tr>
			</c:forEach>
              </tbody>
            </table>
          </div>
</body>
</html>