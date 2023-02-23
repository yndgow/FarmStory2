package kr.co.kmarket2.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.ProductCartVO;
import kr.co.kmarket2.vo.ProductVO;

@Controller
public class ProductCartDeleteController {

	@Autowired
	private ProductService service;
	
	
	@PostMapping("cartDelete")
	public void deleteCart(@RequestBody ProductCartVO cart) {
		String uid = cart.getUid();
		int prodNo = cart.getProdNo();
		
		int result = service.deleteCart(uid, prodNo);
		
		
	}
	
	
}
