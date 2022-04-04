package com.elapid.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.command.ECommand;
import com.elapid.command.EDetailViewCommand;
import com.elapid.command.EImageViewCommand;
import com.elapid.command.ELuggageListCommand;
import com.elapid.command.ESearchCommand;


@WebServlet("*.do")
public class EController_JJH extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EController_JJH() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		actionDo(request, response);
		System.out.println("doGet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		actionDo(request, response);	
		System.out.println("doPost");
	}

	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		ECommand command = null;
		
		String viewPage = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println(com);
		
		switch(com) {
		
		case("/main.do"):
			viewPage = "index.jsp";
			break;
			
		case("/luggageList.do"):
			command = new ELuggageListCommand();
			command.execute(request, response);
			viewPage = "luggageList.jsp";
			break;
			
		case("/backpackList.do"):
			viewPage = "backpackList.jsp";
			break;
			
		case("/detailView.do"):
			command = new EDetailViewCommand();
			command.execute(request, response);
			viewPage = "detailView.jsp";
			break;
			
		case("/imageView.do"):
			command = new EImageViewCommand();
			command.execute(request, response);
			viewPage = "detailView.jsp";
			break;
		
		case("/search.do"):
			command = new ESearchCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		default:
			break;
		
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
}
