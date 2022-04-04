package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;

public class EDetailViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String p_id = request.getParameter("p_id");
		
		ProductDto dto = new ProductDto();
		ProductDao dao = new ProductDao();
		
		dto = dao.detailView(p_id);
		
		request.setAttribute("detailView", dto);

	}

}
