
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

			<div class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${list }" var="dto">
				  <div class="col">
				    <div class="card h-100" align="center">
			    	  <a href="detailView.do?p_id=${dto.p_id }&p_ctgmiddle=${dto.p_ctgmiddle }">
				      <img src="${dto.p_imgpath }" alt="..." align="center">
				      <div class="card-body">
				        <h5 class="card-title">${dto.p_name }</h5>
				      </a>
				        <h6 class="card-price">${dto.p_discountprice } won</h6>
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
				      <%-- 로그인 시 유저 장바구니로 들어가기 --%>
				      	<c:choose>
				      		<c:when test="">
				      			<form action="userCartView.do">
									<button type="button" class="btn btn-dark">장바구니 담기</button>
								</form>
				      		</c:when>
				      		<%-- 아이디값 null시 비회원 장바구니로 들어가기 --%>
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
		
			
		<%@ include file="/layout/footer.jsp"%>	