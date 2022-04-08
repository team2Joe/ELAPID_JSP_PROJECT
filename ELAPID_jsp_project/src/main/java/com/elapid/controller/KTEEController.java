package com.elapid.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.command.EAddressBookViewCommand;
import com.elapid.command.ECommand;
import com.elapid.command.EIdCheckCommand;
import com.elapid.command.ELoginCheckCommand;
import com.elapid.command.ELogoutCommand;
import com.elapid.command.EMainCommand;
import com.elapid.command.EMyPageCommand;
import com.elapid.command.EProfileDeleteCommand;
import com.elapid.command.EProfileModifyCommand;
import com.elapid.command.ERegisterAddCommand;
import com.elapid.command.ERegisterCheckCommand;
import com.elapid.command.ERegisterDeleteCommand;
import com.elapid.command.ERegisterSetDefault;
import com.elapid.command.EUserOrderFormCommand;
import com.mysql.cj.protocol.a.MergingColumnDefinitionFactory;

/**
 * Servlet implementation class EController
 */
@WebServlet("*.do")
public class KTEEController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     
	
    public KTEEController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actiondo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actiondo(request,response);
	}
	
	protected void actiondo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			command = new EMainCommand();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		case("/loginForm.do"):
			viewPage = "loginForm.jsp";
			break;
		case("/loginCheck.do"):
			command = new ELoginCheckCommand();
			command.execute(request, response);
			viewPage = (String)request.getAttribute("loginviewparam");
			break;
		case("/logout.do"):
			command = new ELogoutCommand();
			command.execute(request, response);
			viewPage = "loginForm.do";
			break;
		
		case("/registerForm.do"):
			viewPage = "registerForm.jsp";
			break;
		case("/idCheck.do"):
			command = new EIdCheckCommand();
			command.execute(request, response);
			viewPage = "registerForm.jsp";
			break;
		case("/registerCheck.do"):
			command = new ERegisterCheckCommand();
			command.execute(request, response);			
			viewPage ="loginForm.do";
			break;
			
		case("/myPage.do"):
			command = new EMyPageCommand();
			command.execute(request, response);
			viewPage = "myPage.jsp";
			break;
		case("/profileView.do"):
			command = new EMyPageCommand();
			command.execute(request, response);
			viewPage = "profileView.jsp";
			break;
		case("/profileModify.do"):
			command = new EProfileModifyCommand();
			command.execute(request, response);
			viewPage = "profileView.do";
			break;
		case("/profileDelete.do"):
			command = new EProfileDeleteCommand();
			command.execute(request, response);
			viewPage = "main.do";
			break;
		
		case("/addressBookView.do"):
			command = new EAddressBookViewCommand();
			command.execute(request, response);
			viewPage = "addressBookView.jsp";
			break;
		case("/registerAddForm.do"):
			viewPage = "registerAddForm.jsp";
			break;
		case("/registerAdd.do"):
			command = new ERegisterAddCommand();
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;

		case("/registerDelete.do"):
			command = new ERegisterDeleteCommand(); 
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;
		case("/registerSetDefault.do"):
			command = new ERegisterSetDefault(); 
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;
			
		case("/userOrderForm.do"):
			command = new EUserOrderFormCommand();
			command.execute(request, response);
			viewPage = "userOrderPage.jsp";
			break;
			
		case("/luggageList.do"):
			viewPage = "luggageList.jsp";
			break;
		case("/backpackList.do"):
			viewPage = "backpackList.jsp";
			break;
		
		default:
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	

}