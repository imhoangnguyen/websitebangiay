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
						<p class="right__desc">${danhmuc }</p>
						<div class="right__formWrapper">
							<form:form action="${pageContext.request.contextPath}/admin/addcategory" modelAttribute="category" method="post">
								<form:hidden path="id" />
								<div class="right__inputWrapper">
									<label for="title">Tiêu đề</label> 
									<form:input path = "name" type="text" placeholder="Tiêu đề"/>
								</div>
								<div class="right__inputWrapper">
									<label for="desc">Mô tả</label>
									<form:textarea path ="description" id="editor" cols="30" rows="10" placeholder="Mô tả"></form:textarea>
								</div>
								<div class="right__inputWrapper">
								<label for="label">Thuộc danh mục cha</label> 
									<form:select path="categorytype">
										<form:option value="sản phẩm" label="sản phẩm"/>
										<form:option value="phụ kiện khác" label="phụ kiện khác"/>
									</form:select>
								</div>
								<button class="btn" type="submit">Chèn</button>
								
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	${message}
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/ckeditor.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/sweetalert/sweetalert2.js"></script>
</body>
</html>