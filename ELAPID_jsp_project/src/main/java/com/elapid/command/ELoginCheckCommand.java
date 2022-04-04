package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.UserDao;

public class ELoginCheckCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		UserDao dao = new UserDao();
		String uid = "";
		uid = request.getParameter("uid");
		
		String upassword = request.getParameter("upassword");
		int result = dao.loginCheck(uid, upassword);
		
		if(result == 1 ) {
			session.setAttribute("uid",uid);
			request.setAttribute("loginviewparam", "main.do");
		}else{
			
			request.setAttribute("loginviewparam", "loginForm.jsp");
		}
		
		 

	}

}
