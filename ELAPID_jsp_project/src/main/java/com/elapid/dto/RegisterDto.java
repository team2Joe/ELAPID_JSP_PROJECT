package com.elapid.dto;

public class RegisterDto {

	private String add_id;
	private String u_id;
	
	public RegisterDto() {
		// TODO Auto-generated constructor stub
	}

	public RegisterDto(String add_id, String u_id) {
		super();
		this.add_id = add_id;
		this.u_id = u_id;
	}

	public String getAdd_id() {
		return add_id;
	}

	public void setAdd_id(String add_id) {
		this.add_id = add_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
	
}
