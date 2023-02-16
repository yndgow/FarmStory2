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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket2.dao.AdminDAO;
import kr.co.kmarket2.dto.ProductDTO;
import kr.co.kmarket2.entity.ProductEntity;
import kr.co.kmarket2.repository.ProductRepo;
import kr.co.kmarket2.vo.ProductCate2VO;
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
	
	public AdminService(AdminDAO adminDAO, ProductRepo productRepo) {
		this.productRepo = productRepo;
		this.adminDAO = adminDAO;
	}

	// 상품 등록
	public void insertProduct(ProductEntity entity) {
		productRepo.save(entity);
	}
	
	// 상품 목록
	public List<ProductEntity> selectProducts(){
		return productRepo.findAll();
	}
	public Page<ProductEntity> getLatestProducts(int pageNum) {
	    Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("rdate").descending());
	    Page<ProductEntity> products = productRepo.findAll(pageable);
	    return products;
	}
	
	public List<Integer> getPageNumbers(Page<ProductEntity> productPage) {
	    int totalPages = productPage.getTotalPages();
	    int currentPage = productPage.getNumber() + 1;

	    int startPage = ((currentPage - 1) / 10) * 10 + 1;
	    int endPage = Math.min(startPage + 9, totalPages);

	    List<Integer> pageNumbers = new ArrayList<>();
	    for (int i = startPage; i <= endPage; i++) {
	        pageNumbers.add(i);
	    }

	    return pageNumbers;
	}
	

	public List<ProductCate2VO> selectAdminCate2(int cate1) {
		List<ProductCate2VO> cate2List =  adminDAO.selectAdminCate2(cate1);
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
	
}
