package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDetailDto;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductListDto;

public class EDetailViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String p_name = request.getParameter("p_name");
		
		ArrayList<ProductDetailDto> dtos = new ArrayList<ProductDetailDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.detailView(p_name);
		
		request.setAttribute("detailView", dtos);

	}

}
