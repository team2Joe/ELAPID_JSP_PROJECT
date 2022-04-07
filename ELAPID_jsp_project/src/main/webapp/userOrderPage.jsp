<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/layout/header.jsp"%>
<meta charset="UTF-8">
<title>UserOrderPage</title>
</head>

	
</head>
 
 
 
<body>
   	<div style = "padding: 30px 200px 20px 200px;">
        <div style="float:left ;">
    		
    		<h3>주문결제</h3>
    		<h4>1.주문고객 정보</h4>
    			이름 : u_name<br>
    			이메일주소 : u_email<br>
    			전화번호 : u_tel<br>
    			
    		<h4>2.배송 정보</h4>
    			u_address	
			    
    		<h4>3.결제 정보 선택</h4>
    		
    		
    		
    
    		</div>
    	        <div style="float:right;">
        			<div class="container">
			  		<div class="row">
							<!-- 상품 이미지 -->			  			
				   		<div class="col-2" align="left">
						    <img alt="캐리어1" src="elapid_img/luggage/sefton_main.jpg" width="50">
						</div>
						    <!-- 상품 정보 -->
					    <div class="col-4" align="left">
					     	<p class="fs-6">${User_Cart.p_name }</p>
					     	<p class="fs-8">${User_Cart.p_colorname }</p>
						 </div>
						   	 <!-- 삭제,주문하기,가격 -->
						  <div class="col -2" align="right">
						  	<p>${User_Cart.p_price } 원</p>
				   		 </div>
			  		</div>
				</div>
	<hr width="550">
        
        
        </div>
    </div>

	

	 
	
</body>
<%@ include file="/layout/footer.jsp"%>	
</html>