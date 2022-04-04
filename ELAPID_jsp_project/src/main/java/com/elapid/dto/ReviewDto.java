package com.elapid.dto;

public class ReviewDto {

	private String u_id;
	private String uod_id;
	
	public ReviewDto() {
		// TODO Auto-generated constructor stub
	}

	public ReviewDto(String u_id, String uod_id) {
		super();
		this.u_id = u_id;
		this.uod_id = uod_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getUod_id() {
		return uod_id;
	}

	public void setUod_id(String uod_id) {
		this.uod_id = uod_id;
	}
	
	
}
