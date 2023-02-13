package kr.co.kmarket2.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CouponVO {

	private int no;
	private String name;
	private int discount;
	private String condition;
	private int status;
	private LocalDateTime rdate;
	private LocalDateTime rexpdate;
	
}
