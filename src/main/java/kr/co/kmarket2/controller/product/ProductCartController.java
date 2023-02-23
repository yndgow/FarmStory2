package kr.co.kmarket2.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.ProductCartVO;


@Controller
public class ProductCartController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("cart")

	public String cart(Model model, String uid){
		
		List<ProductCartVO> carts = service.selectCartProducts(uid);
		
		
		model.addAttribute("carts", carts);

		
		return "cart";
	}
	

	@PostMapping("cart")
	public void cart() {
		
	}

	

}
