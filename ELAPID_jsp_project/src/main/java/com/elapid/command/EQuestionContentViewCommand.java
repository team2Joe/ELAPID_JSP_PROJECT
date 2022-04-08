package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.QnaDao;
import com.elapid.dto.ProductQuestionDto;

public class EQuestionContentViewCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
//		HttpSession session = request.getSession();
//		String u_id = (String) session.getAttribute("u_id");
		
		int pq_id =Integer.parseInt(request.getParameter("pq_id"));
		String qc_name =request.getParameter("qc_name");
		String pq_title = request.getParameter("pq_title");
		String pq_content= request.getParameter("pq_content");
		String u_id = "aaa";
		
		QnaDao dao = new QnaDao();
		ProductQuestionDto dto = dao.contentView(pq_id, qc_name, pq_title, pq_content, u_id);


	}

}