package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductListDto;

public class EFunctionListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String p_mainf = request.getParameter("p_mainf");
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		ProductDao dao = new ProductDao();
		
		ProductDao countDao = new ProductDao();
		
		// 중분류 where 쿼리문
		int count = countDao.productCount("where p.p_mainf = '" + p_mainf + "'");
		
		String tempStart = request.getParameter("page");
		
		int startPage = 0;
		int onePageCount = 3;
		
		count = (int)Math.ceil((double)count/(double)onePageCount);
		
		if(tempStart != null) {
			startPage = (Integer.parseInt(tempStart)-1)*onePageCount;
		}
	
		dtos = dao.functionList(p_mainf, startPage, onePageCount);
		System.out.println(count);
		request.setAttribute("count", count);
		request.setAttribute("list", dtos);

	}

}
