package com.elapid.dto;

import java.sql.Timestamp;

public class OrderHistoryDto {

	private int uo_id;
	private int uod_id;
	private int p_id;
	private int img_id;
	private int ctg_id;
	private String u_id;
	
	
	
	private String uo_name;
	private String uo_tel;
	private int uo_discountedamount;
	private Timestamp uo_date;
	private String uo_specificaddress;
	private String uo_address;
	private int uo_shippingfee;
	private String uo_paymentmethod;

	private int p_price;
	private int p_size;
	private String p_name;
	private String p_colorname;
	
	private String img_thum;
	
	private String ctg_sub;

	public OrderHistoryDto() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderHistoryDto(int uo_id, int uod_id, int p_id, int img_id, int ctg_id, String u_id, String uo_name,
			String uo_tel, int uo_discountedamount, Timestamp uo_date, String uo_specificaddress, String uo_address,
			int uo_shippingfee, String uo_paymentmethod, int p_price, int p_size, String p_name, String p_colorname,
			String img_thum, String ctg_sub) {
		super();
		this.uo_id = uo_id;
		this.uod_id = uod_id;
		this.p_id = p_id;
		this.img_id = img_id;
		this.ctg_id = ctg_id;
		this.u_id = u_id;
		this.uo_name = uo_name;
		this.uo_tel = uo_tel;
		this.uo_discountedamount = uo_discountedamount;
		this.uo_date = uo_date;
		this.uo_specificaddress = uo_specificaddress;
		this.uo_address = uo_address;
		this.uo_shippingfee = uo_shippingfee;
		this.uo_paymentmethod = uo_paymentmethod;
		this.p_price = p_price;
		this.p_size = p_size;
		this.p_name = p_name;
		this.p_colorname = p_colorname;
		this.img_thum = img_thum;
		this.ctg_sub = ctg_sub;
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

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}

	public int getCtg_id() {
		return ctg_id;
	}

	public void setCtg_id(int ctg_id) {
		this.ctg_id = ctg_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getUo_name() {
		return uo_name;
	}

	public void setUo_name(String uo_name) {
		this.uo_name = uo_name;
	}

	public String getUo_tel() {
		return uo_tel;
	}

	public void setUo_tel(String uo_tel) {
		this.uo_tel = uo_tel;
	}

	public int getUo_discountedamount() {
		return uo_discountedamount;
	}

	public void setUo_discountedamount(int uo_discountedamount) {
		this.uo_discountedamount = uo_discountedamount;
	}

	public Timestamp getUo_date() {
		return uo_date;
	}

	public void setUo_date(Timestamp uo_date) {
		this.uo_date = uo_date;
	}

	public String getUo_specificaddress() {
		return uo_specificaddress;
	}

	public void setUo_specificaddress(String uo_specificaddress) {
		this.uo_specificaddress = uo_specificaddress;
	}

	public String getUo_address() {
		return uo_address;
	}

	public void setUo_address(String uo_address) {
		this.uo_address = uo_address;
	}

	public int getUo_shippingfee() {
		return uo_shippingfee;
	}

	public void setUo_shippingfee(int uo_shippingfee) {
		this.uo_shippingfee = uo_shippingfee;
	}

	public String getUo_paymentmethod() {
		return uo_paymentmethod;
	}

	public void setUo_paymentmethod(String uo_paymentmethod) {
		this.uo_paymentmethod = uo_paymentmethod;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_size() {
		return p_size;
	}

	public void setP_size(int p_size) {
		this.p_size = p_size;
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

	public String getImg_thum() {
		return img_thum;
	}

	public void setImg_thum(String img_thum) {
		this.img_thum = img_thum;
	}

	public String getCtg_sub() {
		return ctg_sub;
	}

	public void setCtg_sub(String ctg_sub) {
		this.ctg_sub = ctg_sub;
	}
	
	//포인트 쿠폰은 나중에 쓸지도 모르니까 일단 적어봄 
	//private String uo_coupon;
	//private int uo_point;
	
	
}
