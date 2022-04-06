package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.elapid.dao.UserDao;
import com.elapid.dto.AddressDto;
import com.elapid.dto.RegisterDto;

public class EAddressBookViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		UserDao dao = new UserDao();
		ArrayList<RegisterDto> dtos = new ArrayList<RegisterDto>();
		String uid = (String) session.getAttribute("uid"); 
		
		dtos = dao.searchRegisterForUser(uid);
		
				
		
		
		request.setAttribute("registerdtos", dtos);
		
	}

}
