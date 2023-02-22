package kr.co.kmarket2.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

	@GetMapping("my/info")
	public String info() {
		return "my/info";
	}
}
