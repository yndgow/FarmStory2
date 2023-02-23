package kr.co.kmarket2.service;

import kr.co.kmarket2.dao.MyDAO;
import kr.co.kmarket2.vo.CsQnaVO;
import kr.co.kmarket2.vo.MemberPointVO;
import kr.co.kmarket2.vo.MemberVO;
import kr.co.kmarket2.vo.ProductOrderVO;
import kr.co.kmarket2.vo.ProductReviewVO;

public class MyService implements MyDAO{

	@Override
	public int selectMemberPointByUid(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countDeliveryByUid(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countCouponByUid(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countQnaStatByUid(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductOrderVO selectOrderByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberPointVO selectPointByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductReviewVO selectReviewByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CsQnaVO selectQnaByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMemberInfoByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductOrderVO selectOrderByUidForPeriod(String uid, int periodNum, String period) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductOrderVO selectOrderByUidBetween(String uid, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberPointVO selectPointByUidForPeriod(String uid, int periodNum, String period) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberPointVO selectPointByUidBetween(String uid, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductReviewVO selectReviewListByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}


}
