package com.shoes_shop.Controller.indexcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes_shop.Contants;
import com.shoes_shop.entities.ProductEntity;
import com.shoes_shop.repositories.ProductFilterRepo;
import com.shoes_shop.repositories.ProductRepo;

@Controller
public class SmartSearchController extends BaseController implements Contants{
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	ProductFilterRepo productFilterRepo;
	@Autowired
	ProductRepo productRepo;
	//trả về một danh sách các sản phẩm do người dùng tìm kiếm
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String resultSearch(final HttpServletRequest request,final HttpServletResponse response,final ModelMap model) {
		//lấy giá trị tham số trên link có tên là key
		String key = request.getParameter("key");
		int page = Integer.parseInt(request.getParameter("page"));
		//phân trang
		if(page > 0) page = page - 1;
		else if(page < 0) page = 0;
		Page<ProductEntity> resultSearching = productFilterRepo.search(key,true,PageRequest.of(page, 9));
		model.addAttribute("resultSearching", resultSearching);
		HttpSession ss = request.getSession();
		ss.setAttribute(CURRENTCATEGORYSEO, "home");
		return "front-end/searchingIndex";
	}
	@RequestMapping(value = "/autocomplete", method = RequestMethod.GET)
	public List<ProductEntity> resultSearchAutoComplete(final HttpServletRequest request,final HttpServletResponse response,final ModelMap model) {
		return productRepo.findByStatus(true);
	}
}
