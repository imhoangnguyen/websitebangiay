<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Giày đẹp</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
<jsp:include page="/WEB-INF/views/front-end/common/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/stylechitiet.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/account.css">

</head>
<body>
	<div class="wrapper">
		<!-- message -->
		<div class="message">
			<img src="../../images/logo/messege-image.png">
			<div class="message-text">Xin chào bạn ! chúng tôi có thể giúp
				gì cho bạn ?</div>
			<div class="message-box">
				<header class="header-box">Chăm sóc khách hàng</header>
				<div class="content-box"></div>
				<div class="text-typing">
					<form action="#">
						<input type="text" placeholder="Aa">
						<button>
							<i class="fas fa-paper-plane"></i>
						</button>
					</form>
				</div>
			</div>
		</div>
		<!-- /message -->
		<!-- title -->
		<div class="title">Welcome to shoes-shop!</div>
		<!-- /title -->
		<!-- slider -->
		<div class="slider">
			<jsp:include page="/WEB-INF/views/front-end/common/header.jsp"></jsp:include>
			<form action="${pageContext.request.contextPath}/user" method="POST"
				class="frmaccount">
				<h1>ĐĂNG NHẬP</h1>
				<input type="text" id ="username" name="username" class="text" placeholder="Tài khoản"
					required> </br> <input type="password" id ="password" name="password" class="text"
					placeholder="Mật khẩu" required> </br> 
					<input type="submit" value="ĐĂNG NHẬP" id="btn-send"> </br> 
					<span> <a
					href="${pageContext.request.contextPath }/accountRegister">Đăng kí</a>
					or <a href="${pageContext.request.contextPath }/forgetPassword">Quên
						mật khẩu</a>
					</span>
					<c:if test="${not empty param.error_login}">
					<div class="alert alert-danger" role="alert">
						Tài khoản hoặc mật khẩu không chính xác
					</div>
				</c:if>
			</form>
		</div>
		<!-- /slider -->
		<!-- content -->
		<div class="content"></div>
		<!-- /content -->
		<jsp:include page="/WEB-INF/views/front-end/common/footer.jsp"></jsp:include>
	</div>
</body>
</html>