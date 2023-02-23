package kr.co.kmarket2.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("my")
	public String myHome() {
		return "my/home";
	}
}
