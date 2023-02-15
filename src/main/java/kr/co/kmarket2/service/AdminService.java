package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.AdminDAO;
import kr.co.kmarket2.vo.ProductCate2VO;

@Service
public class AdminService implements AdminDAO{

	private final AdminDAO adminDAO;

	public AdminService(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public List<ProductCate2VO> selectAdminCate2(int cate1) {
		List<ProductCate2VO> cate2List =  adminDAO.selectAdminCate2(cate1);
		return cate2List;
	}
	
	
}
