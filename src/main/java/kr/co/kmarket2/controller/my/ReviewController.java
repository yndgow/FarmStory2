package kr.co.kmarket2.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

	@GetMapping("my/review")
	public String review() {
		return "my/review";
	}
}
