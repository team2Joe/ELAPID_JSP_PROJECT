package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.CartViewDao;
import com.elapid.dao.CouponDao;
import com.elapid.dto.CouponDto;
import com.elapid.dto.UserCartViewDto;


public class EUserCartViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		CartViewDao dao = new CartViewDao();

		String u_id = (String) session.getAttribute("uid");
		//String p_id = request.getParameter("p_id");
		//String u_id = request.getParameter("u_id");
		
		ArrayList<UserCartViewDto> dtos = dao.UserCartViewList(u_id);
		
		dtos.get(3).getCart_totalamount();
		
		request.setAttribute("User_Cart", dtos);

	}

}
