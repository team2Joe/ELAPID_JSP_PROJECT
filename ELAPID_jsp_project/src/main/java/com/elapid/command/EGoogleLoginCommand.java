package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EGoogleLoginCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String id = request.getParameter("gemail");
		String img = request.getParameter("gimg");
		String name = request.getParameter("gname");
		String email = request.getParameter("gemail");
		
		
		session.setAttribute("uid", id);
		session.setAttribute("comment", name+"님 환영합니다.");
		session.setAttribute("gresult", "1");
		
		

	}

}
