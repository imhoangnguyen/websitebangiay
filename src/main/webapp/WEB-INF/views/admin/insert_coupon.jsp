<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
						<p class="right__desc">Chèn mã giảm giá</p>
						<div class="right__formWrapper">
							<form action="" method="post">
								<div class="right__inputWrapper">
									<label for="title">Tiêu đề</label> <input type="text"
										placeholder="Tiêu đề">
								</div>
								<div class="right__inputWrapper">
									<label for="price">Giá SP</label> <input type="text"
										placeholder="Giá SP">
								</div>
								<div class="right__inputWrapper">
									<label for="limit">Giới hạn</label> <input type="number"
										placeholder="Giới hạn">
								</div>
								<div class="right__inputWrapper">
									<label for="product">Chọn sản phẩm</label> <select name="">
										<option disabled selected>Chọn sản phẩm</option>
										<option value="">Kota dress</option>
										<option value="">Huno dress</option>
										<option value="">Beta dress</option>
									</select>
								</div>
								<div class="right__inputWrapper">
									<label for="code">Mã giảm giá</label> <input type="text"
										placeholder="Mã giảm giá">
								</div>
								<button class="btn" type="submit">Chèn</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>