package com.shoes_shop.Controller.admincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminUserController {
	@RequestMapping (value = "/admin/addadmin",method = RequestMethod.GET)
	public String addAdmin(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		return "admin/insert_admin";
	}
	@RequestMapping (value = "/admin/viewadmin",method = RequestMethod.GET)
	public String viewAdmin(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		return "admin/view_admins";
	}
	@RequestMapping (value = "/admin/repairadmin",method = RequestMethod.GET)
	public String repairAdmin(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		return "admin/view_admins";
	}
	@RequestMapping (value = "/admin/deleteadmin",method = RequestMethod.GET)
	public String deleteAdmin(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		return "admin/view_admins";
	}
}
