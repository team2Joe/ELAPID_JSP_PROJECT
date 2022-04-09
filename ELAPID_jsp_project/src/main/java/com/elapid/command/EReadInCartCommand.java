package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.OrderDao;

public class EReadInCartCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("uid");
		
		OrderDao dao = new OrderDao();
		
		ArrayList<Integer> p_ids = new ArrayList<Integer>();
		p_ids =	dao.readPidInCart(uid);
		
		
		
		request.setAttribute("p_ids", p_ids);

	}

}
