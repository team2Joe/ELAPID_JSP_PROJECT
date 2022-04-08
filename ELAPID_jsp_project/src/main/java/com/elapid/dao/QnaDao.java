package com.elapid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
			preparedStatement.setString(1, "aaa");
			resultSet =preparedStatement.executeQuery();
//	String qc_name, String u_id, String pq_id, String pq_title, String pq_content		
			while(resultSet.next()) {
				String qc_name = resultSet.getString("qc_name");
				String u_id = resultSet.getString("u_id");
				int pq_id = resultSet.getInt("pq_id");
				String pq_title = resultSet.getString("pq_title");
				String pq_content = resultSet.getString("pq_content");
			
				
				ProductQuestionDto dto = new ProductQuestionDto(qc_name, u_id, pq_id, pq_title, pq_content);
				dtos.add(dto);
				
						//check
						System.out.println(qc_name + u_id + pq_id + pq_title + pq_content);
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
		
		
		public void contentView(int pq_id, String qc_name, String pq_title, String pq_content, String u_id ) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				String query ="insert into product_question(pq_id, qc_name, pq_title, pq_content, u_id) values (?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, pq_id);
				preparedStatement.setString(2, qc_name);
				preparedStatement.setString(3, pq_title);
				preparedStatement.setString(4, pq_content);
				preparedStatement.setString(5, u_id);
				
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
		
			

	
	}
	
}
