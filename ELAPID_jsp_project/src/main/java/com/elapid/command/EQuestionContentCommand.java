package com.elapid.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.QnaDao;
import com.elapid.dto.ProductQuestionDto;

public class EQuestionContentCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		
		int pq_id =Integer.parseInt(request.getParameter("pq_id"));
		
		ProductQuestionDto dto = new ProductQuestionDto();
		
		QnaDao dao = new QnaDao();
		dto = dao.contentView(pq_id);
		
		request.setAttribute("dto", dto);

	}
}