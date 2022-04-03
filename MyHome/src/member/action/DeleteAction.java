package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		    HttpSession session  = request.getSession();
			MemberDTO dto = (MemberDTO)session.getAttribute("login");
			String password = request.getParameter("password");
			
			String msg = null;
			String url = null;
			
			if(!dto.getPassword().equals(password)) {
				msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�..!! ������������...";
				url = "/MyHome/member/deleteForm.me";
			}else {
				MemberDAO dao = MemberDAO.getInstance();
				boolean check = dao.deleteMember(dto.getNo());
				if(check) {
					session.invalidate();
					msg = "Ż�𼺰�!!�ε�����������...";
					url = "/MyHome/";
				}else {
					msg = "Ż�����!! ����Ŀ� �ٽ� �õ��Ͻʽÿ�..������������...";
					url = "/MyHome/member/deleteForm.me";
				}
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);

	}

}
