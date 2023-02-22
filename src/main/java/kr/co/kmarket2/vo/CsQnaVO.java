package kr.co.kmarket2.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CsQnaVO {
	private int no;
	private String uid; 
	private int cate1;
	private int cate2;
	private String title;
	private String content;
	private String answer;
	private int status;
	private int hit;
	private String regip;
	private Date rdate;
	
	// 추가필드 김지홍
	private String c1Name;
	private String c2Name;
	
	// 추가필드 공민혁
	private int comment;
}

