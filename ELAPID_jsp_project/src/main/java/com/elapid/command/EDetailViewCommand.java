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
		
		String p_id = request.getParameter("p_id");
		
		ProductDetailDto dtos = new ProductDetailDto();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.detailView(p_id);
		
		request.setAttribute("detailView", dtos);

	}

}
