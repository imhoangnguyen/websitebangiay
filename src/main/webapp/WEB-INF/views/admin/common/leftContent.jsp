<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="com.shoes_shop.entities.User"%>
<%!
	public String getEmailUserLogined() {
		String email = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			email = ((User)principal).getEmail();
		}
		return email;
	}
%>
<div class="left">
	<span class="left__icon"> <span></span> <span></span> <span></span>
	</span>
	<div class="left__content">
		<div class="left__logo">Shoes-shop</div>
		<div class="left__profile">
			<div class="left__image">
				<img src="${pageContext.request.contextPath}/assets/profile1.jpg"
					alt="">
			</div>
			<p class="left__name"><%=getEmailUserLogined()%></p>
		</div>
		<ul class="left__menu">
			<li class="left__menuItem"><a
				href="${pageContext.request.contextPath}/admin/dashboard"
				class="left__title"><img
					src="${pageContext.request.contextPath}/assets/icon-dashboard.svg"
					alt="">Dashboard</a></li>
			<li class="left__menuItem">
				<div class="left__title">
					<img src="${pageContext.request.contextPath}/assets/icon-tag.svg"
						alt="">Sản Phẩm<img class="left__iconDown"
						src="${pageContext.request.contextPath}/assets/arrow-down.svg"
						alt="">
				</div>
				<div class="left__text">
					<a class="left__link"
						href="${pageContext.request.contextPath}/admin/addproduct">Thêm
						Sản Phẩm</a> <a class="left__link"
						href="${pageContext.request.contextPath}/admin/product">Xem
						Sản Phẩm</a>
				</div>
			</li>
			<li class="left__menuItem">
				<div class="left__title">
					<img src="${pageContext.request.contextPath}/assets/icon-edit.svg"
						alt="">Danh Mục SP<img class="left__iconDown"
						src="${pageContext.request.contextPath}/assets/arrow-down.svg"
						alt="">
				</div>
				<div class="left__text">
					<a class="left__link"
						href="${pageContext.request.contextPath}/admin/addcategory">Thêm
						Danh Mục</a> <a class="left__link"
						href="${pageContext.request.contextPath}/admin/viewcategory">Xem
						Danh Mục</a>
				</div>
			</li>
			<!-- <li class="left__menuItem">
				<div class="left__title">
					<img src="${pageContext.request.contextPath}/assets/icon-book.svg"
						alt="">Thể Loại<img class="left__iconDown"
						src="${pageContext.request.contextPath}/assets/arrow-down.svg"
						alt="">
				</div>
				
				<div class="left__text">
					<a class="left__link"
						href="${pageContext.request.contextPath}/admin/addtypeproduct">Thêm
						Thể Loại</a> <a class="left__link"
						href="${pageContext.request.contextPath}/admin/viewtypeproduct">Xem
						Thể Loại</a>
				</div>
			</li>-->
			<li class="left__menuItem">
				<div class="left__title">
					<img
						src="${pageContext.request.contextPath}/assets/icon-settings.svg"
						alt="">Slide<img class="left__iconDown"
						src="${pageContext.request.contextPath}/assets/arrow-down.svg"
						alt="">
				</div>
				<div class="left__text">
					<a class="left__link"
						href="${pageContext.request.contextPath}/admin/addslide">Thêm
						Slide</a> <a class="left__link"
						href="${pageContext.request.contextPath}/admin/viewslide">Xem
						Slide</a>
				</div>
			</li>
			<!-- 
			<li class="left__menuItem">
				<div class="left__title">
					<img src="${pageContext.request.contextPath}/assets/icon-book.svg"
						alt="">Coupons<img class="left__iconDown"
						src="${pageContext.request.contextPath}/assets/arrow-down.svg"
						alt="">
				</div>
				<div class="left__text">
					<a class="left__link"
						href="${pageContext.request.contextPath}/admin/addcoupons">Thêm
						Coupon</a> <a class="left__link"
						href="${pageContext.request.contextPath}/admin/viewcoupons">Xem
						Coupons</a>
				</div>
			</li> -->
			<li class="left__menuItem"><a
				href="${pageContext.request.contextPath}/admin/viewcustomers"
				class="left__title"><img
					src="${pageContext.request.contextPath}/assets/icon-users.svg"
					alt="">Khách Hàng</a></li>
			<li class="left__menuItem"><a
				href="${pageContext.request.contextPath}/admin/vieworder"
				class="left__title"><img
					src="${pageContext.request.contextPath}/assets/icon-book.svg"
					alt="">Đơn Đặt Hàng</a></li>
			<!-- 
			<li class="left__menuItem"><a
				href="${pageContext.request.contextPath}/admin/editcss"
				class="left__title"><img
					src="${pageContext.request.contextPath}/assets/icon-pencil.svg"
					alt="">Chỉnh CSS</a></li>
			<li class="left__menuItem">
				<div class="left__title">
					<img src="${pageContext.request.contextPath}/assets/icon-user.svg"
						alt="">Admin<img class="left__iconDown"
						src="${pageContext.request.contextPath}/assets/arrow-down.svg"
						alt="">
				</div>-->
				<div class="left__text">
					<a class="left__link"
						href="${pageContext.request.contextPath}/admin/addadmin">Thêm
						Admin</a> <a class="left__link"
						href="${pageContext.request.contextPath}/admin/viewadmin">Xem
						Admins</a>
				</div>
			</li>
			<li class="left__menuItem"><a
				href="${pageContext.request.contextPath}/admin/logout" class="left__title"><img
					src="${pageContext.request.contextPath}/assets/icon-logout.svg"
					alt="">Đăng Xuất</a></li>
		</ul>
	</div>
</div>
