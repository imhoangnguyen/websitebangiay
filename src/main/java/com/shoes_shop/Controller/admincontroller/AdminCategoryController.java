package com.shoes_shop.Controller.admincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes_shop.entities.CategoryEntity;
import com.shoes_shop.model.AjaxResponse;
import com.shoes_shop.model.Product;
import com.shoes_shop.repositories.CategoryRepo;
import com.shoes_shop.service.CategoryService;

@Controller
public class AdminCategoryController {
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	CategoryService categoryService;
	@Autowired
	CategoryRepo categoryRepo;
	//nhân dữ liệu từ client để thêm danh mục
	@RequestMapping (value = "/admin/addcategory",method = RequestMethod.POST)
	public String addCategory(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response,
			 @ModelAttribute("category") CategoryEntity cat //lẫy dữ liệu từ form trên client có attrribute là category
	) {
		String ms = "<script> setTimeout(function() {Swal.fire({"
				+ "						  icon: 'success',"
				+ "						  title: 'Thêm thành công',"
				+ "						  confirmButtonText: 'Ok'"
				+ "						}).then(function(){"
				+ "                     window.location = 'http://localhost:8080/admin/viewcategory';"
				+ "                  });},0)</script>";
		//nếu là sửa danh mục thì thông báo là sửa thành công
		if(cat.getId() != null) {
			ms = "<script> setTimeout(function() {Swal.fire({"
					+ "						  icon: 'success',"
					+ "						  title: 'Sửa thành công',"
					+ "						  confirmButtonText: 'Ok'"
					+ "						}).then(function(){"
					+ "                     window.location = 'http://localhost:8080/admin/viewcategory';"
					+ "                  });},0)</script>";
		}
		categoryService.save(cat);
		//thông báo là thêm thành công
		model.addAttribute("message", ms);
		//trả về index
		return "admin/insert_p_category";
	}
	//hiển thị index sửa danh mục cho người dùng
	@RequestMapping (value = "/admin/addcategory",method = RequestMethod.GET)
	public String addCategoryView(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response) {
		//add tên của chức năng
		model.addAttribute("danhmuc", "Thêm danh mục");
		//mới vào index của insert category phải khởi tạo một đối tượng category rỗng
		model.addAttribute("category", new CategoryEntity());
		return "admin/insert_p_category";
	}
	//xem danh sách category
	@RequestMapping (value = "/admin/viewcategory",method = RequestMethod.GET)
	public String viewCategory(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		model.addAttribute("category", new CategoryEntity());
		//lấy ra những category vẫn đang hoạt động(có status là true)
		model.addAttribute("categories", categoryRepo.findByStatus(true));
		return "admin/view_p_category";
	}
	//sửa category bằng trang admin
	@RequestMapping (value = "/admin/repaircategory/{id}",method = RequestMethod.GET)
	public String repairCategoryView(@PathVariable("id") Integer id,final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		model.addAttribute("danhmuc", "Sửa danh mục");
		//lấy ra category bởi id
		model.addAttribute("category", categoryRepo.findById(id));
		return "admin/insert_p_category";
	}
	//sủa category
	@RequestMapping (value = "/admin/repaircategory",method = RequestMethod.POST)
	public String repairCategorySave(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response,
			@ModelAttribute("category") CategoryEntity cate ) {
		categoryService.save(cate);
		model.addAttribute("category", new CategoryEntity());
		return "admin/view_p_category";
	}
	//xoá category bằng ajax(trả về kiểu ResponseEntity có kiểu truyền vào là AjaxResponse do người dùng định nghĩa)
	//requestbody để lấy dữ liệu tự trang do js gửi về thông qua ajax sử dụng jquery
	//kiểu dữ liệu gửi về là product do người dùng tự định nghĩa
	@RequestMapping(value = {"/admin/deletecategory"}, method = RequestMethod.DELETE)
	public ResponseEntity<AjaxResponse> deleteCategoryWithAjax(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody Product prd)
	throws Exception {
		CategoryEntity cate = categoryRepo.getOne(prd.getId());
		cate.setStatus(false);
		categoryRepo.save(cate);
		//trả về responseentity có trạng thái là ok truyền vào là kiểu dữ liệu sẽ trả về cho ajax gọi đến
		return ResponseEntity.ok(new AjaxResponse(200,"Xoá thành công"));
 }
}
