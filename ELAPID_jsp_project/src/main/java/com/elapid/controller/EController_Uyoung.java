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
import com.elapid.command.ESearchCommand;
import com.elapid.command.ESizeFilterListCommand;
import com.elapid.command.EUserCartViewCommand;
import com.elapid.command.AddCartCommand;
import com.elapid.command.EBackpackListCommand;
import com.elapid.command.EColorFilterListCommand;
import com.elapid.command.ECommand;
import com.elapid.command.EDetailViewCommand;
import com.elapid.command.EFunctionFilterListCommand;
import com.elapid.command.EFunctionListCommand;
import com.elapid.command.ELuggageListCommand;
import com.elapid.command.EMiddleFunctionListCommand;
import com.elapid.command.EMiddleViewCommand;
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
			
			// 캐리어 전체 리스트 페이지
		case("/luggageList.do"):
			command = new ELuggageListCommand();
			command.execute(request, response);
			viewPage = "luggageList.jsp";
			break;
			
			//백팩 전체리스트 페이지
		case("/backpackList.do"):
			command = new EBackpackListCommand();
			command.execute(request, response);
			viewPage = "backpackList.jsp";
			break;
			
			// 제품 상세 페이지
		case("/detailView.do"):
			command = new EDetailViewCommand();
			command.execute(request, response);
			viewPage = "detailView.jsp";
			break;

			
			//제품 중분류별 리스트 페이지
		case("/middleView.do"):
			command = new EMiddleViewCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
			break;
			
			// 제품 기능전체 리스트페이지
		case("/middleFunctionList.do"):
			command = new EMiddleFunctionListCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
			break;
			
			// 제품 기능별 리스트 페이지
		case("/functionList.do"):
			command = new EFunctionListCommand();
			command.execute(request, response);
			viewPage = "functionList.jsp";
			break;

			// 검색목록 출력
		case("/search.do"):
			command = new ESearchCommand();
			command.execute(request, response);
			viewPage = "searchList.jsp";
			break;
			
			// 색깔 필터
		case("/colorFilterList.do"):
			command = new EColorFilterListCommand();
			command.execute(request, response);
			viewPage = "luggageList.jsp";
			break;
			
			// 캐리어사이즈별 필터
		case("/sizeFilterList.do"):
			command = new ESizeFilterListCommand();
			command.execute(request, response);
			viewPage = "luggageList.jsp";
			break;
			
			// 제품 기능별 필터 
		case("/functionFilterList.do"):
			command = new EFunctionFilterListCommand();
			command.execute(request, response);
			viewPage = "luggageList.jsp";
			break;
		
		
			
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
