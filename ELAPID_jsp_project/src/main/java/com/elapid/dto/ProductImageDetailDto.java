package com.elapid.dto;

public class ProductImageDetailDto {
	private int img_id;
	private int p_id;
	
	public ProductImageDetailDto() {
		
	}
	
	public ProductImageDetailDto(int img_id, int p_id) {
		super();
		this.img_id = img_id;
		this.p_id = p_id;
	}

	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	
	
}
