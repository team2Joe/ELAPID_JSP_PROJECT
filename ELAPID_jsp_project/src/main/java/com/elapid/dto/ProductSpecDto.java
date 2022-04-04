package com.elapid.dto;

public class ProductSpecDto {

	private String ps_id;
	private String ps_material;
	private String ps_color;
	private int ps_size;
	private int ps_height;
	private int ps_depth;
	private int ps_width;
	private int ps_volume;
	private int ps_weight;
	
	public ProductSpecDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductSpecDto(String ps_id, String ps_material, String ps_color, int ps_size, int ps_height, int ps_depth,
			int ps_width, int ps_volume, int ps_weight) {
		super();
		this.ps_id = ps_id;
		this.ps_material = ps_material;
		this.ps_color = ps_color;
		this.ps_size = ps_size;
		this.ps_height = ps_height;
		this.ps_depth = ps_depth;
		this.ps_width = ps_width;
		this.ps_volume = ps_volume;
		this.ps_weight = ps_weight;
	}

	public String getPs_id() {
		return ps_id;
	}

	public void setPs_id(String ps_id) {
		this.ps_id = ps_id;
	}

	public String getPs_material() {
		return ps_material;
	}

	public void setPs_material(String ps_material) {
		this.ps_material = ps_material;
	}

	public String getPs_color() {
		return ps_color;
	}

	public void setPs_color(String ps_color) {
		this.ps_color = ps_color;
	}

	public int getPs_size() {
		return ps_size;
	}

	public void setPs_size(int ps_size) {
		this.ps_size = ps_size;
	}

	public int getPs_height() {
		return ps_height;
	}

	public void setPs_height(int ps_height) {
		this.ps_height = ps_height;
	}

	public int getPs_depth() {
		return ps_depth;
	}

	public void setPs_depth(int ps_depth) {
		this.ps_depth = ps_depth;
	}

	public int getPs_width() {
		return ps_width;
	}

	public void setPs_width(int ps_width) {
		this.ps_width = ps_width;
	}

	public int getPs_volume() {
		return ps_volume;
	}

	public void setPs_volume(int ps_volume) {
		this.ps_volume = ps_volume;
	}

	public int getPs_weight() {
		return ps_weight;
	}

	public void setPs_weight(int ps_weight) {
		this.ps_weight = ps_weight;
	}
	
	
}
