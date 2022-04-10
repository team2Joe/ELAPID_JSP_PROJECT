
<%@page import="com.elapid.dao.ProductDao"%>
<%@page import="com.elapid.dto.ProductListDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

			<div class="row row-cols-1 row-cols-md-3 g-4">
				 
<%
				// middleFunctionView.do 페이지수
				int count = (int)request.getAttribute("count");	

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
				      <img src="<%=list.get(i).getImg_thum() %>" alt="..." align="center" width="200" height="300">
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
				      			<form action="nonUserCartView.do">
									<button type="button" class="btn btn-dark">장바구니 담기</button>
								</form>
				      		</c:when>
				      		<c:otherwise>
				      			<form action="nonUserCartView.do">
									<button type="button" class="btn btn-dark">장바구니 담기</button>
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
				
		<div class="div2">
			<tr>
				<td>
			
	<%
			for(int i=1; i<=count; i++){
	%>			
				<a href="middleFunctionList.do?ctg_middle=<%=list.get(0).getCtg_middle() %>&page=<%=i %>">[<%=i %>]</a>
	<%
			}
	%>
				<td>
			</tr>
		</div>	
			
		<%@ include file="/layout/footer.jsp"%>	