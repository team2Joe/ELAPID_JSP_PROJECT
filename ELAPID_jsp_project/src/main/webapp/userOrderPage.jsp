<%@page import="org.apache.catalina.ant.jmx.JMXAccessorQueryTask"%>
<%@page import="com.elapid.dto.RegisterDto"%>
<%@page import="com.elapid.dto.UserDto"%>
<%@page import="com.elapid.dto.RegisterJoinDto"%>
<%@page import="com.elapid.dto.ProductListDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<%@ include file="/layout/header.jsp"%>
<meta charset="UTF-8">
<title>UserOrderPage</title>
</head>



<%
// uo_paymentmethod
// up_add_id

ArrayList<RegisterDto> registerDtos = (ArrayList<RegisterDto>) request.getAttribute("registerDtos");
ArrayList<ProductListDto> pListDtos = (ArrayList<ProductListDto>) request.getAttribute("pListDtos");
%>

<body>
	<div style="padding: 30px 200px 20px 200px;">
					<form action="userOrder.do" method="post" id = "userOrderForm">
		<div class="row">
			<div class="col-5 col-md-6">
				<div style="float: left;">
						<div style="padding-top: 20px; padding-bottom: 20px">
							<h3>구매내역 </h3>
						</div>
						<h4>1.주문자 정보 </h4>
						이름 : <input type="text" style="border: none" id="uo_name"
							readonly="readonly" value="${userDto.u_name}"><br>
						이메일 : <input type="text" style="border: none" id="uo_email"
							readonly="readonly" value="${userDto.u_email }"><br>
						휴대폰 : <input type="text" style="border: none" id="uo_tel"
							readonly="readonly" value="${userDto.u_tel }"><br> <br>
						<h4>2.배송지 선택 </h4>



						<c:forEach var="rdto" items="${registerDtos}">
							<div class="row order-card">
								<c:if test="${rdto.reg_defaultaddress eq 1}">
									<input type="radio" name="uo_address" value=${rdto.add_id }
										checked="checked">
								</c:if>
								<c:if test="${rdto.reg_defaultaddress eq 0}">
									<input type="radio" name="uo_address" value=${rdto.add_id }>
								</c:if>
								<div class="text-card col-12 col-md-12">
									<table class="table table-borderless">
										<tr>

											<td class="col-md-2">이름 :</td>
											<td class="col-md-6">${rdto.reg_name}</td>
										</tr>
										<tr>
											<td>휴대폰 :</td>
											<td>${rdto.reg_tel }</td>
											<td class="col-md-1"></td>
										</tr>
										<tr>
											<td>주소 :</td>
											<td>${rdto.add_address }</td>
										</tr>
										<tr>
											<td>상세주소 :</td>
											<td>${rdto.reg_specificaddress}</td>
											<td class="col-md-1"></td>
										</tr>
									</table>
								</div>
							</div>
						</c:forEach>
						<div style="padding-top: 20px; padding-bottom: 20px;'">

							<h4>3. 결제수단 선택 </h4>
						</div>
						<div class="row" style="text-align: center;">
							<div class="col-5">
								<input type="radio" value="신용카드" name="uo_paymentmethod" checked="checked">
								신용카드
							</div>
							<div class="col-5">

								<input type="radio" value="휴대폰결제" name="uo_paymentmethod"> 휴대폰결제 
							</div>
						</div>

						<br> <br> <br>
						<div style="text-align: center;">
							<button class="btn btn-dark" onclick="userorder()">주문하기</button>
						</div>


						<input type="hidden" style="border: none" id="uo_name"
							readonly="readonly" value="${userDto.u_name}"><br>




				</div>
			</div>
			<div class="col-5 col-md-6" style="text-align=right;">
				<div class="container">
					<c:forEach var="pdto" items="${pListDtos}">
						<div class="row order-card">
							<div class="text-card col-12 col-md-12">
								<table class="table table-borderless">
									<tr>
										<td class="col-md-2">상품 이미지 </td>
										<td class="col-md-6">
											<img src="${pdto.img_thum}">
										
										</td>

									</tr>
									<tr>
										<td>상품 이름 :</td>
										<td>${pdto.p_name }</td>
										<td class="col-md-1"></td>
									</tr>
									<tr>
										<td>상품 분류 :</td>
										<td>${pdto.ctg_sub}</td>
									</tr>
									<tr>
										<td>상품 가격 :</td>
										<c:if test="${pdto.p_price  eq pdto.p_discountprice}">
								  		<td>${pdto.p_price } </td>
										</c:if>
										<c:if test="${pdto.p_price  != pdto.p_discountprice}">
								  		<td>${pdto.p_price } => ${pdto.p_discountprice}</td>
										</c:if>
										
										<td class="col-md-1"></td>
									</tr>
								</table>
							</div>
						</div>
						<input type="hidden" name= "p_ids" value="${pdto.p_id }">
					</c:forEach>
					<c:forEach var="cd_id" items="${cd_ids}">
						<input type="hidden" name= "cd_ids" value="${cd_id }">
					</c:forEach>
					<%
					ArrayList<ProductListDto> pdtos = new ArrayList<ProductListDto>();
					pdtos = (ArrayList<ProductListDto>) request.getAttribute("pListDtos");
					int amount = 0;
					int discountamount = 0;
					for (int i = 0; i < pdtos.size(); i++) {
						amount += pdtos.get(i).getP_price();
						discountamount += pdtos.get(i).getP_discountprice();
					}

					int shippingfee = (discountamount >= 3000000) ? 0 : 10000;
					int total = shippingfee + discountamount;

					// ê°ê²©ì ì½¤ë§ ì°ê¸°
					String stramount = Integer.toString(discountamount);
					String strshippingfee = Integer.toString(shippingfee);
					String strtotal = Integer.toString(total);

					int len = stramount.length();

					for (int i = 0; i < (len-1) / 3; i++) {
						stramount = stramount.substring(0, stramount.length() - ((i + 1) * 3 + i)) + ","
						+ stramount.substring(stramount.length() - ((i + 1) * 3 + i), stramount.length());
					}

					len = strshippingfee.length();

					for (int i = 0; i < (len-1)  / 3; i++) {
						strshippingfee = strshippingfee.substring(0, strshippingfee.length() - ((i + 1) * 3 + i)) + ","
						+ strshippingfee.substring(strshippingfee.length() - ((i + 1) * 3 + i), strshippingfee.length());
					}

					len = strtotal.length();

					for (int i = 0; i < (len-1)  / 3; i++) {
						strtotal = strtotal.substring(0, strtotal.length() - ((i + 1) * 3 + i)) + ","
						+ strtotal.substring(strtotal.length() - ((i + 1) * 3 + i), strtotal.length());
					}
					//
					%>

					<div class="row">
						<!-- ìí ì´ë¯¸ì§ -->
						<div class="col-2" align="left">
						</div>
						<!-- ìí ì ë³´ -->
						<div class="col-4" align="left">
							<p class="fs-6">${User_Cart.p_name }</p>
							<p class="fs-8">${User_Cart.p_colorname }</p>
						</div>
						
						
						
						<!-- ì­ì ,ì£¼ë¬¸íê¸°,ê°ê²© -->
						<div class="col -2" align="right">
							<p><%=stramount%>원
							</p>
							<br>
							<p>
								배송비 :
								<%=strshippingfee%>원
							</p>
							<p>
								총액 :
								<%=strtotal%>원
							</p>

						</div>
					</div>
				</div>
				<hr width="550">


				</div>
			</div>
			<input type="hidden" name = "uo_amount" value="<%=amount%>">
			<input type="hidden" name = "uo_discountedamount" value="<%=discountamount%>">
			<input type="hidden" name = "uo_shippingfee" value="<%=shippingfee%>">
		</form>
	</div>



	<script src="js/order.js"></script>
</body>

<%@ include file="/layout/footer.jsp"%>
