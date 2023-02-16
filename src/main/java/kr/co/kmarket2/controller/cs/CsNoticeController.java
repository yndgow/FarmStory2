package kr.co.kmarket2.controller.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsNoticeController {
	
	@GetMapping("cs/notice/view")
	public String noticeview() {
		return "cs/notice/view";
	}
	
	@GetMapping("cs/notice/list")
	public String noticelist() {
		return "cs/notice/list";
	}
	
}
