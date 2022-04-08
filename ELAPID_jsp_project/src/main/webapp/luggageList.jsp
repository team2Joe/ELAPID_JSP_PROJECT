
<%@page import="com.elapid.dto.ProductListDto"%>
<%@page import="com.elapid.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
			<div class="category-banner">
				<div class="image-group">
					<div class="image-field">
						<picture>
						<img src="elapid_img/luggage_header.png">
						</picture>
					</div>
					<div class="header-field">
						<h2>캐리어</h2>
					</div>
				</div>
			</div>
			
			<div>
				<h4>필터</h4>
				<h5>크기</h5>
				<form action="sizeFilterList.do">
					기내용/소형 <input type="checkbox" name="ctg_middle" value="small">
					중형수하물 <input type="checkbox" name="ctg_middle" value="middle">
					대형수하물 <input type="checkbox" name="ctg_middle" value="large">
					<input type="submit" value="확인">
				</form>
				
				<h5>색상</h5>
				<form action="colorFilterList.do">
					
					검정 <input type="checkbox" name="ps_color" value="black">
					회색 <input type="checkbox" name="ps_color" value="grey">
					빨강 <input type="checkbox" name="ps_color" value="red">
					흰색 <input type="checkbox" name="ps_color" value="white">
					<input type="submit" value="확인">
				</form>
				
				<h5>주요기능</h5>
				<form action="functionFilterList.do">
					서스펜션 휠 <input type="checkbox" name="p_mainf" value="서스펜션휠">
					자동제어장치 <input type="checkbox" name="p_mainf" value="자동제어장치">
					지문인식 <input type="checkbox" name="p_mainf" value="지문인식">
					RFID <input type="checkbox" name="p_mainf" value="rfid">
					<input type="submit" value="확인">
				</form>
				
				<form action="">
					<label for="customRange3" class="form-label">가격</label>
					<input type="range" class="form-range" min="68000" max="890000" step="1000" id="customRange3">
				</form>
				
			</div>
			
			<div class="row row-cols-1 row-cols-md-3 g-4">
				
					
					

				
 <%
 	ArrayList<ProductListDto> list = (ArrayList<ProductListDto>) request.getAttribute("list");
 
 for(int i = 0; i < list.size(); i++){
	 boolean check = true;
 	for(int j = 0; j < i; j++){
 		
 		// list내의 product이름이 서로 같고 컬러나 사이즈가 서로 다른 상품은 리스트에서 하나만 띄우고 나머지는 제외
 		if((list.get(i).getP_name().equals(list.get(j).getP_name()) &&  list.get(i).getP_size() != list.get(j).getP_size())
 	 			|| (list.get(i).getP_name().equals(list.get(j).getP_name()) &&  list.get(i).getPs_color() != list.get(j).getPs_color())	){
 			check = false;
 			break;
 		}
 		
 	}
 	if(check){

%>
				 
				 <div class="col">
				    <div class="card h-100" align="center">
			    	  <a href="detailView.do?p_name=<%=list.get(i).getP_name() %>&ctg_middle=<%=list.get(i).getCtg_middle() %>">
				      <img src="<%=list.get(i).getImg_thum() %>" alt="..." align="center">
				      <div class="card-body">
				        <h5 class="card-title"><%=list.get(i).getP_name() %></h5>
				      </a>
				        <h6 class="card-price"><%=list.get(i).getP_price() %> won</h6>
				        <div class="attribute">	
							
						</div>
				      </div>
				      <div class="card-footer">
				 	<%-- 아이디값 null시 비회원 장바구니로 들어가기 --%>
				      	<c:choose>
				      		<c:when test="${sessionScope.u_id eq '' }">
				      			<form action="addCart.do?p_id=<%=list.get(i).getP_id() %>">
									<button type="submit" class="btn btn-dark" >장바구니 담기</button>
								</form>
				      		</c:when>
				      		<c:otherwise>
				      			<form action="addCart.do?p_id=<%=list.get(i).getP_id() %>">
									<button type="submit" class="btn btn-dark">장바구니 담기</button>
								</form>
				      		</c:otherwise>
				      	</c:choose>
							
						
				      </div>
				    </div>
				  </div>
			
						
	 <%
						 }
		 }
	 %>
				</div>
			
		<%@ include file="/layout/footer.jsp"%>	
		
		
		
		
		
		