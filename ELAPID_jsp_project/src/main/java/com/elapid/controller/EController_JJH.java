package com.elapid.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.command.EBackpackListCommand;
import com.elapid.command.ECommand;
import com.elapid.command.EDetailViewCommand;
import com.elapid.command.EFunctionListCommand;
import com.elapid.command.EImageViewCommand;
import com.elapid.command.ELuggageListCommand;
import com.elapid.command.EMiddleFunctionListCommand;
import com.elapid.command.EMiddleViewCommand;
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
			// 캐리어 전체 리스트 페이지
		case("/luggageList.do"):
			command = new ELuggageListCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
			break;
			//백팩 전체리스트 페이지
		case("/backpackList.do"):
			command = new EBackpackListCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
			break;
			
			// 제품 상세 페이지
		case("/detailView.do"):
			command = new EDetailViewCommand();
			command.execute(request, response);
			viewPage = "detailView.jsp";
			break;
			
			//제품 중분류별 페이지
		case("/middleView.do"):
			command = new EMiddleViewCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
			break;
		case("/middleFunctionList.do"):
			command = new EMiddleFunctionListCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
			break;
			
		case("/functionList.do"):
			command = new EFunctionListCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
			break;
			
		case("/imageView.do"):
			command = new EImageViewCommand();
			command.execute(request, response);
			viewPage = "detailView.jsp";
			break;
		
		case("/search.do"):
			command = new ESearchCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
		default:
			break;
		
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
}
