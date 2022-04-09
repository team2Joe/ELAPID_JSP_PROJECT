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

public class CartViewDao {

	DataSource dataSource = null;

	public CartViewDao() {	
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		//-----------------------------------------------------------------------------------------------------------------------------------------
		//UserCartView Page	
		public ArrayList<UserCartViewDto> UserCartViewList(String u_id2) {
				
				ArrayList<UserCartViewDto> dtos = new ArrayList<UserCartViewDto>();
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				int cart_totalamount = 0;
				
				try {
					connection = dataSource.getConnection();
					String query = "select u.u_id, p.p_id, p.p_name, p.p_price, p.p_colorname, p.p_size, p.p_discountprice ,cd.cd_id, c.cart_id, img_thum "
							+ "from product as p "
							+ "inner join cart_detail as cd "
							+ "on p.p_id = cd.p_id "
							+ "inner join cart as c "
							+ "on cd.cart_id = c.cart_id "
							+ "inner join user as u "
							+ "on c.u_id = u.u_id "
							+ "inner join image_detail as imgd "
							+ "on imgd.p_id = p.p_id "
							+ "inner join product_image as pimg "
							+ "on imgd.img_id = pimg.img_id "
							+ "where c.cart_id = (Select cart_id from cart where u_id = ?) ";
					
					preparedStatement  = connection.prepareStatement(query);
					preparedStatement.setString(1 , u_id2);
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						
						
						String u_id = resultSet.getString("u_id");
						int p_id = resultSet.getInt("p_id");
						int cart_id = resultSet.getInt("cart_id");
						String p_name = resultSet.getString("p_name");
						String p_colorname = resultSet.getString("p_colorname");
						int p_price = resultSet.getInt("p_price");
						String img_thum = resultSet.getString("img_thum");
						int cd_id = resultSet.getInt("cd_id");

						//총합 부분 계산
						cart_totalamount += p_price;
						UserCartViewDto dto = new UserCartViewDto(u_id, p_id, cd_id, cart_id, p_name, p_colorname, p_price, cart_totalamount, img_thum);
						dtos.add(dto);
						
						//check
						System.out.println(u_id + p_id + cart_id + p_name + p_colorname +"&&&&&&&&&&&"+ p_price +"***"+ cart_totalamount+"qqqq"+cd_id);
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
}
