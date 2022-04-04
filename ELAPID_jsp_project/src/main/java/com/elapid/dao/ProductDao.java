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
import com.elapid.dto.ProductImageDetailDto;
import com.elapid.dto.ProductImageDto;
import com.elapid.dto.ProductSpecDto;

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
	
	// 대분류 상품 전체 리스트 출력
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
				String p_imgpath = rs.getString("p_imgpath");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice, p_size, p_mainf,
						p_colorimg, p_colorname, p_date, p_desc, p_clickcount, p_imgpath);
				
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
	
	public ProductDto detailView(String sp_id) {
		ProductDto dto = new ProductDto();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from product where p_id = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(sp_id));
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
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
				String p_imgpath = rs.getString("p_imgpath");
				
				dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice, p_size, p_mainf,
						p_colorimg, p_colorname, p_date, p_desc, p_clickcount, p_imgpath);
				
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
		
		return dto;
	}
	
	public ArrayList<ProductImageDto> imageView(String sp_id) {
		
		ArrayList<ProductImageDto> dtos = new ArrayList<ProductImageDto>();
		ProductImageDto dto = new ProductImageDto();	
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select p.img_path from product_image p, product_detail_image d"
					+ " where d.p_id = ? and p.img_id = d.img_id";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(sp_id));
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int img_id = rs.getInt("img_id");
				String img_name = rs.getString("img_name");
				String img_path = rs.getString("img_path");

				dto = new ProductImageDto(img_id, img_name, img_path);
				
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



