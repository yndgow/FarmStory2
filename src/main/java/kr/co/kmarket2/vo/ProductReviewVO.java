package kr.co.kmarket2.vo;

import lombok.Data;

@Data
public class ProductReviewVO {
	private int revNo;
	private int prodNo;
	private String content;
	private String uid;
	private int rating;
	private String regip;
	private String rdate;
}
