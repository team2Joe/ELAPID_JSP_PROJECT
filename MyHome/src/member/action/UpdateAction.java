package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			MemberDTO login = (MemberDTO)request.getSession().getAttribute("login");
			
			MemberDTO dto = new MemberDTO();
			dto.setNo(login.getNo());
			dto.setEmail(request.getParameter("email"));
			dto.setTel1(request.getParameter("tel1"));
			dto.setTel2(request.getParameter("tel2"));
			dto.setTel3(request.getParameter("tel3"));
			
			boolean check = MemberDAO.getInstance().updateMember(dto);
			
			String msg = null;
			String url = null;
			
			if(check) {
				login.setEmail(request.getParameter("email"));
				login.setTel1(request.getParameter("tel1"));
				login.setTel2(request.getParameter("tel2"));
				login.setTel3(request.getParameter("tel3"));
				msg = "�����Ϸ�!!MyPage��...";
				url = "/MyHome/member/myPage.me";
			} else {
				msg = "��������!!������������...";
				url = "/MyHome/member/updateForm.me";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			
	}

}
