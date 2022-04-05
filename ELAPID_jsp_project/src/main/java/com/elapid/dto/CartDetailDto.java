package com.elapid.dto;

import java.sql.Timestamp;

public class CartDetailDto {

	private int cart_id;
	private int cd_id;
	private int p_id;
	private String p_name;
	private String p_colorname;
	private int p_price;
	private int cdp_count;
	private int c_id;
	private String c_name;
	private int c_atleastprice;
	private int c_termofusedesc;
	private int c_value;
	private Timestamp c_period;
	private String img_id;
	
	public CartDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDetailDto(int cart_id, int cd_id, int p_id, String p_name, String p_colorname, int p_price,
			int cdp_count, int c_id, String c_name, int c_atleastprice, int c_termofusedesc, int c_value,
			Timestamp c_period, String img_id) {
		super();
		this.cart_id = cart_id;
		this.cd_id = cd_id;
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_colorname = p_colorname;
		this.p_price = p_price;
		this.cdp_count = cdp_count;
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_atleastprice = c_atleastprice;
		this.c_termofusedesc = c_termofusedesc;
		this.c_value = c_value;
		this.c_period = c_period;
		this.img_id = img_id;
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

	public int getCdp_count() {
		return cdp_count;
	}

	public void setCdp_count(int cdp_count) {
		this.cdp_count = cdp_count;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
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

	public int getC_termofusedesc() {
		return c_termofusedesc;
	}

	public void setC_termofusedesc(int c_termofusedesc) {
		this.c_termofusedesc = c_termofusedesc;
	}

	public int getC_value() {
		return c_value;
	}

	public void setC_value(int c_value) {
		this.c_value = c_value;
	}

	public Timestamp getC_period() {
		return c_period;
	}

	public void setC_period(Timestamp c_period) {
		this.c_period = c_period;
	}

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	
	
	
}
