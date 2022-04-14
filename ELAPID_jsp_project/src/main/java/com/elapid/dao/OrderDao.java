package com.elapid.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.elapid.dto.OrderHistoryDto;
import com.elapid.dto.ProductListDto;

public class OrderDao {
	DataSource dataSource = null;

	public OrderDao() {
		// TODO Auto-generated constructor stub
	

		
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProductListDto> productsInfo(ArrayList<Integer> p_ids) {
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			for (int i = 0 ; i < p_ids.size() ; i++) {
				
			
				String query = "select *\n"
						+ "from product_image i \n"
						+ "\n"
						+ "join image_detail id\n"
						+ "on i.img_id = id.img_id\n"
						+ "\n"
						+ "join product p\n"
						+ "on p.p_id = id.p_id\n"
						+ "\n"
						+ "join category_detail cd\n"
						+ "on p.p_id = cd.p_id\n"
						+ "\n"
						+ "join category c\n"
						+ "on c.ctg_id = cd.ctg_id\n"
						+ "\n"
						+ "join product_detail pd\n"
						+ "on pd.p_id = p.p_id\n"
						+ "\n"
						+ "join product_spec s\n"
						+ "on s.ps_id = pd.ps_id\n"
						+ "\n"
						+ "where p.p_id = ? ";
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, p_ids.get(i));
				rs = stmt.executeQuery();

				while(rs.next()) {
					// product 정보 가져오기 
					int sp_id = rs.getInt("p_id");
					String p_name = rs.getString("p_name");
					int p_stock = rs.getInt("p_stock");
					int price = rs.getInt("p_price");
					int discountPrice = rs.getInt("p_discountPrice");
					int p_size = rs.getInt("p_size");
					String p_mainf = rs.getString("p_mainf");
					String p_colorimg = rs.getString("p_colorimg");
					String p_colorname = rs.getString("p_colorname");
					Timestamp p_date = rs.getTimestamp("p_date");
					String p_desc = rs.getString("p_desc");
					String p_clickcount = rs.getString("p_clickcount");
					String ctg_id = rs.getString("ctg_id");
					String ctg_main = rs.getString("ctg_main");
					String ctg_middle = rs.getString("ctg_middle");
					String ctg_sub = rs.getString("ctg_sub");
					String img_thum = rs.getString("img_thum");
					String ps_color = rs.getString("ps_color");
					
					ProductListDto dto = new ProductListDto(sp_id, p_name, p_stock, price, discountPrice,
							p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
							ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
					
					dtos.add(dto);
					
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

		
		return dtos;
		
		
	}
	
	public ArrayList<Integer> readPidInCart(String uid){
		ArrayList<Integer> p_ids = new  ArrayList<Integer>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
				
			
			String query = "SELECT p_id FROM cart_detail cd "
					+ "join cart c on cd.cart_id = c.cart_id "
					+ "and c.u_id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, uid);
			rs = stmt.executeQuery();

			while(rs.next()) {
				// product 정보 가져오기 
				int sp_id = rs.getInt("p_id");
				p_ids.add(sp_id);
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
	
	public void uesrOrderWrite(String u_id, String uo_name, String uo_tel, int uo_discountedamount,int uo_amount,String uo_address,String uo_specificaddress, int uo_shippingfee,String  uo_paymentmethod){
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			
			String query = "insert into user_order (u_id,uo_name,uo_tel, uo_discountedamount, uo_amount, uo_address, uo_specificaddress,  uo_shippingfee,  uo_paymentmethod , uo_date) values (?,?,?,?,?,?,?,?,?,now())";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u_id);
			stmt.setString(2, uo_name);
			stmt.setString(3, uo_tel);
			stmt.setInt(4, uo_discountedamount);
			stmt.setInt(5, uo_amount);
			stmt.setString(6, uo_address);
			stmt.setString(7, uo_specificaddress);
			stmt.setInt(8, uo_shippingfee);
			stmt.setString(9, uo_paymentmethod);
			
			stmt.executeUpdate();
			
			
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
	}
	
	
	public int searchLatestOrderForUser(String u_id) {
		int uo_id = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			
			
			String query = "select uo_id from user_order where u_id = ? order by uo_date desc limit 1";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u_id);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				uo_id = rs.getInt("uo_id");
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
		
		return uo_id;		
	}
	
	
	public void userOrderDetailWrite(ArrayList<Integer> p_ids, int uo_id){
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			
			for(int i = 0 ; i <p_ids.size()  ; i++) {
				
			String query = "insert into user_order_detail (uo_id, p_id ) values (?,?)";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, uo_id);
			stmt.setInt(2, p_ids.get(i));
			
			stmt.executeUpdate();
			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteOrderedCart(ArrayList<Integer> cd_ids){
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			
			for(int i = 0 ; i <cd_ids.size()  ; i++) {
				
				System.out.println(cd_ids.get(i) + "************");
				String query = "delete from cart_detail where cd_id = ?";
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, cd_ids.get(i));
				
				stmt.executeUpdate();
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void deleteAllInCart(int cart_id){
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			
				
				String query = "delete from cart_detail where cart_id = ?";
				stmt = conn.prepareStatement(query);
				stmt = setInt(1,cart_id);
				stmt.executeUpdate();
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private PreparedStatement setInt(int i, int cart_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderHistoryDto> userOrderHistory(String uid) {
		
		ArrayList<OrderHistoryDto> dtos = new ArrayList<OrderHistoryDto>();
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			
			
			String query = "select uo.u_id, uo.uo_id, uod.uod_id, p.p_id, pi.img_id, ctg.ctg_id, "
					+ "uo.uo_name,uo.uo_tel,uo.uo_discountedamount,uo.uo_date,uo.uo_specificaddress,uo.uo_address,uo.uo_shippingfee,uo.uo_paymentmethod, "
					+ "p.p_price, p.p_size, p.p_name , p.p_colorname, "
					+ "pi.img_thum, "
					+ "ctg.ctg_sub "
					+ "from user_order as uo "
					+ "join user_order_detail as uod on uo.uo_id = uod.uo_id "
					+ "join product as p on p.p_id = uod.p_id "
					+ "join image_detail as id on id.p_id = p.p_id "
					+ "join product_image as pi on pi.img_id = id.img_id "
					+ "join category_detail as cd on cd.p_id = p.p_id "
					+ "join category as ctg on ctg.ctg_id = cd.ctg_id\n"
					+ "where u_id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, uid);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				OrderHistoryDto dto = new OrderHistoryDto();
				
				dto.setU_id(rs.getString("u_id")); 
				dto.setUo_id(rs.getInt("uo_id")); 
				dto.setUod_id(rs.getInt("uod_id")); 
				dto.setP_id(rs.getInt("uod_id"));
				dto.setImg_id(rs.getInt("img_id"));
				dto.setCtg_id(rs.getInt("ctg_id"));
	
				dto.setUo_name(rs.getString("uo_name"));
				dto.setUo_tel(rs.getString("uo_tel"));
				dto.setUo_discountedamount(rs.getInt("uo_discountedamount"));
				dto.setUo_date(rs.getTimestamp("uo_date"));
				dto.setUo_address(rs.getString("uo_address"));
				dto.setUo_specificaddress(rs.getString("uo_specificaddress"));
				dto.setUo_shippingfee(rs.getInt("uo_shippingfee"));
				dto.setUo_paymentmethod(rs.getString("uo_paymentmethod"));

				dto.setP_price(rs.getInt("p_price"));
				dto.setP_name(rs.getString("p_name"));
				dto.setP_size(rs.getInt("p_size"));
				dto.setP_colorname(rs.getString("p_colorname"));
				
				
				
				dto.setImg_thum(rs.getString("img_thum"));
				
				dto.setCtg_sub(rs.getString("ctg_sub"));
				
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
