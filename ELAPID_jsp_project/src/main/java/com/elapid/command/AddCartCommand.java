package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.CartDao;
import com.elapid.dto.AddCartDto;
import com.mysql.cj.Session;

public class AddCartCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		String p_id =request.getParameter("p_id");
		String u_id = request.getParameter("u_id");
		
//		int p_id = 1;
//		String u_id = "11";
		
		CartDao dao = new CartDao();
		ArrayList<AddCartDto> adddto = dao.addcart(p_id, u_id);
		
		request.setAttribute("add", adddto);
		
		
	
	}

}
