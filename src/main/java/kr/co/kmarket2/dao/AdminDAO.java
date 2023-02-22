package kr.co.kmarket2.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.CsFaqVO;
import kr.co.kmarket2.vo.CsQnaVO;


@Mapper
@Repository
public interface AdminDAO {
	public List<CsQnaVO> selectListQna(int offset, int pageSize, int cate1, int cate2);
	public int countTotalQna(int cate1, int cate2);
	
}
