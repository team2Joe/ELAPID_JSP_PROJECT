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

	
	// 대분류 상품 전체 리스트 출력
	public ArrayList<ProductDto> luggageList(){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from product where p_ctgmain = 'luggage'";
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
				String p_ctgmain = rs.getString("p_ctgmain");
				String p_ctgmiddle = rs.getString("p_ctgmiddle");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice, p_size, p_mainf, p_colorimg, p_colorname, 
											p_date, p_desc, p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
				
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
	public ArrayList<ProductDto> backpackList(){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from product where p_ctgmain = 'backpack'";
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
				String p_ctgmain = rs.getString("p_ctgmain");
				String p_ctgmiddle = rs.getString("p_ctgmiddle");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice, p_size, p_mainf, p_colorimg, p_colorname, 
											p_date, p_desc, p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
				
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
				String p_ctgmain = rs.getString("p_ctgmain");
				String p_ctgmiddle = rs.getString("p_ctgmiddle");
				
				dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, 
						p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
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
	
	//상세 페이지 이미지 리스트 불러오기 
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
				
				// 이미지 파일 불러오기
				Blob img_file = rs.getBlob("img_file");
				byte[] data = img_file.getBytes(img_id, (int)img_file.length());
				
				File file = new File("Users/tj/Desktop/jjh/elapid_img/luggage/clite_main.jpeg");
				FileOutputStream fos = new FileOutputStream(file);
				
				fos.write(data);
				fos.close();
				
				dto = new ProductImageDto(img_id, img_name, img_file);
				
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
	
	public ArrayList<ProductDto> search(String search) {
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from product where p_name like '%" + search + "%' or p_size like '%" + search + 
					"%' or p_mainf like '%" + search + "%' or p_desc = '%" + search + "%' or p_ctgmain like '%" + search
					+ "%' or p_ctgmiddle like '%" + search + "%'";
			
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
				String p_ctgmain = rs.getString("p_ctgmain");
				String p_ctgmiddle = rs.getString("p_ctgmiddle");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, 
						p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
				
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
	
	
	public ArrayList<ProductDto> middleList(String sp_ctgmiddle){
		
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = dataSource.getConnection();
			String query = "select * from product where p_ctgmiddle = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, sp_ctgmiddle);
			
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
				String p_ctgmain = rs.getString("p_ctgmain");
				String p_ctgmiddle = rs.getString("p_ctgmiddle");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, 
						p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
				
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
	public ArrayList<ProductDto> functionList(String sp_mainf){
		
		 ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		 Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
		
			try {
				conn = dataSource.getConnection();
				String query = "select * from product where p_mainf = ?";
				
				stmt = conn.prepareStatement(query);
				stmt.setString(1, sp_mainf);
				
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
					String p_ctgmain = rs.getString("p_ctgmain");
					String p_ctgmiddle = rs.getString("p_ctgmiddle");
					
					ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice,
							p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, 
							p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
					
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
	public ArrayList<ProductDto> middleFunctionList(){
		
		 ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		 Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
		
			try {
				conn = dataSource.getConnection();
				String query = "select * from product where p_mainf != ''";
				
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
					String p_ctgmain = rs.getString("p_ctgmain");
					String p_ctgmiddle = rs.getString("p_ctgmiddle");
					
					ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice,
							p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, 
							p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
					
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
	public ArrayList<ProductDto> colorFilterList(String[] sp_colorname){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		String query = "select * from product where p_ctgmain = 'luggage' ";
		
		try {
			conn = dataSource.getConnection();
			
			String[] queryValues = new String[sp_colorname.length];
			
			String querySum = "";
			
			for(int i = 0; i < sp_colorname.length; i++) {
				
				if(i == 0) {
					queryValues[i] = " and p_colorname = '" + sp_colorname[i] + "'";
				}else {
					queryValues[i] = " or p_colorname = '" + sp_colorname[i] + "'";
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
				String p_ctgmain = rs.getString("p_ctgmain");
				String p_ctgmiddle = rs.getString("p_ctgmiddle");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, 
						p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
				
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
	public ArrayList<ProductDto> sizeFilterList(String[] sp_ctgmiddle){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		String query = "select * from product where p_ctgmain = 'luggage'";
		
		try {
			conn = dataSource.getConnection();
			
			String[] queryValues = new String[sp_ctgmiddle.length];
			
			String querySum = "";
			
			for(int i = 0; i < sp_ctgmiddle.length; i++) {
				
				if(i == 0) {
					queryValues[i] = " and p_ctgmiddle = '" + sp_ctgmiddle[i] + "'";
				}else {
					queryValues[i] = " or p_ctgmiddle = '" + sp_ctgmiddle[i] + "'";
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
				String p_ctgmain = rs.getString("p_ctgmain");
				String p_ctgmiddle = rs.getString("p_ctgmiddle");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, 
						p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
				
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
	public ArrayList<ProductDto> functionFilterList(String[] sp_mainf){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		String query = "select * from product where p_ctgmain = 'luggage'";
		
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
				String p_ctgmain = rs.getString("p_ctgmain");
				String p_ctgmiddle = rs.getString("p_ctgmiddle");
				
				ProductDto dto = new ProductDto(p_id, p_name, p_stock, p_price, p_discountprice,
						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, 
						p_clickcount, p_imgpath, p_ctgmain, p_ctgmiddle);
				
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



