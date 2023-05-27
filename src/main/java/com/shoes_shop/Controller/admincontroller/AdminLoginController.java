package com.shoes_shop.Controller.admincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminLoginController {

	@RequestMapping(value = {"/admin"}, method = RequestMethod.GET)

	public String adminIndexLogin(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		//nếu người dùng nhập sai tài khoản hoặc mật khẩu thì hiển thị ra thông báo
		if(request.getParameter("error_access") != null)
			{if(request.getParameter("error_access").equals("loi"));
			model.addAttribute("error_message_accessing","<div class=\"alert alert-danger\" role=\"alert\">\r\n"
					+ "						bạn không có quyền truy cập vào trang này\r\n"
					+ "					</div>");
			}
			else model.addAttribute("error_message_accessing","");
		return "admin/login";			
	}
}

