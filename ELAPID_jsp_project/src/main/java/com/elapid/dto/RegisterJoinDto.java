package com.elapid.dto;

public class RegisterJoinDto {
	private String reg_specificaddress;
	private int reg_defaultaddress;
	private String reg_name;
	private String reg_tel;
	private String add_address;
	
	public RegisterJoinDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public RegisterJoinDto(String reg_specificaddress, int reg_defaultaddress, String reg_name, String reg_tel,
			String add_address) {
		super();
		this.reg_specificaddress = reg_specificaddress;
		this.reg_defaultaddress = reg_defaultaddress;
		this.reg_name = reg_name;
		this.reg_tel = reg_tel;
		this.add_address = add_address;
	}


	public String getReg_specificaddress() {
		return reg_specificaddress;
	}


	public void setReg_specificaddress(String reg_specificaddress) {
		this.reg_specificaddress = reg_specificaddress;
	}


	public int getReg_defaultaddress() {
		return reg_defaultaddress;
	}


	public void setReg_defaultaddress(int reg_defaultaddress) {
		this.reg_defaultaddress = reg_defaultaddress;
	}


	public String getReg_name() {
		return reg_name;
	}


	public void setReg_name(String reg_name) {
		this.reg_name = reg_name;
	}


	public String getReg_tel() {
		return reg_tel;
	}


	public void setReg_tel(String reg_tel) {
		this.reg_tel = reg_tel;
	}


	public String getAdd_address() {
		return add_address;
	}


	public void setAdd_address(String add_address) {
		this.add_address = add_address;
	}
	
	
	
}
