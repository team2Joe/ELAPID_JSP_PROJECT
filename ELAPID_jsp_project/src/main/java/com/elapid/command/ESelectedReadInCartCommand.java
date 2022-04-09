package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ESelectedReadInCartCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String[] strp_ids = request.getParameterValues("cartchoice");
		ArrayList<Integer> p_ids = new ArrayList<Integer>();
		
		for (int i = 0 ; i < strp_ids.length ; i++) {
			p_ids.add(Integer.parseInt(strp_ids[i]));
		}
		request.setAttribute("p_ids",p_ids);
		
	}
}
