package kr.co.kmarket2.controller.admin;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * 날짜: 2023/02/15
 * 이름: 김지홍
 * 내용: admin/cs controller 
 */

@Controller
public class AdminCsController {
	
	@GetMapping("admin")
	public String index(Model model) {
		return "admin/index";
	}
	
	@GetMapping("admin/cs/{type}/list")
	public String list(@PathVariable String type) {
		
		
		
		
		return "admin/cs/"+type+"/list";
		
	}
	
	@GetMapping("admin/cs/{type}/write")
	public String write(@PathVariable String type) {
		return "admin/cs/"+type+"/write";
	}
	
	@GetMapping("admin/cs/{type}/modify")
	public String modify(@PathVariable String type, String no) {
		return "admin/cs/"+type+"/modify";
	}
	
	@GetMapping("admin/cs/{type}/view")
	public String view(@PathVariable String type, String no) {
		return "admin/cs/"+type+"/view";
	}
	
}
