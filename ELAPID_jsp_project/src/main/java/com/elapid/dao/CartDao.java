package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.elapid.dto.CartViewDto;

public class CartDao {
	
	
		DataSource dataSource = null;

	public CartDao() {	
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* ArrayList CartView
	public ArrayList<CartViewDto> cartViewList(){
		
		ArrayList<CartViewDto> dtos = new ArrayList<CartViewDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select c.cart_id, p.p_id, p.p_name, p.p_colorname, p.p_price from product as p inner join cart_detail as cd on p.p_id = cd.product_p_id inner join cart as c on cd.cart_cart_id = c.cart_id where p_id = ? and cart_id = ?";
			preparedStatement  = connection.prepareStatement(query);
			preparedStatement.setInt(1,1);//(1, Integer.parseInt("p_id"));
			preparedStatement.setInt(1,1);	//(1, Integer.parseInt("cart_id"));
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int p_id1 =1 ; //resultSet.getInt("p_id");
				int cart_id = 1;  //resultSet.getInt("cart_id");
				String p_name = resultSet.getString("p_name");
				String p_colorname = resultSet.getString("p_colorname");
				int p_price = resultSet.getInt("p_price");
				
				CartViewDto dto = new CartViewDto(cart_id, p_id1, p_name, p_colorname, p_price);
				dtos.add(dto);
				
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement !=null)preparedStatement.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}return dtos;
	

	} 
	*/
	
	public CartViewDto cartViewList(int p_id2, int cart_id2) {
		
		
		CartViewDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select c.cart_id, p.p_id, p.p_name, p.p_colorname, p.p_price from product as p inner join cart_detail as cd on p.p_id = cd.product_p_id inner join cart as c on cd.cart_cart_id = c.cart_id where p_id = ? and cart_id = ?";
			preparedStatement  = connection.prepareStatement(query);
			preparedStatement.setInt(1,1);//(1, Integer.parseInt("p_id"));
			preparedStatement.setInt(2,1);	//(1, Integer.parseInt("cart_id"));
			resultSet = preparedStatement.executeQuery();
			
			
			if(resultSet.next()) {
				int p_id = resultSet.getInt("p_id");
				int cart_id = resultSet.getInt("cart_id");
				String p_name = resultSet.getString("p_name");
				String p_colorname = resultSet.getString("p_colorname");
				int p_price = resultSet.getInt("p_price");
				
				dto = new CartViewDto(cart_id, p_id, p_name, p_colorname, p_price);
				
				
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement !=null)preparedStatement.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}return dto;
	}
	
	
}
