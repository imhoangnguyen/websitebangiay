<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/loginstyle.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
	<div class="wrapper">
		<div class="leftLogin">
			<h1>
				<b>Login</b>
			</h1>
			<div class="content">
				<form action="${pageContext.request.contextPath}/admin"
					method="POST">
					<input type="text" name="username" id="username"
						placeholder="Username..." required> <input type="password"
						name="password" id="password" placeholder="Password..." required>
					<br> <input type="submit" id="btn-send" class="btn"
						value="submit">
				</form>
			</div>
			<footer>
			${error_message_accessing}
				<c:if test="${not empty param.error_login}">
					<div class="alert alert-danger" role="alert">
						Tài khoản hoặc mật khẩu không chính xác
					</div>
				</c:if>
				<a href="#">Forgot password ?</a>
			</footer>
		</div>
	</div>
</body>
</html>