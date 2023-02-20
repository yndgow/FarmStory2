package kr.co.kmarket2.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket2.entity.CsCate1Entity;
import kr.co.kmarket2.entity.CsNoticeEntity;
import kr.co.kmarket2.repository.CsNoticeRepo;
import kr.co.kmarket2.service.AdminService;
import kr.co.kmarket2.specification.AdminNoticeSpecification;

/*
 * 날짜: 2023/02/15
 * 이름: 김지홍
 * 내용: admin/cs controller 
 */

@Controller
public class AdminCsController {
	
	private final AdminService adminService;
	private final CsNoticeRepo csNoticeRepo;
	
	public AdminCsController(AdminService adminService, CsNoticeRepo csNoticeRepo) {
		this.adminService = adminService;
		this.csNoticeRepo = csNoticeRepo;
	}

	@GetMapping("admin")
	public String index(Model model) {
		return "admin/index";
	}
	
	@GetMapping("admin/cs/notice/list")
	public String noticeList(
			Model model, 
			@RequestParam(defaultValue = "1", name = "pageNum") int pageNum, 
			@RequestParam(defaultValue = "0", name = "cate1") int cate1) {
		
		Page<CsNoticeEntity> page = adminService.getNoticeList(cate1, pageNum);
		int[] pageNumbers = adminService.getPageNumbers(page);
		
		model.addAttribute("startPages", pageNumbers[0]);
		model.addAttribute("endPages", pageNumbers[1]);
		model.addAttribute("noticeList", page.getContent());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPosts", page.getTotalElements());
		model.addAttribute("cate1", cate1);
		return "admin/cs/notice/list";
		
	}

	// 페이지 이동 write
	@GetMapping("admin/cs/{type}/write")
	public String write(@PathVariable String type) {
		return "admin/cs/"+type+"/write";
	}
	
	// 공지사항 글쓰기 
	@PostMapping("admin/cs/notice/write")
	public String writeNotice(CsNoticeEntity csNoticeEntity, int cate1,HttpServletRequest req) {
		adminService.writeNotice(csNoticeEntity, cate1, req);
		return "redirect:/admin/cs/notice/list";
	}
	
	// 페이지 이동 notice modify
	@GetMapping("admin/cs/notice/modify")
	public String modifyNotice(Model model, int no)	{
		CsNoticeEntity entity= adminService.getNoticeOne(no);
		model.addAttribute("notice", entity);
		return "admin/cs/notice/modify";
	}
	
	@PutMapping("admin/cs/notice/modify")
	public String modifyNotice(CsNoticeEntity entity) {
		return "redirect:/admin/cs/notice/list";
	}
	
//	@GetMapping("admin/cs/{type}/modify")
//	public String modify(@PathVariable String type, Model model, int no)	{
//		CsNoticeEntity entity= adminService.getNoticeOne(no);
//		model.addAttribute("notice", entity);
//		return "admin/cs/"+type+"/modify";
//	}
	
	
	// 페이지 이동 view
	@GetMapping("admin/cs/{type}/view")
	public String view(@PathVariable String type, String no, Model model) {
		model.addAttribute("no", no);
		return "admin/cs/"+type+"/view";
	}
	
	// 공지사항 삭제
	@DeleteMapping("admin/cs/notice/delete")
	public ResponseEntity<Void> deleteNotice(@RequestParam int no) {
		adminService.deleteNotice(no);
		return ResponseEntity.ok().build();
	}
	
}
