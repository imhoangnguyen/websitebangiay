<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.css">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="dashboard">
				<jsp:include page="/WEB-INF/views/admin/common/leftContent.jsp"></jsp:include>
				<div class="right">
					<div class="right__content">
						<div class="right__title">Bảng điều khiển</div>
						<p class="right__desc">Chèn slide</p>
						<div class="right__formWrapper">
							<form:form action="${pageContext.request.contextPath}/admin/addslide" method="post" modelAttribute = "slide" enctype="multipart/form-data">
								<form:hidden path = "id" />
								<div class="right__inputWrapper">
									<label for="name">Tên slide</label> 
									<form:input type="text" path = "title" placeholder="Tên slide" />
								</div>
								<div class="right__inputWrapper">
									<label for="url">Url</label> 
									<form:input type="text" path = "url" placeholder="Url"/>
								</div>
								<div class="right__inputWrapper">
									<label for="image">Hình ảnh</label> 
									<input type="file" name = "slide_image">
								</div>
								<button class="btn" type="submit">Chèn</button>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/sweetalert/sweetalert2.js"></script>
	${message}
</body>
</html>