package com.elapid.dto;

import java.sql.Timestamp;

public class NonUserOrderDto {

	private int nuo_id;
	private Timestamp nuo_orderdate;
	private String nuo_name;
	private String nuo_tel;
	private String nuo_email;
	private String nuo_address;
	private int nuo_amount;
	private int nuo_discountedamount;
	private int nuo_shippingfee;
	private String nuo_paymentmethod;
	
	public NonUserOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public NonUserOrderDto(int nuo_id, Timestamp nuo_orderdate, String nuo_name, String nuo_tel, String nuo_email,
			String nuo_address, int nuo_amount, int nuo_discountedamount, int nuo_shippingfee,
			String nuo_paymentmethod) {
		super();
		this.nuo_id = nuo_id;
		this.nuo_orderdate = nuo_orderdate;
		this.nuo_name = nuo_name;
		this.nuo_tel = nuo_tel;
		this.nuo_email = nuo_email;
		this.nuo_address = nuo_address;
		this.nuo_amount = nuo_amount;
		this.nuo_discountedamount = nuo_discountedamount;
		this.nuo_shippingfee = nuo_shippingfee;
		this.nuo_paymentmethod = nuo_paymentmethod;
	}

	public int getNuo_id() {
		return nuo_id;
	}

	public void setNuo_id(int nuo_id) {
		this.nuo_id = nuo_id;
	}

	public Timestamp getNuo_orderdate() {
		return nuo_orderdate;
	}

	public void setNuo_orderdate(Timestamp nuo_orderdate) {
		this.nuo_orderdate = nuo_orderdate;
	}

	public String getNuo_name() {
		return nuo_name;
	}

	public void setNuo_name(String nuo_name) {
		this.nuo_name = nuo_name;
	}

	public String getNuo_tel() {
		return nuo_tel;
	}

	public void setNuo_tel(String nuo_tel) {
		this.nuo_tel = nuo_tel;
	}

	public String getNuo_email() {
		return nuo_email;
	}

	public void setNuo_email(String nuo_email) {
		this.nuo_email = nuo_email;
	}

	public String getNuo_address() {
		return nuo_address;
	}

	public void setNuo_address(String nuo_address) {
		this.nuo_address = nuo_address;
	}

	public int getNuo_amount() {
		return nuo_amount;
	}

	public void setNuo_amount(int nuo_amount) {
		this.nuo_amount = nuo_amount;
	}

	public int getNuo_discountedamount() {
		return nuo_discountedamount;
	}

	public void setNuo_discountedamount(int nuo_discountedamount) {
		this.nuo_discountedamount = nuo_discountedamount;
	}

	public int getNuo_shippingfee() {
		return nuo_shippingfee;
	}

	public void setNuo_shippingfee(int nuo_shippingfee) {
		this.nuo_shippingfee = nuo_shippingfee;
	}

	public String getNuo_paymentmethod() {
		return nuo_paymentmethod;
	}

	public void setNuo_paymentmethod(String nuo_paymentmethod) {
		this.nuo_paymentmethod = nuo_paymentmethod;
	}
	
	
}
