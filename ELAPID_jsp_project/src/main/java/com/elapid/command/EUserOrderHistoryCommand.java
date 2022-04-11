package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.OrderDao;
import com.elapid.dto.OrderHistoryDto;

public class EUserOrderHistoryCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("uid");
		
		OrderDao dao = new OrderDao();
		ArrayList<OrderHistoryDto> dtos = new ArrayList<OrderHistoryDto>();
		
		dtos = dao.userOrderHistory(uid);
		
		request.setAttribute("orderHistory", dtos);
		
		System.out.println( request.getParameter("pageNum") + "***********");
		
		if (request.getParameter("pageNum") != null) {
			
			request.setAttribute("pageNumtwo",Integer.parseInt(request.getParameter("pageNum")));
		}else {
			request.setAttribute("pageNumtwo", 1);
		}
		
		System.out.println();
		
	}

}
