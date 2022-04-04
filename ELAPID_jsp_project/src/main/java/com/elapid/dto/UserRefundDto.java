package com.elapid.dto;

public class UserRefundDto {

	
	private int uod_id;
	private String rc_name;
	private int urf_id;
	private String urf_reason;
	private String urf_img;
	private String urf_status;
	
	public UserRefundDto() {
		// TODO Auto-generated constructor stub
	}

	public UserRefundDto(int uod_id, String rc_name, int urf_id, String urf_reason, String urf_img, String urf_status) {
		super();
		this.uod_id = uod_id;
		this.rc_name = rc_name;
		this.urf_id = urf_id;
		this.urf_reason = urf_reason;
		this.urf_img = urf_img;
		this.urf_status = urf_status;
	}

	public int getUod_id() {
		return uod_id;
	}

	public void setUod_id(int uod_id) {
		this.uod_id = uod_id;
	}

	public String getRc_name() {
		return rc_name;
	}

	public void setRc_name(String rc_name) {
		this.rc_name = rc_name;
	}

	public int getUrf_id() {
		return urf_id;
	}

	public void setUrf_id(int urf_id) {
		this.urf_id = urf_id;
	}

	public String getUrf_reason() {
		return urf_reason;
	}

	public void setUrf_reason(String urf_reason) {
		this.urf_reason = urf_reason;
	}

	public String getUrf_img() {
		return urf_img;
	}

	public void setUrf_img(String urf_img) {
		this.urf_img = urf_img;
	}

	public String getUrf_status() {
		return urf_status;
	}

	public void setUrf_status(String urf_status) {
		this.urf_status = urf_status;
	}
	
	
	
}
