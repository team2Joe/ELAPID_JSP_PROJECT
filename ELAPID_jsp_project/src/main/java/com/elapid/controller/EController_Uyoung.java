package com.elapid.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.command.ENonUserCartViewCommand;
import com.elapid.command.EUserCartViewCommand;
import com.elapid.command.AddCartCommand;
import com.elapid.command.ECommand;
import com.elapid.command.UserCartDetailAddCommand;

/**
 * Servlet implementation class EController
 */
@WebServlet("*.do")
public class EController_Uyoung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     
	
    public EController_Uyoung() {
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
			viewPage = "index.jsp";
			break;
		case("/loginForm.do"):
			viewPage = "loginForm.jsp";
			
		case("/luggageList.do"):
			viewPage = "luggageList.jsp";
			break;
		case("/backpackList.do"):
			viewPage = "backpackList.jsp";
			break;
		//test
		
		
			
		case("/addCart.do"):
			command = new AddCartCommand();
			command.execute(request, response);
			viewPage = "userCartView.jsp";
			break;
			
//			
//		//nonUser가 Cart(장바구니)로 이동
//		//장바구니에 아이템들이 잘들어가 있어야 하는데 이건 아직 확인 못함...
//		case("/nonUserCartView.do"):
//			command = new ENonUserCartViewCommand();
//			command.execute(request, response);
//			viewPage = "nonUserCartView.jsp";
//			break;
//		
//		//User가 u_id값을 들고다니면서 p_id가 달린 장바구니담기 값을 누르면 보여주는 장바구니 페이지.?
//		//p_id 값이 장바구니에 잘 보관되어야 하는데 이게 장바구니가 잘 가지고 있어줄지 걱정..
			
//		case("/userCartView.do"):
//			command = new EUserCartViewCommand();
//			command.execute(request, response);
//			viewPage = "userCartView.jsp";
//			break;
			
		
		
		
		
		
		
		
		
		default:
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	

}
