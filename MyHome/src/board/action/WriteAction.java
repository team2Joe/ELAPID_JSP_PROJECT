package board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.boarddao.BoardDAO;
import board.boarddto.BoardDTO;
import member.memberdto.MemberDTO;
import util.Action;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		BoardDTO dto = new BoardDTO();
//		
//		MemberDTO login = (MemberDTO)request.getSession().getAttribute("login");
//		
//		dto.setId(login.getId());
//		dto.setName(login.getName());
//		dto.setTitle(request.getParameter("title"));
//		
//		String content = request.getParameter("content");
//		dto.setContent(content.replaceAll("\r\n", "<br>"));
//		
//		boolean check = BoardDAO.getInstance().write(dto);
//
//		request.setAttribute("check", check);
//		request.setAttribute("status", "write");
//		request.setAttribute("url", "/MyHome/board/list.brd");
		

		// MultipartRequest ��ü�� ����Ͽ� ���� ���ε�...
		String realPath = request.getServletContext().getRealPath("/storage");
		//G:\�����\Spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MyHome\storage

		MultipartRequest mr = new MultipartRequest(request, realPath, 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());

		// 1. request
		// 2. ������ ������ ���� ���...�������
		// 3. �ִ� ���� ũ�� - byte������ �ۼ�
		// 4. ���ڵ� Ÿ��
		// 5. ���� ����� ���� ���� Ŭ���� - ���û���

		BoardDTO dto = new BoardDTO();

		dto.setId(((MemberDTO)request.getSession().getAttribute("login")).getId());
		dto.setName(((MemberDTO)request.getSession().getAttribute("login")).getName());
		dto.setTitle(mr.getParameter("title"));

		String content = mr.getParameter("content");
		dto.setContent(content.replaceAll("\r\n", "<br>"));

		dto.setFilename(mr.getFilesystemName("filename"));

		System.out.println(mr.getParameter("filename"));
		System.out.println(mr.getOriginalFileName("filename"));
		System.out.println(mr.getFilesystemName("filename"));
		// mr.getParameter("filename") - null
		// mr.getOriginalFileName("filename") - ���� ���ε�� ���ϸ�
		// mr.getFilesystemName("filename") - ���� ����� ���ϸ�

		boolean check = BoardDAO.getInstance().write(dto);

		request.setAttribute("check", check);
		request.setAttribute("status", "write");
		request.setAttribute("url", "/MyHome/board/list.brd");
		
	}

}
