package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.UserDao;
import com.elapid.dto.UserDto;

public class EMyPageCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("uid");
		
		UserDao dao = new UserDao();
		UserDto dto = new UserDto();
		
		dto = dao.profileView(uid);
		
		request.setAttribute("profiledto", dto);

	}

}
