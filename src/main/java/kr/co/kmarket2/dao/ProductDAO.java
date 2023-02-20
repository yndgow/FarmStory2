package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.ProductReviewVO;
import kr.co.kmarket2.vo.ProductVO;

@Mapper
@Repository
public interface ProductDAO {

	public int selectCountTotal(String cate1, String cate2); //홍민준 list paging
	public int selectCountTotalRe(int prodNo); //홍민준 review paging
	
	
	public List<ProductVO> selectProducts(String cate1, String cate2, String sort);
	public ProductVO selectProduct(int prodNo);
	public ProductReviewVO selectProductReview(int prodNo);
	public void insertProduct(ProductVO vo);
	public void updateProduct(ProductVO vo);
	public void deleteProduct(int prodNo);
}
