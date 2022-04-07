package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.OrderDao;
import com.elapid.dao.UserDao;
import com.elapid.dto.ProductListDto;
import com.elapid.dto.RegisterJoinDto;
import com.elapid.dto.UserDto;

public class EUserOrderFormCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		UserDao dao = new UserDao();
		String uid = (String) session.getAttribute("uid");
		UserDto userDto = dao.profileView(uid);
	
		
		ArrayList<RegisterJoinDto> shipDtos = new ArrayList<RegisterJoinDto>();
		
		
		userDto = dao.profileView(uid);
		shipDtos = dao.searchRegisterForUser(uid);
		
		ArrayList<Integer> p_ids = new ArrayList<Integer>();
		
		p_ids.add(1);
		p_ids.add(2);
		
		
		OrderDao orderDao = new OrderDao();
		ArrayList<ProductListDto> pListDtos = orderDao.productsInfo(p_ids);
		
		request.setAttribute("pListDtos", pListDtos);
		request.setAttribute("shipDtos", shipDtos);
		request.setAttribute("userDto", userDto);
		
		
		
		

	}

}
