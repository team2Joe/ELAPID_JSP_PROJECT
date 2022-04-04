package com.elapid.dto;

import java.sql.Timestamp;

public class CouponDto {

	
	private String c_id;
	private String c_name;
	private String c_atleastprice; // 최소가격
	private String c_termofusedesc; // 사용조건
	private String c_value; // 할인률||할인금액
	private Timestamp c_period; // 쿠폰사용기간
	
	public CouponDto() {
		// TODO Auto-generated constructor stub
	}

	public CouponDto(String c_id, String c_name, String c_atleastprice, String c_termofusedesc, String c_value,
			Timestamp c_period) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_atleastprice = c_atleastprice;
		this.c_termofusedesc = c_termofusedesc;
		this.c_value = c_value;
		this.c_period = c_period;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_atleastprice() {
		return c_atleastprice;
	}

	public void setC_atleastprice(String c_atleastprice) {
		this.c_atleastprice = c_atleastprice;
	}

	public String getC_termofusedesc() {
		return c_termofusedesc;
	}

	public void setC_termofusedesc(String c_termofusedesc) {
		this.c_termofusedesc = c_termofusedesc;
	}

	public String getC_value() {
		return c_value;
	}

	public void setC_value(String c_value) {
		this.c_value = c_value;
	}

	public Timestamp getC_period() {
		return c_period;
	}

	public void setC_period(Timestamp c_period) {
		this.c_period = c_period;
	}
	
	
}
