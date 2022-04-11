package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.elapid.dto.ProductListDto;
import com.elapid.dto.ProductQuestionDto;


public class QnaDao {

	DataSource dataSource = null;
	public QnaDao() {
		// TODO Auto-generated constructor stub

		
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public ArrayList<ProductQuestionDto> questionList(String u_sid){
		ArrayList<ProductQuestionDto> dtos = new ArrayList<ProductQuestionDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query ="select * from product_question where u_id = ?";
		
			//preparedStatement.setString(1, u_sid);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, u_sid);
			resultSet =preparedStatement.executeQuery();
//	String qc_name, String u_id, String pq_id, String pq_title, String pq_content		
			while(resultSet.next()) {
				String qc_name = resultSet.getString("qc_name");
				String uid = resultSet.getString("u_id");
				int pq_id = resultSet.getInt("pq_id");
				String pq_title = resultSet.getString("pq_title");
				String pq_content = resultSet.getString("pq_content");
			
				
				ProductQuestionDto dto = new ProductQuestionDto(qc_name, uid, pq_id, pq_title, pq_content);
				dtos.add(dto);
				
						//check
						System.out.println(qc_name + uid + pq_id + pq_title + pq_content);
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	
		
		
		public ProductQuestionDto contentView(int spq_id ) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ProductQuestionDto dto = null;
			
			try {
				connection = dataSource.getConnection();
				String query ="select * from product_question where pq_id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, spq_id);
				resultSet =preparedStatement.executeQuery(); //��ȸ
				

				if(resultSet.next()) {
				
					String qc_name = resultSet.getString("qc_name");
					String uid = resultSet.getString("u_id");
					int pq_id = resultSet.getInt("pq_id");
					String pq_title = resultSet.getString("pq_title");
					String pq_content = resultSet.getString("pq_content");
					
					dto = new ProductQuestionDto(qc_name, uid, pq_id, pq_title, pq_content);
					
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dto;
		
		}

			public void write( String qc_name, String pq_title, String pq_content, String uid) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection();
					String query ="insert into product_question ( qc_name, pq_title, pq_content, u_id) values (?,?,?,?)";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, qc_name);
					preparedStatement.setString(2, pq_title);
					preparedStatement.setString(3, pq_content);
					preparedStatement.setString(4, uid);
					
					preparedStatement.executeUpdate();   //����
					
				}catch (Exception e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
						
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			
				
			}//write
			
			public void delete(int pq_id) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection();
					String query ="delete from product_question where pq_id = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, pq_id);
					
					preparedStatement.executeUpdate();
					
				}catch (Exception e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
						
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			
				
			}//delete
			
			public void modify(int pq_id, String qc_name, String pq_title, String pq_content, String uid) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection();
					String query ="update product_question set qc_name=?, pq_title=?, pq_content=? where pq_id = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, qc_name);
					preparedStatement.setString(2, pq_title);
					preparedStatement.setString(3, pq_content);	
					preparedStatement.setInt(4, pq_id);	
					preparedStatement.executeUpdate();
					
				}catch (Exception e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
						
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			
				
			}//modify
			
			
			

	
	
	
}
