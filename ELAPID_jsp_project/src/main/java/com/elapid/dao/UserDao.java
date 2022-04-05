package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
}
