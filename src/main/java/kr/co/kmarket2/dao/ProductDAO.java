package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ProductVO;

@Mapper
@Repository
public interface ProductDAO {

	public List<ProductVO> selectProducts();
	public ProductVO selectProduct(int prodNo);
	public void insertProduct(ProductVO vo);
	public void updateProduct(ProductVO vo);
	public void deleteProduct(int prodNo);
}
