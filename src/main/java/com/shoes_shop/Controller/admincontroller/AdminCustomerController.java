package com.shoes_shop.Controller.admincontroller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes_shop.entities.SaleOrder;
import com.shoes_shop.model.AjaxResponse;
import com.shoes_shop.model.Product;
import com.shoes_shop.repositories.OrderRepo;

@Controller
public class AdminCustomerController {
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	OrderRepo orderRepo;
	@RequestMapping (value = "/admin/viewcustomers",method = RequestMethod.GET)
	public String customers(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		model.addAttribute("customers", orderRepo.findByCustomerActive(true));
		return "admin/view_customers";
	}
	//xoá người dùng sử dụng ajax
	@RequestMapping(value = {"/admin/deletecustomer"}, method = RequestMethod.DELETE)
	public ResponseEntity<AjaxResponse> deleteOrder(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody Product data)
	throws Exception {
		SaleOrder prd = orderRepo.getOne(data.getId());
		prd.setCustomer_active(false);
		orderRepo.save(prd);
		return ResponseEntity.ok(new AjaxResponse(200,"Xoá thành công"));
 }
}
