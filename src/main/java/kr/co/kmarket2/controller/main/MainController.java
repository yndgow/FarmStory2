package kr.co.kmarket2.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.ProductVO;

public class MainController {

	@Autowired
	private ProductService service;
	
	@GetMapping(value={"/", "/index"})
	public String main(Model model) {
		List<ProductVO> productsbest = service.selectProductsBest();
		List<ProductVO> productshit = service.selectProductsHit();
		List<ProductVO> productsscore = service.selectProductsScore();
		List<ProductVO> productsnew = service.selectProductsNew();
		List<ProductVO> productsdiscount = service.selectProductsDiscount();
		
		model.addAttribute("best", productsbest);
		model.addAttribute("hit", productshit);
		model.addAttribute("socore", productsscore);
		model.addAttribute("new", productsnew);
		model.addAttribute("discount", productsdiscount);
		model.addAttribute("imagesEndpoint", "images/");
		model.addAttribute("filename", "cat-g893543a6c_640.jpg");

		return "/, /index";
	}
}