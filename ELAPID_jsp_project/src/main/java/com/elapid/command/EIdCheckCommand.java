package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.RegisterDao;
import com.elapid.dao.UserDao;

public class EIdCheckCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RegisterDao dao = new RegisterDao();
		

	}

}