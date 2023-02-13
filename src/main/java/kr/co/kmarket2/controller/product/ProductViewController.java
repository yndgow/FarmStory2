package kr.co.kmarket2.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductViewController {
	
	@GetMapping("list")
	public String list(){
		return "list";
	}

}
