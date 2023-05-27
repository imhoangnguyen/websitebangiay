<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/fontawesome/fontawesome-free-5.14.0-web/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
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
						<p class="right__desc">${title }</p>
						<div class="right__formWrapper">
							<form:form
								action="${pageContext.request.contextPath}/admin/addproduct"
								modelAttribute="product" method="post"
								enctype="multipart/form-data">
								<form:hidden path="id" />
								<div class="right__inputWrapper">
									<label for="title">Tiêu đề</label>
									<form:input type="text" placeholder="Tiêu đề" path="title" />
								</div>
								<div class="right__inputWrapper">
									<label for="p_category">Danh mục</label>
									<form:select class="form-control form-control-line"
										path="category.id">
										<!-- product.getCategory().setId() -->
										<form:options items="${categories}" itemValue="id"
											itemLabel="name" />
									</form:select>
								</div>
								<div class="right__inputWrapper">
									<label for="image">Ảnh sản phẩm(Tên ảnh chứa chữ avatar sẽ được đặt làm avatar)</label> <input type="file"
										name="product_images" multiple="multiple">
								</div>
								<div class="right__inputWrapper">
									<label for="label">Nhãn sản phẩm</label> 
									<form:select path="producttype">
										<form:option value="san-pham-moi-nhat" label="Sản phẩm mới nhất"/>
										<form:option value="san-pham-giam-gia" label="Sản phẩm giảm giá"/>
										<form:option value="san-pham-noi-bat" label="Sản phẩm nổi bật"/>
									</form:select>
								</div>
								<div class="right__inputWrapper">
									<label for="title">Giá sản phẩm</label>
									<form:input type="tel" pattern="[0-9' ']*" placeholder="Giá sản phẩm" path="price" />
								</div>
								<div class="right__inputWrapper">
									<label for="title">Giá sản phẩm giảm còn</label>
									<form:input type="tel" pattern="[0-9' ']*" placeholder="Giá sản phẩm sau khi giảm" path="price_sale" />
								</div>
								<div class="right__inputWrapper">
									<label for="desc">Mô tả ngắn</label>
									<form:textarea id="editor"
										placeholder="Mô tả được hiển thị ở sản phẩm"
										class="form-control" path="shortDes" />
								</div>
								<div class="right__inputWrapper">
									<label>Chất liệu và kĩ thuật</label>
									<form:textarea id="editor1"
										placeholder="Chất liệu và kĩ thuật"
										class="form-control" path="metarial_vs_skill" />
								</div>
								<div class="right__inputWrapper">
									<label>Details description</label>
									<form:textarea id="editor3"
										placeholder="Mô tả được hiển thị ở chi tiết sản phẩm"
										class="form-control" path="shortDetails" />
								</div>
								<h2>Các biến thể</h2>
								<br>
								<div class="right__inputWrapper">
									<label for="title">Kích thước</label>
									<form:input type="tel" pattern="[0-9]{2}([-]{1}([[0-9]){2}){0,6}" path = "size"  class="text" placeholder="12-34-56..." required="required"/> 
								</div>
								<div class="right__inputWrapper">
									<label for="title">Màu sắc(chữ in thường không dấu)</label>
									<form:input type="tel" pattern="[a-z]{0,5}([-]{1}([[a-z]){0,5}){0,6}" path = "color"  class="text" placeholder="xanh-do-tim..." required="required"/> 
								</div>
								<button class="btn" type="submit">Chèn</button>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
${message}
<script src="${pageContext.request.contextPath}/js/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/editor-solution.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.js"></script>
</html>