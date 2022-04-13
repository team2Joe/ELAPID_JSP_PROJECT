
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
						<img src="elapid_img/suspension_header.png">
						</picture>
					</div>
					<div class="header-field">
						<h2>주요기능</h2>
					</div>
				</div>
			</div>

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
				 	<%-- 아이디값 null시 비회원 장바구니로 들어가기 --%>
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
			// middleView.do 페이지수
			int count = (int)request.getAttribute("count");	
			
			ArrayList<ProductListDto> list = (ArrayList<ProductListDto>)request.getAttribute("list");
	
			for(int i=1; i<=count; i++){
	%>			
				<button onclick="location.href='functionList.do?p_mainf=<%=list.get(0).getP_mainf() %>&page=<%=i %>'"><%=i %></button>
	<%
			}
	%>
	
				<td>
			</tr>
		</div>	
			
		<%@ include file="/layout/footer.jsp"%>	