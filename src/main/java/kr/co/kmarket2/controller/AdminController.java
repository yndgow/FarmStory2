package kr.co.kmarket2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("admin")
	public String index(Model model) {
		model.addAttribute("imagesEndpoint", "images");
		model.addAttribute("filename", "cat-g893543a6c_640.jpg");
		return "admin/index";
	}
}
