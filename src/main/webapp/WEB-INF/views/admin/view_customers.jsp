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
						<p class="right__desc">Xem sản phẩm</p>
						<div class="right__table" id = "refreshTable">
							<div class="right__tableWrapper">
								<table>
									<thead>
										<tr>
											<th>STT</th>
											<th>Tên</th>
											<th>Email</th>
											<th>Phone</th>
											<th>Địa chỉ</th>
											<th>Xoá</th>
										</tr>
									</thead>

									<tbody>
									<c:forEach var="customer" items="${customers}">
										<tr>
											<td data-label="STT">${customers.indexOf(customer) + 1}</td>
											<td data-label="Tên">${customer.getCustomerName()}</td>
											<td data-label="Email">${customer.getCustomerEmail()}</td>
											<td data-label="Phone">${customer.getCustomerPhone()}</td>
											<td data-label="Địa chỉ">${customer.getCustomerAddress()}</td>
											<td data-label="Xoá" class="right__iconTable"><a onclick = "deleteCustomer(${customer.id})"><img
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

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>