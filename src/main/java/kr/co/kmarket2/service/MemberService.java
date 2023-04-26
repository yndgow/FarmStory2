package kr.co.kmarket2.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.dao.MemberDAO;
import kr.co.kmarket2.repository.MemberRepo;
import kr.co.kmarket2.vo.MemberTermsVO;
import kr.co.kmarket2.vo.MemberVO;

@Service
public class MemberService {

	private final MemberRepo memberRepo;
	private final MemberDAO memberDAO;
	private final PasswordEncoder encoder;
	
	public MemberService(MemberRepo memberRepo, MemberDAO memberDAO, PasswordEncoder encoder) {
		this.memberRepo = memberRepo;
		this.memberDAO = memberDAO;
		this.encoder = encoder;
	}
	
	public MemberTermsVO selectTerms() {
		return memberDAO.selectTerms();
	}
	
	public void insertMember(MemberVO vo) {
		vo.setPass(encoder.encode(vo.getPass2()));
		if(vo.getCompany() == null) {
			vo.setLevel(1);
			vo.setType(2);
		}else {
			vo.setLevel(5);
			vo.setType(1);
		}
		memberDAO.insertMember(vo);
	};
	
}
