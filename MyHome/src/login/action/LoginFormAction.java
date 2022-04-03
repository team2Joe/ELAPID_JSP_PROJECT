package login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Action;

public class LoginFormAction implements Action {

	public void execute(HttpServletRequest request,HttpServletResponse response) {
		
		//��Ű���� �˻��ؼ� ���̵� ����ϱ���
		//���̵� ã�Ƽ�
		//loginForm���� ����
		
		boolean check = false; //���̵� ����ϱ� üũ ����
		
		String id = request.getParameter("id");
		
		if(id == null){
			//��Ű���ϵ� �о����...
			Cookie[] cks = request.getCookies();
			
			//��Ű���� �˻�
			if(cks != null){
				for(Cookie ck : cks){
					if(ck.getName().equals("ckid")) { //ckid��� ��Ű���� �˻�
						id = ck.getValue();//Content�� �ޱ�...
						check = true;
						break;
					}
				}
			}
		}
		
		request.setAttribute("id", id);
		request.setAttribute("check", check);
	}
	
}
