package com.elapid.dto;

import java.sql.Timestamp;

public class ReceiveDto {

	private String u_id;
	private String c_id;
	private Timestamp bi_date;
	
	public ReceiveDto() {
		// TODO Auto-generated constructor stub
	}

	public ReceiveDto(String u_id, String c_id, Timestamp bi_date) {
		super();
		this.u_id = u_id;
		this.c_id = c_id;
		this.bi_date = bi_date;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public Timestamp getBi_date() {
		return bi_date;
	}

	public void setBi_date(Timestamp bi_date) {
		this.bi_date = bi_date;
	}
	
	
}
