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
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductImageDetailDto;
import com.elapid.dto.ProductImageDto;
import com.elapid.dto.ProductSpecDto;
import com.elapid.dto.ProductDetailDto;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductImageDetailDto;
import com.elapid.dto.ProductImageDto;
import com.elapid.dto.ProductListDto;
import com.elapid.dto.ProductSpecDto;

public class ProductDao {
	DataSource dataSource = null;

	public ProductDao() {
		// TODO Auto-generated constructor stub

		
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	// 상품 갯수 숫자 출력해주는 메서드 추가
	
	
	// 대분류 상품 전체 리스트 출력
	public ArrayList<ProductListDto> luggageList(int startPage, int onePageCount){
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			

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
					+ "where c.ctg_main = 'luggage'"
					+ "limit "+ startPage + ", " + onePageCount;
			
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
	
	// 상품 카운트 반환 메서드
	public int productCount(String category) {
		
		int count = 0;
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			// 
			String query = "select count(*) "
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
					+ category;
			
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				// 캐리어 상품 수 저장 
				count = rs.getInt(1);
				
			}
			System.out.println("카운트 수 : " + count);
			
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
		
		
		return count;
	}

	
	// 백팩리스트 전체 출력
	public ArrayList<ProductListDto> backpackList(int startPage, int onePageCount){
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
					+ "where c.ctg_main = 'backpack'"
					+ "limit " + startPage + ", " + onePageCount;
			
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
	public ProductDetailDto detailView(String sp_id) {
		ProductDetailDto dto = new ProductDetailDto();

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
					+ "where p.p_id = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, sp_id);
			
			rs = stmt.executeQuery();
			
			// 상품 조회수 기록해줄 변수 선언
			int p_clickcount = 0;
			int p_id = 0;
			
			if(rs.next()) {
				// product 정보 가져오기 
				p_id = rs.getInt("p_id");
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
				p_clickcount = rs.getInt("p_clickcount");
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
				
				p_clickcount++; //상품 조회수 1씩 증가
				
				 dto = new ProductDetailDto(p_id, p_name, p_stock,
						price, discountPrice, p_size, p_mainf, p_colorimg,
						p_colorname, p_desc, p_clickcount, ctg_id, ctg_main,
						ctg_middle, ctg_sub, img_thum, ps_color, img_01, img_02,
						img_03, img_04, img_05, img_06);

			}
			
			// 조회수 1씩 증가해주는 쿼리문
			String countQuery = "update product set p_clickcount = ? where p_id = ?";
			
			stmt = conn.prepareStatement(countQuery);
			stmt.setInt(1, p_clickcount);
			stmt.setInt(2, p_id);
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
		
		return dto;
	}

	// 상품 검색 페이지 출력
	public ArrayList<ProductListDto> search(String search, String category) {
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 검색 카테고리에서 각각의 항목을 클릭시 해당 조건 검색해주는 조건 쿼리문
		String categoryQuery = " where " + category +" like '%" + search + "%'";
		
		// 카테고리에서 전체항목 버튼 클릭시 출력할 조건 쿼리문
//		String allQuery = " where p.p_name like '%" + search + "%' or p.p_size like '%" + search + 
//				"%' or p.p_mainf like '%" + search + "%' or p.p_desc = '%" + search + "%' or c.ctg_main like '%" + search
//				+ "%' or c.ctg_middle like '%" + search + "%'";
		
		
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
					+ "on s.ps_id = pd.ps_id";
			
					// 검색 카테고리가 전체 가 아닌경우
//					if(category == "all") {
//						query += allQuery;
//												
//						// 이외에는 전체 카테고리로 검색하는 쿼리문 출력
//					}else {
			
						query += categoryQuery;
						
//					}
					
					

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
						ctg_sub, img_thum, ps_color, ps_color);
				
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
	public ArrayList<ProductListDto> middleList(String sctg_middle, int startPage, int onePageCount){

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
					+ "on s.ps_id = pd.ps_id where ctg_middle = ?"
					+ "limit " + startPage + ", " + onePageCount;
			
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
	public ArrayList<ProductListDto> functionList(String sp_mainf, int startPage, int onePageCount){
		
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
						+ "where p.p_mainf = ?"
						+ "limit " + startPage + ", " + onePageCount;
				
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
					
					ProductListDto dto = new ProductListDto(p_id, p_name, p_stock,
							price, discountPrice, p_size, p_mainf, p_colorimg,
							p_colorname, p_date, p_desc, p_clickcount, ctg_id,
							ctg_main, ctg_middle, ctg_sub, img_thum, ps_color, ps_color);
					
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
	public ArrayList<ProductListDto> middleFunctionList(int startPage, int onePageCount){
		
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
						+ "where p.p_mainf != ''"
						+ "limit " + startPage + ", " + onePageCount;
				
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
	
	// 캐리어 필터 리스트 메소드
	public ArrayList<ProductListDto> luggageFilterList(String[] sctg_middle, String[] sps_color,
 String[] sp_mainf, int startPage, int onePageCount) {
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
		
		// 페이지 나눠 줄 limit 쿼리문장
		String limitQuery = " limit " + startPage + ", " + onePageCount;
				
		
		try {
			conn = dataSource.getConnection();
		
			if(sp_mainf != null) {
				
				String[] queryValuesMainf = new String[sp_mainf.length];
			
				// 주요기능 필터 쿼리문 조건
				for(int i = 0; i < sp_mainf.length; i++) {
	
					// 필터 선택 조건이 한번일때
					if(sp_mainf.length == 1) {
						queryValuesMainf[i] = " and p_mainf = '" + sp_mainf[i] + "'";
						query += queryValuesMainf[i];
						
					}else {
						
						if(i == 0) {
							queryValuesMainf[i] = " and (p_mainf = '" + sp_mainf[i] + "'";
	
						// 하나의 카테고리 조건이 끝날 때 마지막에 괄호로 닫아주는 조건
						}else if(i == sp_mainf.length-1){
							queryValuesMainf[i] = " or p_mainf = '" + sp_mainf[i] + "')";
						}else{
							queryValuesMainf[i] = " or p_mainf = '" + sp_mainf[i] + "'";
						}
						query += queryValuesMainf[i];
						
					}
				}
			}
			
			if(sctg_middle != null) {
				String[] queryValuesMiddle = new String[sctg_middle.length];
					// 중분류 필터 쿼리문 조건
				for(int i = 0; i < sctg_middle.length; i++) {
					
					if(sctg_middle.length == 1) {
						queryValuesMiddle[i] = " and c.ctg_middle = '" + sctg_middle[i] + "'";
						query += queryValuesMiddle[i];
						
					}else {
						
						if(i == 0) {
							queryValuesMiddle[i] = " and (c.ctg_middle = '" + sctg_middle[i] + "'";
						}else if(i == sctg_middle.length-1){
							queryValuesMiddle[i] = " or c.ctg_middle = '" + sctg_middle[i] + "')";
						}else {
							queryValuesMiddle[i] = " or c.ctg_middle = '" + sctg_middle[i] + "'";
						}
						query += queryValuesMiddle[i];	
					}
					
				}
			}
			
	
			if(sps_color != null) {
				String[] queryValuesColor = new String[sps_color.length];
				
				// 색상 필터 쿼리문 조건
				for(int i = 0; i < sps_color.length; i++) {
		
					if(sps_color.length == 1) {
						queryValuesColor[i] = " and s.ps_color = '" + sps_color[i] + "'";
						query += queryValuesColor[i];
						
					}else {
						if(i == 0) {
							queryValuesColor[i] = " and (s.ps_color = '" + sps_color[i] + "'";
		
						}else if(i == sps_color.length-1){
							queryValuesColor[i] = " or s.ps_color = '" + sps_color[i] + "')";
						}else {
							queryValuesColor[i] = " or s.ps_color = '" + sps_color[i] + "'";
						}
					
						query += queryValuesColor[i];
					}
				}		
			}

			System.out.println(query+limitQuery);
			stmt = conn.prepareStatement(query+limitQuery);

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

	
	// 조회수 많은 상품 순 리스트
	public ArrayList<ProductListDto> interestedProductList() {

		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "select *, "
					+ "dense_rank() over(order by p_clickcount desc) p_rank "
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
					+ "where p_clickcount != '' order by p_clickcount desc limit 0, 3";

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
				String p_rank = rs.getString("p_rank");
			
				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price,
						discountPrice, p_size, p_mainf, p_colorimg, p_colorname,
						p_date, p_desc, p_clickcount, ctg_id, ctg_main, ctg_middle,
						ctg_sub, img_thum, ps_color, p_rank);
				
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



