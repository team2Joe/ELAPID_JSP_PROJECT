package com.elapid.dto;

public class NonUserCancelDto {

	private int nuod_id;
	private String cc_name;
	private int can_id;
	private int canp_id;
	private String can_category;
	private String can_reason;
	
	public NonUserCancelDto() {
		// TODO Auto-generated constructor stub
	}

	public NonUserCancelDto(int nuod_id, String cc_name, int can_id, int canp_id, String can_category,
			String can_reason) {
		super();
		this.nuod_id = nuod_id;
		this.cc_name = cc_name;
		this.can_id = can_id;
		this.canp_id = canp_id;
		this.can_category = can_category;
		this.can_reason = can_reason;
	}

	public int getNuod_id() {
		return nuod_id;
	}

	public void setNuod_id(int nuod_id) {
		this.nuod_id = nuod_id;
	}

	public String getCc_name() {
		return cc_name;
	}

	public void setCc_name(String cc_name) {
		this.cc_name = cc_name;
	}

	public int getCan_id() {
		return can_id;
	}

	public void setCan_id(int can_id) {
		this.can_id = can_id;
	}

	public int getCanp_id() {
		return canp_id;
	}

	public void setCanp_id(int canp_id) {
		this.canp_id = canp_id;
	}

	public String getCan_category() {
		return can_category;
	}

	public void setCan_category(String can_category) {
		this.can_category = can_category;
	}

	public String getCan_reason() {
		return can_reason;
	}

	public void setCan_reason(String can_reason) {
		this.can_reason = can_reason;
	}
	
	
	
	
}
