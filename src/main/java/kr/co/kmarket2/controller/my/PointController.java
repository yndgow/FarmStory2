package kr.co.kmarket2.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {

	@GetMapping("my/point")
	public String point() {
		return "my/point";
	}
}
