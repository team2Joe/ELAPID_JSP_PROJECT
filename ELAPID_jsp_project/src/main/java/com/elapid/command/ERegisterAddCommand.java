package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.UserDao;

public class ERegisterAddCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		UserDao dao = new UserDao();
		String uid = (String) session.getAttribute("uid");
		String uname = request.getParameter("uname");
		String utel = request.getParameter("utel");
		String addaddress = request.getParameter("jibunAddr");
		String addspecificaddress = request.getParameter("addrDetail");
		String addpostnumber = request.getParameter("zipNo");
		
		
		int searchresult = dao.searchAddress(addpostnumber, addaddress);
		
		if(searchresult >= 1) {// 주소북에 같은 주소 있을 시 add_id 받아와서 relation에만 저장 
			dao.registerAdd(uid, searchresult, addspecificaddress,uname,utel, 0);
			
		}else { // 주소북에 같은 주소 없을 시 주소북에 주소 저장후 relation 에 상세 주소 저장
			dao.addressAdd(addpostnumber, addaddress);
			int addid =  dao.searchAddress(addpostnumber, addaddress);
			dao.registerAdd(uid,addid, addspecificaddress,uname,utel,0);
			
		}
	}

}
