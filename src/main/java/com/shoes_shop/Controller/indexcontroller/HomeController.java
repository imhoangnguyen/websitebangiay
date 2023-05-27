package com.shoes_shop.Controller.indexcontroller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes_shop.Contants;
import com.shoes_shop.entities.User;
import com.shoes_shop.model.AjaxResponse;
import com.shoes_shop.model.Subcriber;
import com.shoes_shop.repositories.EmailRepo;
import com.shoes_shop.repositories.ProductRepo;
import com.shoes_shop.repositories.SlideRepo;
import com.shoes_shop.service.UserService;

@Controller
public class HomeController extends BaseController implements Contants{
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	ProductRepo productRepo;
	@Autowired
	UserService userService;
	@Autowired
 	CartController cart;
	@Autowired
 	SlideRepo slideRepo;
	//trả về trang chủ của website
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		HttpSession ss = request.getSession();
		model.addAttribute("productMn", productRepo.findByProducttypeAndStatus("san-pham-moi-nhat",true));
		model.addAttribute("productNb", productRepo.findByProducttypeAndStatus("san-pham-noi-bat",true));
		model.addAttribute("productGg", productRepo.findByProducttypeAndStatus("san-pham-giam-gia",true));
		ss.setAttribute(CURRENTCATEGORYSEO, "home");
		ss.setAttribute("slides", slideRepo.findByStatus(true));
		if(ss.getAttribute("shop_cart") == null) model.addAttribute("amount", 0);
		return "front-end/home";
	}
	//lưu email của khách hàng muốn nhận thông báo
	@RequestMapping(value = {"/save-contact-with-ajax"}, method = RequestMethod.POST)
	public ResponseEntity<AjaxResponse> saveWithAjax(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody Subcriber data)
	throws Exception {
		if(userService.saveEmailNoti(data.getEmail()))
		return ResponseEntity.ok(new AjaxResponse(200,"Thành công"));
		else return ResponseEntity.ok(new AjaxResponse(404,"Email này đã được sử dụng"));
 }
}
