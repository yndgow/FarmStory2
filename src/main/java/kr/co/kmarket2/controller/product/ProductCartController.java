package kr.co.kmarket2.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductCartController {
	
	@GetMapping("cart")
	public String cart(){
		
		
		
		
		return "cart";
	}
	
	//@PostMapping("cart")
	//public void cart() {
		
//	}
	

}
