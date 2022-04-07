package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.UserDao;

public class ERegisterDeleteCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		UserDao dao = new UserDao();
		String uid = (String) session.getAttribute("uid");
		int add_id = Integer.parseInt(request.getParameter("add_id")); 
		
		
		dao.registerDelete(uid, add_id);
		
	}

}
