package com.elapid.dto;

public class NonUserRefundDto {

	private int nuod_id;
	private int nrf_id;
	private String rc_name;
	private String nrf_reason;
	private String nrf_img;
	private String urf_status;

	public NonUserRefundDto() {
		// TODO Auto-generated constructor stub
	}

	public NonUserRefundDto(int nuod_id, int nrf_id, String rc_name, String nrf_reason, String nrf_img,
			String urf_status) {
		super();
		this.nuod_id = nuod_id;
		this.nrf_id = nrf_id;
		this.rc_name = rc_name;
		this.nrf_reason = nrf_reason;
		this.nrf_img = nrf_img;
		this.urf_status = urf_status;
	}

	public int getNuod_id() {
		return nuod_id;
	}

	public void setNuod_id(int nuod_id) {
		this.nuod_id = nuod_id;
	}

	public int getNrf_id() {
		return nrf_id;
	}

	public void setNrf_id(int nrf_id) {
		this.nrf_id = nrf_id;
	}

	public String getRc_name() {
		return rc_name;
	}

	public void setRc_name(String rc_name) {
		this.rc_name = rc_name;
	}

	public String getNrf_reason() {
		return nrf_reason;
	}

	public void setNrf_reason(String nrf_reason) {
		this.nrf_reason = nrf_reason;
	}

	public String getNrf_img() {
		return nrf_img;
	}

	public void setNrf_img(String nrf_img) {
		this.nrf_img = nrf_img;
	}

	public String getUrf_status() {
		return urf_status;
	}

	public void setUrf_status(String urf_status) {
		this.urf_status = urf_status;
	}
	
	
}
