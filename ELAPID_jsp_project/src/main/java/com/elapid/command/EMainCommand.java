package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.UserDao;

public class EMainCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uid = ""; 
		String uname = "";
		UserDao dao = new UserDao();
		String comment = "";
		uid = (String) session.getAttribute("uid");
		
		uname = dao.nameReturn(uid);
		
		comment = (uname == "") ? "": (uname+"님 환영합니다."); 
		
		request.setAttribute("uid", uid);
		session.setAttribute("comment", comment);
		
	}

}
