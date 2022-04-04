package com.elapid.dto;

public class UserOrderDetailDto {

	private int uo_id;
	private int uod_id;
	private String uod_coupon;
	private int uod_count;
	
	public UserOrderDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public UserOrderDetailDto(int uo_id, int uod_id, String uod_coupon, int uod_count) {
		super();
		this.uo_id = uo_id;
		this.uod_id = uod_id;
		this.uod_coupon = uod_coupon;
		this.uod_count = uod_count;
	}

	public int getUo_id() {
		return uo_id;
	}

	public void setUo_id(int uo_id) {
		this.uo_id = uo_id;
	}

	public int getUod_id() {
		return uod_id;
	}

	public void setUod_id(int uod_id) {
		this.uod_id = uod_id;
	}

	public String getUod_coupon() {
		return uod_coupon;
	}

	public void setUod_coupon(String uod_coupon) {
		this.uod_coupon = uod_coupon;
	}

	public int getUod_count() {
		return uod_count;
	}

	public void setUod_count(int uod_count) {
		this.uod_count = uod_count;
	}
	
	
	
}
