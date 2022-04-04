package com.elapid.dto;

public class UserCancelDto {

	private int uo_id;
	
	private int can_id;
	private String can_category;
	private String cc_name;
	private String can_reason;
	private int canp_id;//취소할 상품 id
	
	public UserCancelDto() {
		// TODO Auto-generated constructor stub
	}

	public UserCancelDto(int uo_id, int can_id, String can_category, String cc_name, String can_reason, int canp_id) {
		super();
		this.uo_id = uo_id;
		this.can_id = can_id;
		this.can_category = can_category;
		this.cc_name = cc_name;
		this.can_reason = can_reason;
		this.canp_id = canp_id;
	}

	public int getUo_id() {
		return uo_id;
	}

	public void setUo_id(int uo_id) {
		this.uo_id = uo_id;
	}

	public int getCan_id() {
		return can_id;
	}

	public void setCan_id(int can_id) {
		this.can_id = can_id;
	}

	public String getCan_category() {
		return can_category;
	}

	public void setCan_category(String can_category) {
		this.can_category = can_category;
	}

	public String getCc_name() {
		return cc_name;
	}

	public void setCc_name(String cc_name) {
		this.cc_name = cc_name;
	}

	public String getCan_reason() {
		return can_reason;
	}

	public void setCan_reason(String can_reason) {
		this.can_reason = can_reason;
	}

	public int getCanp_id() {
		return canp_id;
	}

	public void setCanp_id(int canp_id) {
		this.canp_id = canp_id;
	}

	
	
}
