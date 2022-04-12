package com.elapid.dto;

import java.sql.Timestamp;

public class ProductListDto {
	
	private int p_id;
	private String p_name;
	private int p_stock;
	private int p_price;
	private int p_discountprice;
	private int p_size;
	private String p_mainf;
	private String p_colorimg;
	private String p_colorname;
	private Timestamp p_date;
	private String p_desc;
	private String p_clickcount;
	private String ctg_id;
	private String ctg_main;
	private String ctg_middle;
	private String ctg_sub;
	private String img_thum;
	private String ps_color;
	private String p_rank;
	
	public ProductListDto() {
		// TODO Auto-generated constructor stub
	}


	

	// p_rank 제외한 생성자
	public ProductListDto(int p_id, String p_name, int p_stock, int p_price, int p_discountprice, int p_size,
			String p_mainf, String p_colorimg, String p_colorname, Timestamp p_date, String p_desc, String p_clickcount,
			String ctg_id, String ctg_main, String ctg_middle, String ctg_sub, String img_thum, String ps_color) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_stock = p_stock;
		this.p_price = p_price;
		this.p_discountprice = p_discountprice;
		this.p_size = p_size;
		this.p_mainf = p_mainf;
		this.p_colorimg = p_colorimg;
		this.p_colorname = p_colorname;
		this.p_date = p_date;
		this.p_desc = p_desc;
		this.p_clickcount = p_clickcount;
		this.ctg_id = ctg_id;
		this.ctg_main = ctg_main;
		this.ctg_middle = ctg_middle;
		this.ctg_sub = ctg_sub;
		this.img_thum = img_thum;
		this.ps_color = ps_color;
	}





	public ProductListDto(int p_id, String p_name, int p_stock, int p_price, int p_discountprice, int p_size,
			String p_mainf, String p_colorimg, String p_colorname, Timestamp p_date, String p_desc, String p_clickcount,
			String ctg_id, String ctg_main, String ctg_middle, String ctg_sub, String img_thum, String ps_color,
			String p_rank) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_stock = p_stock;
		this.p_price = p_price;
		this.p_discountprice = p_discountprice;
		this.p_size = p_size;
		this.p_mainf = p_mainf;
		this.p_colorimg = p_colorimg;
		this.p_colorname = p_colorname;
		this.p_date = p_date;
		this.p_desc = p_desc;
		this.p_clickcount = p_clickcount;
		this.ctg_id = ctg_id;
		this.ctg_main = ctg_main;
		this.ctg_middle = ctg_middle;
		this.ctg_sub = ctg_sub;
		this.img_thum = img_thum;
		this.ps_color = ps_color;
		this.p_rank = p_rank;
	}





	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public int getP_stock() {
		return p_stock;
	}


	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}


	public int getP_price() {
		return p_price;
	}


	public void setP_price(int p_price) {
		this.p_price = p_price;
	}


	public int getP_discountprice() {
		return p_discountprice;
	}


	public void setP_discountprice(int p_discountprice) {
		this.p_discountprice = p_discountprice;
	}


	public int getP_size() {
		return p_size;
	}


	public void setP_size(int p_size) {
		this.p_size = p_size;
	}


	public String getP_mainf() {
		return p_mainf;
	}


	public void setP_mainf(String p_mainf) {
		this.p_mainf = p_mainf;
	}


	public String getP_colorimg() {
		return p_colorimg;
	}


	public void setP_colorimg(String p_colorimg) {
		this.p_colorimg = p_colorimg;
	}


	public String getP_colorname() {
		return p_colorname;
	}


	public void setP_colorname(String p_colorname) {
		this.p_colorname = p_colorname;
	}


	public Timestamp getP_date() {
		return p_date;
	}


	public void setP_date(Timestamp p_date) {
		this.p_date = p_date;
	}


	public String getP_desc() {
		return p_desc;
	}


	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}


	public String getP_clickcount() {
		return p_clickcount;
	}


	public void setP_clickcount(String p_clickcount) {
		this.p_clickcount = p_clickcount;
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


	public String getImg_thum() {
		return img_thum;
	}


	public void setImg_thum(String img_thum) {
		this.img_thum = img_thum;
	}


	public String getPs_color() {
		return ps_color;
	}


	public void setPs_color(String ps_color) {
		this.ps_color = ps_color;
	}

	public String getP_rank() {
		return p_rank;
	}

	public void setP_rank(String p_rank) {
		this.p_rank = p_rank;
	}


	



	
	// 상품 리스트 출력할 생성자
	
	
	//전체 생성자


	


	
	
	
	
	
}
