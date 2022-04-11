package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.QnaDao;


public class EQuestionDeleteCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub


		int pq_id =Integer.parseInt(request.getParameter("pq_id"));
		
		QnaDao dao = new QnaDao();
		dao.delete(pq_id);

	

		
		
	}

}
