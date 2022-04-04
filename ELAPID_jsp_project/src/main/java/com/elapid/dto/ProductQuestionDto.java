package com.elapid.dto;

public class ProductQuestionDto {

	private String qc_name;
	private String u_id;
	private String pq_id;
	private String pq_title;
	private String pq_content;
	
	public ProductQuestionDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductQuestionDto(String qc_name, String u_id, String pq_id, String pq_title, String pq_content) {
		super();
		this.qc_name = qc_name;
		this.u_id = u_id;
		this.pq_id = pq_id;
		this.pq_title = pq_title;
		this.pq_content = pq_content;
	}

	public String getQc_name() {
		return qc_name;
	}

	public void setQc_name(String qc_name) {
		this.qc_name = qc_name;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getPq_id() {
		return pq_id;
	}

	public void setPq_id(String pq_id) {
		this.pq_id = pq_id;
	}

	public String getPq_title() {
		return pq_title;
	}

	public void setPq_title(String pq_title) {
		this.pq_title = pq_title;
	}

	public String getPq_content() {
		return pq_content;
	}

	public void setPq_content(String pq_content) {
		this.pq_content = pq_content;
	}
	
	
}
