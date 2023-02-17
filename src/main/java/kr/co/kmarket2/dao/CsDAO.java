package kr.co.kmarket2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket2.vo.CsNoticeVO;
import kr.co.kmarket2.vo.CsQnaVO;

@Mapper
@Repository
public interface CsDAO {
	
	// index
	public List<CsNoticeVO> selectIndexNotice();
	public List<CsQnaVO> selectIndexQna();
	
	// notice
	public CsNoticeVO selectNotice();
	public List<CsNoticeVO> selectNoticeByGroup();
	public List<CsNoticeVO> selectNotices(int start);
	public List<CsNoticeVO> selectNoticesCate(int start, String cate1);
	public int selectCountNotice(String cate1);
	public int selectCountNotices();
	
	// qna
	public void selectQna();
	
	// faq
	public void selectFaq();
	
}
