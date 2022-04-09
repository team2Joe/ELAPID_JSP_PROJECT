package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductListDto;

public class ELuggageProductCountCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductDao dao = new ProductDao();
		
		String p_mainf = null;
		int luggageCount = dao.luggageCount(p_mainf);
		
	}

}
