package com.elapid.dao;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.elapid.dto.AddCartDto;

public class CartDao2 {

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
}

	
	
	
	
	
	
	
	
	
	
	
	
	
}