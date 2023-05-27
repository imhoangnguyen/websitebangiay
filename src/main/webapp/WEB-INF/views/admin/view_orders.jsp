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
						<p class="right__desc">Xem đơn hàng</p>
						<div class="right__table" id = "refreshTable">
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
											<th>Xoá</th>
											<th>Thanh toán</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="order" items="${allOrder}">
										<tr>
											<td data-label="STT">${allOrder.indexOf(order) + 1}</td>
											<td data-label="HỌ VÀ TÊN">${order.customerName}</td>
											<td data-label="SDT">${order.customerPhone}</td>
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
											<td data-label="Trạng Thái">${order.pay == false ? 'Đang xử lý' : 'Đã xử lý'}</td>
											<td data-label="Xoá" class="right__iconTable"><a onclick = "deleteOrder(${order.id})"><img
													src="${pageContext.request.contextPath}/assets/icon-trash-black.svg"
													alt=""></a></td>
											<td data-label="Thanh toán" class="right__confirm"><a
												onclick = "setPay(${order.id})" class="right__iconTable" style = "display:${order.pay == false ? 'inline' : 'none'}">Xác nhận <img
													src="${pageContext.request.contextPath}/assets/icon-check.svg"
													alt=""></a>
													${order.pay == true ? 'Đã thanh toán' : ''}
													</td>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>