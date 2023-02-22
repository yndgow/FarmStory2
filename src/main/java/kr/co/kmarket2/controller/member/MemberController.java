package kr.co.kmarket2.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket2.service.MemberService;
import kr.co.kmarket2.vo.MemberTermsVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("member/login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	@GetMapping("member/register")
	public String register() {
		return "member/register";
	}
	
	@GetMapping("member/registerSeller")
	public String registerSeller() {
		return "member/registerSeller";
	}
	
	@GetMapping("member/signup")
	public String terms(Model model, String type) {
		MemberTermsVO vo = service.selectTerms();
		
		model.addAttribute("type", type);
		model.addAttribute("vo", vo);
		return "member/signup";
	}
}
