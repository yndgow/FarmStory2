package kr.co.kmarket2.dao;

import kr.co.kmarket2.vo.CsQnaVO;
import kr.co.kmarket2.vo.MemberPointVO;
import kr.co.kmarket2.vo.MemberVO;
import kr.co.kmarket2.vo.ProductOrderVO;
import kr.co.kmarket2.vo.ProductReviewVO;

public interface MyDAO {
	int selectMemberPointByUid(String uid);
	int countDeliveryByUid(String uid);
	int countCouponByUid(String uid);
	int countQnaStatByUid(String uid);
	ProductOrderVO selectOrderByUid(String uid);
	MemberPointVO selectPointByUid(String uid);
	ProductReviewVO selectReviewByUid(String uid);
	CsQnaVO selectQnaByUid(String uid);
	MemberVO selectMemberInfoByUid(String uid);
	ProductOrderVO selectOrderByUidForPeriod(String uid, int periodNum, String period);
	ProductOrderVO selectOrderByUidBetween(String uid, String startDate, String endDate);
	MemberPointVO selectPointByUidForPeriod(String uid, int periodNum, String period);
	MemberPointVO selectPointByUidBetween(String uid, String startDate, String endDate);
	ProductReviewVO selectReviewListByUid(String uid);
}
