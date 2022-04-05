package com.elapid.dto;

import java.sql.Blob;

public class ProductImageDto {
	
	private int img_id;
	private String img_name;
	private Blob img_file; // 실제 이미지 파일
	
	public ProductImageDto() {
		// TODO Auto-generated constructor stub
	}

	

	public ProductImageDto(int img_id, String img_name, Blob img_file) {
		super();
		this.img_id = img_id;
		this.img_name = img_name;
		this.img_file = img_file;
	}


	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}



	public String getImg_name() {
		return img_name;
	}



	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}



	public Blob getImg_file() {
		return img_file;
	}



	public void setImg_file(Blob img_file) {
		this.img_file = img_file;
	}



}
