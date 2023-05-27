<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<p class="right__desc">Xem slides</p>
						<div class="right__slidesWrapper">
							<div class="right__slides" id = "right__slides">
							<c:forEach var = "slide" items = "${slides}">
								<div class="right__slide">
									<div class="right__slideTitle">${slide.getTitle()}</div>
									<div class="right__slideImage">
										<img
											src="${pageContext.request.contextPath}/file/uploads/slides/${slide.getImage()}"
											alt="">
									</div>
									<div class="right__slideIcons">
										<a class="right__slideIcon"
											href="${pageContext.request.contextPath}/admin/addslide/${slide.getId()}"><img
											src="${pageContext.request.contextPath}/assets/icon-pencil.svg"
											alt=""></a> 
											<a class="right__slideIcon" onclick = "deleteSlide(${slide.getId()})"><img
											src="${pageContext.request.contextPath}/assets/icon-trash.svg"
											alt=""></a>
									</div>
								</div>
							</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.js"></script>
</body>
</html>