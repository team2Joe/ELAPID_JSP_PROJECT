package com.elapid.dto;

public class NonUserOrderDetailDto {

	private int nuo_id;
	private int nuod_id;
	private int p_id;
	private int p_count;
	private String uod_coupon;
	private int uod_count;
	private int can_id;
	private int nrf_id;
	
	public NonUserOrderDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public NonUserOrderDetailDto(int nuo_id, int nuod_id, int p_id, int p_count, String uod_coupon, int uod_count,
			int can_id, int nrf_id) {
		super();
		this.nuo_id = nuo_id;
		this.nuod_id = nuod_id;
		this.p_id = p_id;
		this.p_count = p_count;
		this.uod_coupon = uod_coupon;
		this.uod_count = uod_count;
		this.can_id = can_id;
		this.nrf_id = nrf_id;
	}

	public int getNuo_id() {
		return nuo_id;
	}

	public void setNuo_id(int nuo_id) {
		this.nuo_id = nuo_id;
	}

	public int getNuod_id() {
		return nuod_id;
	}

	public void setNuod_id(int nuod_id) {
		this.nuod_id = nuod_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
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

	public int getCan_id() {
		return can_id;
	}

	public void setCan_id(int can_id) {
		this.can_id = can_id;
	}

	public int getNrf_id() {
		return nrf_id;
	}

	public void setNrf_id(int nrf_id) {
		this.nrf_id = nrf_id;
	}
	
	
	
}
