<%@page import="com.elapid.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="/layout/header.jsp"%>

<script language="javascript">
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.getElementById("roadFullAddr").value = roadFullAddr;
		document.getElementById("addrDetail").value = addrDetail;
		document.getElementById("jibunAddr").value = jibunAddr;
		document.getElementById("zipNo").value = zipNo;
/* 		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.roadAddrPart2.value = roadAddrPart2; */
//		document.form.addrDetail.value = addrDetail;
/* 		document.form.engAddr.value = engAddr; */
//		document.form.jibunAddr.value = jibunAddr;
//		document.form.zipNo.value = zipNo;
/*		document.form.admCd.value = admCd;
		document.form.rnMgtSn.value = rnMgtSn;
		document.form.bdMgtSn.value = bdMgtSn;
		document.form.detBdNmList.value = detBdNmList; */
		/** 2017년 2월 추가제공 **/
/* 		document.form.bdNm.value = bdNm;
		document.form.bdKdcd.value = bdKdcd;
		document.form.siNm.value = siNm;
		document.form.sggNm.value = sggNm;
		document.form.emdNm.value = emdNm;
		document.form.liNm.value = liNm;
		document.form.rn.value = rn;
		document.form.udrtYn.value = udrtYn;
		document.form.buldMnnm.value = buldMnnm;
		document.form.buldSlno.value = buldSlno;
		document.form.mtYn.value = mtYn;
		document.form.lnbrMnnm.value = lnbrMnnm;
		document.form.lnbrSlno.value = lnbrSlno;
		/** 2017년 3월 추가제공 **/
/*		document.form.emdNo.value = emdNo; 
*/
		
}


</script>
<% 
	UserDto dto = new UserDto(); 
	dto = (UserDto)request.getAttribute("profiledto");
%>

<div class="container">
  <div class="row justify-content-md-center">
    <div class="col col-lg-1">
      1/3
    </div>
    <div class="col-md-auto" style = "text-align:center;">
    	<div style="padding-top:100px; padding-bottom:100px; width: 1000px">
	    	<h1> 회원정보 입력 </h1>
    	</div>
      	<form class="register" id="usermodifyForm" action="profileModify.do" method="post">
			
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">아이디 : </label>
		    <div class="col-sm-2">
		      <input type="text" class="form-control" name="uid" id="userid" onkeyup="idformcheck()" readonly="readonly" value = "${sessionScope.uid}">
		    </div>

		  </div>
		  
		  
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호 : </label>
		    <div class="col-sm-3">
		      <input type="password" class="form-control" name="upassword" id="inputPassword" onkeyup="passwordformcheck()" >
		    </div>
		    <div class = "col-sm-7" id="pwdcondition"> 8~12자 영문/숫자/특수문자 조합으로 작성해주세요.
	        </div>
		  </div>
		  
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호 확인 : </label>
		    <div class="col-sm-3">
		      <input type="password" class="form-control" name="upasswordtwo" id="inputPassword2" onkeyup="passwordformcheck2()">
		    </div>
  		    <div class = "col-sm-6 " id="pwdcondition2"> 다시 한 번 작성해주세요.
	        </div>
		  </div>
		  
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label"> 이름 : </label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" name="uname" id="inputName" onkeyup="nameformcheck()" readonly="readonly" value="${profiledto.u_name}">
			</div>
	      </div>
	      
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label"> 이메일 : </label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" name="uemail" id="inputEmail" onkeyup="emailformcheck()" value="${profiledto.u_email}">
			</div>
  		    <div class = "col-sm-6 " id="emailcondition">
  		    	이메일 형식으로 작성해주세요. 
	        </div>
	      </div>
	      
	     <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label"> 휴대폰 : </label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" name="utel" id="inputTel" onkeyup="telformcheck()" value="${profiledto.u_tel}">
			</div>
  		    <div class = "col-sm-6 " id="telcondition">
  		    	(ex 010-1234-1234) 
	        </div>
		  </div>
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label"> 성별 : </label>
		    <div class="col-sm-3" style="padding-top:10px" >
		    <%
		    	String gender = dto.getU_gender();
			   	if(gender.equals("male")){
			%>
  		    	<input type="radio" name = "ugender" value = "male" checked="checked" readonly="readonly"> 남 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  		    	<input type="radio" name = "ugender" value = "female" readonly="readonly"> 여
		    <%
			   	}else{
		    %>
		      	<input type="radio" name = "ugender" value = "male"  readonly="readonly"> 남 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  		    	<input type="radio" name = "ugender" value = "female" checked="checked" readonly="readonly"> 여
		    <%
			   	}
		    %>
			</div>
  		    <div class = "col-sm-6 " id="telcondition">
  		    	 
	        </div>
		  </div>
		  <div class="mb-3 row">
		    <div class="col-sm-2">
		    	생년월일 :
		    </div>
		    <div class="col-sm-3"> 
				<%
					
					
					
					String birthdate = dto.getU_birthdate();
					String year = birthdate.substring(0,4);
					String month = birthdate.substring(5,7);
					String day = birthdate.substring(8);
					
				%>
  		    	<input type="text"  name="birthyear" id="inputBirthYear" onkeyup="modbirthformcheck()" maxlength="4" size = "4px" value="<%=year %>" > 년 
  		    	&nbsp
  		    	<input type="text"  name="birthmonth" id="inputBirthMonth" onkeyup="modbirthformcheck()" maxlength="2" size = "2px" value="<%=month%>"> 월 
  		    	&nbsp
  		    	<input type="text"  name="birthday" id="inputBirthDay" onkeyup="modbirthformcheck()" maxlength="2" size="2px" value="<%=day%>"> 일 
			</div>

  		    <div class = "col-sm-5" id="birthcondition">
  		    	(ex) 1990년 09월 12일
	        </div>
	  
		  </div>
		  <div>
		  	<input type="hidden" id="idcheckresult" value="${sessionScope.idcheckresult}">
		  	<button type="button" class="btn btn-dark" onclick="modifycheck()"> 수정하기 </button> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="button" class="btn btn-dark" onclick="userdelete()"> 탈퇴하기 </button>
		  </div>
		  <div>
		  	
		  </div>
		</form>
		
    </div>
    <div class="col col-lg-1">
      3/3
    </div>
  </div>

</div>


 
  
	
<%@ include file="/layout/footer.jsp"%>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="js/basic.js"></script>
	<script src="js/login.js"></script>