package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartProductDeleteDao {

	
	DataSource dataSource = null;

	public CartProductDeleteDao() {	
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void userDeleteCart(int cd_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
	
	try {
		connection = dataSource.getConnection();
		String query = "delete from cart_detail where cd_id = ? ";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, cd_id);
		
		
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
