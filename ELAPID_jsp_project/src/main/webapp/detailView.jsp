<%@ include file="/layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
		
		<div align="center">
		
		<h3>${detailView.p_name }</h3> <br>
		가격 : ${detailView.p_discountprice }<br>
		<br>
		<img src="${detailView.p_imgpath }">
		<br>
		<c:forEach items="${image }" var="dto">
			<img src="${dto.img_path }">
		</c:forEach>
		
		
		원하는 사이즈 선택<br>
		구매/장바구니<br>
		</div>
		

<%@ include file="/layout/footer.jsp"%>	
	