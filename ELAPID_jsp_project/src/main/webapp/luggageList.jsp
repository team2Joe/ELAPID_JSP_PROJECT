
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
			
			<div class="row row-cols-1 row-cols-md-3 g-4">
				
 <%
 	ArrayList<ProductDto> list = (ArrayList<ProductDto>) request.getAttribute("list");
 
 for(int i = 0; i < list.size(); i++){
	 boolean check = true;
 	for(int j = 0; j < i; j++){
 		
 		// list내의 product이름이 서로 같고 컬러나 사이즈가 서로 다른 상품은 리스트에서 하나만 띄우고 나머지는 제외
 		if((list.get(i).getP_name().equals(list.get(j).getP_name()) &&  list.get(i).getP_size() != list.get(j).getP_size())
 	 			|| (list.get(i).getP_name().equals(list.get(j).getP_name()) &&  list.get(i).getP_colorname() != list.get(j).getP_colorname())	){
 			check = false;
 			break;
 		}
 		
 	}
 	if(check){

%>
				 
				 <div class="col">
				    <div class="card h-100" align="center">
			    	  <a href="detailView.do?p_id=<%=list.get(i).getP_id() %>&p_ctgmiddle=<%=list.get(i).getP_ctgmiddle() %>">
				      <img src="<%=list.get(i).getP_imgpath() %>" alt="..." align="center">
				      <div class="card-body">
				        <h5 class="card-title"><%=list.get(i).getP_name() %></h5>
				      </a>
				        <h6 class="card-price"><%=list.get(i).getP_discountprice() %> won</h6>
				        <div class="attribute">	
							<div class="owl-carousel size-selection">
								
								<a class="attr-selector" href="#" data-attr-type="productSize" data-attr-value="55 cm">
								55 cm
								</a>
						
								<a class="attr-selector" href="#" data-attr-type="productSize" data-attr-value="69 cm">
								69 cm
								</a>
								
							</div>
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
		<%@ include file="/layout/footer.jsp"%>	