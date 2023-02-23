package kr.co.kmarket2.controller.product;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.MemberVO;
import kr.co.kmarket2.vo.ProductCartVO;
import kr.co.kmarket2.vo.ProductReviewVO;
import kr.co.kmarket2.vo.ProductVO;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping("product/list")
	public String list(Model model, String cate1, String cate2, String pg, String sort) {
		// 페이징 처리
		int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);
        int total = 0;
        total = service.selectCountTotal(cate1,cate1);
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getpageStartNum(total, start);
        int[] groups = service.getPageGroup(currentPage, lastPageNum);

        List<ProductVO> products = service.selectProducts(cate1, cate2, sort);
		
        model.addAttribute("products", products);
		model.addAttribute("sort", sort);
		model.addAttribute("pg", pg);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("groups", groups);
		
		return "product/list";
	}

	@GetMapping("product/view")
	public String view(Model model, String cate1, String cate2, String prodNo, String pg) {
		model.addAttribute("cate1",cate1);
		model.addAttribute("cate2",cate2);
		
		//상품출력
		ProductVO product = service.selectProduct(prodNo);
		model.addAttribute("product", product);
		
		// review
		int currentPage = service.getCurrentPage2(pg);
        int start = service.getLimitStart2(currentPage);

        int total = service.selectCountTotalReview(prodNo);
        int lastPageNum = service.getLastPageNum2(total);
        int pageStartNum = service.getpageStartNum2(total, start);
        int groups[] = service.getPageGroup2(currentPage, lastPageNum);
		
        List<ProductReviewVO> reviews = service.selectReview(prodNo, start);
        model.addAttribute("reviews", reviews);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("groups", groups);
        model.addAttribute("prodNo", prodNo);
		
		
		return "product/view";
	}
	
	@ResponseBody
	@PostMapping("product/view")
	public Map<String, Integer> view(ProductCartVO vo, int proNo){
		
		Map<String, Integer> map = new HashMap<>();
		int	result = service.insertCart(vo);
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("product/cart")
	public String cart(Model model,HttpSession session, String prodNo, String cartNo) {
		String uid = session.getId();
		
		List<ProductCartVO> carts = service.selectCartProduct(uid);
		
		model.addAttribute("carts ", carts );
		model.addAttribute("cartNo", cartNo);
		model.addAttribute("prodNo", prodNo);
		
		
		
		return "prduct/cart";
	}
	
	@ResponseBody
	@PostMapping("product/cart")
	public Map<String, Integer> cart(@RequestParam("chks") List<String> chks){
		
		Map<String, Integer> map = new HashMap<>();
		int result = service.deleteCart(chks);
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("product/order")
	public String order(Model model, @AuthenticationPrincipal MemberVO mem, @RequestParam(value="cartNo", required=false) List<String> cartNo, 
			@RequestParam(value="prodNo", required=false)  String prodNo, @RequestParam(value="count", required=false) String count) {
		
		List<ProductCartVO> cart= null;
		ProductVO product = null;
		
		if(prodNo == null) {
			cart = service.selectCartByCartNo(cartNo);
		}else {
			product = service.selectProduct(prodNo);
		}
		
		model.addAttribute("cart", cart);
		model.addAttribute("count", count);
		model.addAttribute("product", product);
		model.addAttribute("mem", mem);
		
		return "product/order";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
