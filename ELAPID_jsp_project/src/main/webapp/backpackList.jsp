
<%@page import="com.elapid.dao.ProductDao"%>
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
					<img src="elapid_img/backpack_header.png">
					</picture>
				</div>
				<div class="header-field" align="center">
					<h2>백팩</h2>
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
		      	<c:choose>
		      		<c:when test="${sessionScope.u_id != '' }">
		      			<form action="nonUserCartView.do?">
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
	
				
	</c:forEach>
		</div>
					
		<br>			
		<div align="center">
			
			
	<%
			// middleView.do 페이지수
			int count = (int)request.getAttribute("count");	
			
			ArrayList<ProductListDto> list = (ArrayList<ProductListDto>)request.getAttribute("list");
	
			for(int i=1; i<=count; i++){
	%>			
				<button onclick="location.href='backpackList.do?page=<%=i %>'"><%=i %></button>
	<%
			}
	%>

		</div>	
			
		<%@ include file="/layout/footer.jsp"%>	
		
		
		
		
		
		