package kr.co.kmarket2.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderedController {

	@GetMapping("my/ordered")
	public String Ordered() {
		return "my/ordered";
	}
}
