package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductListDto;

public class ELuggageFilterListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
			String[] ctg_middle = request.getParameterValues("ctg_middle");
			String[] ps_color = request.getParameterValues("ps_color");
			String[] p_mainf = request.getParameterValues("p_mainf");
		
		
			ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
			
			ProductDao dao = new ProductDao();
			
			dtos = dao.luggageFilterList(ctg_middle, ps_color, p_mainf);
	
			request.setAttribute("list", dtos);

	}

}
