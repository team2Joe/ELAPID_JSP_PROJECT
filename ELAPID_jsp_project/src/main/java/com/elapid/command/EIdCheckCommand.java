package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.RegisterDao;
import com.elapid.dao.UserDao;

public class EIdCheckCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		RegisterDao dao = new RegisterDao();
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String utel = request.getParameter("utel");
		String comment = "";
		int result = 0;
		result = dao.idCheck(uid);
		
		if(result >= 1) {
			comment = "중복된 아이디 입니다.";
		}else {
			comment = "사용 가능한 아이디입니다.";
		}
		
		session.setAttribute("reguid",uid);
		session.setAttribute("uname",uname);
		session.setAttribute("uemail",uemail);
		session.setAttribute("utel",utel);
		
		session.setAttribute("idcheckresult",result);
		session.setAttribute("idcheckcomment", comment);		
	}

}
