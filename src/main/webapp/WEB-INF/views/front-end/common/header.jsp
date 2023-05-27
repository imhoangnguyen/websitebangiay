<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<header class="header" id = "header">
	<!--header-top-content  -->
	<div class="header-content">
		<div class="header-top-content">
			<div class="search">
				<form action="${pageContext.request.contextPath}/search" method = "get">
					<input type="search" class="color-hover" name = "key" id="input-search" placeholder="Tìm kiếm sản phẩm..." required/>
					<button class="color-hover" type = "submit">
						<i class="fas fa-search"></i>
					</button>
					<input type = "hidden" name = "page" value = "1"/>
				</form>
			</div>
			<div class="logo"><a href = "${pageContext.request.contextPath}/">Shoes-shop</a></div>
			<nav class="header-menu menu-upto500">
				<ul class="nav">
					<li class="nav-item ${currentCategorySeo.equals('home') ? 'categoryactive' : ''}"><a class="nav-link color-hover"
						href="${pageContext.request.contextPath}/"> TRANG CHỦ </a></li>
					<li class="nav-item sp"><a class="nav-link color-hover"
						href="${pageContext.request.contextPath}/shoes-shop/product-all">SẢN PHẨM
							&nbsp<i class="fas fa-angle-down"></i>
					</a>
						<ul class="sub-menu sub-menu-sp color-hover">
							<c:forEach var="category" items="${categories}">
								<c:if test="${category.categorytype.equals('sản phẩm')}">
									<li><a href="${base}/shoes-shop/${category.seo}">${category.name}</a></li>
								</c:if>
							</c:forEach>
						</ul></li>
					<li class="nav-item lc"><a class="nav-link color-hover"
						href="${pageContext.request.contextPath}/shoes-shop/accessory-all">PHỤ KIỆN
							KHÁC &nbsp<i class="fas fa-angle-down"></i>
					</a>
						<ul class="sub-menu sub-menu-lc">
							<c:forEach var="category" items="${categories}">
								<c:if test="${category.categorytype.equals('phụ kiện khác')}">
									<li><a href="${base}/shoes-shop/${category.seo}">${category.name}</a></li>
								</c:if>
							</c:forEach>
						</ul></li>
				</ul>
			</nav>
			<div class="account-cart">
			<c:set var="pathUser" value="${pageContext.request.contextPath}/user"/>
			<c:set var="pathUserInfor" value="${pageContext.request.contextPath}/user/info"/>
				<span class="account"><a
					href="${currentUser != null ? pathUserInfor : pathUser}"
					class="color-hover"><i class="far fa-user"></i> ${currentUser != null ? currentUser.getUsername() : 'Tài khoản' }</a></span> <span
					class="cart"> <a href="${pageContext.request.contextPath }/cart" class="color-hover"> 
					<i class="fas fa-cart-plus"></i> 
						<span class="cart-text">Giỏ hàng</span></a>
					<div class="small-circle-cart" id="small-circle-cart">${amount}</div>
				</span> <span class="responsive-menu">
					<div class="rp-menu-exit">
						<i class="fas fa-times"></i>
					</div>
					<button id="rp-menu-btn">
						<i class="fas fa-bars"></i>
						<ul class="nav flex-column content-rp-menu">
							<div class="title-rp-menu">Menu</div>
							<li class="nav-item ${currentCategorySeo.equals('home') ? 'categoryactive' : ''}">
							<a class="nav-link color-hover" href="${pageContext.request.contextPath}/"> TRANG CHỦ </a></li>
							<li class="nav-item sp"><a href="${pageContext.request.contextPath}/shoes-shop/product-all">SẢN PHẨM &nbsp</a><i
								class="fas fa-angle-down sp-icon"></i>
								<ul class="sub-menu-sp color-hover">
									<c:forEach var="category" items="${categories}">
										<c:if test="${category.categorytype.equals('sản phẩm')}">
											<li><a href="${base}/shoes-shop/${category.seo}">${category.name}</a></li>
										</c:if>
									</c:forEach>
								</ul></li>
							<li class="nav-item lc">
							<a href="${pageContext.request.contextPath}/shoes-shop/accessory-all">PHỤ KIỆN
									KHÁC &nbsp</a><i class="fas fa-angle-down lc-icon"></i>
								<ul class="sub-menu-lc">
									<c:forEach var="category" items="${categories}">
										<c:if test="${category.categorytype.equals('phụ kiện khác')}">
											<li><a href="${base}/shoes-shop/${category.seo}">${category.name}</a></li>
										</c:if>
									</c:forEach>
								</ul></li>
							<li class="nav-item rp-account"><!-- <a
								href="${pageContext.request.contextPath}/userlogin"> -->
								<span class="account">
								<a href="${currentUser != null ? pathUserInfor : pathUser}" class="color-hover"><i class="far fa-user"></i> ${currentUser != null ? currentUser.getUsername() : 'Tài khoản' }</a></span></i></li>
						</ul>
					</button>
				</span>
			</div>
		</div>
		<!-- responsive-search -->
		<div class="search responsive-search">
			<form action="${pageContext.request.contextPath}/search" method = "get">
				<input type="search" name="key" class="color-hover"
					placeholder="Tìm kiếm sản phẩm..." required>
				<button class="color-hover">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
		<!-- /responsive-search -->
		<!-- menu -->
		<nav class="header-menu">
			<ul class="nav">
				<li class="nav-item ${currentCategorySeo.equals('home') ? 'categoryactive' : ''}"><a class="nav-link color-hover"
					href="${pageContext.request.contextPath}/"> TRANG CHỦ </a></li>
				<li class="nav-item sp"><a class="nav-link color-hover"
					href="${pageContext.request.contextPath}/shoes-shop/product-all">SẢN PHẨM
						&nbsp<i class="fas fa-angle-down"></i>
				</a>
					<ul class="sub-menu sub-menu-sp color-hover">
						<c:forEach var="category" items="${categories}">
							<c:if test="${category.categorytype.equals('sản phẩm')}">
								<li><a href="${base}/shoes-shop/${category.seo}">${category.name}</a></li>
							</c:if>
						</c:forEach>
					</ul></li>
				<li class="nav-item lc"><a class="nav-link color-hover"
					href="${pageContext.request.contextPath}/shoes-shop/accessory-all">PHỤ KIỆN KHÁC &nbsp<i class="fas fa-angle-down"></i></a>
					<ul class="sub-menu sub-menu-lc">
						<c:forEach var="category" items="${categories}">
							<c:if test="${category.categorytype.equals('phụ kiện khác')}">
								<li><a href="${base}/shoes-shop/${category.seo}">${category.name}</a></li>
							</c:if>
						</c:forEach>
					</ul></li>
			</ul>
		</nav>
		<!-- /menu -->	
	</div>
	<!-- header-top-content -->
	<!-- status -->
	<hr class = "gn" style = "display:${currentCategorySeo.equals('home') ? 'none' : ''}">
	<span class = "status" style = "display:${currentCategorySeo.equals('home') ? 'none' : ''}">
	${!currentCategorySeo.equals('home') ? status : ''}</span>
	<!-- /status -->
</header>