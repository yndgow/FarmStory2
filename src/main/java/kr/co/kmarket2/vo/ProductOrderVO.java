package kr.co.kmarket2.vo;

import lombok.Data;

@Data
public class ProductOrderVO {
	private int ordNo;
	private String ordUid;
	private int ordCount;
	private int ordPrice;
	private int ordDiscount;
	private int ordDelivery;
	private int savePoint;
	private int usedPoint;
	private int ordTotPrice;
	private String recipName;
	private String recipHp;
	private String recipZip;
	private String recipAddr1;
	private String recipAddr2;
	private int ordPayment;
	private int ordComplete;
	private String ordDate;
	private int deliveryStatus; // 배송상태 추가 김지홍 02/23 
	
	// 추가필드 my
	private String thumb1;
	private String company;
	private String prodName;
}
