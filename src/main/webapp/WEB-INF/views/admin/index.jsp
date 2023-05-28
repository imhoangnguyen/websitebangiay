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
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="dashboard">
				<jsp:include page="/WEB-INF/views/admin/common/leftContent.jsp"></jsp:include>
				<div class="right">
					<div class="right__content">
						<div class="right__title">Bảng điều khiển</div>
						<p class="right__desc">Bảng điều khiển</p>
						<div class="right__cards">
							<a class="right__card"
								href="${pageContext.request.contextPath}/admin/product">
								<div class="right__cardTitle">Sản Phẩm</div>
	
								<div class="right__cardDesc">
									Xem Chi Tiết <img
										src="${pageContext.request.contextPath}/assets/arrow-right.svg"
										alt="">
								</div>
							</a> <a class="right__card"
								href="${pageContext.request.contextPath}/admin/viewcustomers">
								<div class="right__cardTitle">Khách Hàng</div>
								
								<div class="right__cardDesc">
									Xem Chi Tiết <img
										src="${pageContext.request.contextPath}/assets/arrow-right.svg"
										alt="">
								</div>
							</a> <a class="right__card"
								href="${pageContext.request.contextPath}/admin/viewcategory">
								<div class="right__cardTitle">Danh Mục</div>
								
								<div class="right__cardDesc">
									Xem Chi Tiết <img
										src="${pageContext.request.contextPath}/assets/arrow-right.svg"
										alt="">
								</div>
							</a> <a class="right__card"
								href="${pageContext.request.contextPath}/admin/vieworder">
								<div class="right__cardTitle">Đơn Hàng</div>
								
								<div class="right__cardDesc">
									Xem Chi Tiết <img
										src="${pageContext.request.contextPath}/assets/arrow-right.svg"
										alt="">
								</div>
							</a>
						</div>
						<div class="right__table">
							<p class="right__tableTitle">Đơn hàng ngày hôm nay</p>
							<div class="right__tableWrapper">
								<table>
									<thead>
										<tr>
											<th>STT</th>
											<th>HỌ VÀ TÊN</th>
											<th>SDT</th>
											<th>Số Hoá Đơn</th>
											<th>ID Sản Phẩm</th>
											<th>Số Lượng</th>
											<th>Kích thước</th>
											<th>Tổng tiền</th>
											<th>Trạng Thái</th>
										</tr>
									</thead>

									<tbody>
									<c:forEach var="order" items="${orders}">
										<tr>
											<td data-label="STT">${orders.indexOf(order) + 1}</td>
											<td data-label="HỌ VÀ TÊN">${order.customerName}</td>
											<td data-label="SDT" style="text-align: left;">${order.customerPhone}</td>
											<td data-label="Số Hoá Đơn">${order.code}</td>
											<td data-label="ID Sản Phẩm">
											<c:forEach var="product" items="${order.saleOrderProducts}">
												<div>${product.getProduct().getId()}</div>
											</c:forEach>
											</td>
											<td data-label="Số Lượng">
											<c:forEach var="product" items="${order.saleOrderProducts}">
												<div>${product.getQuality()}</div>
											</c:forEach>
											</td>
											<td data-label="Kích thước">
												<c:forEach var="product" items="${order.saleOrderProducts}">
												<div>${product.getSize()}</div>
												</c:forEach>
											</td>
											<td data-label="Tổng tiền">
												${order.getTotal()}
											</td>
											<td data-label="Trạng Thái">${order.pay == false ? 'Đang xử lý' : 'Đã thanh toán'}</td>
										</tr>
									</tbody>
									</c:forEach>
								</table>
							</div>
							<a href="${pageContext.request.contextPath}/admin/vieworder" class="right__tableMore"><p>Xem tất cả các đơn
									đặt hàng</p> <img
								src="${pageContext.request.contextPath}/assets/arrow-right-black.svg"
								alt=""></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>
