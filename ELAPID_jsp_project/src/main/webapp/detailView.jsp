<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
		
		<h2 align="center">${detailView.p_name }</h2> <br>
		
		<div align="center">
		
		<table>
			<tr align="center">
				<td>
					
				</td>
				<td>
					<br>
					<img src="${detailView.p_imgpath }">
					<br>
					<c:forEach items="${image }" var="dto">
						<img src="${dto.img_path }">
					</c:forEach>
					
					<h2>가격 : ${detailView.p_discountprice }</h2><br>
					
					원하는 사이즈 선택<br>
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
					<form action="#">
						<button type="button" class="btn btn-dark">바로구매</button>
					</form>
				</td>
			</tr>
		</table>
		<br>
		댓글-답글
		</div>
		

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="js/basic.js"></script>
<%@ include file="/layout/footer.jsp"%>	
	