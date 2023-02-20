package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ProductCate2VO;

@Mapper
@Repository
public interface AdminDAO {
	
	public List<ProductCate2VO> selectAdminCate2(int cate1);
	
}
