package kr.co.kmarket2.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.ProductCartVO;
import kr.co.kmarket2.vo.ProductReviewVO;
import kr.co.kmarket2.vo.ProductVO;

@Controller
public class ProductViewController {

	@Autowired
	private ProductService service;
	
	@GetMapping("view")
	public String view(Model model, int prodNo, String pg){
		ProductVO product = service.selectProduct(prodNo);
		ProductReviewVO review = service.selectProductReview(prodNo);
		
		int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);

        int total = service.selectCountTotalRe(prodNo);
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		model.addAttribute("product", product);
		model.addAttribute("review", review);
		model.addAttribute("pg", pg);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("groups", groups);
		model.addAttribute("imagesEndpoint", "images/");
		model.addAttribute("filename", "cat-g893543a6c_640.jpg");
		
		return "product/view";
	}

	@PostMapping("view")
	public void view(@RequestBody ProductCartVO cart) {
		ProductCartVO vo = new ProductCartVO();
		vo.setUid(cart.getUid());
		vo.setProdNo(cart.getProdNo());
		vo.setCount(cart.getCount());
		vo.setPrice(cart.getPrice());
		vo.setDiscount(cart.getDiscount());
		vo.setPoint(cart.getPoint());
		vo.setDelivery(cart.getDelivery());
		vo.setTotal(cart.getTotal());
		vo.setRdate(cart.getRdate());
		int result = service.insertCart(vo);
		
		
		
		
	}
	

}
