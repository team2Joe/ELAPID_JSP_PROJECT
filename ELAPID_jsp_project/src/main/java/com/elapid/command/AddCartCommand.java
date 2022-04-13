package com.elapid.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.AddCartDao;

public class AddCartCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//addCartCommand
		HttpSession session = request.getSession();
		
		String u_id = (String) session.getAttribute("uid");
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		System.out.println("p_id : " + p_id);
		AddCartDao dao = new AddCartDao();
		dao.userAddcart(p_id,u_id);
		System.out.println("**************"+p_id);
		
//		String uri = (String) request.getParameter("uri");
//		String conPath = request.getContextPath();
//		System.out.println(conPath +"############"+uri);
//		String url =  request.getRequestURL().substring(0);
//		
//		System.out.println("***********"+url);
//		//String com = url.substring(conPath.length()+100);
//		
//	
//		String ctg_middle = request.getParameter("ctg_middle");
//		String p_name = request.getParameter("p_name");
//		String com = uri.substring(conPath.length()+1, uri.length()-3);
//		
//		
//		System.out.println(com.length() +"com  :" +com);
//		System.out.println("p_name :" + p_name + "ctg_middle :" + ctg_middle);
//		
//		
//		if(com.length() == 12 || com.length() == 13 || com.length() == 19) {
//		
//			com += "do";
//			String viewPage = com;
//			request.setAttribute("cartReturnPage", viewPage);
//		
//		}else if(com.length() == 11){//디테일뷰	
//		
//			com += "do?p_id="+p_id+"&cdg_middle="+ctg_middle;
//			String viewPage = com;
//			request.setAttribute("cartReturnPage", viewPage);
//			//detailView.do?p_id=1&ctg_middle=small
//			}
//		
//		
//		
//		System.out.println(com+"*****************");
//		System.out.println("com : " + com);
//		
		
		
	
	}

	}
