package kr.co.kmarket2.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kmarket2.dto.ProductDTO;
import kr.co.kmarket2.entity.ProductEntity;
import kr.co.kmarket2.mappers.ProductMapper;
import kr.co.kmarket2.repository.ProductRepo;
import kr.co.kmarket2.service.AdminService;

/*
 * 날짜: 2023/02/15
 * 이름: 김지홍
 * 내용: admin/Product controller
 */

@Controller
public class AdminProductController {
	
	// autowired를 대신하는 생성자

	private final AdminService adminService;
	
	public AdminProductController(AdminService adminService) {
		this.adminService = adminService;
	}

	// admin 상품 목록
	@GetMapping("admin/product/list")
	public String list(Model model, @RequestParam(defaultValue = "1") int pageNum) {
		Page<ProductEntity> products= adminService.getLatestProducts(pageNum-1);
		List<Integer> pageNumbers = adminService.getPageNumbers(products);
		
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("products", products);
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", products.getTotalPages());
		model.addAttribute("startPages", pageNumbers.get(0));
		model.addAttribute("endPages", pageNumbers.get(pageNumbers.size()-1));
		
		return "admin/product/list";
	}
	

	
	
	
	// admim 상품등록 페이지
	@GetMapping("admin/product/register")
	public String register() {
		return "admin/product/register";
	}
	
	// admim 상품등록 기능
	@PostMapping("admin/product/register")
	public String insert(ProductDTO dto, HttpServletRequest req) {
		
		// IPv4 입력
		dto.setIp(adminService.getRemoteIP(req));
		
		List<String> fList= adminService.upload(dto);
		
		ProductEntity entity = ProductMapper.INSTANCE.toEntity(dto);
		entity.setThumb1(fList.get(0));
		entity.setThumb2(fList.get(1));
		entity.setThumb3(fList.get(2));
		entity.setDetail(fList.get(3));
		
		adminService.insertProduct(entity);
		
		return "redirect:/admin/product/register";
	}
	
}
