package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.elapid.dto.NonUserCartViewDto;
import com.elapid.dto.UserCartViewDto;

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


	//NonUserCartViewPage
	public NonUserCartViewDto nonUserCartViewList(int p_id2, int cart_id2) {
		
		
		NonUserCartViewDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select c.cart_id, p.p_id, p.p_name, p.p_colorname, p.p_price " 
					+"from product as p inner join cart_detail as cd on p.p_id = cd.product_p_id "
					+"inner join cart as c on cd.cart_cart_id = c.cart_id "
					+"where p_id = ? and cart_id = ?";
			preparedStatement  = connection.prepareStatement(query);
			//임시로 숫자 적은거임 p_id받아오면 수정!
			preparedStatement.setInt(1,1);
			preparedStatement.setInt(2,1);
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				int p_id = resultSet.getInt("p_id");
				int cart_id = resultSet.getInt("cart_id");
				String p_name = resultSet.getString("p_name");
				String p_colorname = resultSet.getString("p_colorname");
				int p_price = resultSet.getInt("p_price");
				
				dto = new NonUserCartViewDto(cart_id, p_id, p_name, p_colorname, p_price);
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
	
	
	//UserCartView Page	
	public UserCartViewDto UserCartViewList(int p_id2, String u_id2) {
			
			UserCartViewDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				double cart_discountedamount= 0;
				int cart_amount = 0;
				double cart_total = 0;
				
				String query = "select u.u_id, p.p_id, c.cart_id, p.p_name, cou.c_id, p.p_colorname, p.p_price, cou.c_name, cou.c_atleastprice, cou.c_value "
						+ "from product as p "
						+ "inner join cart_detail as cd "
						+ "on p.p_id = cd.product_p_id "
						+ "inner join cart as c "
						+ "on cd.cart_cart_id = c.cart_id "
						+ "inner join user as u "
						+ "on c.u_id = u.u_id "
						+ "inner join receive as r "
						+ "on u.u_id = r.u_id "
						+ "inner join coupon as cou "
						+ "on r.c_id = cou.c_id "
						+ "where u.u_id = ? and p.p_id = ?";
				
				preparedStatement  = connection.prepareStatement(query);
				//임시로 값 줌! 나중에 p_id 받으면 수정하기!
				preparedStatement.setString(1 , "11");
				preparedStatement.setInt(2 , 1);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
				
					String u_id = resultSet.getString("u_id");
					int p_id = resultSet.getInt("p_id");
					int cart_id = resultSet.getInt("cart_id");
					int c_id = resultSet.getInt("c_id"); 
					String p_name = resultSet.getString("p_name");
					String p_colorname = resultSet.getString("p_colorname");
					int p_price = resultSet.getInt("p_price");
					String c_name = resultSet.getString("c_name");
					int c_atleastprice = resultSet.getInt("c_atleastprice");
					int c_value = resultSet.getInt("c_value");
					
					//총합 부분 계산
					cart_amount += p_price;
					cart_discountedamount = cart_amount * ((c_value)*0.01);
					cart_total = ((cart_amount)-(cart_discountedamount));
					dto = new UserCartViewDto(u_id, p_id, cart_id, c_id, p_name, p_colorname, p_price, c_name, c_atleastprice, c_value, cart_total);

					//호출 확인용
					System.out.println(u_id + p_id + cart_id + c_id + p_name + p_colorname + p_price + c_name + c_atleastprice + c_value);
					//호출확인용
					System.out.println(cart_amount + "\n" +cart_discountedamount +"\n"+ cart_amount +"\n"+ cart_total);
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
