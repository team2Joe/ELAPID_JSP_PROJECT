package com.elapid.dto;

public class AddressDto {
 
	private String add_id;
	private String add_address;
	private String add_specificaddress;
	private int add_postnumber;
	private String add_defaultaddress;
	
	
	public AddressDto() {
		// TODO Auto-generated constructor stub
	}


	public AddressDto(String add_id, String add_address, String add_specificaddress, int add_postnumber,
			String add_defaultaddress) {
		super();
		this.add_id = add_id;
		this.add_address = add_address;
		this.add_specificaddress = add_specificaddress;
		this.add_postnumber = add_postnumber;
		this.add_defaultaddress = add_defaultaddress;
	}


	public String getAdd_id() {
		return add_id;
	}


	public void setAdd_id(String add_id) {
		this.add_id = add_id;
	}


	public String getAdd_address() {
		return add_address;
	}


	public void setAdd_address(String add_address) {
		this.add_address = add_address;
	}


	public String getAdd_specificaddress() {
		return add_specificaddress;
	}


	public void setAdd_specificaddress(String add_specificaddress) {
		this.add_specificaddress = add_specificaddress;
	}


	public int getAdd_postnumber() {
		return add_postnumber;
	}


	public void setAdd_postnumber(int add_postnumber) {
		this.add_postnumber = add_postnumber;
	}


	public String getAdd_defaultaddress() {
		return add_defaultaddress;
	}


	public void setAdd_defaultaddress(String add_defaultaddress) {
		this.add_defaultaddress = add_defaultaddress;
	}
	
	
}
