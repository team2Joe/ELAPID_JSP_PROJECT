package com.elapid.dto;

public class CategoryDto {

	private String ctg_id;
	private String ctg_main;
	private String ctg_middle;
	private String ctg_sub;
	
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(String ctg_id, String ctg_main, String ctg_middle, String ctg_sub) {
		super();
		this.ctg_id = ctg_id;
		this.ctg_main = ctg_main;
		this.ctg_middle = ctg_middle;
		this.ctg_sub = ctg_sub;
	}

	public String getCtg_id() {
		return ctg_id;
	}

	public void setCtg_id(String ctg_id) {
		this.ctg_id = ctg_id;
	}

	public String getCtg_main() {
		return ctg_main;
	}

	public void setCtg_main(String ctg_main) {
		this.ctg_main = ctg_main;
	}

	public String getCtg_middle() {
		return ctg_middle;
	}

	public void setCtg_middle(String ctg_middle) {
		this.ctg_middle = ctg_middle;
	}

	public String getCtg_sub() {
		return ctg_sub;
	}

	public void setCtg_sub(String ctg_sub) {
		this.ctg_sub = ctg_sub;
	}
	
	
}
