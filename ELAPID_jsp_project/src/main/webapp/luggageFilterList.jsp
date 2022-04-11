
<%@page import="com.elapid.dao.ProductDao"%>
<%@page import="com.elapid.dto.ProductListDto"%>
<%@page import="com.elapid.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
   .div1 {
   padding : 0 0 0 100px;
   }
   .div2 {
   padding : 0 0 200px 200px;
   }
</style> 	
	<div class=".div2">
		<h4>필터</h4>
		<h5>크기</h5>
		<form action="luggageFilterList.do">
			기내용/소형 <input type="checkbox" name="ctg_middle" value="small">
			중형수하물 <input type="checkbox" name="ctg_middle" value="middle">
			대형수하물 <input type="checkbox" name="ctg_middle" value="large">
		
		<h5>색상</h5>
			검정 <input type="checkbox" name="ps_color" value="black">
			회색 <input type="checkbox" name="ps_color" value="grey">
			빨강 <input type="checkbox" name="ps_color" value="red">
			흰색 <input type="checkbox" name="ps_color" value="white">
		
		<h5>주요기능</h5>
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
		</c:forEach>
			</div>
			
		<div class="div2">
			<tr>
				<td>
			
	<%
			// middleView.do 페이지수
			int count = (int)request.getAttribute("count");	
			
			ArrayList<ProductListDto> list = (ArrayList<ProductListDto>)request.getAttribute("list");
	
			for(int i=1; i<=count; i++){
	%>			
				<a href="luggageFilterList.do?page=<%=i %>">[<%=i %>]</a>
	<%
			}
	%>
				<td>
			</tr>
		</div>		
			
			
		<%@ include file="/layout/footer.jsp"%>	
		
		
		
		
		
		