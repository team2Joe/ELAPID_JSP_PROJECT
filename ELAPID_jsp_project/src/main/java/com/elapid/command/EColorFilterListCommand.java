package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductListDto;

public class EColorFilterListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] ps_color = request.getParameterValues("ps_color");
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.colorFilterList(ps_color);

		request.setAttribute("list", dtos);

	}

}
