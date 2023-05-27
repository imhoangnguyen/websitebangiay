<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Danh mục</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
<jsp:include page="/WEB-INF/views/front-end/common/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styledanhmuc.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/sweetalert/dist/sweetalert2.min.css">
</head>
<body onload = "document.getElementById('btn-cl').click();">
	<input style="display:none" id ="cate" value = "${currentCategorySeo}"/>
	<div class="wrapper"  id = "app">
		<!-- title -->
		<div class="title">Welcome to shoes-shop!</div>
		<!-- /title -->
		<!-- menu -->
		<jsp:include page="/WEB-INF/views/front-end/common/header.jsp"></jsp:include>
		<!-- /menu -->
		<!-- content -->
		<div class="content">
			<div class="filter">
				<div class="part-filter top-filter">
					<h3 name = "category_name">${categoryname}</h3>
				</div>
				<div class="part-filter bot-filter">
					<h3>
						<i class="fas fa-filter"></i>&nbsp Bộ lọc
					</h3>
					<div href="#" class="buttn bot-btn">
							<i class="fas fa-sort-alpha-down"></i> Sắp xếp theo &nbsp &nbsp <i
							class="fas fa-angle-down"></i>
							<ul class="sub-menu sub-menu-filter" id = "filterSort">
								<li><a id="td" v-on:click = "setSort('td','Giá: Tăng dần')">Giá: Tăng dần</a></li>
								<li><a id="gd" v-on:click = "setSort('gd','Giá: Giảm dần')">Giá: Giảm dần</a></li>
								<li><a id="az" v-on:click = "setSort('az','Tên: A-Z')">Tên: A-Z</a></li>
								<li><a id="za" v-on:click = "setSort('za','Tên: Z-A')">Tên: Z-A</a></li>
								<li><a id="new" v-on:click = "setSort('new','Mới nhất')">Mới nhất</a></li>
								<li><a id="bcn" v-on:click = "setSort('bcn','Bán chạy nhất')">Bán chạy nhất</a></li>
							</ul>
					</div>
					<div href="#" class="buttn bot-btn">
						Giá sản phẩm &nbsp &nbsp <i class="fas fa-angle-down"></i>
						<ul class="sub-menu sub-menu-filter">
							<li><input type="checkbox" v-model="filterApplied" name="price" value = "Dưới 500,000₫"> Dưới
									500,000₫</li>
							<li><input type="checkbox" v-model="filterApplied" name="price" value = "500,000₫-1,000,000₫"> 500,000₫
									- 1,000,000₫</li>
							<li><input type="checkbox" v-model="filterApplied" name="price" value = "1,000,000₫-1,500,000₫">
									1,000,000₫ - 1,500,000₫</li>
							<li><input type="checkbox" v-model="filterApplied" name="price" value = "1,500,000₫-5,000,000₫">
									1,500,000₫ - 5,000,000₫</a></li>
							<li><input type="checkbox" v-model="filterApplied" name="price" value = "Trên 5,000,000₫"> Trên
									5,000,000₫</li>
						</ul>
					</div>
					<div href="#" class="buttn bot-btn">
						Màu sắc &nbsp &nbsp <i class="fas fa-angle-down"></i>
						<ul class="sub-menu sub-menu-filter">
							<li><a><input type="checkbox" v-model="color" name="color" value = "xanh"> Xanh</a></li>
							<li><a><input type="checkbox" v-model="color" value = "do"> Đỏ</a></li>
							<li><a><input type="checkbox" v-model="color" value = "tim"> Tím</a></li>
							<li><a><input type="checkbox" v-model="color" value = "vang"> Vàng</a></li>
							<li><a><input type="checkbox" v-model="color" value = "hong"> Hồng</a></li>
							<li><a><input type="checkbox" v-model="color" value = "nau"> Nâu</a></li>
							<li><a><input type="checkbox" v-model="color" value = "den"> Đen</a></li>
							<li><a><input type="checkbox" v-model="color" value = "trang"> Trắng</a></li>
						</ul>
					</div>
					<div href="#" class="buttn bot-btn">
						Kích thước &nbsp &nbsp <i class="fas fa-angle-down"></i>
						<ul class="sub-menu sub-menu-filter">
							<li><a><input type="checkbox" v-model="size" value="38"> 38</a></li>
							<li><a><input type="checkbox" v-model="size" value="39"> 39</a></li>
							<li><a><input type="checkbox" v-model="size" value="40"> 40</a></li>
							<li><a><input type="checkbox" v-model="size" value="41"> 41</a></li>
							<li><a><input type="checkbox" v-model="size" value="42"> 42</a></li>
							<li><a><input type="checkbox" v-model="size" value="43"> 43</a></li>
							<li><a><input type="checkbox" v-model="size" value="44"> 44</a></li>
						</ul>
					</div>
				</div>
				<!-- filter responsive -->
				<div class="buttn top-btn rp-btn">
						Bộ lọc &nbsp &nbsp <i class="fas fa-angle-down"></i>
						<ul class="sub-menu sub-menu-filter">
							<li><select id="new" name="new">
									<option value="title" disabled>*Mới nhất</option>
									<option value="saab">Giá: Giảm dần</option>
									<option value="fiat">Tên: A-Z</option>
									<option value="title">Tên: Z-A</option>
									<option value="saab">Cũ nhất</option>
									<option value="fiat">Mới nhất</option>
									<option value="saab">Bán chạy nhất</option>
									<option value="fiat">Tồn kho:Giảm dần</option>
							</select></li>
							<li><select id="new" name="new">
									<option value="title" disabled>*Giá sản phẩm</option>
									<option value="saab">Dưới 500,000₫</option>
									<option value="fiat">500,000₫ - 1,000,000₫</option>
									<option value="title">1,000,000₫ - 1,500,000₫</option>
									<option value="saab">2,000,000₫ - 5,000,000₫</option>
									<option value="fiat">Trên 5,000,000₫</option>
							</select></li>
							<li><select id="new" name="new">
									<option value="title" disabled>*Màu sắc</option>
									<option value="saab">Xanh</option>
									<option value="fiat">Đỏ</option>
									<option value="title">Tím</option>
									<option value="saab">Vàng</option>
									<option value="fiat">Hồng</option>
									<option value="saab">Nâu</option>
									<option value="fiat">Đen</option>
									<option value="fiat">Trắng</option>
							</select></li>
							<li><select id="new" name="new">
									<option value="title" disabled>*Kích thước</option>
									<option value="saab">38</option>
									<option value="fiat">39</option>
									<option value="title">40</option>
									<option value="saab">41</option>
									<option value="fiat">42</option>
							</select></li>
							<li><select id="new" name="new" >
									<option value="title" disabled>*Giới tính</option>
									<option value="saab">Nam</option>
									<option value="fiat">Nữ</option>
							</select></li>
							<li><select id="new" name="new">
									<option value="title" disabled>*Loại sản phẩm</option>
									<option value="saab">Khác</option>
							</select></li>
						</ul>
					</div>
				<!-- /filter responsive -->
			</div>
			<span v-bind:class = "filterApplied.length == 0 && sort == null && size.length == 0 && color.length == 0 ? 'filter_status dpn' : 'filter_status'" id = "filter_status" >
			Trạng thái lọc:
				<span v-for = "item in filterApplied" class = "filter_selected">Giá: {{item}}<span class = "btn-close"><i class="fas fa-window-close" v-on:click = "setfilterApplied(item)"></i></span></span>
				<span v-for = "item in size" class = "filter_selected">Size: {{item}}<span class = "btn-close"><i class="fas fa-window-close" v-on:click = "setSize(item)"></i></span></span>
				<span v-for = "item in color" class = "filter_selected">Màu sắc: {{item}}<span class = "btn-close"><i class="fas fa-window-close" v-on:click = "setColor(item)"></i></span></span>
				<span v-bind:class = "sort == null ? 'filter_selected dpn':'filter_selected'">{{sort}}<span class = "btn-close"><i class="fas fa-window-close" v-on:click = "setSortNull()"></i></span></span>
			</span>
			</div>
			<div class="container-fluid">
				<div class="row justify-content-center">
				<button style = "display:none" id = "btn-cl" v-on:click = "setCate()"></button>
						<div class="col-xl-3 col-lg-3 col-md-5 prd" v-for = "product in filterItems">
							<img
								v-bind:src="'${pageContext.request.contextPath}/file/uploads/'+product.avatar">
							<div class="btn-more add-btn add-btn-m">
								<a v-on:click = "setCartData(product.id,1,product.size)">THÊM VÀO GIỎ</a>
							</div>
							<div class="btn-more add-btn ct-btn">
								<a
									v-bind:href="'${pageContext.request.contextPath}/products/'+product.seo">CHI
									TIẾT</a>
							</div>
							<div class="cost">
									<b>{{product.title}}</b>
									<span v-bind:class = "product.price_sale != null ? 'price' : 'price dpn'">{{formatPrice(product.price_sale)}}</span>
									&nbsp &nbsp
									<span v-bind:class = "product.price_sale != null ? 'price old-cost' :'price' ">{{formatPrice(product.price)}}</span> 
							</div>
						</div>
				</div>
			</div>
			<!-- pagination-->
			<nav aria-label="..." v-bind:class = "numberOfPage < 2 ? 'dpn' : ''">
				  <ul class="pagination pagi-margin" id = "pagi-custom">
				    <li class="page-item">
				      <a class="page-link" tabindex="-1" v-on:click = "pmPageNumber(-1)"><i class="fas fa-backward"></i></a>
				    </li>
				    <li v-for = "i in numberOfPage"  v-bind:class="pageNumber == i ? 'page-item active' : 'page-item'"><a class = "page-link" v-bind:value = "i" v-on:click = "setPageNumber(i)">{{i}}</a></li>
				  <li class="page-item">
				      <a class="page-link" v-on:click = "pmPageNumber(1)"> <i class="fas fa-forward"></i></a>
				    </li>
				  </ul>
				</nav>
			<!-- /pagination-->
			<!-- /content -->
			<jsp:include page="/WEB-INF/views/front-end/common/footer.jsp"></jsp:include>
		</div>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/vue.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/vueDanhMuc.js"></script>
</html>