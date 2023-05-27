package com.shoes_shop.Controller.admincontroller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes_shop.entities.ProductEntity;
import com.shoes_shop.entities.SaleOrder;
import com.shoes_shop.model.AjaxResponse;
import com.shoes_shop.model.Product;
import com.shoes_shop.repositories.OrderRepo;

@Controller
public class AdminOrder {
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	OrderRepo orderRepo;
	//hiển thị các đơn đặt hàng chưa giao
	@RequestMapping (value = "/admin/vieworder",method = RequestMethod.GET)
	public String order(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		model.addAttribute("allOrder", orderRepo.findByStatus(true));
		return "admin/view_orders";
	}
	//xoá các đơn đặt hàng bằng ajax
	@RequestMapping(value = {"/admin/deleteorder"}, method = RequestMethod.DELETE)
	public ResponseEntity<AjaxResponse> deleteOrder(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody Product data)
	throws Exception {
		SaleOrder prd = orderRepo.getOne(data.getId());
		prd.setStatus(false);
		orderRepo.save(prd);
		return ResponseEntity.ok(new AjaxResponse(200,"Xoá thành công"));
 }
 	//sửa
	@RequestMapping(value = {"/admin/setpay"}, method = RequestMethod.PUT)
	public ResponseEntity<AjaxResponse> setPay(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody Product data)
	throws Exception {
		SaleOrder prd = orderRepo.getOne(data.getId());
		prd.setPay(true);
		orderRepo.save(prd);
		return ResponseEntity.ok(new AjaxResponse(200,"Xoá thành công"));
 }
}
