package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.QnaDao;
import com.elapid.dto.ProductQuestionDto;

public class EQuestionContentViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		QnaDao dao = new QnaDao();
		ArrayList<ProductQuestionDto> dtos = dao.questionList();
		request.setAttribute("questionList", dtos);

	}

}
