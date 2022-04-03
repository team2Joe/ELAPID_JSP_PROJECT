package board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boarddao.BoardDAO;
import board.boarddto.BoardDTO;
import util.Action;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int start = 0;
		
		if(request.getParameter("start") != null) {
			start = Integer.parseInt(request.getParameter("start"));
		}
		
		ArrayList<BoardDTO> list = BoardDAO.getInstance().getList(start);
		
		int total = BoardDAO.getInstance().getTotal();
		int nowPage = start / 5 + 1; 
		int totalPage = total % 5 == 0 ? total / 5 : total / 5 + 1;
		
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("start", start);
		request.setAttribute("list", list);
		
	}

}
