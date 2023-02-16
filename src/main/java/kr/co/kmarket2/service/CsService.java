package kr.co.kmarket2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.CsDAO;
import kr.co.kmarket2.vo.CsNoticeVO;
import kr.co.kmarket2.vo.CsQnaVO;

@Service
public class CsService {

	@Autowired
	private CsDAO dao;
	
	public List<CsNoticeVO> selectIndexNotice() {
		return dao.selectIndexNotice();
	}
	
	public List<CsQnaVO> selectIndexQna() {
		return dao.selectIndexQna();
	}
}
