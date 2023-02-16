package kr.co.kmarket2.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket2.dto.ProductDTO;
import kr.co.kmarket2.entity.ProductEntity;
import kr.co.kmarket2.mappers.ProductMapper;
import kr.co.kmarket2.repository.ProductRepo;

@Controller
public class AdminProductController {
	
	private final ProductRepo productRepo;
	
	public AdminProductController(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	@GetMapping("admin/product/list")
	public String list(Model model) {
		model.addAttribute("imagesEndpoint", "/images/");
		model.addAttribute("filename", "plant-7413415_640.png");
		model.addAttribute("path", "2023-02-15/");
		return "admin/product/list";
	}
	
	@GetMapping("admin/product/register")
	public String register() {
		return "admin/product/register";
	}
	
	@PostMapping("admin/product/register")
	public String insert(ProductDTO dto, HttpServletRequest req) {
		
		dto.setIp(req.getRemoteAddr());
		
		ProductEntity entity = ProductMapper.INSTANCE.toEntity(dto);
//		entity.setThumb1(dto.getThumb1().getName());
//		entity.setThumb1(dto.getThumb2().getName());
//		entity.setThumb1(dto.getThumb3().getName());
//		entity.setThumb1(dto.getDetail().getName());
		
		productRepo.save(entity);
		return "redirect:admin/product/register";
	}
	
}