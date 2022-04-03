package board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boarddao.BoardDAO;
import board.boarddto.BoardDTO;
import util.Action;

public class ContentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 받아오기, 조회수 올리는 action 2개
		
		String mode = (String)request.getAttribute("mode");
		
		int seq = 0;
		if(mode == null) {
			seq = Integer.parseInt(request.getParameter("seq"));
			mode = request.getParameter("mode");
			if(mode == null) {
				
				BoardDAO.getInstance().readCount(seq);
			}
		} else {
			seq = (int)request.getAttribute("seq");
		}
		
		BoardDTO dto = BoardDAO.getInstance().getContent(seq);
		
		if(mode != null) {
			if(mode.equals("update")) {
				String content = dto.getContent();
				dto.setContent(content.replaceAll("<br>", "/r/n"));
			}
		}
		
		request.setAttribute("dto", dto);
		
	}

}
