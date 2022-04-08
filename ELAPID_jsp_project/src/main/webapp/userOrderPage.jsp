<<<<<<< HEAD
<%@page import="com.elapid.dto.RegisterJoinDto"%>
<%@page import="com.elapid.dto.ProductListDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<<<<<<< HEAD
=======
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
>>>>>>> f22167109229e4bbf84986d42d4f0382db3c42f7
>>>>>>> c9283c13149760eed255d755ffcefae76e27ae12
<!DOCTYPE html>
<html>
<head>

<%@ include file="/layout/header.jsp"%>
<meta charset="UTF-8">
<title>UserOrderPage</title>
</head>

<<<<<<< HEAD

</head>

and 


<body>
	<div style="padding: 30px 200px 20px 200px;">
		<div style="float: left;">

			<form action="" method="post">

				<h3>주문결제</h3>
				<h4>1.주문고객 정보</h4>
				이름 : 
				<input type="text" style="border:none" id="uo_name" readonly="readonly" value="${userDto.u_name}"><br>
				이메일 주소 :
				<input type="text" style="border:none" id="uo_email" readonly="readonly" value="${userDto.u_email }"><br>
				전화번호 :
				<input type="text" style="border:none" id="uo_tel" readonly="readonly" value="${userDto.u_tel }"><br>
				<br>
				<h4>2.배송 정보</h4>
				
				
				
				<c:forEach var = "rdto" items ="${registerDtos}">
					<div class="row order-card">
							<c:if test="${rdto.reg_defaultaddress eq 1}">
								<input type="radio" name = "uo_address" value= ${rdto.add_id } checked="checked">
							</c:if>
							<c:if test="${rdto.reg_defaultaddress eq 0}">
								<input type="radio" name = "uo_address" value= ${rdto.add_id }>
							</c:if>
						<div class="text-card col-12 col-md-12">
							<table class="table table-borderless">
							  <tr >
							  
							  	<td class = "col-md-2">
							  		받는이 : 
							  	</td>
							  	<td class = "col-md-6">
							  		${rdto.reg_name}
							  	</td>
							  </tr>
							  <tr>
							  	<td>
							  		휴대폰 : 
							  	</td>
							  	<td>
							  		${rdto.reg_tel }
							  	</td>
							  	<td class = "col-md-1">
							  		
							  	</td>
							  </tr>
							  <tr>
							  	<td>
							  		주소 : 
							  	</td>
							  	<td>
							  		${rdto.add_address }
							  	</td>
							  </tr>
							  <tr>	
							  	<td>
							  		상세주소 : 
							  	</td>
							  	<td>
							  		${rdto.reg_specificaddress}
							  	</td>
							  	<td class = "col-md-1">
							  	</td>
							  </tr>
							</table>
						</div>
					</div>
				</c:forEach>

				<h4>3.결제 정보 선택</h4>
				<input type="radio" name = "uo_paymentmethod" checked="checked"> 신용카드
				<input type="radio" name = "uo_paymentmethod"> 휴대폰결제
					
				


			</form>



		</div>
		<div style="float: right;">
			<div class="container">
				<c:forEach var = "pdto" items ="${pListDtos}">
					<div class="row order-card">
						<div class="text-card col-12 col-md-12">
							<table class="table table-borderless">
							  <tr >
							  	<td class = "col-md-2">
							  		이미지 : 
							  	</td>
							  	<td class = "col-md-6">
							  		${pdto.img_thum}
							  	</td>

							  </tr>
							  <tr>
							  	<td>
							  		이름 : 
							  	</td>
							  	<td>
							  		${pdto.p_name }
							  	</td>
							  	<td class = "col-md-1">
							  		
							  	</td>
							  </tr>
							  <tr>
							  	<td>
							  		소분류 : 
							  	</td>
							  	<td>
							  		${pdto.ctg_sub}
							  	</td>
							  </tr>
							  <tr>	
							  	<td>
							  		가격 : 
							  	</td>
							  	<td>
							  		${pdto.p_price } ${pdto.p_discountprice}
							  	</td>
							  	<td class = "col-md-1">
							  	</td>
							  </tr>
							</table>
						</div>
					</div>
				</c:forEach>
				
				<% 
				
					ArrayList<ProductListDto> pdtos = new ArrayList<ProductListDto>();
					pdtos = (ArrayList<ProductListDto>) request.getAttribute("pListDtos");
					int amount = 0;
					int discountamount = 0;
					for(int i = 0 ; i< pdtos.size() ; i++){
						amount += pdtos.get(i).getP_price();
					    discountamount += pdtos.get(i).getP_discountprice();
					}
					
					int shippingfee = (discountamount >= 3000000) ? 0:10000;
					int total = shippingfee + discountamount; 
					
					
					// 가격 3 개 콤마 찍기
					String stramount = Integer.toString(discountamount);
					String strshippingfee = Integer.toString(shippingfee);
					String strtotal = Integer.toString(total);
					
					int len = stramount.length();
				
					for (int i = 0 ; i < len/3 ; i++  ){
						stramount = stramount.substring(0,stramount.length() - ((i+1)*3+i) ) +"," + stramount.substring(stramount.length() - ((i+1)*3+i) , stramount.length() );
					}
					
					len = strshippingfee.length();
					
					for (int i = 0 ; i < len/3 ; i++  ){
						strshippingfee = strshippingfee.substring(0,strshippingfee.length() - ((i+1)*3+i) ) +"," + strshippingfee.substring(strshippingfee.length() - ((i+1)*3+i) , strshippingfee.length() );
					}
					
					len = strtotal.length();
				
					for (int i = 0 ; i < len/3 ; i++  ){
						strtotal = strtotal.substring(0,strtotal.length() - ((i+1)*3+i) ) +"," + strtotal.substring(strtotal.length() - ((i+1)*3+i) , strtotal.length() );
					}
				
				%>
				
				<div class="row">
					<!-- 상품 이미지 -->
					<div class="col-2" align="left">
						<img alt="캐리어1" src="images/loginform.jpeg" width="50">
					</div>
					<!-- 상품 정보 -->
					<div class="col-4" align="left">
						<p class="fs-6">${User_Cart.p_name }</p>
						<p class="fs-8">${User_Cart.p_colorname }</p>
					</div>
					<!-- 삭제,주문하기,가격 -->
					<div class="col -2" align="right">
						<p><%=stramount %>원</p><br>
						<p>배달료 : <%=strshippingfee %>원</p>
						<p>총 계 : <%=strtotal %>원</p> 
						
					</div>
				</div>
			</div>
			<hr width="550">


		</div>
	</div>





</body>
<%@ include file="/layout/footer.jsp"%>
<<<<<<< HEAD

=======
=======
	
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
>>>>>>> f22167109229e4bbf84986d42d4f0382db3c42f7
>>>>>>> c9283c13149760eed255d755ffcefae76e27ae12
</html>