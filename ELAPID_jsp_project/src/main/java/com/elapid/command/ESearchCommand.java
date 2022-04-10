package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductListDto;

public class ESearchCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String search = request.getParameter("search");
		String category = request.getParameter("category");
		
		ProductDao dao = new ProductDao();
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();

		dtos = dao.search(search, category);
		
		request.setAttribute("list", dtos);
	}

}
