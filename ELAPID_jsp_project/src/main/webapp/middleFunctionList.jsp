
<%@page import="com.elapid.dao.ProductDao"%>
<%@page import="com.elapid.dto.ProductListDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

			<div class="row row-cols-1 row-cols-md-3 g-4">	
	 			<c:forEach items="${list }" var="dto">
				 <div class="col">
				    <div class="card h-100" align="center">
			    	  <a href="detailView.do?p_id=${dto.p_id }&ctg_middle=${dto.ctg_middle }">
				      <img src="${dto.img_thum }" alt="..." align="center">
				      <div class="card-body">
				        <h5 class="card-title">${dto.p_name }</h5>
				      </a>
				        <h6 class="card-price">${dto.p_price } won</h6>
				        <div class="attribute">	
							
						</div>
				      </div>
				      <div class="card-footer">
				     	 <button class="btn btn-dark" onclick = "location.href='addCart.do?p_id=${dto.p_id}'" >장바구니 담기</button> 
				      </div>
				    </div>
				  </div>	
				</c:forEach>
			</div>
		
		<br>		
		<div align="center">
			<tr>
				<td>
			
	<%
			int count = (int)request.getAttribute("count");	
	
			for(int i=1; i<=count; i++){
	%>			
				<button onclick="location.href='middleFunctionList.do?page=<%=i %>'"><%=i %></button>
	<%
			}
	%>
				<td>
			</tr>
		</div>	
		<%@ include file="/layout/footer.jsp"%>	