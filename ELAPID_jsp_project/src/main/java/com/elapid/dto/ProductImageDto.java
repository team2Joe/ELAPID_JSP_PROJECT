package com.elapid.dto;

import java.sql.Blob;

public class ProductImageDto {
	
	private int img_id;
	private String img_thum;
	private String img_01;
	private String img_02;
	private String img_03;
	private String img_04;
	private String img_05;
	private String img_06;
	public ProductImageDto(int img_id, String img_thum, String img_01, String img_02, String img_03, String img_04,
			String img_05, String img_06) {
		super();
		this.img_id = img_id;
		this.img_thum = img_thum;
		this.img_01 = img_01;
		this.img_02 = img_02;
		this.img_03 = img_03;
		this.img_04 = img_04;
		this.img_05 = img_05;
		this.img_06 = img_06;
	}
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
	public String getImg_thum() {
		return img_thum;
	}
	public void setImg_thum(String img_thum) {
		this.img_thum = img_thum;
	}
	public String getImg_01() {
		return img_01;
	}
	public void setImg_01(String img_01) {
		this.img_01 = img_01;
	}
	public String getImg_02() {
		return img_02;
	}
	public void setImg_02(String img_02) {
		this.img_02 = img_02;
	}
	public String getImg_03() {
		return img_03;
	}
	public void setImg_03(String img_03) {
		this.img_03 = img_03;
	}
	public String getImg_04() {
		return img_04;
	}
	public void setImg_04(String img_04) {
		this.img_04 = img_04;
	}
	public String getImg_05() {
		return img_05;
	}
	public void setImg_05(String img_05) {
		this.img_05 = img_05;
	}
	public String getImg_06() {
		return img_06;
	}
	public void setImg_06(String img_06) {
		this.img_06 = img_06;
	}
	
	

}
