package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;

public class ESearchCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String search = request.getParameter("search");
		
		ProductDao dao = new ProductDao();
		
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		dtos = dao.search(search);
		
		request.setAttribute("list", dtos);
		
	}

}
