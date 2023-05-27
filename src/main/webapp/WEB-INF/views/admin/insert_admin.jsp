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
						<p class="right__desc">Chèn admin</p>
						<div class="right__formWrapper">
							<form action="" method="post">
								<div class="right__inputWrapper">
									<label for="name">Tên admin</label> <input type="text"
										placeholder="Tên admin">
								</div>
								<div class="right__inputWrapper">
									<label for="email">Email</label> <input type="text"
										placeholder="Email">
								</div>
								<div class="right__inputWrapper">
									<label for="password">Mật khẩu</label> <input type="text"
										placeholder="Mật khẩu">
								</div>
								<div class="right__inputWrapper">
									<label for="image">Hình ảnh</label> <input type="file">
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