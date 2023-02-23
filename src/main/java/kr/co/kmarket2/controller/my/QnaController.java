package kr.co.kmarket2.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnaController {

	@GetMapping("my/qna")
	public String qna() {
		return "my/qna";
	}
}
