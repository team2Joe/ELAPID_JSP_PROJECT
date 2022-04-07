package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.UserDao;
import com.elapid.dto.RegisterJoinDto;

public class ERegisterModifyFormCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String uid =(String) session.getAttribute("uid");
		String add_id = request.getParameter("add_id");
		UserDao dao = new UserDao();
		
		RegisterJoinDto dto = new RegisterJoinDto();
		dto =  dao.searchRegister(uid, add_id);
		
		
		request.setAttribute("registerjoindto", dto);
		
	}

}
