package kr.co.kmarket2.service;

import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.MemberDAO;
import kr.co.kmarket2.repository.MemberRepo;
import kr.co.kmarket2.vo.MemberTermsVO;

@Service
public class MemberService {

	private final MemberRepo memberRepo;
	private final MemberDAO memberDAO;
	
	public MemberService(MemberRepo memberRepo, MemberDAO memberDAO) {
		this.memberRepo = memberRepo;
		this.memberDAO = memberDAO;
	}
	
	public MemberTermsVO selectTerms() {
		return memberDAO.selectTerms();
	}
	
	
	
	
}
