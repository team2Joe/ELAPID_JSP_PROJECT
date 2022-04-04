package com.elapid.dto;

import java.sql.Timestamp;

public class UserDto {
	
	
	
	private int u_id;
	private String u_pwd;
	private String u_name;
	private String u_tel;
	private String u_address;
	private String u_nickname;
	private String u_email;
	private String u_grade;
	private int u_point;
	private Timestamp u_resignationdate;
	
	
	
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}


	public UserDto(int u_id, String u_pwd, String u_name, String u_tel, String u_address, String u_nickname,
			String u_email, String u_grade, int u_point, Timestamp u_resignationdate) {
		super();
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_tel = u_tel;
		this.u_address = u_address;
		this.u_nickname = u_nickname;
		this.u_email = u_email;
		this.u_grade = u_grade;
		this.u_point = u_point;
		this.u_resignationdate = u_resignationdate;
	}


	public int getU_id() {
		return u_id;
	}


	public void setU_id(int u_id) {
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


	public String getU_address() {
		return u_address;
	}


	public void setU_address(String u_address) {
		this.u_address = u_address;
	}


	public String getU_nickname() {
		return u_nickname;
	}


	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
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


	public int getU_point() {
		return u_point;
	}


	public void setU_point(int u_point) {
		this.u_point = u_point;
	}


	public Timestamp getU_resignationdate() {
		return u_resignationdate;
	}


	public void setU_resignationdate(Timestamp u_resignationdate) {
		this.u_resignationdate = u_resignationdate;
	}
	
	
	
}
