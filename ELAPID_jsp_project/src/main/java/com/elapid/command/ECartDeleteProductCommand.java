package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.CartProductDeleteDao;

public class ECartDeleteProductCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		
		String u_id = (String) session.getAttribute("uid");
		int cd_id = Integer.parseInt(request.getParameter("cd_id"));
		
		CartProductDeleteDao dao = new CartProductDeleteDao();
		dao.userDeleteCart(cd_id);
		
		
//		System.out.println("cd_id<" + cd_id + ">cd_id");
	}

}
