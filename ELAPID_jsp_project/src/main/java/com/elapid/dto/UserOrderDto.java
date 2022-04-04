package com.elapid.dto;

import java.sql.Timestamp;

public class UserOrderDto {

	private int uo_id;
	private String uo_name;
	private String uo_tel;
	private int uo_point;
	private int uo_amount;
	private int uo_discountedamount;
	private Timestamp uo_date;
	private String uo_coupon;
	private String uo_address;
	private int uo_shippingfee;
	private String uo_paymentmethod;
	private int uo_deliverycharge;
	
	public UserOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public UserOrderDto(int uo_id, String uo_name, String uo_tel, int uo_point, int uo_amount, int uo_discountedamount,
			Timestamp uo_date, String uo_coupon, String uo_address, int uo_shippingfee, String uo_paymentmethod,
			int uo_deliverycharge) {
		super();
		this.uo_id = uo_id;
		this.uo_name = uo_name;
		this.uo_tel = uo_tel;
		this.uo_point = uo_point;
		this.uo_amount = uo_amount;
		this.uo_discountedamount = uo_discountedamount;
		this.uo_date = uo_date;
		this.uo_coupon = uo_coupon;
		this.uo_address = uo_address;
		this.uo_shippingfee = uo_shippingfee;
		this.uo_paymentmethod = uo_paymentmethod;
		this.uo_deliverycharge = uo_deliverycharge;
	}

	public int getUo_id() {
		return uo_id;
	}

	public void setUo_id(int uo_id) {
		this.uo_id = uo_id;
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

	public int getUo_point() {
		return uo_point;
	}

	public void setUo_point(int uo_point) {
		this.uo_point = uo_point;
	}

	public int getUo_amount() {
		return uo_amount;
	}

	public void setUo_amount(int uo_amount) {
		this.uo_amount = uo_amount;
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

	public String getUo_coupon() {
		return uo_coupon;
	}

	public void setUo_coupon(String uo_coupon) {
		this.uo_coupon = uo_coupon;
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

	public int getUo_deliverycharge() {
		return uo_deliverycharge;
	}

	public void setUo_deliverycharge(int uo_deliverycharge) {
		this.uo_deliverycharge = uo_deliverycharge;
	}
	
	
}
