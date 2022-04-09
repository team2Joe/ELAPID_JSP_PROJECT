package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.AddCartDao;

public class AddCartCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//addCartCommand
		HttpSession session = request.getSession();
		
		String u_id = (String) session.getAttribute("uid");
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		
		AddCartDao dao = new AddCartDao();
		dao.userAddcart(p_id,u_id);
		
		//dao.userAddcart(1,"uyoung1");
		
		
		
		
		
	
	}

}
