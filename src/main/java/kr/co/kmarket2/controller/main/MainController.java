package kr.co.kmarket2.controller.main;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

	@GetMapping(value={"/", "/index"})
	public String main() {
		return "/, /index";
	}
}
