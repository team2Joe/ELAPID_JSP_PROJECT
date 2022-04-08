package com.elapid.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

<<<<<<< HEAD
import com.elapid.dto.ProductDto;
=======
import com.elapid.dto.ProductDetailDto;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductImageDetailDto;
import com.elapid.dto.ProductImageDto;
>>>>>>> 81601e412d6b3175f02abe3a7c70db70c4af6750
import com.elapid.dto.ProductListDto;
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
	public ArrayList<ProductListDto> luggageList(){
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			// 
			String query = "select * "
					+ "from product_image i "
					+ "join image_detail id "
					+ "on i.img_id = id.img_id "
					+ "join product p "
					+ "on p.p_id = id.p_id "
					+ "join category_detail cd "
					+ "on p.p_id = cd.p_id "
					+ "join category c "
					+ "on c.ctg_id = cd.ctg_id "
					+ "join product_detail pd "
					+ "on pd.p_id = p.p_id "
					+ "join product_spec s "
					+ "on s.ps_id = pd.ps_id "
					+ "where c.ctg_main = 'luggage'";
			
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
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

			
				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price,
						discountPrice, p_size, p_mainf, p_colorimg, p_colorname,
						p_date, p_desc, p_clickcount, ctg_id, ctg_main, ctg_middle,
						ctg_sub, img_thum, ps_color);
				
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
	
	// 백팩리스트 전체 출력
	public ArrayList<ProductListDto> backpackList(){
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
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
					+ "where c.ctg_main = 'backpack'";
			
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
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
				
				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
						ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
				
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
	
	// 상품 상세 페이지 출력
	public ArrayList<ProductDetailDto> detailView(String sp_name) {
		ArrayList<ProductDetailDto> dtos = new ArrayList<ProductDetailDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
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
					+ "where p.p_name = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, sp_name);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
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
				String img_01 = rs.getString("img_01");
				String img_02 = rs.getString("img_02");
				String img_03 = rs.getString("img_03");
				String img_04 = rs.getString("img_04");
				String img_05 = rs.getString("img_05");
				String img_06 = rs.getString("img_06");
				
				
				ProductDetailDto dto = new ProductDetailDto(p_id, p_name, p_stock,
						price, discountPrice, p_size, p_mainf, p_colorimg,
						p_colorname, p_desc, p_clickcount, ctg_id, ctg_main,
						ctg_middle, ctg_sub, img_thum, ps_color, img_01, img_02,
						img_03, img_04, img_05, img_06);
				
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
	

	// 상품 검색 페이지 출력
	public ArrayList<ProductListDto> search(String search) {
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select *\n"
					+ "from product_image i \n"
					+ "join image_detail id\n"
					+ "on i.img_id = id.img_id\n"
					+ "join product p\n"
					+ "on p.p_id = id.p_id\n"
					+ "join category_detail cd\n"
					+ "on p.p_id = cd.p_id\n"
					+ "join category c\n"
					+ "on c.ctg_id = cd.ctg_id\n"
					+ "join product_detail pd\n"
					+ "on pd.p_id = p.p_id\n"
					+ "join product_spec s\n"
					+ "on s.ps_id = pd.ps_id where p.p_name like '%" + search + "%' or p.p_size like '%" + search + 
					"%' or p.p_mainf like '%" + search + "%' or p.p_desc = '%" + search + "%' or c.ctg_main like '%" + search
					+ "%' or c.ctg_middle like '%" + search + "%'";
			
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();

			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
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
				
				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
						ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
				
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
	
	// 상품 중분류 페이지 출력
	public ArrayList<ProductListDto> middleList(String sctg_middle){
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = dataSource.getConnection();
			String query = "select *\n"
					+ "from product_image i \n"
					+ "join image_detail id\n"
					+ "on i.img_id = id.img_id\n"
					+ "join product p\n"
					+ "on p.p_id = id.p_id\n"
					+ "join category_detail cd\n"
					+ "on p.p_id = cd.p_id\n"
					+ "join category c\n"
					+ "on c.ctg_id = cd.ctg_id\n"
					+ "join product_detail pd\n"
					+ "on pd.p_id = p.p_id\n"
					+ "join product_spec s\n"
					+ "on s.ps_id = pd.ps_id where ctg_middle = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, sctg_middle);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
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
				
				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
						ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
				
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
	
	//기능별 상품 페이지 리스트
	public ArrayList<ProductListDto> functionList(String sp_mainf){
		
		 ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		 Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
		
			try {
				conn = dataSource.getConnection();
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
						+ "where p.p_mainf = ?";
				
				stmt = conn.prepareStatement(query);
				stmt.setString(1, sp_mainf);
				
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					// product 정보 가져오기 
					int p_id = rs.getInt("p_id");
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
					
					ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
							p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
							ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
					
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
	
	// 기능 전체 페이지 리스트
	public ArrayList<ProductListDto> middleFunctionList(){
		
		 ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
			try {
				conn = dataSource.getConnection();
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
						+ "where p.p_mainf != ''";
				
				stmt = conn.prepareStatement(query);
				
				rs = stmt.executeQuery();
				

				while(rs.next()) {
					// product 정보 가져오기 
					int p_id = rs.getInt("p_id");
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
					
					ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
							p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
							ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
					
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
	
	// 색상 별 필터 분류 하기
	public ArrayList<ProductListDto> colorFilterList(String[] sps_color){
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
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
				+ "on s.ps_id = pd.ps_id "
				+ "where c.ctg_main = 'luggage'";
		
		try {
			conn = dataSource.getConnection();
			
			String[] queryValues = new String[sps_color.length];
			
			String querySum = "";
			
			for(int i = 0; i < sps_color.length; i++) {
				
				if(i == 0) {
					queryValues[i] = " and s.ps_color = '" + sps_color[i] + "'";
				}else {
					queryValues[i] = " or s.ps_color = '" + sps_color[i] + "'";
				}
			
				querySum += queryValues[i];
			}
				
			System.out.println(query+querySum);
			
				stmt = conn.prepareStatement(query+querySum);

			

			rs = stmt.executeQuery();
			
			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
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
				
				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
						ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
				
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
	
	//사이즈 별 필터 분류 하기
	public ArrayList<ProductListDto> sizeFilterList(String[] sctg_middle){
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
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
				+ "on s.ps_id = pd.ps_id where c.ctg_main = 'luggage'";
		
		try {
			conn = dataSource.getConnection();
			
			String[] queryValues = new String[sctg_middle.length];
			
			String querySum = "";
			
			for(int i = 0; i < sctg_middle.length; i++) {
				
				if(i == 0) {
					queryValues[i] = " and c.ctg_middle = '" + sctg_middle[i] + "'";
				}else {
					queryValues[i] = " or c.ctg_middle = '" + sctg_middle[i] + "'";
				}
			
				querySum += queryValues[i];
			}
				
			System.out.println(query+querySum);
			stmt = conn.prepareStatement(query+querySum);

			rs = stmt.executeQuery();
			
			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
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
				
				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
						ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
				
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
	
	//기능별 필터 분류 하기
	public ArrayList<ProductListDto> functionFilterList(String[] sp_mainf){
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
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
				+ "on s.ps_id = pd.ps_id where c.ctg_main = 'luggage'";
		
		try {
			conn = dataSource.getConnection();
			
			String[] queryValues = new String[sp_mainf.length];
			
			String querySum = "";
			
			for(int i = 0; i < sp_mainf.length; i++) {
				
				if(i == 0) {
					queryValues[i] = " and p_mainf = '" + sp_mainf[i] + "'";
				}else {
					queryValues[i] = " or p_mainf = '" + sp_mainf[i] + "'";
				}
			
				querySum += queryValues[i];
			}
				
			System.out.println(query+querySum);
			stmt = conn.prepareStatement(query+querySum);

			rs = stmt.executeQuery();
			while(rs.next()) {
				// product 정보 가져오기 
				int p_id = rs.getInt("p_id");
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
				
				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
						ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
				
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



