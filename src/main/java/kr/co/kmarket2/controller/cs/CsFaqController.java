package kr.co.kmarket2.controller.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsFaqController {

	
	@GetMapping("cs/faq/list")
	public String faqlist() {
		return "cs/faq/list";
	}
	
	@GetMapping("cs/faq/view")
	public String faqview() {
		return "cs/faq/view";
	}
}
