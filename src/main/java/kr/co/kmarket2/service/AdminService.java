package kr.co.kmarket2.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket2.dao.AdminDAO;
import kr.co.kmarket2.dto.ProductDTO;
import kr.co.kmarket2.entity.CsCate1Entity;
import kr.co.kmarket2.entity.CsFaqEntity;
import kr.co.kmarket2.entity.CsNoticeEntity;
import kr.co.kmarket2.entity.CsQnaEntity;
import kr.co.kmarket2.entity.ProductCate2Entity;
import kr.co.kmarket2.entity.ProductEntity;
import kr.co.kmarket2.repository.CsCate1Repo;
import kr.co.kmarket2.repository.CsFaqRepo;
import kr.co.kmarket2.repository.CsNoticeRepo;
import kr.co.kmarket2.repository.CsQnaRepo;
import kr.co.kmarket2.repository.ProductCate2Repo;
import kr.co.kmarket2.repository.ProductRepo;
import kr.co.kmarket2.specification.ProductSpecification;
import lombok.extern.slf4j.Slf4j;

/*
 * 날짜 : 2023/02/16
 * 이름 : 김지홍
 * 내용 : admin Service
 */

@Slf4j
@Service
public class AdminService{

	private final AdminDAO adminDAO;
	private final ProductRepo productRepo;
	private final ProductCate2Repo cate2Repo;
	private final CsFaqRepo csFaqRepo;
	private final CsQnaRepo csQnaRepo;
	private final CsNoticeRepo csNoticeRepo;
	private final CsCate1Repo cate1Repo;
	
	public AdminService(AdminDAO adminDAO, ProductRepo productRepo, ProductCate2Repo cate2Repo, CsFaqRepo csFaqRepo,
			CsQnaRepo csQnaRepo, CsNoticeRepo csNoticeRepo, CsCate1Repo cate1Repo) {
		this.adminDAO = adminDAO;
		this.productRepo = productRepo;
		this.cate2Repo = cate2Repo;
		this.csFaqRepo = csFaqRepo;
		this.csQnaRepo = csQnaRepo;
		this.csNoticeRepo = csNoticeRepo;
		this.cate1Repo = cate1Repo;
	}

	private final int PAGESIZE = 10;
	// 상품 등록
	public void insertProduct(ProductEntity entity) {
		productRepo.save(entity);
	}
	
	// cate 1에 따라 cate2 불러오기
	public List<ProductCate2Entity> selectAdminCate2(int cate1) {
		//List<ProductCate2VO> cate2List =  adminDAO.selectAdminCate2(cate1);
		List<ProductCate2Entity> cate2List = cate2Repo.findByCate1(cate1);
		return cate2List;
	}
	
	// IPv4 형식의 ip 값 가져오기
    public String getRemoteIP(HttpServletRequest request){
        String ip = request.getHeader("X-FORWARDED-FOR"); 
        //proxy 환경일 경우
        if (ip == null || ip.length() == 0) ip = request.getHeader("Proxy-Client-IP");
        //웹로직 서버일 경우
        if (ip == null || ip.length() == 0) ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip == null || ip.length() == 0) ip = request.getRemoteAddr() ;
        return ip;
   }
    
   // 파일 업로드
   public List<String> upload(ProductDTO dto) {
	   MultipartFile[] files = {dto.getThumb1(), dto.getThumb2(), dto.getThumb3(), dto.getDetail()};
	   List<String> fList = new ArrayList<>();
	   for (MultipartFile file : files) {
		   String oriName = file.getOriginalFilename();
		   String ext = oriName.substring(oriName.lastIndexOf("."));
		   String newFileName = UUID.randomUUID().toString() + ext;
		   
		   DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		   Date date = new Date();
		   String dateStr = dateFormat.format(date);
		   
		   File folder = new File("file/" + dateStr);
		   if(!folder.exists()) {
			   folder.mkdirs();
		   }
		   
		   Path path = Paths.get("file/" + dateStr + "/" + newFileName);
		   try {
			   Files.write(path, file.getBytes());
			   
		   } catch (IOException e) {
			   log.error(e.getMessage());
		   }
		   
		    fList.add(dateStr + "/" + newFileName);
	   }
	   
	   return fList;
   }
   
	// admin product list - jpa 로 페이징 하기
	public Page<ProductEntity> getProducts(int pageNum, String prodName, String prodNo, String company, String seller){
		Specification<ProductEntity> specification = new ProductSpecification(prodName, prodNo, company, seller);
		Pageable pageable = PageRequest.of(pageNum-1, PAGESIZE, Sort.by("rdate"));
		return productRepo.findAll(specification, pageable);
	}
	
	// 페이징에 필요한 start, endpage 가져오기
	public int[] getPageNumbers(Page<?> productPage) {
	    int totalPages = productPage.getTotalPages();
	    int currentPage = productPage.getNumber() + 1;

	    int startPage = ((currentPage - 1) / 10) * 10 + 1;
	    int endPage = Math.min(startPage + 9, totalPages);

	    int[] pageNumbers = {startPage, endPage};
	    return pageNumbers;
	}

	// cs notice list
	public Page<CsNoticeEntity> getNoticeList(int pageNum){
		
		Pageable pageable = PageRequest.of(pageNum-1, PAGESIZE, Sort.by("rdate").descending());
		return csNoticeRepo.findAllWithCsCate1Entities(pageable);
//		return csNoticeRepo.findAllByOrderByRdateDesc(pageable);
	}
	
	// cs notice write
	public void writeNotice(CsNoticeEntity csNoticeEntity, int cate1, HttpServletRequest req) {
		CsCate1Entity cate1Entity = cate1Repo.findById(cate1).orElse(null);
		if (cate1Entity != null) {
		    csNoticeEntity.setCate1Entity(cate1Entity);
		    csNoticeEntity.setRegip(getRemoteIP(req));
		    csNoticeRepo.save(csNoticeEntity);
		}
	}
	
	// cs notice delete
	public void deleteNotice(int no) {
		csNoticeRepo.deleteById(no);
	}
	
	
	// cs faq list
	public List<CsFaqEntity> getFaqList(Model model){
		return null;
	}
	
	// cs qna list
	public List<CsQnaEntity> getQnaList(Model model){
		return null;
	}
}
