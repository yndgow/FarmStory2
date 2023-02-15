package kr.co.kmarket2.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.ProductVO;


@Controller
public class ProductListController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("product/list")
	public String list(Model model, String cate1, String cate2, String sort, String pg){
		
        int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);

        int total = service.selectCountTotal(cate1,cate2);
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ProductVO> products = service.selectProducts(cate1, cate2, sort);
		
		model.addAttribute("products", products);
		model.addAttribute("cate1", cate1);
		model.addAttribute("cate2", cate2);
		model.addAttribute("sort", sort);
		model.addAttribute("pg", pg);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("groups", groups);
		model.addAttribute("imagesEndpoint", "images/");
		model.addAttribute("filename", "cat-g893543a6c_640.jpg");
		
		return "product/list";
	}

}
