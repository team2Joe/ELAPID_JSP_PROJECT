package com.elapid.dto;

public class CategoryDetailDto {

	private String ctg_id;
	private String p_id;
	
	
	public CategoryDetailDto() {
		// TODO Auto-generated constructor stub
	}


	public CategoryDetailDto(String ctg_id, String p_id) {
		super();
		this.ctg_id = ctg_id;
		this.p_id = p_id;
	}


	public String getCtg_id() {
		return ctg_id;
	}


	public void setCtg_id(String ctg_id) {
		this.ctg_id = ctg_id;
	}


	public String getP_id() {
		return p_id;
	}


	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	
	
}
