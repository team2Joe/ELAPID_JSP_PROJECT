package com.elapid.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.command.AddCartCommand;
import com.elapid.command.EAddressBookViewCommand;

import com.elapid.command.ENonUserCartViewCommand;
import com.elapid.command.ESearchCommand;
import com.elapid.command.EUserCartViewCommand;
import com.elapid.command.AddCartCommand;

import com.elapid.command.EBackpackListCommand;
import com.elapid.command.ECartDeleteProductCommand;
import com.elapid.command.ECommand;
import com.elapid.command.EDetailViewCommand;
import com.elapid.command.EFunctionListCommand;
import com.elapid.command.EGoogleLoginCommand;
import com.elapid.command.EIdCheckCommand;
import com.elapid.command.EInterestedProductListCommand;
import com.elapid.command.ELoginCheckCommand;
import com.elapid.command.ELogoutCommand;
import com.elapid.command.ELuggageFilterListCommand;
import com.elapid.command.ELuggageListCommand;
import com.elapid.command.EMiddleFunctionListCommand;
import com.elapid.command.EMiddleViewCommand;

import com.elapid.command.EMyPageCommand;
import com.elapid.command.EProfileDeleteCommand;
import com.elapid.command.EProfileModifyCommand;
import com.elapid.command.EQuestionContentCommand;
import com.elapid.command.EQuestionDeleteCommand;
import com.elapid.command.EQuestionListCommand;
import com.elapid.command.EReadInCartCommand;
import com.elapid.command.EQuestionModifyCommand;
import com.elapid.command.EQuestionWriteCommand;
import com.elapid.command.ERegisterAddCommand;
import com.elapid.command.ERegisterCheckCommand;
import com.elapid.command.ERegisterDeleteCommand;
import com.elapid.command.ERegisterSetDefault;
import com.elapid.command.ESearchCommand;
import com.elapid.command.ESelectedReadInCartCommand;

import com.elapid.command.EUserCartViewCommand;
import com.elapid.command.EUserOrderCommand;
import com.elapid.command.EUserOrderFormCommand;
import com.elapid.command.EUserOrderHistoryCommand;
import com.mysql.cj.protocol.a.MergingColumnDefinitionFactory;

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
		
//		System.out.println(uri);
//		System.out.println(com);
//		System.out.println(conPath);
		
		switch(com) {
			//?????? ?????? 
		case("/main.do"):
			viewPage = "index.jsp";
			break;
			
			// ????????? ?????? ????????? ?????????
		case("/luggageList.do"):
			command = new ELuggageListCommand();
			command.execute(request, response);
			viewPage = "luggageList.jsp";
			break;
			
			// ????????? ?????? ??????
		case("/luggageFilterList.do"):
			command = new ELuggageFilterListCommand();
			command.execute(request, response);
			viewPage = "luggageFilterList.jsp";
			break;	
			
			//?????? ??????????????? ?????????
		case("/backpackList.do"):
			command = new EBackpackListCommand();
			command.execute(request, response);
			viewPage = "backpackList.jsp";
			break;
			
			// ?????? ?????? ?????????
		case("/detailView.do"):
			command = new EDetailViewCommand();
			command.execute(request, response);
			viewPage = "detailView.jsp";
			break;

			//?????? ???????????? ????????? ?????????
		case("/middleView.do"):
			command = new EMiddleViewCommand();
			command.execute(request, response);
			viewPage = "mainList.jsp";
			break;
			
			// ?????? ???????????? ??????????????????
		case("/middleFunctionList.do"):
			command = new EMiddleFunctionListCommand();
			command.execute(request, response);
			viewPage = "middleFunctionList.jsp";
			break;
			
			// ?????? ????????? ????????? ?????????
		case("/functionList.do"):
			command = new EFunctionListCommand();
			command.execute(request, response);
			viewPage = "functionList.jsp";
			break;

			// ???????????? ??????
		case("/search.do"):
			command = new ESearchCommand();
			command.execute(request, response);
			viewPage = "searchList.jsp";
			break;
			
			// ????????? ?????? ????????? ????????? ??????
		case("/interestedProductList.do"):
			command = new EInterestedProductListCommand();
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
		case("/googleLogin.do"):
			command = new EGoogleLoginCommand();
			command.execute(request, response);
			viewPage = "main.do";
			break;
			//????????????
		case("/logout.do"):
			command = new ELogoutCommand();
			command.execute(request, response);
			viewPage = "loginForm.do";
			break;
		case("/googleLogout.do"):
			command = new ELogoutCommand();
			command.execute(request, response);
			viewPage = "loginForm.do";
			break;
			
			

			//????????? ?????? ??????		
		case("/registerForm.do"):
			viewPage = "registerForm.jsp";
			break;
			
		case("/idCheck.do"):
			command = new EIdCheckCommand();
			command.execute(request, response);
			viewPage = "registerForm.jsp";
			break;

			//???????????? ?????? ?????? ??? ????????????
		case("/registerCheck.do"):
			command = new ERegisterCheckCommand();
			command.execute(request, response);			
			viewPage ="loginForm.do";
			break;
			
			//??????????????? ??????
		case("/myPage.do"):
			command = new EMyPageCommand();
			command.execute(request, response);
			viewPage = "myPage.jsp";
			break;

			//??? ?????? ?????? 
		case("/profileView.do"):
			command = new EMyPageCommand();
			command.execute(request, response);
			viewPage = "profileView.jsp";
			break;

			//??? ?????? ??????
		case("/profileModify.do"):
			command = new EProfileModifyCommand();
			command.execute(request, response);
			viewPage = "profileView.do";
			break;

			//?????? ??????
		case("/profileDelete.do"):
			command = new EProfileDeleteCommand();
			command.execute(request, response);
			viewPage = "main.do";
			break;
			
			//????????? ??????
		case("/addressBookView.do"):
			command = new EAddressBookViewCommand();
			command.execute(request, response);
			viewPage = "addressBookView.jsp";
			break;

			//?????? ?????? ??????
		case("/registerAddForm.do"):
			viewPage = "registerAddForm.jsp";
			break;
			
			//?????? ??????
		case("/registerAdd.do"):
			command = new ERegisterAddCommand();
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;
			//?????? ?????? 
		case("/registerDelete.do"):
			command = new ERegisterDeleteCommand(); 
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;

			//?????? ????????? ?????? 
		case("/registerSetDefault.do"):
			command = new ERegisterSetDefault(); 
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;
			
			//?????? ???????????? ??????
		case("/userOrderForm.do"):
			command = new EUserOrderFormCommand();
			command.execute(request, response);
			viewPage = "userOrderPage.jsp";
			break;
			//???????????? ???????????? ????????????
		case("/readInCart.do"):
			command = new EReadInCartCommand();
			command.execute(request, response);
			viewPage = "userOrderForm.do";
			break;
			//?????????????????? ???????????? ???????????? ?????????
		case("/selectedReadInCart.do"):
			command = new ESelectedReadInCartCommand();
			command.execute(request, response);
			viewPage = "userOrderForm.do";
			break;	
			//?????? ???????????? 
		case("/userOrder.do"):
			command = new EUserOrderCommand();
			command.execute(request, response);
			viewPage = "userOrderCompletePage.jsp";
			break;
		case("/userOrderHistory.do"):
			command = new EUserOrderHistoryCommand();
			command.execute(request, response);
			viewPage = "userOrderHistory.jsp";
			break;
			
		case("/questionList.do"):
			command = new EQuestionListCommand();
			command.execute(request, response);
			viewPage = "questionList.jsp";
			break;
			
		case("/questionContentView.do"):
			command = new EQuestionContentCommand();
			command.execute(request, response);
			viewPage = "questionContent.jsp";
		break;

		case("/questionWriteForm.do"):
			viewPage = "questionWrite.jsp";
		break;
		
		case("/questionWrite.do"):
			command = new EQuestionWriteCommand();
			command.execute(request, response);
			viewPage = "questionList.do";
			
		break;
		
		
		case("/questionModify.do"):
			command = new EQuestionModifyCommand();
		command.execute(request, response);
		viewPage = "questionList.do";
		break;
		case("/questionDelete.do"):
			command = new EQuestionDeleteCommand();
		command.execute(request, response);
		viewPage = "questionList.do";
		break;
		
//		case("/test.do"):
//			break;
			//???????????? ?????? 
		case("/addCart.do"):
			command = new AddCartCommand();
			command.execute(request, response);
			viewPage = "cartLink.jsp";
//			viewPage = (String) request.getAttribute("cartReturnPage");
			break;
		
			//???????????? ??????
		case("/userCartView.do"):
			command = new EUserCartViewCommand();
			command.execute(request, response);
			viewPage = "userCartView.jsp";
			break;
			
			//???????????? ?????? ??????
		case("/cartDeleteProduct.do"):
			command = new ECartDeleteProductCommand();
			command.execute(request, response);
			viewPage = "userCartView.do";
			break;	
			
		default:
			break;
			
		}
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}catch(Exception e){
			// ????????? ?????? ????????? ???????????? ????????? ???????????? ??? ?????? ????????? ????????? ??????
			if( session.getAttribute("uid") == null ) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.do");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("errorpage.jsp");
				dispatcher.forward(request, response);				
				e.printStackTrace();
			}
		}
	}
	
}


