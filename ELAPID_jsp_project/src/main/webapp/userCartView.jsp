<%@page import="com.elapid.command.EUserCartViewCommand"%>
<%@page import="com.elapid.dto.UserCartViewDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.elapid.dto.AddCartDto"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/layout/header.jsp"%>

<html>
<head>
<style type="text/css">
 /* link - 아직 클릭하지 않은 경우 red 색상 설정 */
 a:link { color: black; text-decoration: none;}	
 /* visited - 한번 클릭하거나 전에 클릭한적 있을 경우 #c71d44 설정 */
 a:visited { color: black; text-decoration: none;}	
 /* hover - 마우스를 해당 링크에 위치했을 경우 #006DD7 설정 */
 a:hover { color: #006DD7; text-decoration: none;}
</style>
<meta charset="UTF-8">
<title>cartForm</title>
</head>
<body>




	<div style="padding: 30px 200px 20px 200px;">
		<!-- 중앙! -->
		<div class="">
			<h3>주문하기</h3>
		</div>
	<%
	ArrayList<UserCartViewDto> dtos = (ArrayList<UserCartViewDto>)request.getAttribute("User_Cart");
		if ( dtos.size() != 0 ){
			
		
	%>

		<form action="userOderForm.do" id="cart">
			<c:forEach items="${User_Cart }" var="dtos">
					<div class="container">
						<div class="row">
							<div class="col-1" style="padding: 75px 0px 0px 0px;">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" name="cartchoice" value="${dtos.cd_id }" id="flexCheckDefault">
									<label class="form-check-label" for="flexCheckDefault">
									</label>
								</div>
							</div>

							<!-- 상품 이미지 -->
							<div class="col-2" align="left">
							<a href="detailView.do?p_id=${dtos.p_id }&ctg_middle=${dtos.ctg_middle}"> <img

									src="${dtos.img_thum }" width="100" height="150"></a>
							</div>
							<!-- 상품 정보 -->
							<div class="col-4" align="left">
								<a href="detailView.do?p_name=${dtos.p_name }"> <pclass="fs-4">${dtos.p_name }</p></a>
								<p class="fs-7">${dtos.p_size }</p>
								<p class="fs-6">${dtos.p_colorname }</p>
							</div>
							<!-- 삭제,주문하기,가격 -->
							<div class="col -2" align="right">
								<p class="fs-5">
									<a href="cartDeleteProduct.do?cd_id=${dtos.cd_id }">X</a>
								</p>
								<br>
								<br> <br>
								<fmt:formatNumber value="${dtos.p_price }" pattern="#,###,###" />원
							</div>
						</div>
					</div>
					<hr width="1050">
			</c:forEach>
		</form>



		<div align="right">
			<h5>총 계</h5>
			<h4>
				<fmt:formatNumber
					value="${User_Cart.get(User_Cart.size()-1).cart_totalamount}" pattern="#,###,###" />원
			</h4>
		</div><!-- 중앙! -->
	</div><!-- 2분할! -->
	
	<div class="d-grid gap-2 col-10" align="right">
		<div>
			<button onclick="selectedCartOrder()" class="btn btn-dark"
				style="float: right;">선택상품 주문하기</button>
		</div>
		<div>
			<button type="submit" onclick="location.href='readInCart.do'"
				class="btn btn-dark" style="float: right;">전체 결제하기</button>
		</div>
	</div>
	<br>


	<div align="center"></div>
	
	<%
		}else{
	%>
		<div style="padding: 30px 200px 20px 200px;">
		<!-- 중앙! -->
		<form action="main.do">
					<div  style="padding: 100px 0px 0px 0px;">
						<div align="center"><br><br><h2>장바구니가 비어있어요 T^T</h2><br><br>
						<input type="submit" class="btn btn-dark" value="메인으로 이동">
				<hr width="800"></div>
			</div>
		</form>
	</div><!-- 중앙! -->
	
		
	<%
		}
	%>

</body>
<%@ include file="/layout/footer.jsp"%>	
</html>