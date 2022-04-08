package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.QnaDao;
import com.elapid.dto.ProductQuestionDto;

public class EQuestionListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("u_id");
		
		ArrayList<ProductQuestionDto> dtos = new ArrayList<ProductQuestionDto>();
		QnaDao dao = new QnaDao();
		
		dtos = dao.questionList(u_id);
		
		request.setAttribute("QuestionList", dtos);
	}

}
