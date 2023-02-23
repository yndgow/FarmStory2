package kr.co.kmarket2.vo;

import lombok.Data;

@Data
public class MemberPointVO {
	private int pointNo;
	private int pointStat; // 0223 추가 김지홍 구분 - 포인트 상태 
	private String uid;
	private int ordNo;
	private int point;
	private String desc; // 0223 추가 김지홍 비고 -포인트 설명
	private String rdate; // 0223 추가 김지홍 포인트 적립일 - 구매확정일
	private String pointDate; // 포인트 소멸일
}
