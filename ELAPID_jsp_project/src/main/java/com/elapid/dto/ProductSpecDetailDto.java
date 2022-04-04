package com.elapid.dto;

public class ProductSpecDetailDto {

	private String ps_id;
	private int p_id; 
	
	public ProductSpecDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductSpecDetailDto(String ps_id, int p_id) {
		super();
		this.ps_id = ps_id;
		this.p_id = p_id;
	}

	public String getPs_id() {
		return ps_id;
	}

	public void setPs_id(String ps_id) {
		this.ps_id = ps_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	
}
