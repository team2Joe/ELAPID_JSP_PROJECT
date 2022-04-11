package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.CartOrderDao;
import com.elapid.dao.RegisterDao;
import com.elapid.dao.UserDao;

public class ERegisterCheckCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		
		String uid = request.getParameter("uid");
		String upwd = request.getParameter("upassword");
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String utel = request.getParameter("utel");
		String ugender = request.getParameter("ugender");
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthday = request.getParameter("birthday");
		String ubirthdate = birthyear + "-" +birthmonth + "-" + birthday;
		
		dao.userAdd(uid, upwd, uname, uemail, utel, ugender, ubirthdate);
		
		CartOrderDao cdao2 =new CartOrderDao();
		
		cdao2.CartAdd(uid);
		
		
		String addaddress = request.getParameter("jibunAddr");
		String addspecificaddress = request.getParameter("addrDetail");
		String addpostnumber = request.getParameter("zipNo");
		
		int searchresult = dao.searchAddress(addpostnumber, addaddress);
		
		if(searchresult >= 1) {// 주소북에 같은 주소 있을 시 add_id 받아와서 relation에만 저장 
			dao.registerAdd(uid, searchresult, addspecificaddress,uname,utel, 1);
		}else { // 주소북에 같은 주소 없을 시 주소북에 주소 저장후 relation 에 상세 주소 저장
			dao.addressAdd(addpostnumber, addaddress);
			int addid =  dao.searchAddress(addpostnumber, addaddress);
			dao.registerAdd(uid,addid, addspecificaddress,uname,utel,1);
			
		}
		
		
	}

}

