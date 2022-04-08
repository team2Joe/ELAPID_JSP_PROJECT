package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.CartDao;

public class UserCartDetailAddCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		String u_id = request.getParameter("u_id");
		
		CartDao dao = new CartDao();
	
		
		
	}

}
