package kr.co.kmarket2.controller.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsQnaController {

	@GetMapping("cs/qna/list")
	public String qnalist() {
		return "cs/qna/list";
	}
	
	@GetMapping("cs/qna/view")
	public String qnaview() {
		return "cs/qna/view";
	}
	
	@GetMapping("cs/qna/write")
	public String qnawrite() {
		return "cs/qna/write";
	}
}
