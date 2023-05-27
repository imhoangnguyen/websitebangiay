<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<form action="${pageContext.request.contextPath}/account" method="POST"
	class="frmaccount">
	<h1>ĐĂNG NHẬP</h1>
	<input type="text" name="username" class="text" placeholder="Tài khoản">
	</br> <input type="text" name="password" class="text" placeholder="Mật khẩu">
	</br> <input type="button" value="ĐĂNG NHẬP" id="login"> </br> <span>
		<a href="${pageContext.request.contextPath }/accountSignIn">Đăng
			kí</a> or <a
		href="${pageContext.request.contextPath }/accountForgetPassword">Quên
			mật khẩu</a>
	</span>
</form>