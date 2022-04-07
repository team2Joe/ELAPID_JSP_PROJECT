<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.elapid.dto.AddCartDto"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/layout/header.jsp"%>
<%
	ArrayList<AddCartDto> cart = null;

	Object object = session.getAttribute("cart");




%>





<html>
<head>
<meta charset="UTF-8">
<title>cartForm</title>
</head>
	<body>
		
		
		
		
			<div style = "padding: 30px 200px 20px 200px;"> <!-- 중앙! --> 
				<div class="">
					<h3> 주문하기 </h3>
				</div>
		
				<c:forEach items="${add }" var="adddto">
			
			
				<div class="container">
			  		<div class="row">
			  				<div class="col-1" style="padding: 75px 0px 0px 0px;">
			  			<div class="form-check" >
						  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
						  <label class="form-check-label" for="flexCheckDefault">
						  </label>
						</div>
							</div>
							
							<!-- 상품 이미지 -->			  			
				   			<div class="col-2" align="left">
						     <img alt="캐리어1" src="elapid_img/luggage/sefton_main.jpg" width="100">
						    </div>
						    <!-- 상품 정보 -->
					    	<div class="col-4" align="left">
					     		<p class="fs-4">${adddto.p_name }</p>
					     		<p class="fs-6">${adddto.p_colorname }</p>
						   	</div>
						   	 <!-- 삭제,주문하기,가격 -->
						    <div class="col -2" align="right">
						      	<p class="fs-4" >X</p>
						      	<button type="button" class="btn btn-dark">주문하기</button><br><br>
						      	<p>${adddto.p_price } 원</p>
				   		 	</div>
			  		</div>
				</div>
	<hr width="1050">
				</c:forEach>
		
		<!-- 쿠폰 -->
		<div class="container" >
		  <div class="row">
		    <div class="col" align="left">
		     	
		    </div>
		    <div class="col" align="right">
		      - 원
		    </div>
		  </div>
		</div>
	<hr width="1050">
		<p class="fs-6" align="right">배송비 :??원 </p>
	<hr width="1050">
		<div align="right">	
			<h5>총 계</h5>
			<h4>원</h4>
		</div>
	
	
	<!-- Small button group -->
	
	</div><!-- 중앙! -->
	<!-- 2분할! -->
	<div class="d-grid gap-2 col-10">
	
	  <div><button type="button" class="btn btn-dark" style="float: right;" >선택상품 주문하기</button></div>
	 <div><button type="button" class="btn btn-dark" style="float: right;" >결제하기</button></div>
	</div>
	<br>
	  
		
	<div align="center">
	</div>
	
	
	</body>
<%@ include file="/layout/footer.jsp"%>	
</html>