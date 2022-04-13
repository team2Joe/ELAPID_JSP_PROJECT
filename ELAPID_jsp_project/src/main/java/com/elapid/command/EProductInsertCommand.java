package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDetailDto;
import com.mysql.cj.jdbc.Blob;

public class EProductInsertCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String p_name = request.getParameter("p_name");
		String p_id = request.getParameter("p_id");
		String ps_color = request.getParameter("ps_color");
		String ctg_main = request.getParameter("ctg_main");
		String ctg_middle = request.getParameter("ctg_middle");
//		Blob img_thum = request.getParameter("img_thum");
//		Blob img_01 = request.getParameter("img_01");
//		Blob img_02 = request.getParameter("img_02");
//		Blob img_03 = request.getParameter("img_03");
//		Blob img_04 = request.getParameter("img_04");
//		Blob img_05 = request.getParameter("img_05");
//		Blob img_06 = request.getParameter("img_06");
		

		
		ProductDao dao = new ProductDao();
		
		dao.productInsert();
		
	}

}
