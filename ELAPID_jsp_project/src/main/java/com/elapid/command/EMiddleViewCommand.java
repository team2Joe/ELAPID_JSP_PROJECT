package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;

public class EMiddleViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String p_ctgmiddle = request.getParameter("p_ctgmiddle");
		
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.middleList(p_ctgmiddle);

		request.setAttribute("list", dtos);
	}

}
