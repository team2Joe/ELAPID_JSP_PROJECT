package com.elapid.dto;


public class UserCartViewDto {

	String u_id;
	int p_id;
	int cart_id;
	int c_id;
	String p_name;
	String p_colorname; 
	int p_price; 
	String c_name; 
	int c_atleastprice;
	int c_value;
	//할인량.
	int cart_totaldiscountedamount;
	//총합.
	int cart_totalamount;
	
	public UserCartViewDto() {
		// TODO Auto-generated constructor stub
		
	}

	public UserCartViewDto(String u_id, int p_id, int cart_id, int c_id, String p_name, String p_colorname, int p_price,
			String c_name, int c_atleastprice, int c_value, int cart_totaldiscountedamount, int cart_totalamount) {
		super();
		this.u_id = u_id;
		this.p_id = p_id;
		this.cart_id = cart_id;
		this.c_id = c_id;
		this.p_name = p_name;
		this.p_colorname = p_colorname;
		this.p_price = p_price;
		this.c_name = c_name;
		this.c_atleastprice = c_atleastprice;
		this.c_value = c_value;
		this.cart_totaldiscountedamount = cart_totaldiscountedamount;
		this.cart_totalamount = cart_totalamount;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
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

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_atleastprice() {
		return c_atleastprice;
	}

	public void setC_atleastprice(int c_atleastprice) {
		this.c_atleastprice = c_atleastprice;
	}

	public int getC_value() {
		return c_value;
	}

	public void setC_value(int c_value) {
		this.c_value = c_value;
	}

	public int getCart_totaldiscountedamount() {
		return cart_totaldiscountedamount;
	}

	public void setCart_totaldiscountedamount(int cart_totaldiscountedamount) {
		this.cart_totaldiscountedamount = cart_totaldiscountedamount;
	}

	public int getCart_totalamount() {
		return cart_totalamount;
	}

	public void setCart_totalamount(int cart_totalamount) {
		this.cart_totalamount = cart_totalamount;
	}

	
	
}
