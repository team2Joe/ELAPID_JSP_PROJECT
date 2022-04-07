<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="/layout/header.jsp"%>

<script language="javascript">
	// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
	//document.domain = "abc.go.kr";

	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
			roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
			detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
			buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
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


<div class="container">
	<div class="row justify-content-md-center">
		<div class="col col-lg-1">1/3</div>
		<div class="col-md-auto" style="text-align: center;">
			<div style="padding-top: 100px; padding-bottom: 100px; width: 1000px">
				<h1>회원정보 입력</h1>
			</div>
			<div style="padding-left : 100px">
			<form class="register" id="registerModifyForm" action="registerModify.do" method="post">


				<div class="mb-3 row" style="padding-left: 33px;">
					<label for="inputPassword" class="col-sm-2 col-form-label">
						이름 : </label>
					<div class="col-sm-3" style="padding-left: 32px;">
						<input type="text" class="form-control" name="uname"
							id="inputName" onkeyup="nameformcheck()"
							value="${registerjoindto.reg_name}">
					</div>
					<div class="col-sm-6 " id="namecondition">한글 정자로 기입해주세요.</div>
				</div>

				<div class="mb-3 row" style="padding-left: 33px;">
					<label for="inputPassword" class="col-sm-2 col-form-label">
						휴대폰 : </label>
					<div class="col-sm-3" style="padding-left: 32px;">
						<input type="text" class="form-control" name="utel" id="inputTel"
							onkeyup="telformcheck()" value="${registerjoindto.reg_tel}">
					</div>
					<div class="col-sm-6 " id="telcondition">(ex 010-1234-1234)</div>
				</div>

				<div class="mb-3 row">
					<div>
						<div id="list"></div>
						<div id="callBackDiv">
							<table>

								<tr>
									<td>우편번호</td>
									<td
										style="text-align: left; padding-left: 35px; padding-top: 5px;"><input
										type="text" style="width: 100px;" id="zipNo" name="zipNo"
										readonly="readonly" /> <input type="button"
										class="btn btn-dark" onClick="goPopup();" value="주소 찾기 " /></td>
								</tr>
								<tr>
									<td style="padding-right: 13px">도로명주소 전체</td>
									<td style="padding-left: 35px; padding-bottom: 7px;"><input
										type="text" style="width: 400px;" id="roadFullAddr"
										name="roadFullAddr" value = "" readonly="readonly" /></td>
								</tr>
								<tr>
									<td>지번</td>
									<td style="padding-left: 35px; padding-bottom: 7px;"><input
										type="text" style="width: 400px;" id="jibunAddr"
										name="jibunAddr" value = "${registerjoindto.add_address}" readonly="readonly" /></td>
								</tr>
								<tr>
									<td style="padding-left: 25px; padding-right: 20px">고객입력
										상세주소 :</td>
									<td style="padding-left: 35px; padding-bottom: 7px;"><input
										type="text" style="width: 400px;" id="addrDetail" value="${registerjoindto.reg_specificaddress}"
										name="addrDetail" /></td>
								</tr>
							</table>
						</div>
						<div class="col-sm-8 " id="addresscondition">주소와 상세주소를
							기입해주세요.</div>

					</div>
				</div>
				<div>
				<button type="button"  class="btn btn-dark" onclick = "registerModifyCheck()" >추가하기</button>
				</div>
				
				<input type="hidden" name="add_id" value="${registerjoindto.add_id}">
			</form>
			</div>
		<div></div>
	</div>
	<div class="col col-lg-1">3/3</div>
</div>

</div>



<%@ include file="/layout/footer.jsp"%>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script src="js/basic.js"></script>
<script src="js/login.js?ver=5"></script>