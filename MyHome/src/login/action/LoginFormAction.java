package login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Action;

public class LoginFormAction implements Action {

	public void execute(HttpServletRequest request,HttpServletResponse response) {
		
		//쿠키파일 검색해서 아이디 기억하기한
		//아이디 찾아서
		//loginForm으로 전송
		
		boolean check = false; //아이디 기억하기 체크 유무
		
		String id = request.getParameter("id");
		
		if(id == null){
			//쿠키파일들 읽어오기...
			Cookie[] cks = request.getCookies();
			
			//쿠키파일 검색
			if(cks != null){
				for(Cookie ck : cks){
					if(ck.getName().equals("ckid")) { //ckid라는 쿠키파일 검색
						id = ck.getValue();//Content값 받기...
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
