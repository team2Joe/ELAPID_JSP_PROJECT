package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.CartDao;
import com.elapid.dto.NonUserCartViewDto;

public class ENonUserCartViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int p_id = 1;
		int cart_id = 1;
		//request.getParameter(Integer.parseInt("p_id"));
		CartDao dao = new CartDao();
		NonUserCartViewDto dto = dao.nonUserCartViewList(p_id, cart_id);
		request.setAttribute("cart_view", dto);
		
		
		

		
		
		
//		CartDao dao = new CartDao();
//		ArrayList<CartViewDto> dtos = dao.cartViewList();
//		request.setAttribute("cart", dtos);
		// 리스트로 담은 DB 내용을 
		// request 객체에 list란 이름으로 담는다.

		
	}

}
