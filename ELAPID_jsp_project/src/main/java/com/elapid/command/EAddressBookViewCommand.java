package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.elapid.dao.UserDao;
import com.elapid.dto.AddressDto;

public class EAddressBookViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		UserDao dao = new UserDao();
		ArrayList<AddressDto> dtos = new ArrayList<AddressDto>();
		
		

	}

}
