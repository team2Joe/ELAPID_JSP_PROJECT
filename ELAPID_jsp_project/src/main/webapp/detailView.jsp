
<%@page import="com.elapid.dto.ProductDetailDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

		
<%
	ProductDetailDto detailView = (ProductDetailDto) request.getAttribute("detailView");

%>		
			<h2 align="center"><%=detailView.getP_id() %></h2> <br>
			
			<div align="center">
			<table>
				<tr align="center">
					<%--상품 필터 col --%>
					<td align="center">
						<img src="<%=detailView.getImg_01() %>" width="400" height="600">
						
					</td>
					<%-- 상품 상세내용 col --%>
					<td align="center">
						<h2> <%=detailView.getP_name() %></h2>
						<h4>가격 : <%=detailView.getP_price() %></h4><br>
				<%
						if(detailView.getCtg_main().equals("luggage")){

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
						남은 수량 : <%=detailView.getP_stock() %><br>
						<button class="btn btn-dark" name="p_id" id="pid" onclick = "inputCart()" value="<%=detailView.getP_id() %>">장바구니 담기</button>
				      	<br>
						<button onclick="location.href='userOrderForm.do?p_id=<%=detailView.getP_id() %>'" class="btn btn-dark">바로구매</button>
					</td>
					
				</tr>
				<tr>
					<td align="center">
						<img src="<%=detailView.getImg_02()%>" width="400" height="600">
						<img src="<%=detailView.getImg_03()%>" width="400" height="600">
						<img src="<%=detailView.getImg_04()%>" width="400" height="600">
						<img src="<%=detailView.getImg_05()%>" width="400" height="600">
						<img src="<%=detailView.getImg_06()%>" width="400" height="600">
					</td>
					<td>
						<textarea rows="50" cols="50" readonly="readonly"><%=detailView.getP_desc() %></textarea> 
					</td>
				</tr>
			</table>
			<br>
			댓글-답글
			<br>		
		
			</div>
			<h3>1:1문의</h3>
			<div class="form-floating">
			  
			  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
			  
			  <label for="floatingTextarea">Comments</label>

			</div>


<%@ include file="/layout/footer.jsp"%>	
	