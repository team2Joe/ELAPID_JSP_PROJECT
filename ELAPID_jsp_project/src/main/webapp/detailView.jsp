
<%@page import="com.elapid.dto.ProductDetailDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
		
		
<%
	// 상품명이 같을 경우 하나만 출력해주는 조건
	
	// 해당 조건은 정해진 단일 상품만을 보여주는 단점이 존재함
	// 해당 사이즈 혹은 색상에 맞는 상품이 상세페이지에도 이에 맞게 출력되야한다...
	
	ArrayList<ProductDetailDto> detailView = (ArrayList<ProductDetailDto>)request.getAttribute("detailView");
	
	
	for (int i = 0; i < detailView.size(); i++ ){
		boolean check = true;
		for(int j = 0; j < i; j++ ){
	 		if((detailView.get(i).getP_name().equals(detailView.get(j).getP_name()) &&  detailView.get(i).getP_size() != detailView.get(j).getP_size())
	 	 			|| (detailView.get(i).getP_name().equals(detailView.get(j).getP_name()) &&  detailView.get(i).getPs_color() != detailView.get(j).getPs_color())	){
	 			check = false;
	 			break;
	 		}
	 		
	 	}
	 	if(check){
%>		
			<h2 align="center"><%=detailView.get(i).getP_id() %></h2> <br>
			
			<div align="center">
			<c:choose>
				<c:when test="">
					
				</c:when>
			</c:choose>
			<table>
				<tr align="center">
					<%--상품 필터 col --%>
					<td align="center">
						<img src="<%=detailView.get(i).getImg_01()%>" width="500" height="700">
						
						
						
						
					</td>
					<%-- 상품 상세내용 col --%>
					<td align="center">
						<h2> <%=detailView.get(i).getP_name() %></h2>
						<h4>가격 : <%=detailView.get(i).getP_price() %></h4><br>
						
				<%
						if(detailView.get(i).getCtg_main().equals("luggage")){
				%>		
								size  
									<select name="ctg_middle">
										<option value="small">small</option>
										<option value="middle">middle</option>
										<option value="large">large</option>
									</select>
								<br>
								color
									<select name="ps_color">
										<option value="black">검정</option>
										<option value="grey">회색</option>
										<option value="red">빨강</option>
									</select>	
					<%
						}
					%>
								
						<br>
						<br>
						남은 수량 : <%=detailView.get(i).getP_stock() %>
						<c:choose>
				      		<c:when test="${sessionScope.u_id eq '' } %>">
				      			<form action="nonUserCartView.do?p_id=<%=detailView.get(i).getP_id() %>">

									<button type="button" class="btn btn-light">장바구니 담기</button>
								</form>
				      		</c:when>
				      		<c:otherwise>
				      			<form action="UserCartView.do?u_id=${sessionScope.u_id }&p_id=<%=detailView.get(i).getP_id() %>">
									<button type="button" class="btn btn-light">장바구니 담기</button>
								</form>
				      		</c:otherwise>
				      	</c:choose>
				      	<br>
						<form action="userOrderForm.do?p_id=<%=detailView.get(i).getP_id() %>">
							<button type="button" class="btn btn-dark">바로구매</button>
						</form>
					</td>
					
				</tr>
				<tr>
					<td align="center">
						<img src="<%=detailView.get(i).getImg_02()%>" width="500" height="700">
						<img src="<%=detailView.get(i).getImg_03()%>" width="500" height="700">
						<img src="<%=detailView.get(i).getImg_04()%>" width="500" height="700">
						<img src="<%=detailView.get(i).getImg_05()%>" width="500" height="700">
						<img src="<%=detailView.get(i).getImg_06()%>" width="500" height="700">
					</td>
					<td>
						<textarea rows="50" cols="50" readonly="readonly"><%=detailView.get(i).getP_desc() %></textarea> 
					</td>
				</tr>
			</table>
			<br>
			댓글-답글
			<br>
<%
	 	}
	}
%>			
		
			</div>
			<h3>1:1문의</h3>
			<div class="form-floating">
			  
			  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
			  
			  <label for="floatingTextarea">Comments</label>
			
			
			</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="js/basic.js"></script>
<%@ include file="/layout/footer.jsp"%>	
	