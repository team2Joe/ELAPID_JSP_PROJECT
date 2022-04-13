<%@page import="com.elapid.dto.OrderHistoryDto"%>
<%@page import="com.elapid.command.EUserOrderHistoryCommand"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.elapid.dto.AddCartDto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/layout/header.jsp"%>

<div style="padding: 100px 200px 20px 200px; text-align:cneter;"  >
<h1> 주문내역 </h1>
</div>
<div style="padding: 30px 200px 20px 200px;">
	<!-- 중앙! -->
	

<%!
	// 가격에 콤마 찍어주는 함수
	public String comma(int num1){
		String stramount = Integer.toString(num1);

		int len = stramount.length();
		for (int i = 0; i < (len-1) / 3; i++) {
			stramount = stramount.substring(0, stramount.length() - ((i + 1) * 3 + i)) + ","
			+ stramount.substring(stramount.length() - ((i + 1) * 3 + i), stramount.length());
		}
		return stramount;
	}

%>						

<%
	ArrayList<OrderHistoryDto> ohdtos = new ArrayList<OrderHistoryDto>();
	
	ohdtos = (ArrayList<OrderHistoryDto>)request.getAttribute("orderHistory");
	
	String justcomment = "";
	
	int contentsNumPerPage  = 5 ; // 페이지당 총 컨텐츠 수;
	int contentCount = 0 ; // 컨텐츠 카운트
	int pageNum = (Integer)request.getAttribute("pageNumtwo");  // 현재 페이지 넘버 
	ArrayList<Integer> iNum = new ArrayList<Integer>();
	ArrayList<Integer> uo_ids = new ArrayList<Integer>();
	iNum.add(0);
	int count = 0;
	for(int i = 0; i<ohdtos.size() ; i++){
		if(i > 0){
			if(ohdtos.get(i).getUo_id() != ohdtos.get(i-1).getUo_id()){
				count += 1 ;
				if(count % 5 == 0){
					iNum.add(i);
				}
			}
		}
	}
	int allPageNum = iNum.size();

	if (ohdtos.size() != 0){
%>
	 <!-- 일단 반품을 고려해 form 으로 체크 박스를 넣으려고 했기때문에 폼이 있다.-->
 	<form action="userOderForm.do" id="cart">
<%
		for(int i = 0 + iNum.get(pageNum-1) ; i<ohdtos.size() ; i++){
			if(i == 0){
				contentCount += 1;
%>
				
				<!-- 인덱스 0 만 따로 출력 끝 -->
				<div class="container">
					<div class="row">
						<div class="col-2" style="padding: 35px 0px 0px 0px;">
								<label class="form-check-label" for="flexCheckDefault"> 주문 번호 : <%=ohdtos.get(i).getUo_id()%><br></label>
									
									
						</div>
		
						<!-- 상품 이미지 -->
						<div class="col-4" align="left">
							
							받는이 : <%= ohdtos.get(i).getUo_name() %><br>
							휴대폰 : <%=ohdtos.get(i).getUo_tel() %><br>
							주소 : <%=ohdtos.get(i).getUo_address()%><br>
							상세주소 : <%=ohdtos.get(i).getUo_specificaddress()%><br>
							
						</div>	
						<!-- 상품 정보 -->
						<div class="col-3" align="right">

						</div>
						<!-- 삭제,주문하기,가격 -->


						<div class="col -2" align="right">
							결제수단 : <%=ohdtos.get(i).getUo_paymentmethod() %><br>
							배송료 : <%=comma( ohdtos.get(i).getUo_shippingfee()) %>원<br>
							주문 금액 : <%=comma(ohdtos.get(i).getUo_discountedamount()) %>원<br>
							결제 금액 : <%=comma ( ohdtos.get(i).getUo_shippingfee() + ohdtos.get(i).getUo_discountedamount()) %>원<br>
						</div>
					</div>
				</div>
				<hr width="1350">
				
							<div class="container">
				<div class="row">
					<div class="col-1" style="padding: 55px 0px 0px 0px;">
						<%-- <input class="form-check-input" type="checkbox" name="cartchoice" value="${dtos.cd_id}" id="flexCheckDefault">  --%>
						
					</div>
					<div class="col-2" style="padding: 50px 0px 0px 0px;">
							<label class="form-check-label" for="flexCheckDefault"> 주문상세 번호 : <%=ohdtos.get(i).getUod_id()%><br></label><br>
							<label class="form-check-label" for="flexCheckDefault"> 상품 번호 : <%=ohdtos.get(i).getP_id()%><br></label>
					</div>
					<!-- 상품 이미지 -->
					<div class="col-2" align="left">
						<img src="<%=ohdtos.get(i).getImg_thum() %>" width="100" height="150">
					</div>
					<!-- 상품 정보 -->
					<div class="col-4" align="left" style="padding: 20px 0px 0px 0px;">
						상품 이름 : <%=ohdtos.get(i).getP_name() %><br>
						상품 분류 : <%=ohdtos.get(i).getCtg_sub() %><br>
						상품 색상 : <%=ohdtos.get(i).getP_colorname() %><br>
						상품 사이즈 : <%=ohdtos.get(i).getP_size() %><br>
						<br>
					</div>
					<!-- 상품 가격 -->
					<div class="col -2" align="right" style="padding: 40px 0px 0px 0px;">
						<p>상품 가격 : <%= comma(ohdtos.get(i).getP_price()) %>원</p>
					</div>
				</div>
			</div>
			<hr width="1350">
			<!-- 인덱스 0 만 따로 출력 끝 -->
			
<%
			
			
				// i 가 0 이 아니고 주문번호 가 다를 떄 
			}else if ( ohdtos.get(i).getUo_id() != ohdtos.get(i-1).getUo_id()){
				contentCount += 1;
				if(contentCount == contentsNumPerPage +1 ){
					break;
				}
				
%>
				<div class="container">
					<div class="row">
						<div class="col-2" style="padding: 35px 0px 0px 0px;">
								<label class="form-check-label" for="flexCheckDefault"> 주문 번호 : <%=ohdtos.get(i).getUo_id()%><br></label>
									
									
						</div>
		
						<!-- 수령자 정보 -->
						<div class="col-4" align="left">
							
							받는이 : <%= ohdtos.get(i).getUo_name() %><br>
							휴대폰 : <%=ohdtos.get(i).getUo_tel() %><br>
							주소 : <%=ohdtos.get(i).getUo_address()%><br>
							상세주소 : <%=ohdtos.get(i).getUo_specificaddress()%><br>
							
						</div>	
						<div class="col-3" align="right">
						</div>
						<!-- 결제 내역 -->
						<div class="col -2" align="right">
							결제수단 : <%=ohdtos.get(i).getUo_paymentmethod() %><br>
							배송료 : <%=comma(ohdtos.get(i).getUo_shippingfee()) %>원<br>
							주문 금액 : <%=comma( ohdtos.get(i).getUo_discountedamount()) %>원<br>
							결제 금액 : <%=comma(ohdtos.get(i).getUo_shippingfee() + ohdtos.get(i).getUo_discountedamount() )%>원<br>
						</div>
					</div>
				</div>
				<hr width="1350">
		<%
			} // 안쪽 if문 끝 
		%>
			<div class="container">
				<div class="row">
					<div class="col-1" style="padding: 55px 0px 0px 0px;">
						<%-- <input class="form-check-input" type="checkbox" name="cartchoice" value="${dtos.cd_id}" id="flexCheckDefault">  --%>
						
					</div>
					<div class="col-2" style="padding: 50px 0px 0px 0px;">
							<label class="form-check-label" for="flexCheckDefault"> 주문상세 번호 : <%=ohdtos.get(i).getUod_id()%><br></label><br>
							<label class="form-check-label" for="flexCheckDefault"> 상품 번호 : <%=ohdtos.get(i).getP_id()%><br></label>
					</div>
					<!-- 상품 이미지 -->
					<div class="col-2" align="left">
						<img src="<%=ohdtos.get(i).getImg_thum() %>" width="100" height="150">
					</div>
					<!-- 상품 정보 -->
					<div class="col-4" align="left" style="padding: 20px 0px 0px 0px;">
						상품 이름 : <%=ohdtos.get(i).getP_name() %><br>
						상품 분류 : <%=ohdtos.get(i).getCtg_sub() %><br>
						상품 색상 : <%=ohdtos.get(i).getP_colorname() %><br>
						상품 사이즈 : <%=ohdtos.get(i).getP_size() %><br>
						<br>
					</div>
					<!-- 상품 가격 -->
					<div class="col -2" align="right" style="padding: 40px 0px 0px 0px;">
						<p>상품 가격 : <%=comma(ohdtos.get(i).getP_price()) %>원</p>
					</div>
				</div>
			</div>
			<hr width="1350">
		<%
			
		
		}//for 문 끝
		%>
		
	</form> 
	<%
	}// 바깥 if 문 끝
	else {
		justcomment = "주문을 해야 내역이 있지 않을까요?!";
	}// 바깥 else 문 끝 
	%>
	<h1><%=justcomment %></h1>

</div>
	<div style="text-align:center;">
<%
		for(int i = 1 ; i <= allPageNum ; i++){
			
%>
			<a href="userOrderHistory.do?pageNum=<%=i%>" >[<%=i%>]</a>

<%
		}
%>
	</div>
		
	<%@ include file="/layout/footer.jsp"%>