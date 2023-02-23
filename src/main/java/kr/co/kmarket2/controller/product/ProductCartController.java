package kr.co.kmarket2.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.co.kmarket2.service.ProductService;
import kr.co.kmarket2.vo.MemberVO;
import kr.co.kmarket2.vo.ProductCartVO;
import kr.co.kmarket2.vo.ProductOrderVO;


@Controller
public class ProductCartController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("cart")

	public String cart(Model model, String uid){
		
		List<ProductCartVO> carts = service.selectCartProduct(uid);
		
		
		model.addAttribute("carts", carts);

		
		return "cart";
	}
	

	@PostMapping("cart")
	public void cart(HttpServletRequest req, @RequestBody ProductCartVO vo) {
		
		// 장바구니에서 주문
		
		HttpSession sess = req.getSession();
		MemberVO mem = (MemberVO) sess.getAttribute("sessUser");
		
		// product order
		ProductOrderVO ovo = new ProductOrderVO();
		ovo.setOrdUid(mem.getUid());
		ovo.setOrdCount(vo.getCount());
		ovo.setOrdPrice(vo.getPrice());
		ovo.setOrdDiscount(vo.getDiscount());
		ovo.setOrdDelivery(vo.getDelivery());
		ovo.setSavePoint(vo.getPoint());
		ovo.setOrdTotPrice(vo.getTotal());
		
		ovo.setRecipName(mem.getName());
		ovo.setRecipHp(mem.getHp());
		ovo.setRecipZip(mem.getZip());
		ovo.setRecipAddr1(mem.getAddr1());
		ovo.setRecipAddr2(mem.getAddr2());
		
		int result = service.insertOrder(ovo);
		
		
		
		
		
	}

	

}
