package com.elapid.dto;

import java.sql.Timestamp;

public class UserDto {
	
	
	
	private String u_id;
	private String u_pwd;
	private String u_name;
	private String u_tel;
	private String u_email;
	private String u_grade;
	private String u_gender;
	private String u_birthdate;
	private int u_point;
	private String u_resignationdate;
	private String u_registerdate;
	
	
	
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}




	public UserDto(String u_id, String u_pwd, String u_name, String u_tel, String u_email, String u_grade, String u_gender,
			String u_birthdate, int u_point, String u_resignationdate, String u_registerdate) {
		super();
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_tel = u_tel;
		this.u_email = u_email;
		this.u_grade = u_grade;
		this.u_gender = u_gender;
		this.u_birthdate = u_birthdate;
		this.u_point = u_point;
		this.u_resignationdate = u_resignationdate;
		this.u_registerdate = u_registerdate;
	}




	public String getU_id() {
		return u_id;
	}




	public void setU_id(String u_id) {
		this.u_id = u_id;
	}




	public String getU_pwd() {
		return u_pwd;
	}




	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}




	public String getU_name() {
		return u_name;
	}




	public void setU_name(String u_name) {
		this.u_name = u_name;
	}




	public String getU_tel() {
		return u_tel;
	}




	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}




	public String getU_email() {
		return u_email;
	}




	public void setU_email(String u_email) {
		this.u_email = u_email;
	}




	public String getU_grade() {
		return u_grade;
	}




	public void setU_grade(String u_grade) {
		this.u_grade = u_grade;
	}




	public String getU_gender() {
		return u_gender;
	}




	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}




	public String getU_birthdate() {
		return u_birthdate;
	}




	public void setU_birthdate(String u_birthdate) {
		this.u_birthdate = u_birthdate;
	}




	public int getU_point() {
		return u_point;
	}




	public void setU_point(int u_point) {
		this.u_point = u_point;
	}




	public String getU_resignationdate() {
		return u_resignationdate;
	}




	public void setU_resignationdate(String u_resignationdate) {
		this.u_resignationdate = u_resignationdate;
	}




	public String getU_registerdate() {
		return u_registerdate;
	}




	public void setU_registerdate(String u_registerdate) {
		this.u_registerdate = u_registerdate;
	}



	
	
}
