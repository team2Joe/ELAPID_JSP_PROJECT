package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;

public class ELuggageListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.mainList();
		
		request.setAttribute("list", dtos);
	}

}
