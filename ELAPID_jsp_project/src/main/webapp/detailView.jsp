<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
		
		<h2 align="center">${detailView.p_name }</h2> <br>
		
		<div align="center">
		
		<table>
			<tr align="center">
				<td align="left">
					dsfadfafd
				</td>
				<td>
					<br>
					<img src="${detailView.p_imgpath }">
					<br>
					<c:forEach items="${image }" var="dto">
						<img src="${dto.img_path }">
					</c:forEach>
					
					가격 : ${detailView.p_discountprice }<br>
					
					원하는 사이즈 선택<br>
					<br>
					구매/장바구니<br>
				</td>
			</tr>
		</table>
		<br>
		댓글-답글
		</div>
		

<%@ include file="/layout/footer.jsp"%>	
	