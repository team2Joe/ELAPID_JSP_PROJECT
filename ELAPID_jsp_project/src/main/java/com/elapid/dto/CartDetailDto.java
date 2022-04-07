package com.elapid.dto;

public class CartDetailDto {

	private int cart_id;
	private int cd_id;
	private int p_id;
	private int cdp_count;
	
	public CartDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDetailDto(int cart_id, int cd_id, int p_id, int cdp_count) {
		super();
		this.cart_id = cart_id;
		this.cd_id = cd_id;
		this.p_id = p_id;
		this.cdp_count = cdp_count;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getCd_id() {
		return cd_id;
	}

	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getCdp_count() {
		return cdp_count;
	}

	public void setCdp_count(int cdp_count) {
		this.cdp_count = cdp_count;
	}
	
	
}
