package com.elapid.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CouponDao {

	public CouponDao() {
	
		DataSource dataSource = null;

		
		try {
			
			
			Context context = new InitialContext();
			
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/elapdid");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
