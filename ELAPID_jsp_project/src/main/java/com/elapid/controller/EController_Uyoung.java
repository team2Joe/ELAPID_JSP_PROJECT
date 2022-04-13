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
			//메인 화면 
		case("/main.do"):
			viewPage = "index.jsp";
			break;
			
			// 캐리어 전체 리스트 페이지
		case("/luggageList.do"):
			command = new ELuggageListCommand();
			command.execute(request, response);
			viewPage = "luggageList.jsp";
			break;
			
			// 캐리어 전용 필터
		case("/luggageFilterList.do"):
			command = new ELuggageFilterListCommand();
			command.execute(request, response);
			viewPage = "luggageFilterList.jsp";
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
			viewPage = "middleFunctionList.jsp";
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
			
			// 조회수 많은 상품순 리스트 출력
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
			//로그아웃
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
			
			

			//아이디 중복 체크		
		case("/registerForm.do"):
			viewPage = "registerForm.jsp";
			break;
			
		case("/idCheck.do"):
			command = new EIdCheckCommand();
			command.execute(request, response);
			viewPage = "registerForm.jsp";
			break;

			//회원가입 양식 체크 후 회원가입
		case("/registerCheck.do"):
			command = new ERegisterCheckCommand();
			command.execute(request, response);			
			viewPage ="loginForm.do";
			break;
			
			//마이페이지 화면
		case("/myPage.do"):
			command = new EMyPageCommand();
			command.execute(request, response);
			viewPage = "myPage.jsp";
			break;

			//내 정보 보기 
		case("/profileView.do"):
			command = new EMyPageCommand();
			command.execute(request, response);
			viewPage = "profileView.jsp";
			break;

			//내 정보 수정
		case("/profileModify.do"):
			command = new EProfileModifyCommand();
			command.execute(request, response);
			viewPage = "profileView.do";
			break;

			//회원 탈퇴
		case("/profileDelete.do"):
			command = new EProfileDeleteCommand();
			command.execute(request, response);
			viewPage = "main.do";
			break;
			
			//주소록 보기
		case("/addressBookView.do"):
			command = new EAddressBookViewCommand();
			command.execute(request, response);
			viewPage = "addressBookView.jsp";
			break;

			//주소 추가 화면
		case("/registerAddForm.do"):
			viewPage = "registerAddForm.jsp";
			break;
			
			//주소 추가
		case("/registerAdd.do"):
			command = new ERegisterAddCommand();
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;
			//주소 삭제 
		case("/registerDelete.do"):
			command = new ERegisterDeleteCommand(); 
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;

			//기본 주소지 설정 
		case("/registerSetDefault.do"):
			command = new ERegisterSetDefault(); 
			command.execute(request, response);
			viewPage = "addressBookView.do";
			break;
			
			//회원 주문하기 화면
		case("/userOrderForm.do"):
			command = new EUserOrderFormCommand();
			command.execute(request, response);
			viewPage = "userOrderPage.jsp";
			break;
			//장바구니 상품번호 가져오기
		case("/readInCart.do"):
			command = new EReadInCartCommand();
			command.execute(request, response);
			viewPage = "userOrderForm.do";
			break;
			//장바구니에서 선택상품 가져와서 형변환
		case("/selectedReadInCart.do"):
			command = new ESelectedReadInCartCommand();
			command.execute(request, response);
			viewPage = "userOrderForm.do";
			break;	
			//회원 주문하기 
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
			//장바구니 담기 
		case("/addCart.do"):
			command = new AddCartCommand();
			command.execute(request, response);
			viewPage = "cartLink.jsp";
//			viewPage = (String) request.getAttribute("cartReturnPage");
			break;
		
			//장바구니 보기
		case("/userCartView.do"):
			command = new EUserCartViewCommand();
			command.execute(request, response);
			viewPage = "userCartView.jsp";
			break;
			
			//장바구니 물건 삭제
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
			// 로그인 안한 상태서 로그인을 요하는 페이지로 갈 경우 로그인 폼으로 가기
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


