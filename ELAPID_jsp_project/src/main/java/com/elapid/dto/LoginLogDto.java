package com.elapid.dto;

import java.sql.Timestamp;

public class LoginLogDto {

	private String u_id;
	private String lo_id;
	private Timestamp lo_date;
	
	public LoginLogDto() {
		// TODO Auto-generated constructor stub
	}

	public LoginLogDto(String u_id, String lo_id, Timestamp lo_date) {
		super();
		this.u_id = u_id;
		this.lo_id = lo_id;
		this.lo_date = lo_date;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getLo_id() {
		return lo_id;
	}

	public void setLo_id(String lo_id) {
		this.lo_id = lo_id;
	}

	public Timestamp getLo_date() {
		return lo_date;
	}

	public void setLo_date(Timestamp lo_date) {
		this.lo_date = lo_date;
	}
	
	
}
