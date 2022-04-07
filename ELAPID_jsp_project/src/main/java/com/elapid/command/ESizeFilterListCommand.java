package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductListDto;

public class ESizeFilterListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] ctg_middle = request.getParameterValues("ctg_middle");
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.sizeFilterList(ctg_middle);

		request.setAttribute("list", dtos);

	}

}
