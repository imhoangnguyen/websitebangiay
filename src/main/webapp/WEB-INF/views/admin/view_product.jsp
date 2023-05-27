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
					<div class="right__content" id = "product__table">
						<div class="right__title">Bảng điều khiển</div>
						<p class="right__desc">Xem sản phẩm</p>
						<div class="right__table">
							<div class="right__tableWrapper">
								<table>
									<thead>
										<tr>
											<th>STT</th>
											<th>Tên sản phẩm</th>
											<th>Hình ảnh</th>
											<th>Giá cũ SP</th>
											<th>Giá mới</th>
											<th>Thời gian</th>
											<th>Sửa</th>
											<th>Xoá</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="product" items="${products}">
											<tr>
												<td data-label="STT">${products.indexOf(product)+1}</td>
												<td data-label="Tên sản phẩm">${product.title}</td>
												<td data-label="Hình ảnh"><img
													src="${pageContext.request.contextPath}/file/uploads/${product.avatar}"
													alt=""></td>
												<td data-label="Giá cũ">${product.price}</td>
												<td data-label="Giá mới">${product.price_sale != null ? product.price_sale : 'chưa có'}</td>
												<td data-label="Thời gian">${product.formatDate(product.createdDate)}</td>
												<td data-label="Sửa" class="right__iconTable"><a
													href="${pageContext.request.contextPath}/admin/repairproduct/${product.id}"><img
														src="${pageContext.request.contextPath}/assets/icon-edit.svg"
														alt=""></a></td>
												<td data-label="Xoá" class="right__iconTable"><a
													onclick="deletePrd(${product.id});"><img
														src="${pageContext.request.contextPath}/assets/icon-trash-black.svg"
														alt=""></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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
	<script src="${pageContext.request.contextPath}/js/sweetalert/sweetalert2.js"></script>
	${message}
</body>
</html>