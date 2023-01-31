<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Required meta tags -->
<base href="${pageContext.servletContext.contextPath}/">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>P@M System</title>

<link
	href="<c:url value='/resource/assets/dist/csshome/bootstrap.css'/>"
	rel="stylesheet">

<link href="<c:url value='/resource/assets/dist/csshome/style(1).css'/>"
	rel="stylesheet">
	<link href="<c:url value='/resource/assets/dist/css/sidebar.css'/>"
	rel="stylesheet">
<style type="text/css">
.container {
	max-width: 400px;
	
}
</style>
</head>
<body class="booking_table">
	<section class="banner_area">
		<div class="booking_table d_flex align-items-center">
			<div style="transform: translateY(40.7526px);" data-background=""
				data-stellar-vertical-offset="0" data-stellar-ratio="0.9"
				class="overlay bg-parallax"></div>

			<div class="container ">
				<div class="banner_content  mw-50">

					<form:form action="/QuanLyNhaTro/login/index.htm" class="form-signin box3" method="post"
						modelAttribute="user">
						<div class="text-center mb-4">
							<h2 class="h3 mb-3 font-weight-normal text-warning text-center">P@M</h2>
							<div class="h3 mb-3 font-weight-normal text-center">ĐĂNG NHẬP HỆ THỐNG QUẢN LÝ TRỌ</div>

						</div>
						<c:choose>
							<c:when test="${check==null}">

							</c:when>
							<c:otherwise>
								<div class="alert alert-danger border-0" role="alert">
									<strong>${message}</strong>
								</div>
							</c:otherwise>
						</c:choose>
						<div class="form-label-group mb-3">
						<label for="inputEmail">Tên đăng nhập:</label>
							<form:input path="taiKhoan" type="email" id="inputEmail"
								class="form-control" placeholder="Nhập tên đăng nhập" required="required" />
							
						</div>
						
						

						<div class="form-label-group mb-4">
						<label for="inputPassword">Mật khẩu:</label>
							<form:input path="matKhau" type="password" id="inputPassword"
								class="form-control" placeholder="Nhập mật khẩu" required="required" />
							
						</div>
						
						<div class ="text-center">
						<form:button class="btn theme_btn button_hover " type="submit">Đăng nhập</form:button>
						
						</div>
						<div class="text-center">
							<a href="/QuanLyNhaTro/login/forgotpw.htm" class="text-warning font-13 mb-3"><i
								>Quên mật khẩu?</i> </a>
						</div>
						<p class="mt-5 mb-3 text-muted text-center">© 2022-2077</p>

					</form:form>



				</div>
			</div>
		</div>

	</section>
</body>
</html>