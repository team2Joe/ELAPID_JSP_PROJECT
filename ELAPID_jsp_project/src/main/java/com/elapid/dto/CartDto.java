package com.elapid.dto;

public class CartDto {

	private String u_id;
	private int cart_id;
	private int cd_id;
	private int cart_discountedamount;
	private int cart_amount;
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDto(String u_id, int cart_id, int cd_id, int cart_discountedamount, int cart_amount) {
		super();
		this.u_id = u_id;
		this.cart_id = cart_id;
		this.cd_id = cd_id;
		this.cart_discountedamount = cart_discountedamount;
		this.cart_amount = cart_amount;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
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

	public int getCart_discountedamount() {
		return cart_discountedamount;
	}

	public void setCart_discountedamount(int cart_discountedamount) {
		this.cart_discountedamount = cart_discountedamount;
	}

	public int getCart_amount() {
		return cart_amount;
	}

	public void setCart_amount(int cart_amount) {
		this.cart_amount = cart_amount;
	}
	
	
}
