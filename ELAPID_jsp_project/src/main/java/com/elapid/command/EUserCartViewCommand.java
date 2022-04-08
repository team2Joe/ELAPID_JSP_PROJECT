package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.CartDao;
import com.elapid.dto.UserCartViewDto;


public class EUserCartViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		int p_id = 0;
		String u_id = "0";
		
		CartDao dao = new CartDao();
		UserCartViewDto dto = dao.UserCartViewList(p_id, u_id);
		
		request.setAttribute("User_Cart", dto);
		
	}

}
