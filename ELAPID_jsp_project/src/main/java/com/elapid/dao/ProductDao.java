package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.elapid.dto.ProductDto;

public class ProductDao {

	DataSource dataSource = null;
	
	public ProductDao() {
		
		try {
			
			Context context = new InitialContext();
			
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/elapid");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ProductDto> list(){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from product";
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
				String p_name = rs.getString("p_name");
				String p_stock = rs.getString("p_stock");
				int p_price = rs.getInt("p_price");
				int p_discountprice = rs.getInt("p_discountprice");
				int p_size = rs.getInt("p_size");
				String p_mainf = rs.getString("p_mainf");
				String p_colorimg = rs.getString("p_colorimg");
				String p_colorname = rs.getString("p_colorname");
				Timestamp p_date = rs.getTimestamp("p_date");
				String p_desc = rs.getString("p_desc");
				String p_clickcount = rs.getString("p_clickcount");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice, p_size, p_mainf,
						p_colorimg, p_colorname, p_date, p_desc, p_clickcount);
				
				dtos.add(dto);
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

		
		return dtos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



