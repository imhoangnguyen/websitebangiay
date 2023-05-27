<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Chi tiết</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
<jsp:include page="/WEB-INF/views/front-end/common/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/stylechitiet.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.css">
</head>
<body>
	<div class="wrapper">
		<!-- title -->
		<div class="title">Welcome to shoes-shop!</div>
		<!-- /title -->
		<!-- menu -->
		<jsp:include page="/WEB-INF/views/front-end/common/header.jsp"></jsp:include>
		<!-- /menu -->
		<!-- content -->
		<div class="content">
			<div class="container-fluid">
				<div class="row justify-content-center">
					<div class="col-xl-8 left-info">
						<fieldset style="width: 85%;margin:auto;height: 600px;">
							<div class="box" id="box">
								<img src="${pageContext.request.contextPath}/file/uploads/${product.getProductImages().size() > 0 ? product.getProductImages().get(0).path : 'unnamed.png'}" id="image">
							</div>
							<div class="sub">
								<ul>
									<c:forEach var = "image" items = "${product.getProductImages()}">
										<li><img id="${image.id}" src="${pageContext.request.contextPath}/file/uploads/${image.path}" onclick="changeImage(${image.id})"></li>
									</c:forEach>
								</ul>
							</div>
						</fieldset>
					</div>
					<div class="col-xl-4 right-info">
						<h3>${product.title}</h3>
						<div class="code-prd">
							Code:<span>${product.id}</span>
						</div>
						<h5><span class = "price">${product.price_sale != null ? product.getPriceFormat(product.price_sale) : product.getPriceFormat(product.price)}</span></h5>
						<div class="amount">
							<button class="btn minus">-</button>
							<div class="current-amount">1</div>
							<button class="btn plus">+</button>
						</div>
						<h4>Size</h4>
						<div id = "size">
							<span id = "${product.getSizes().size() > 0 ? product.getSizes().get(0).getSize() : ''}" class = "btn btn-outline-dark selected" onclick = "buttonSelected(${product.getSizes().size() > 0 ? product.getSizes().get(0).getSize() : ''})">${product.getSizes().size() > 0 ? product.getSizes().get(0).getSize() : ''}</span>
							<c:forEach var = "size" items = "${product.getSizes()}">
							<c:if test = "${product.getSizes().indexOf(size) != 0}">
								<span id = "${size.getSize()}" class = "btn btn-outline-dark" onclick = "buttonSelected(${size.getSize()})">${size.getSize()}</span>
							</c:if>
							</c:forEach>
						</div>
						<br>
						<h4>Đánh giá</h4>
						<ul class="pagination">
							<li><a href="#" class="s1"><i class="far fa-star"></i></a></li>
							<li><a href="#" class="s2"><i class="far fa-star"></i></a></li>
							<li><a href="#" class="s3"><i class="far fa-star"></i></a></li>
							<li><a href="#" class="s4"><i class="far fa-star"></i></a></li>
							<li><a href="#" class="s5"><i class="far fa-star"></i></a></li>
						</ul>
						<div class="btn-more ct-add-btn">
							<a onclick = "Shop.cartData(${product.id},parseInt($('.current-amount').html()),parseInt($('.selected').html()))" >THÊM VÀO GIỎ</a>
						</div>
						<div class="tab">
							<ul class="nav nav-tabs" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									data-toggle="tab" href="#home">Giới thiệu</a></li>
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#menu1">Chất liệu & kỹ thuật</a></li>
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#menu2">Bình luận</a></li>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div id="home" class="container tab-pane active">
									<br>
									<p>${product.shortDetails}</p>
								</div>
								<div id="menu1" class="container tab-pane fade">
									<br>
									<p>${product.metarial_vs_skill}</p>
								</div>
								<div id="menu2" class="container tab-pane fade">
									<br>
									<p></p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row justify-content-center splq">
					<div class="col-12">
						<h2>SẢN PHẨM LIÊN QUAN</h2>
					</div>
					<div class="col-12">
						<div class="row justify-content-center">
						<c:forEach var ="product" items = "${products }">
						<c:if test="${ products.indexOf(product) < 5}">
							<div class="col-xl-2 col-lg-2 col-md-5 prd prd1">
								<a href="${pageContext.request.contextPath}/products/${product.seo}"> <img
									src="${pageContext.request.contextPath}/file/uploads/${product.avatar}">
								</a>
								<div class="cost">
									<b>${product.title}</b>
									<span style="display:${product.price_sale != null ? 'inline' :'none' }" class = "price">${product.getPriceFormat(product.price_sale)}</span>
									&nbsp &nbsp
									<span class = " price ${product.price_sale != null ? 'old-cost' :'' }">${product.getPriceFormat(product.price)}</span> 
								</div>
							</div>
							</c:if>
						</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /content -->
		<jsp:include page="/WEB-INF/views/front-end/common/footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/shop.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/scroll.js"></script>
<script src="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.js"></script>
</html>