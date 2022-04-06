package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.RegisterDao;
import com.elapid.dao.UserDao;

public class ERegisterCheckCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		
		String uid = request.getParameter("uid");
		String upwd = request.getParameter("upassword");
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String utel = request.getParameter("utel");
		String ugender = request.getParameter("ugender");
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthday = request.getParameter("birthday");
		String ubirthdate = birthyear + "-" +birthmonth + "-" + birthday;
		
		
		dao.userAdd(uid, upwd, uname, uemail, utel, ugender, ubirthdate);
		
		String addaddress = request.getParameter("jibunAddr");
		String addspecificaddress = request.getParameter("addrDetail");
		String addpostnumber = request.getParameter("zipNo");
		
		
		
	}

}

