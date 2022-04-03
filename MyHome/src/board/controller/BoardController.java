package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.ContentAction;
import board.action.DeleteAction;
import board.action.DownloadAction;
import board.action.ListAction;
import board.action.UpdateAction;
import board.action.WriteAction;
import util.Action;
import util.ActionForward;

@WebServlet("*.brd")
public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Action action = null;
		ActionForward actionForward = null;
		
		String requestURL = request.getRequestURI().toString();
		
		int start = requestURL.lastIndexOf('/');
		int end = requestURL.lastIndexOf(".brd");
		
		String path = requestURL.substring(start + 1, end);
		
		switch(path) {
		case "list":
			action = new ListAction();
			actionForward = new ActionForward("/board/list.jsp", false);
			break;
		case "writeForm":
			actionForward = new ActionForward("/MyHome/board/write.jsp", true);  // redirect방식
			break;
		case "write":
			action = new WriteAction();
			actionForward = new ActionForward("/board/result.jsp", false);
			break;
		case "content":
			action = new ContentAction();
			actionForward = new ActionForward("/board/content.jsp", false);
			break;
		case "fileDownload":
			action = new DownloadAction();
			actionForward = new ActionForward("/board/content.brd", false);
			break;
		case"updateForm":
			action = new ContentAction();
			actionForward = new ActionForward("/board/update.jsp", false);
			break;
		case "update":
			action = new UpdateAction();
			actionForward = new ActionForward("/board/result.jsp", false);
			break;
		case "delete":
			action = new DeleteAction();
			actionForward = new ActionForward("/board/result.jsp", false);
			break;
		}
		
		if(action != null) {
			action.execute(request, response);
		}
		
		if(actionForward.isRedirect() ) { //true시 redirect방식 
			response.sendRedirect(actionForward.getNextPath());
		}else {  // false시 forward 방식
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
	}

}
