package com.shoes_shop.Controller.admincontroller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shoes_shop.entities.ProductEntity;
import com.shoes_shop.entities.SlideEntity;
import com.shoes_shop.model.AjaxResponse;
import com.shoes_shop.model.Product;
import com.shoes_shop.repositories.SlideRepo;
import com.shoes_shop.service.SlideService;

@Controller
public class AdminSlideController {
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	SlideService slideSerivce;
	@Autowired
	SlideRepo slideRepo;
	//lấy ra trang thêm slide để sử dụng
	@RequestMapping (value = "/admin/addslide",method = RequestMethod.GET)
	public String addSlide(final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) {
		model.addAttribute("slide", new SlideEntity());
		return "admin/insert_slide";
	}
	//nhận dữ liệu từ người dùng thêm slide để xử lý
	@RequestMapping (value = "/admin/addslide",method = RequestMethod.POST)
	public String saveSlide(@ModelAttribute("slide") SlideEntity slide,@RequestParam("slide_image") MultipartFile image ,
			final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) throws IllegalStateException, IOException {
		//Thông báo cho người dùng biết về trạng thái của dữ liệu
		String ms = "<script> setTimeout(function() {Swal.fire({"
				+ "						  icon: 'success',"
				+ "						  title: 'Thêm thành công',"
				+ "						  confirmButtonText: 'Ok'"
				+ "						}).then(function(){"
				+ "                     window.location = 'http://localhost:8080/admin/viewslide';"
				+ "                  });},0)</script>";
		if(slide.getId() != null) {
			ms = "<script> setTimeout(function() {Swal.fire({"
					+ "						  icon: 'success',"
					+ "						  title: 'Sửa thành công',"
					+ "						  confirmButtonText: 'Ok'"
					+ "						}).then(function(){"
					+ "                     window.location = 'http://localhost:8080/admin/viewslide';"
					+ "                  });},0)</script>";
		}
		slideSerivce.save(image, slide);
		model.addAttribute("message", ms);
		return "admin/insert_slide";
	}
	@RequestMapping (value = "/admin/addslide/{id}",method = RequestMethod.GET)
	public String repairSlide(@PathVariable("id") Integer id,
			final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) throws IllegalStateException, IOException {
		model.addAttribute("slide", slideRepo.getOne(id));
		return "admin/insert_slide";
	}
	@RequestMapping (value = "/admin/viewslide",method = RequestMethod.GET)
	public String viewSlide(
			final ModelMap model,final HttpServletRequest request,final HttpServletResponse response ) throws IllegalStateException, IOException {
		model.addAttribute("slides", slideRepo.findByStatus(true));
		return "admin/view_slides";
	}
	//xoá slide bằng ajax
	@RequestMapping(value = {"/admin/delete-slide"}, method = RequestMethod.DELETE)
	public ResponseEntity<AjaxResponse> deleteSlideWithAjax(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody Product data)
	throws Exception {
		SlideEntity slide = slideRepo.getOne(data.getId());
		slide.setStatus(false);
		slideRepo.save(slide);
		return ResponseEntity.ok(new AjaxResponse(200,"Xoá thành công"));
 }
}
