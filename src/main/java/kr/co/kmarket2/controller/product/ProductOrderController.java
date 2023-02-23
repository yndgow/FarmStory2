package kr.co.kmarket2.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.ProductOrderVO;

@Controller
public class ProductOrderController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("order")
	public String order(Model model, @RequestBody String uid){
	
		
		
		List<ProductOrderVO> order = service.selectOrder(uid); 
		
		model.addAttribute(order);
		
		return "order";
	}
	
	
	

}
