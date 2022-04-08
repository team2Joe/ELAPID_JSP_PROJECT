package com.elapid.dto;

public class AddCartDto {

	private int p_id;
	private String u_id;
	private int cd_id;
	private String p_name;
	private int p_price;
	 
	private String p_colorname;
	private int p_size;
	private int p_discountprice;
	private int cart_amount;
	
	public AddCartDto() {
		// TODO Auto-generated constructor stub
	}

	

	

	public AddCartDto(int p_id, String u_id, int cd_id, String p_name, int p_price, String p_colorname,
			int p_size, int p_discountprice, int cart_amount) {
		super();
		this.p_id = p_id;
		this.u_id = u_id;
		this.cd_id = cd_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_colorname = p_colorname;
		this.p_size = p_size;
		this.p_discountprice = p_discountprice;
		this.cart_amount = cart_amount;
	}





	public String getP_name() {
		return p_name;
	}



	public void setP_name(String p_name) {
		this.p_name = p_name;
	}



	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getCd_id() {
		return cd_id;
	}

	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}



	public String getP_colorname() {
		return p_colorname;
	}

	public void setP_colorname(String p_colorname) {
		this.p_colorname = p_colorname;
	}

	public int getP_size() {
		return p_size;
	}

	public void setP_size(int p_size) {
		this.p_size = p_size;
	}

	public int getP_discountprice() {
		return p_discountprice;
	}

	public void setP_discountprice(int p_discountprice) {
		this.p_discountprice = p_discountprice;
	}

	public int getCart_amount() {
		return cart_amount;
	}

	public void setCart_amount(int cart_amount) {
		this.cart_amount = cart_amount;
	}

	
	
}