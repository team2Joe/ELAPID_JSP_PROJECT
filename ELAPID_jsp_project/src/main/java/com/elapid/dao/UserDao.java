package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.elapid.dto.AddressDto;
import com.elapid.dto.RegisterDto;
import com.elapid.dto.RegisterJoinDto;
import com.elapid.dto.UserDto;

public class UserDao {
	DataSource dataSource = null;

	public UserDao() {
		// TODO Auto-generated constructor stub

		
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// uid , upwd 를 만족하는 회원 수 리
	public int loginCheck(String uid, String upassword) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select count(*) from user where u_id = ? and u_pwd = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uid);
			preparedStatement.setString(2, upassword);
			resultSet =preparedStatement.executeQuery(); //��ȸ
			
			
			if(resultSet.next()) {
				result = resultSet.getInt(1);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// uid 로 uname 가져오기 
	public String nameReturn(String uid) {
		String name = "";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select u_name from user where u_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uid);
			resultSet =preparedStatement.executeQuery(); //��ȸ
			
			
			if(resultSet.next()) {
				name = resultSet.getString(1);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return name;
		
	}
	
	// 유저 추가 (회원가입)
	public void userAdd(String uid,String upwd,String uname, String uemail, String utel, String ugender, String ubirthdate) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into user (u_id, u_pwd, u_name,u_email, u_tel, u_gender, u_birthdate, u_point, u_grade, u_registerdate ) values (?,?,?,?,?,?,? ,0 ,'브론즈' ,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uid);
			preparedStatement.setString(2, upwd);
			preparedStatement.setString(3, uname);
			preparedStatement.setString(4, uemail);
			preparedStatement.setString(5, utel);
			preparedStatement.setString(6, ugender);
			preparedStatement.setString(7, ubirthdate);
		
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		
		
	}
	
	//유저 정보 전부 받아오기
	public UserDto profileView(String suid) {
		//UserDto(int u_id, String u_pwd, String u_name, String u_tel, String u_email, String u_grade, String u_gender,
		//		String u_birthdate, int u_point, String u_resignationdate, String u_registerdate)
		
		UserDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select * from user where u_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, (suid));
			resultSet =preparedStatement.executeQuery(); //��ȸ
			
			
			if(resultSet.next()) {
				String uid = resultSet.getString("u_id");
				String upwd = resultSet.getString("u_pwd");
				String uname = resultSet.getString("u_name");
				String utel = resultSet.getString("u_tel");
				String uemail = resultSet.getString("u_email");
				String ugender = resultSet.getString("u_gender");
				String ubirthdate = resultSet.getString("u_birthdate");
				String ugrade = resultSet.getString("u_grade");
				String uregisterdate = resultSet.getString("u_registerdate");
				String uresignationdate = resultSet.getString("u_resignationdate");
				int upoint = resultSet.getInt("u_point");
			
				
				dto = new UserDto(uid,upwd,uname,utel,uemail,ugrade,ugender,ubirthdate,upoint,uresignationdate,uregisterdate);
				
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
		
	}
	
	//유저정보 수정 
	public void profileModify(String uid, String uemail, String upwd, String utel, String ugender, String ubirthdate) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="update user set u_email = ? ,u_pwd= ? , u_tel= ? , u_gender = ? , u_birthdate = ? where u_id = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uemail);
			preparedStatement.setString(2, upwd);
			preparedStatement.setString(3, utel);
			preparedStatement.setString(4, ugender);
			preparedStatement.setString(5, ubirthdate);
			preparedStatement.setString(6, uid);	
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
	}//modify
	
	//탈퇴하기
	public void profileDelete(String uid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="delete from user where u_id = ?";
			
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, uid);	
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}//modify
	
	public int searchAddress(String addpostnumber,String addaddress) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int addid = -1;
		
		try {
			connection = dataSource.getConnection();
			String query ="select add_id from address where add_postnumber = ? and add_address = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, addpostnumber);
			preparedStatement.setString(2, addaddress);
			resultSet =preparedStatement.executeQuery(); //
			
			
			if(resultSet.next()) {
				addid = resultSet.getInt(1);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return addid;
		
	}
	
	
	
	public void addressAdd(String addpostnumber,String addaddress) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into address (add_postnumber, add_address) values (?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, addpostnumber);
			preparedStatement.setString(2, addaddress);
			preparedStatement.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void registerAdd(String uid, int addid,String addspecificaddress ,String name,String tel,int defaultaddress) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into register (u_id,add_id, reg_specificaddress, reg_name,reg_tel ,reg_defaultaddress) values (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,uid);
			preparedStatement.setInt(2, addid);
			preparedStatement.setString(3, addspecificaddress);
			preparedStatement.setString(4, name);
			preparedStatement.setString(5, tel);
			preparedStatement.setInt(6, defaultaddress);
			
			
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void registerSetNoDefault(String uid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update register set reg_defaultaddress = 0 where u_id = ? and reg_defaultaddress = 1 ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,uid);
			
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void registerSetDefault(String uid, int addid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update register set reg_defaultaddress = 1 where u_id = ? and add_id = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,uid);
			preparedStatement.setInt(2,addid);
			
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public void registerDelete(String uid,int addid) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query ="delete from register where u_id = ? and add_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uid);
			preparedStatement.setInt(2, addid);
			
			preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public RegisterJoinDto searchRegister(String uid,int addid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		RegisterJoinDto dto = new RegisterJoinDto();
		
		
		try {
			connection = dataSource.getConnection();
			String query ="SELECT u_id, r.add_id , reg_name, reg_tel, add_address  , reg_specificaddress,reg_defaultaddress FROM register as r inner join address as a on r.add_id = a.add_id where u_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uid);
			resultSet =preparedStatement.executeQuery(); //
			
			while(resultSet.next()) {
				dto.setAdd_address(resultSet.getString("add_address"));
				dto.setReg_defaultaddress(resultSet.getInt("reg_defaultaddress"));
				dto.setReg_specificaddress(resultSet.getString("reg_specificaddress")); 
				dto.setReg_name(resultSet.getString("reg_name")); 
				dto.setReg_tel(resultSet.getString("reg_tel"));
				dto.setU_id(resultSet.getString("reg_tel"));
				dto.setAdd_id(resultSet.getInt("add_id"));
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		return dto;
	}
	public RegisterJoinDto searchRegisterForDefault(String uid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		RegisterJoinDto dto = new RegisterJoinDto();
		
		
		try {
			connection = dataSource.getConnection();
			String query ="SELECT u_id, r.add_id , reg_name, reg_tel, add_address  , reg_specificaddress,reg_defaultaddress FROM register as r inner join address as a on r.add_id = a.add_id where u_id = ? and reg_defaultaddress = 1";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uid);
			resultSet =preparedStatement.executeQuery(); //
			
			while(resultSet.next()) {
				dto.setAdd_address(resultSet.getString("add_address"));
				dto.setReg_defaultaddress(resultSet.getInt("reg_defaultaddress"));
				dto.setReg_specificaddress(resultSet.getString("reg_specificaddress")); 
				dto.setReg_name(resultSet.getString("reg_name")); 
				dto.setReg_tel(resultSet.getString("reg_tel"));
				dto.setU_id(resultSet.getString("reg_tel"));
				dto.setAdd_id(resultSet.getInt("add_id"));
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		return dto;
	}
	
	public ArrayList<RegisterJoinDto> searchRegisterForUser(String uid) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<RegisterJoinDto> dtos = new ArrayList<RegisterJoinDto>();
		
		
		try {
			connection = dataSource.getConnection();
			String query ="SELECT u_id, r.add_id , reg_name, reg_tel, add_address  , reg_specificaddress,reg_defaultaddress FROM register as r inner join address as a on r.add_id = a.add_id where u_id = ? order by reg_defaultaddress desc";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uid);
			resultSet =preparedStatement.executeQuery(); //
			
			while(resultSet.next()) {
				String add_address = resultSet.getString("add_address");
				int reg_defaultaddress = resultSet.getInt("reg_defaultaddress");
				String reg_specificaddress = resultSet.getString("reg_specificaddress");
				String reg_name = resultSet.getString("reg_name");
				String reg_tel = resultSet.getString("reg_tel");
				String u_id = resultSet.getString("u_id");
				int add_id = resultSet.getInt("add_id");
				RegisterJoinDto dto = new RegisterJoinDto(reg_specificaddress,reg_defaultaddress,reg_name,reg_tel,add_id,u_id, add_address);
				
				dtos.add(dto);
				
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		
		return dtos;
		
	}
	
	/*
	public AddressDto (int addid) {
		//UserDto(int u_id, String u_pwd, String u_name, String u_tel, String u_email, String u_grade, String u_gender,
		//		String u_birthdate, int u_point, String u_resignationdate, String u_registerdate)
		
		AddressDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select * from user where u_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, (suid));
			resultSet =preparedStatement.executeQuery(); //��ȸ
			
			
			if(resultSet.next()) {
				String uid = resultSet.getString("u_id");
				String upwd = resultSet.getString("u_pwd");
				String uname = resultSet.getString("u_name");
				String utel = resultSet.getString("u_tel");
				String uemail = resultSet.getString("u_email");
				String ugender = resultSet.getString("u_gender");
				String ubirthdate = resultSet.getString("u_birthdate");
				String ugrade = resultSet.getString("u_grade");
				String uregisterdate = resultSet.getString("u_registerdate");
				String uresignationdate = resultSet.getString("u_resignationdate");
				int upoint = resultSet.getInt("u_point");
			
				
				dto = new UserDto(uid,upwd,uname,utel,uemail,ugrade,ugender,ubirthdate,upoint,uresignationdate,uregisterdate);
				
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
		
	}
	*/
	
}//userdao
