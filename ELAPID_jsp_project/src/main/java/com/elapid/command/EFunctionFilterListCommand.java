package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;

public class EFunctionFilterListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] p_mainf = request.getParameterValues("p_mainf");
		
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.functionFilterList(p_mainf);

		request.setAttribute("list", dtos);

	}

}
