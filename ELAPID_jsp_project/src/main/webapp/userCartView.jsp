<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/layout/header.jsp"%>

<html>
<head>
<meta charset="UTF-8">
<title>OrderFom</title>
</head>
	<body>
			<div style = "padding: 30px 200px 20px 200px;">  
				<div class="">
					<h3> 주문하기 </h3>
				</div>
		
			<%-- <c:forEach items="" var=""> --%>
				<div class="container">
			  		<div class="row">
			  				<div class="col-1" style="padding: 75px 0px 0px 0px;">
			  			<div class="form-check" >
						  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
						  <label class="form-check-label" for="flexCheckDefault">
						  </label>
						</div>
							</div>			  			
				   			<div class="col-2" align="left">
						     <img alt="캐리어1" src="image/캐리어1.jpeg" width="100">
						    </div>
					    	<div class="col-4" align="left">
					     		<p class="fs-4">EVOA TECH</p>
					     		<p class="fs-7">SP 75/28 EXP NON TRACKER</p>
					     		<p class="fs-6">BRUSHED BLACK</p>
						   	 </div>
						    <div class="col -2" align="right">
						      	<p class="fs-4">X</p>
						      	<button type="button" class="btn btn-dark">주문하기</button><br><br>
						      	가격<br>
				   		 	</div>
			  		</div>
				</div>
		</div>
	<div align="center">
	<hr width="1000">
	</div>
			<%--</c:forEach>  --%>
			
	
	<div align="center">
		<hr width="1000">
	</div>
	<div align="center">
		<hr width="1000">
	</div>
	
	<div class="container">
		<div class="row">
		</div>
	</div>
	
	<div>
	물품이미지 :
	물품이름 :
	물품가격
	주문하기:
	포인트:
	쿠폰종류:
	</div>
	
	
	
	</body>
<%@ include file="/layout/footer.jsp"%>	
</html>