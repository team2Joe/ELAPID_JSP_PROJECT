package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;

public class ESizeFilterListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] p_ctgmiddle = request.getParameterValues("p_ctgmiddle");
		
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.sizeFilterList(p_ctgmiddle);

		request.setAttribute("list", dtos);

	}

}
