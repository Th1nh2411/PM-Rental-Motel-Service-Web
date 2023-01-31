<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Required meta tags -->

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>P@M System</title>

<link
	href="<c:url value='/resource/assets/dist/csshome/bootstrap.css'/>"
	rel="stylesheet">

<link href="<c:url value='/resource/assets/dist/csshome/style(1).css'/>"
	rel="stylesheet">
<style type="text/css">
.container {
	max-width: 450px;
}

.login {
	border: 1px solid #777777;
	border-radius: 10px;
	background-color: rgba(249, 249, 255, 0.102);
	padding: 31px 40px 37px;
	color: #fff;
	margin-bottom: 30px;
}
</style>
</head>
<body class="booking_table">
	<section class="banner_area">
		<div class="booking_table d_flex align-items-center">
			<div style="transform: translateY(40.7526px);" data-background=""
				data-stellar-vertical-offset="0" data-stellar-ratio="0.9"
				class="overlay bg-parallax"></div>

			<div class="container login">
				<div class="banner_content  mw-50">


					<div class="text-center mb-4">
						<h2 class="h3 mb-3 font-weight-normal text-warning">P@M</h2>


					</div>
					<div class="card-body">

						<c:if test="${show=='sendCode'}">
							<c:choose>
								<c:when test="${message==null}">
									<div class="h3 alert  border-0 text-center" role="alert">
										ĐẶT LẠI MẬT KHẨU
									</div>
								</c:when>
								<c:otherwise>
									<div class="alert alert-danger border-0" role="alert">
										<strong>Thông báo!</strong> ${message}.
									</div>
								</c:otherwise>
							</c:choose>
							<form class="form-horizontal auth-form" action="sendcode.htm"
								method="post">
								<div class="form-group mb-2">
									<label class="form-label" for="username">Tên đăng
										nhập:</label>
									<div class="input-group">
										<input name="taiKhoan" type="email" class="form-control"
											id="email" placeholder="Nhập tên đăng nhập">
									</div>
								</div>
								<!--end form-group-->

								<div class="form-group mb-0 row">
									<div class="col-12 mt-2">
										<button class="btn btn-primary w-100 waves-effect waves-light"
											type="submit">
											Gửi mã xác nhận <i class="fas fa-sign-in-alt ms-1"></i>
										</button>
									</div>
									<!--end col-->
								</div>
								<!--end form-group-->
							</form>
							<!--end form-->
							<p class="text-warning mb-0 mt-3 text-center">
								Remember It ? <a href="index.htm" class="text-primary ms-2">Sign
									in here</a>
							</p>
						</c:if>
						<c:if test="${show=='confirmCode'}">
							<c:choose>
								<c:when test="${check=='success'}">
									<div class="alert alert-success border-0" role="alert">
										<strong>Thông báo!</strong> ${message}.
									</div>
								</c:when>
								<c:otherwise>
									<div class="alert alert-danger border-0" role="alert">
										<strong>Thông báo!</strong> ${message}.
									</div>
								</c:otherwise>
							</c:choose>
							<form class="form-horizontal auth-form" action="confirmcode.htm"
								method="post">
								<div class="form-group mb-2">
									<label class="form-label" for="username">Mã xác nhận</label>
									<div class="input-group">
										<input name="confirmCode" type="text" class="form-control"
											placeholder="Nhập mã xác nhận">
									</div>
								</div>
								<!--end form-group-->
								<div class="form-group mb-0 row">
									<div class="col-12 mt-2">
										<button class="btn btn-primary w-100 waves-effect waves-light"
											type="submit">
											Xác nhận <i class="fas fa-sign-in-alt ms-1"></i>
										</button>
									</div>
									<!--end col-->
								</div>
								<!--end form-group-->
							</form>
							<!--end form-->
							<p class="text-muted mb-0 mt-3">
								Remember It ? <a href="/login/index.htm"
									class="text-primary ms-2">Sign in here</a>
							</p>
						</c:if>
						<c:if test="${show=='newPassword'}">
							<c:choose>
								<c:when test="${check==null}">
								</c:when>
								<c:when test="${check=='success'}">
									<div class="alert alert-success border-0" role="alert">
										<strong>Thông báo!</strong> ${message}.
									</div>
								</c:when>
								<c:otherwise>
									<div class="alert alert-danger border-0" role="alert">
										<strong>Thông báo!</strong> ${message}.
									</div>
								</c:otherwise>
							</c:choose>

								<!--end form-group-->
								<div class="form-group mb-0 row">
									<div class="col-12 mt-2">
										<c:choose>
											<c:when test="${check=='success'}">
												<a href="index.htm"
													class="btn btn-primary w-100 waves-effect waves-light">
													Quay lại trang chủ <i class="fas fa-sign-in-alt ms-1"></i>
												</a>
											</c:when>
											<c:otherwise>
												<form class="form-horizontal auth-form" action="newpw.htm"
													method="post">
													<div class="form-group mb-2">
														<label class="form-label" for="username">Mật khẩu
															mới</label>
														<div class="input-group">
															<input name="newpw" type="password" class="form-control"
																placeholder="Nhập mật khẩu mới" pattern="{1,50}">
														</div>
													</div>
													<div class="form-group mb-2">
														<label class="form-label" for="username">Xác nhận
															mật khẩu</label>
														<div class="input-group">
															<input name="confirmpw" type="password"
																class="form-control" id="email"
																placeholder="Nhập lại mật khẩu mới" pattern="{1,50}">
														</div>
													</div>


													<button
														class="btn btn-primary w-100 waves-effect waves-light"
														type="submit">
														Thay đổi <i class="fas fa-sign-in-alt ms-1"></i>
													</button>
											</c:otherwise>
										</c:choose>

									</div>

								</div>
						</c:if>







					</div>
				</div>
			</div>
	</section>
</body>
</html>