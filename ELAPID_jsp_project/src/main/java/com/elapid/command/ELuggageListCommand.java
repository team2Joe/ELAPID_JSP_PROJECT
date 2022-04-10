package com.elapid.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elapid.dao.ProductDao;
import com.elapid.dto.ProductDto;
import com.elapid.dto.ProductListDto;

public class ELuggageListCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
		
		ProductDao dao = new ProductDao();
		
		ProductDao countDao = new ProductDao();
		
		// 캐리어 전체 행 갯수 반환 카운트 메서드
		int count = countDao.productCount(" where c.ctg_main = 'luggage'");
		
		// luggageList.jsp 페이지버튼에서 get으로 받은 page값
		String tempStart = request.getParameter("page");
		
		int startPage = 0; // 첫페이지 받아오기
		int onePageCount = 3; // 페이지 하나당 보여줄 상품 갯수
		
		// 페이지 수 저장
		count = (int)Math.ceil((double)count/(double)onePageCount);
		
		if(tempStart != null) { // 처음에는 실행하지 않음
			startPage = (Integer.parseInt(tempStart)-1)*onePageCount;
		}
		
		dtos = dao.luggageList(startPage, onePageCount);
		
		request.setAttribute("count", count);
		request.setAttribute("list", dtos);
		
	}

}
