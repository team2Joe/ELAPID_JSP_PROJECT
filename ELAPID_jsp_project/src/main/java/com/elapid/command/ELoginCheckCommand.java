package com.elapid.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.UserDao;
import com.elapid.dao.UserLogDao;

public class ELoginCheckCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDao dao = new UserDao();
		UserLogDao lDao = new UserLogDao();
		String uid = "";
		uid = request.getParameter("uid");
		
		String upassword = request.getParameter("upassword");
		int result = dao.loginCheck(uid, upassword);
		
		if(result == 1 ) {
			session.setAttribute("uid",uid);
			request.setAttribute("loginviewparam", "main.do");
				
			String comment = dao.nameReturn(uid);
			session.setAttribute("comment", comment + "님 환영합니다.");

			
			lDao.userLoginLogAdd(uid);
		}else{
			request.setAttribute("loginviewparam", "loginForm.jsp");
		}
		
		
	}

}
