package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.QnaDao;


public class EQuestionWriteCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		
		String qc_name =request.getParameter("qc_name");
		
		System.out.println(qc_name + "****************");
		String pq_title = request.getParameter("pq_title");
		String pq_content= request.getParameter("pq_content");
		String uid = (String) session.getAttribute("uid");
	
		
		QnaDao dao = new QnaDao();
		dao.write( qc_name, pq_title, pq_content, uid);


	}
}