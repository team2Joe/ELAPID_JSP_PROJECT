<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  

			<div class="row row-cols-1 row-cols-md-3 g-4">	
	 			<c:forEach items="${list }" var="dto">
				 <div class="col">
				    <div class="card h-100" align="center">
				    <%--순위 반영 --%>
				    <c:choose>
				    	<c:when test="${dto.p_rank == 1 }">
				    		<p class="text-warning bg-dark"><h2>Top${dto.p_rank }</h2></p>
				    	</c:when>
				    	<c:otherwise>
				    		<p class="text-info bg-dark"><h2>Top${dto.p_rank }</h2></p>		    		
				    	</c:otherwise>
				    </c:choose>
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



    
<%@ include file="/layout/footer.jsp"%>	    