package com.shoes_shop.Controller.indexcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes_shop.Contants;
import com.shoes_shop.entities.SaleOrder;
import com.shoes_shop.entities.User;
import com.shoes_shop.model.Cart;
import com.shoes_shop.model.UserDetail;
import com.shoes_shop.repositories.UserRepo;
import com.shoes_shop.service.OrderService;
import com.shoes_shop.service.UserService;

@Controller
public class AccountController extends BaseController implements Contants{
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	UserService userService;
	@Autowired
	UserRepo userRepo;
	@Autowired
	OrderService orderSerivce;
	//lấy ra trang đăng nhập của người sử dụng
	@RequestMapping (value = "/user" , method = RequestMethod.GET)
	public String accountIndex(final ModelMap model ,final HttpServletRequest request,final HttpServletResponse response ) {
		HttpSession ss = request.getSession();
		ss.setAttribute(CURRENTCATEGORYSEO, "user");
		model.addAttribute("status", "Trang chủ / Tài khoản");
		return "front-end/userlogin";
	}
	//kiểm tra và xác thực thông tin của người đặt hàng
	@RequestMapping (value = "/user/checkout" , method = RequestMethod.GET)
	public String userAccess(final ModelMap model ,final HttpServletRequest request,final HttpServletResponse response ) {
		//lấy dữ liệu từ user khi đang nhập được vào trong trang web
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = null;
		String email = null;
		if (principal instanceof UserDetails) {
			name  = ((User)principal).getName();
			email = ((User)principal).getEmail();
		}
		SaleOrder or = new SaleOrder();
		or.setCustomerName(name);
		or.setCustomerEmail(email);
		model.addAttribute("order", or);
		model.addAttribute("status", "Trang chủ / Tài khoản / Xác nhận");
		return "front-end/checkout";
	}
	//trả về thông tin của user khi đăng nhập thành công
	@RequestMapping (value = "/user/info" , method = RequestMethod.GET)
	public String userInfor(final ModelMap model ,final HttpServletRequest request,final HttpServletResponse response ) {
		model.addAttribute("order", new SaleOrder());
		model.addAttribute("status", "Trang chủ/ Tài khoản / Thông tin");
		return "front-end/userinfor";
	}
	//lưu lại đơn đặt hàng của người dùng
	@RequestMapping (value = "/user/saveorder" , method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") SaleOrder order,final ModelMap model ,final HttpServletRequest request,final HttpServletResponse response ) {
		//lấy danh sách sản phẩm từ giở hàng hiện tại trong phiên làm việc hiện tại
		HttpSession ss = request.getSession();
		Cart cart = (Cart) ss.getAttribute("shop_cart");
		//lấy thông tin user đang đặt hàng
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			int id = 0;
			if (principal instanceof UserDetails) {
				id  = ((User)principal).getId();
			}
			//lưu đơn đạt hàng vào bên trong database
		orderSerivce.saveOrder(cart, order,id);
			//khi đặt hàng thành công thì xoá bỏ giỏ hàng và số lượng sản phẩm trong giỏ hàng
		ss.removeAttribute("shop_cart");
		ss.removeAttribute("amount");
		//thông báo cho người dùng về trạng thái đặt hàng
		String ms = "<script> setTimeout(function() {Swal.fire({"
				+ "						  icon: 'success',"
				+ "						  title: 'Đặt hàng thành công',"
				+ "						  confirmButtonText: 'Ok'"
				+ "						}).then(function(){"
				+ "                     window.location = 'http://localhost:8080';"
				+ "                  });},0)</script>";
		model.addAttribute("message", ms);
		return "front-end/checkout";
	}
	//lấy ra trang đăng kí sản phẩm
	@RequestMapping (value = "/accountRegister" , method = RequestMethod.GET)
	public String accountSingInIndex(final ModelMap model ,final HttpServletRequest request,final HttpServletResponse response ) {
		model.addAttribute("user", new User());
		model.addAttribute("status", "Trang chủ/ Tài khoản / Đăng kí");
		return "front-end/accountRegister";
	}
	//nhận dữ liệu của người dùng đăng kí tài khoản rồi xử lý
	@RequestMapping (value = "/accountRegister" , method = RequestMethod.POST)
	public String userAccess(@ModelAttribute("user") User user,final ModelMap model ,final HttpServletRequest request,final HttpServletResponse response ) {
		//thông báo khi tên tài khoản đã được sử dụng
		if(userService.save(user) == 1) {
			model.addAttribute("error_message", "Tên tài khoản của bạn đã tồn tại");
			return "front-end/accountRegister";
		}
		//thông báo khi email đã được sử dụng
		else if(userService.save(user) == 2) {
			model.addAttribute("error_message", "Email của bạn đã được sử dụng");
			return "front-end/accountRegister";
		}
		//thông báo đăng kí thành công
		else {
			model.addAttribute("error_message", "Đăng kí thành công");
			
			return "redirect:/";
		}
	}
	//lấy ra trang quên mật khẩu
	@RequestMapping (value = "/forgetPassword" , method = RequestMethod.GET)
	public String accountForgetPassword(final ModelMap model ,final HttpServletRequest request,final HttpServletResponse response ) {
		model.addAttribute("status", "Trang chủ/ Tài khoản / Quên tài khoản");
		return "front-end/forgetPassword";
	}
}
