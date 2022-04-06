package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.UserDao;

public class EProfileModifyCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserDao dao = new UserDao();
		
		String uid = (String)session.getAttribute("uid");
		String upwd = request.getParameter("upassword");
		String uemail = request.getParameter("uemail");
		String utel = request.getParameter("utel");
		String ugender = request.getParameter("ugender");
		
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthday = request.getParameter("birthday");
		String ubirthdate = birthyear + "-" +birthmonth + "-" + birthday;
		
		dao.profileModify(uid, uemail, upwd, utel, ugender, ubirthdate);
		
	}

}
