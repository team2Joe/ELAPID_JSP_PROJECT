package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.CartOrderDao;
import com.elapid.dao.OrderDao;
import com.elapid.dao.UserDao;
import com.elapid.dto.RegisterJoinDto;
import com.elapid.dto.UserDto;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public class EUserOrderCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		OrderDao oDao = new OrderDao();
		CartOrderDao cDao = new CartOrderDao();
		UserDao uDao = new UserDao();
		
		String uid = (String) session.getAttribute("uid");
		int add_id = Integer.parseInt(request.getParameter("uo_address"));		
		String uo_paymentmethod = request.getParameter("uo_paymentmethod");
		
		ArrayList<Integer> p_ids = null;
		// 장바구니에서 선택 상품주문 한 경우 cd_ids 가 같이 넘어 온다.
		if (request.getParameterValues("cd_ids") != null) {
			
			String[] strcd_ids = request.getParameterValues("cd_ids");
			
			ArrayList<Integer> cd_ids = new ArrayList<Integer>(); 
			for(int i = 0 ; i< strcd_ids.length ; i++ ) {
				cd_ids.add(Integer.parseInt(strcd_ids[i]));
			}
			p_ids = cDao.searchBycdids(cd_ids);
			
			// 장바구니 지우기
			oDao.deleteOrderedCart(cd_ids);
		}else {
			// 장바구니 전체 구매나 상품 바로구매의 경우
			
			String[] strp_ids = request.getParameterValues("p_ids");
			p_ids = new ArrayList<Integer>(); 
			for(int i = 0 ; i< strp_ids.length ; i++ ) {
				p_ids.add(Integer.parseInt(strp_ids[i]));
			}
			
			
			
		}
		
		
		int uo_amount = Integer.parseInt(request.getParameter("uo_amount"));
		int uo_discountedamount = Integer.parseInt(request.getParameter("uo_discountedamount"));
		int uo_shippingfee = Integer.parseInt(request.getParameter("uo_shippingfee"));
		
		
		// 주소록 키값으로 주소 불러오기
		RegisterJoinDto rdto = new RegisterJoinDto();
		rdto = uDao.searchRegister(uid, add_id);
		
		// 주문 테이블 작성 
		oDao.uesrOrderWrite(uid, rdto.getReg_name(),rdto.getReg_tel(), uo_discountedamount, uo_amount, rdto.getAdd_address(), rdto.getReg_specificaddress(),uo_shippingfee,  uo_paymentmethod);
		
		// 가장 최근 주문번호 찾아서 주문 상세 테이블 입력할 떄 같이 넣기  
		int uo_id =  oDao.searchLatestOrderForUser(uid);
		oDao.userOrderDetailWrite(p_ids, uo_id);
		
		
		
		
		
		
		
	}

}
