package com.shoes_shop.Controller.admincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminTypeProduct {
	@RequestMapping (value = "/admin/addtypeproduct",method = RequestMethod.GET)
	public String addTypeProduct(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		return "admin/insert_category";
	}
	@RequestMapping (value = "/admin/viewtypeproduct",method = RequestMethod.GET)
	public String viewTypeProduct(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		return "admin/view_category";
	}
	@RequestMapping (value = "/admin/repairtypeproduct",method = RequestMethod.GET)
	public String repairTypeProduct(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		return "admin/view_category";
	}
	@RequestMapping (value = "/admin/deletetypeproduct",method = RequestMethod.GET)
	public String deleteTypeProduct(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		return "admin/view_category";
	}
}
