package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductListDto;

public class ELuggageFilterListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
			String[] ctg_middle = request.getParameterValues("ctg_middle");
			String[] ps_color = request.getParameterValues("ps_color");
			String[] p_mainf = request.getParameterValues("p_mainf");
		
			
			
			ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
			
			ProductDao dao = new ProductDao();
			
			ProductDao countDao = new ProductDao();
			
			// productDao메서드 파라미터에 전달할 where조건 기본 쿼리문
			String query = " where ctg_main = 'luggage'";

			if(p_mainf != null) {
				
				String[] queryValuesMainf = new String[p_mainf.length];
			
				// 주요기능 필터 쿼리문 조건
				for(int i = 0; i < p_mainf.length; i++) {
	
					// 필터 선택 조건이 한번일때
					if(p_mainf.length == 1) {
						queryValuesMainf[i] = " and p_mainf = '" + p_mainf[i] + "'";
						query += queryValuesMainf[i];
						
					}else {
						
						if(i == 0) {
							queryValuesMainf[i] = " and (p_mainf = '" + p_mainf[i] + "'";
	
						// 하나의 카테고리 조건이 끝날 때 마지막에 괄호로 닫아주는 조건
						}else if(i == p_mainf.length-1){
							queryValuesMainf[i] = " or p_mainf = '" + p_mainf[i] + "')";
						}else{
							queryValuesMainf[i] = " or p_mainf = '" + p_mainf[i] + "'";
						}
						query += queryValuesMainf[i];
						
					}
				}
			}
			if(ctg_middle != null) {
				String[] queryValuesMiddle = new String[ctg_middle.length];
					// 중분류 필터 쿼리문 조건
				for(int i = 0; i < ctg_middle.length; i++) {
					
					if(ctg_middle.length == 1) {
						queryValuesMiddle[i] = " and c.ctg_middle = '" + ctg_middle[i] + "'";
						query += queryValuesMiddle[i];
						
					}else {
						
						if(i == 0) {
							queryValuesMiddle[i] = " and (c.ctg_middle = '" + ctg_middle[i] + "'";
						}else if(i == ctg_middle.length-1){
							queryValuesMiddle[i] = " or c.ctg_middle = '" + ctg_middle[i] + "')";
						}else {
							queryValuesMiddle[i] = " or c.ctg_middle = '" + ctg_middle[i] + "'";
						}
						query += queryValuesMiddle[i];	
					}
					
				}
			}	
			if(ps_color != null) {
				String[] queryValuesColor = new String[ps_color.length];
				
				// 색상 필터 쿼리문 조건
				for(int i = 0; i < ps_color.length; i++) {
		
					if(ps_color.length == 1) {
						queryValuesColor[i] = " and s.ps_color = '" + ps_color[i] + "'";
						query += queryValuesColor[i];
						
					}else {
						if(i == 0) {
							queryValuesColor[i] = " and (s.ps_color = '" + ps_color[i] + "'";
		
						}else if(i == ps_color.length-1){
							queryValuesColor[i] = " or s.ps_color = '" + ps_color[i] + "')";
						}else {
							queryValuesColor[i] = " or s.ps_color = '" + ps_color[i] + "'";
						}
					
						query += queryValuesColor[i];
					}
				}		
			}
			
			// 캐리어 전체 행 갯수 반환 카운트 메서드
			// 위와 같이 luggageFilterList의 쿼리 조건문을 가져와 조건별
			// 쿼리를 추출하고 productCount에 파라미터로 전달
			int count = countDao.productCount(query);
			
			// luggageList.jsp 페이지버튼에서 get으로 받은 page값
			String tempStart = request.getParameter("page");
			
			int startPage = 0; // 첫페이지 받아오기
			int onePageCount = 3; // 페이지 하나당 보여줄 상품 갯수
			
			// 페이지 수 저장
			count = (int)Math.ceil((double)count/(double)onePageCount);
			
			if(tempStart != null) { // 처음에는 실행하지 않음
				startPage = (Integer.parseInt(tempStart)-1)*onePageCount;
			}
			
			dtos = dao.luggageFilterList(ctg_middle, ps_color, p_mainf, startPage, onePageCount);
	
			System.out.println(count);
			
			// 페이지 수 request로 보내기
			request.setAttribute("count", count);
			request.setAttribute("list", dtos);

			
	}

}
