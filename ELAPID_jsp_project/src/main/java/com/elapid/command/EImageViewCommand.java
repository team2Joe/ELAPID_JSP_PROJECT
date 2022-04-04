package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductImageDto;

public class EImageViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String p_id = "1";
		
		ArrayList<ProductImageDto> dtos = new ArrayList<ProductImageDto>();
		
		ProductDao dao = new ProductDao();
		
		dtos = dao.imageView(p_id);
		
		request.setAttribute("image", dtos);
	}

}
