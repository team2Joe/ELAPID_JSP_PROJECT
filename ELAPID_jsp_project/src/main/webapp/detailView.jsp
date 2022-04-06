<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
		
		<h2 align="center">${detailView.p_name }</h2> <br>
		
		<div align="center">
		<c:choose>
			<c:when test="">
				
			</c:when>
		</c:choose>
		<table>
			<tr align="center">
				<%--상품 필터 col --%>
				<td>
					<br>
					<img src="${detailView.p_imgpath }">
					<br>
					<c:forEach items="${image }" var="dto">
						<img src="${dto.img_path }">
					</c:forEach>
					
				</td>
				<%-- 상품 상세내용 col --%>
				<td>
					<h2>가격 : ${detailView.p_discountprice }</h2><br>
					
					
					<c:choose>
						<c:when test="${detailView.p_ctgmain eq 'luggage' }">
							size  
								<select name="ctg-middle">
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
						</c:when>	
					</c:choose >
							
					<br>
					<c:choose>
				      		<c:when test="">
				      			<form action="userCartView.do">
									<button type="button" class="btn btn-light">장바구니 담기</button>
								</form>
				      		</c:when>
				      		<c:otherwise>
				      			<form action="nonUserCartView.do">
									<button type="button" class="btn btn-light">장바구니 담기</button>
								</form>
				      		</c:otherwise>
			      	</c:choose>
			      	<br>
					<form action="orderForm.do">
						<button type="button" class="btn btn-dark">바로구매</button>
					</form>
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
		

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="js/basic.js"></script>
<%@ include file="/layout/footer.jsp"%>	
	