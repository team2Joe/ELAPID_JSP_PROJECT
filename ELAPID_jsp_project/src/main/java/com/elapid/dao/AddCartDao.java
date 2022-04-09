package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.elapid.dto.AddCartDto;
import com.elapid.dto.NonUserCartViewDto;
import com.elapid.dto.UserCartViewDto;
import com.mysql.cj.Session;

import java.lang.Math;


public class AddCartDao {
	
	
		DataSource dataSource = null;

		
	
		
	public AddCartDao() {	
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void userAddcart(int p_id , String u_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
	
	try {
		connection = dataSource.getConnection();
		String query = "insert into cart_detail (p_id,cart_id) values (?, (select cart_id from cart where u_id = ?))";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, p_id);
		preparedStatement.setString(2, u_id);
		preparedStatement.executeUpdate();
		
		System.out.println(u_id + p_id);
		
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
