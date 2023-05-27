package com.shoes_shop.Controller.indexcontroller;

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
import com.shoes_shop.entities.ProductEntity;
import com.shoes_shop.model.AjaxResponse;
import com.shoes_shop.model.ProductCart;
import com.shoes_shop.repositories.ProductRepo;
import com.shoes_shop.model.Cart;
import com.shoes_shop.model.Product;



@Controller
public class CartController extends BaseController implements Contants{
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired 
	ProductRepo productRepo;
	//thêm sản phẩm vào giỏ hàng sử dung ajax
	@RequestMapping (value = {"/save-product-to-cart-with-ajax"},method = RequestMethod.POST)
	public ResponseEntity<AjaxResponse> Cart(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody ProductCart data){
		HttpSession ss = request.getSession();//create a session 
		
		//init a cart
		Cart cart = null;
		//check that has the session added shop_cart yet?
		if(ss.getAttribute("shop_cart") != null) {// the shop_cart exists in session
			cart = (Cart)ss.getAttribute("shop_cart");
		}
		else {
			cart= new Cart();
			ss.setAttribute("shop_cart", cart);
		}
		
		//check that has the cart had this product yet?
		boolean isExists = false;
		for(ProductCart prd : cart.getCart()) {
			if(prd.getProductCode() == data.getProductCode() && prd.getSize() == data.getSize()) { // if exists
				isExists = true;
				prd.setProductAmount(prd.getProductAmount() + data.getProductAmount());
				break;
			}
		}
		if(isExists == false) {//if not exists
			ProductEntity productInRepo = productRepo.getOne(data.getProductCode());
			data.setProductTitle(productInRepo.getTitle());
			data.setProductPrice(productInRepo.getPrice());
			data.setProductAvatar(productInRepo.getAvatar());
			data.setProductSeo(productInRepo.getSeo());
			cart.getCart().add(data);
		}
		ss.setAttribute("amount", countProduct(cart));
		return ResponseEntity.ok(new AjaxResponse(200,String.valueOf(countProduct(cart))));
	}
	//lấy trang giỏ hàng
	@RequestMapping (value = "/cart" , method = RequestMethod.GET)
	public String accountSingInIndex(final ModelMap model ,final HttpServletRequest request,final HttpServletResponse response ) {
		HttpSession ss = request.getSession();
		ss.setAttribute(CURRENTCATEGORYSEO, "cart");
		model.addAttribute("status", "Trang chủ / Giỏ hàng");
		return "front-end/cartindex";
	}
	//xoá sản phẩm trong giỏ hàng
	@RequestMapping(value = {"/deletecartproduct"}, method = RequestMethod.DELETE)
	public ResponseEntity<AjaxResponse> deleteProductCartWithAjax(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody Product data)
	throws Exception {
		HttpSession ss = request.getSession();
		Cart cart = (Cart)ss.getAttribute("shop_cart");
		cart.getCart().remove(cart.findByIdAndSize(data.getId(),data.getSize()));
		ss.setAttribute("amount",countProduct(cart));
		return ResponseEntity.ok(new AjaxResponse(200,"Xoá thành công"));
 }
 	//đếm sản phẩm bên trong giỏ hàng
	public int countProduct(Cart cart) {
		int sum = 0;
		for(ProductCart p : cart.getCart()) {
			sum += p.getProductAmount();
		}
		return sum;
	}
}
