<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="footer fade5">
	<ul>
		<li class="title-footer">Giới thiệu</li>
		<li>CÔNG TY TNHH THƯƠNG MẠI DỊCH VỤ</li>
		<li class="subcriber"><b>Điền email để nhận thông báo từ</br>
				chúng tôi
		</b></li>
		<li><form action="${pageContext.request.contextPath}/home"
				method="post" class="emailfrm">
				<input type="email" id="email" value="" name="email"
					placeholder="Email của bạn" required>
				<button type="button" class="btn btn-primary"
					onclick="Shop.saveContact();">Gửi</button>
			</form></li>
	</ul>
	<ul>
		<li class="title-footer">Shoes-shop</li>
		<li><a href="#">Về chúng tôi</a></li>
		<li><a href="#">Tìm cửa hàng</a></li>
	</ul>
	<ul>
		<li class="title-footer">Thông tin liên hệ</li>
		<li>0366201726</li>
		<li>hoangabc000@gmail.com</li>
		<li class="title-end">@shoes-shop</li>
	</ul>
	<ul>
		<li class="title-footer">Theo dõi chúng tôi trên</li>
		<li><a href="#"><i class="fab fa-facebook"></i></a> &nbsp <a
			href="#"><i class="fab fa-twitter-square"></i></a> &nbsp <a href="#"><i
				class="fab fa-google"></i></a> &nbsp</li>
	</ul>
	<div class="responsive-footer">
		<nav class="nav flex-column">
			<li class="nav-item sp">Giới thiệu &nbsp<i
				class="fas fa-angle-down sp-icon"></i>
				<ul class="sub-menu-sp">
					<li>CÔNG TY TNHH THƯƠNG MẠI DỊCH VỤ</li>
				</ul>
			</li>
			</li>
			<li class="nav-item">shoes-shop<i
				class="fas fa-angle-down lc-icon"></i>
				<ul class="sub-menu-lc">
					<li><a href="#">Về chúng tôi</a></li>
					<li><a href="#">Tìm cửa hàng</a></li>
				</ul>
			</li>
			<li class="nav-item">Thông tin liên hệ<i
				class="fas fa-angle-down m1"></i>
				<ul class="sub-m1">
					<li><a href="#">SDT:0366201726</a></li>
					<li><a href="#">hoangzalabc000@gmail.com</a></li>
				</ul>
			</li>
			</li>
			<li class="nav-item">Theo dõi chúng tôi<i
				class="fas fa-angle-down m2"></i>
				<ul class="sub-m2">
					<li><a href="#"><i class="fab fa-facebook"></i></a> &nbsp <a
						href="#"><i class="fab fa-twitter-square"></i></a> &nbsp <a
						href="#"><i class="fab fa-google"></i></a> &nbsp</li>
				</ul>
			</li>
			</li>
			<li>@shoe-shop</li>
		</nav>
	</div>
</div>