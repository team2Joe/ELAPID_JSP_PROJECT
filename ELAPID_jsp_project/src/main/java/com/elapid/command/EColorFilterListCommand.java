package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;

public class EColorFilterListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] p_colorname = request.getParameterValues("p_colorname");
		
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.colorFilterList(p_colorname);

		request.setAttribute("list", dtos);

	}

}
