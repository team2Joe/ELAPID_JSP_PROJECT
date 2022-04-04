package com.elapid.dto;

public class ProductImageDto {
	private int img_id;
	private String detail_img;
	private String main_img;
	
	public ProductImageDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductImageDto(int img_id, String detail_img, String main_img) {
		super();
		this.img_id = img_id;
		this.detail_img = detail_img;
		this.main_img = main_img;
	}

	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}

	public String getDetail_img() {
		return detail_img;
	}

	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}
	

}
