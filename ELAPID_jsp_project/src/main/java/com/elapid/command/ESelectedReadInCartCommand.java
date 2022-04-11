package com.elapid.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.CartOrderDao;
import com.elapid.dao.OrderDao;

public class ESelectedReadInCartCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String[] strcd_ids = request.getParameterValues("cartchoice");
		
		ArrayList<Integer> cd_ids = new ArrayList<Integer>();
		ArrayList<Integer> p_ids = new ArrayList<Integer>();
		
		
		// 선택된 카트디테일 번호를 
		try {
			for (int i = 0 ; i < strcd_ids.length ; i++) {
				cd_ids.add(Integer.parseInt(strcd_ids[i]));
			}
		}catch(Exception e) {
			try {
				
				response.sendRedirect("userCartView.do?noselect=1");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		CartOrderDao cDao = new CartOrderDao();
		
		p_ids = cDao.searchBycdids(cd_ids);
		
		request.setAttribute("p_ids",p_ids);
		request.setAttribute("cd_ids",cd_ids);
		
		
		
	}
}
