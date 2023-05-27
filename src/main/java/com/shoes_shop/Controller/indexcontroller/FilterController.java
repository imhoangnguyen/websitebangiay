package com.shoes_shop.Controller.indexcontroller;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes_shop.Contants;
import com.shoes_shop.model.ProductFilter;
import com.shoes_shop.repositories.ProductRepo;

@Controller
public class FilterController extends BaseController implements Contants{
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	ProductRepo productRepo;
	//lấy ra danh sách sản phẩm được lọc
	@RequestMapping(value = "/filter" , method = RequestMethod.GET)
	public String ResultFilter(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response) {
		HttpSession ss = request.getSession();
		model.addAttribute("categoryname", ss.getAttribute(CURRENTCATEGORYSEO));
		model.addAttribute("productFilter", new ProductFilter());
		if(ss.getAttribute(CURRENTCATEGORYSEO).equals("product-all"))
		{
			if(request.getParameter("price") != null) {
				if(request.getParameter("price").equals("duoi-500000"))
				model.addAttribute("products", productRepo.findByPriceLessThanAndStatus(BigDecimal.valueOf(500000),true));
				else if(request.getParameter("price").equals("500000-1000000"))
					model.addAttribute("products", productRepo.findByPriceBetweenAndStatus(BigDecimal.valueOf(500000),BigDecimal.valueOf(1000000),true));	
			}
		}
		return "front-end/danhmuc";
	}
}
