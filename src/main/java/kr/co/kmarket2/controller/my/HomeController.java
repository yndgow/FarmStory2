package kr.co.kmarket2.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.MyService;
/*
 * 날짜 : 2023/02/23
 * 이름 : 김지홍
 * 내용 : my home
 */
@Controller
public class HomeController {

	private final MyService service;
	public HomeController(MyService service) {
		this.service = service;
	}

	@GetMapping("my")
	public String myHome(Model model, String uid) {
		if(uid == null) uid = "admin";
		// 상단 고정 정보
		model.addAttribute("topP", service.selectMemberPointByUid(uid));
		model.addAttribute("topD",service.countDeliveryByUid(uid));
		model.addAttribute("topC",service.countCouponByUid(uid));
		model.addAttribute("topQ",service.countQnaStatByUid(uid));
		
		// 최근항목5개씩
		model.addAttribute("recOrder",service.selectOrderByUid(uid));
		model.addAttribute("recPoint",service.selectPointByUid(uid));
		model.addAttribute("recReview",service.selectReviewByUid(uid));
		model.addAttribute("recQna",service.selectQnaByUid(uid));
		
		// 내정보
		model.addAttribute("myInfo",service.selectMemberInfoByUid(uid));
		return "my/home";
	}
}
