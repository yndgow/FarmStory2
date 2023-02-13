package kr.co.kmarket2.vo;

import java.time.LocalDateTime;

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
	private LocalDateTime rdate;
}

