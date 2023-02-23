package kr.co.kmarket2.vo;


import lombok.Data;

@Data
public class CouponVO {

	private int id;
	private String name;
	private int discount;
	private int condition;
	
	private MemberCoupon memberCoupon;
}
