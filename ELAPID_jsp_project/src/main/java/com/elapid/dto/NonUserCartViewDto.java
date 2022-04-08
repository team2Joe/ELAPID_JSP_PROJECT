package com.elapid.dto;

public class NonUserCartViewDto {

	
	private int cart_id;
	private int p_id;
	private String p_name;
	private String p_colorname;
	private int p_price;

	
	public NonUserCartViewDto() {
		// TODO Auto-generated constructor stub
	}


	
	public NonUserCartViewDto(int cart_id, int p_id, String p_name, String p_colorname, int p_price) {
		super();
		this.cart_id = cart_id;
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_colorname = p_colorname;
		this.p_price = p_price;
	}


	public int getCart_id() {
		return cart_id;
	}


	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}


	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getP_colorname() {
		return p_colorname;
	}


	public void setP_colorname(String p_colorname) {
		this.p_colorname = p_colorname;
	}


	public int getP_price() {
		return p_price;
	}


	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	
	
}
