package com.elapid.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CartOrderDao {
	DataSource dataSource = null;


	public CartOrderDao() {	
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public void CartAdd(String uid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into cart (u_id) values (?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uid);
			
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
	
	public ArrayList<Integer> searchBycdids(ArrayList<Integer> cd_ids) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Integer> p_ids = new ArrayList<Integer>();
		
		try {
			conn = dataSource.getConnection();
			
			for(int i = 0 ; i < cd_ids.size() ; i++) {
				
			String query = "select p_id from cart_detail where cd_id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, cd_ids.get(i));
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				p_ids.add(rs.getInt("p_id"));
			}
			
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return p_ids;
	}
	
	
	
	
}