<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<form:form action = "${pageContext.request.contextPath}/user/saveorder" method = "post" modelAttribute = "order" class="frmaccount">
				<h1>XÁC NHẬN ĐƠN HÀNG</h1>
				<h3>Thông tin giao hàng</h3>
				<form:input type="text" path = "customerName" name="name" class="text" placeholder="Họ và tên" required="required" />
				<form:input type="text" path = "customerEmail" name="Email" class="text" placeholder="Email" required="required"/> 
				<form:input type="tel" pattern="[0-9]{10}" path ="customerPhone" name="telephone_number" class="text" placeholder="1234-456-678" required="required"/> </br> 
				<form:input type="text" path = "customerAddress" name="adress" class="text" placeholder="Địa chỉ" required="required"/>
				<input type="submit" value="XÁC NHẬN" id="btn-send"> </br> <span> </span>
			</form:form>
		</div>
		<!-- /slider -->
		<!-- content -->
		<div class="content"></div>
		<!-- /content -->
		<jsp:include page="/WEB-INF/views/front-end/common/footer.jsp"></jsp:include>
	</div>
</body>
${message}
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/shop.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.js"></script>
</html>