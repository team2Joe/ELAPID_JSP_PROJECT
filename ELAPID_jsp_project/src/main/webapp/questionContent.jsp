<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><h3>1:1 문의하기</h3></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<style>
    #wrapper{
        width:500px;
        margin:auto;
    }
</style>
</head>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<body>

<body>
<Form action="questionModify.do" id ="contentForm">



  <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlSelect1"><h6>문의 유형 분류</h6> </label>
    	<input type="hidden" name="pq_id" value = "${dto.pq_id }">
    <select class="form-control" id="exampleFormControlSelect1" name="qc_name">
      			<c:if test="${dto.qc_name.equals('회원정보') }">
						<option selected>회원정보</option>
					</c:if>
					<c:if test="${!dto.qc_name.equals('회원정보') }">
						<option>회원정보</option>
					</c:if>
					<c:if test="${dto.qc_name.equals('주문/결제') }">
						<option selected>주문/결제</option>
					</c:if>
					<c:if test="${!dto.qc_name.equals('주문/결제') }">
						<option>주문/결제</option>
					</c:if>
					<c:if test="${dto.qc_name.equals('취소/교환/반품') }">
						<option selected>취소/교환/반품</option>
					</c:if>
					<c:if test="${!dto.qc_name.equals('취소/교환/반품') }">
						<option>취소/교환/반품</option>
					</c:if>
					<c:if test="${dto.qc_name.equals('AS') }">
						<option selected>AS</option>
					</c:if>
					<c:if test="${!dto.qc_name.equals('AS') }">
						<option>AS</option>
					</c:if>
					<c:if test="${dto.qc_name.equals('기타') }">
						<option selected>기타</option>
					</c:if>
					<c:if test="${!dto.qc_name.equals('기타') }">
						<option>기타</option>
					</c:if>
					</select>
     <%--  <option <%=if() %> value="qinfo">회원정보</option>
      <option <%=select %>  value="qorder">주문/결제</option>
      <option value="qcer">취소/교환/반품</option>
      <option value="qas">AS</option>
      <option value="qetc">기타</option>
    </select> --%>
  </div>
   <br>
 <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlInput1"><h6>문의 제목</h6></label>
    <input type="text" class="form-control" name="pq_title" id="exampleFormControlInput1" value = "${dto.pq_title }" >
	
  </div>
   <br>
    <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlTextarea1"><h6>문의 내용</h6></label>
    <textarea class="form-control" name="pq_content" id="exampleFormControlTextarea1"   rows="10">${dto.pq_content }</textarea>
  </div>
  
<br>

</Form>
   <table border="0" width="600" height="10" id="wrapper">
    <tr>
    <td align=right>
     <button type="button" class="btn btn-secondary" onclick="qnamodify()">수정하기</button></td>
     
     
     <td>
     <button type="button" class="btn btn-dark" onclick="qnadelete()">삭제하기</button></td>
     </tr></table>

<script src="js/basic.js"></script>
</body>
</html>
<%@ include file="layout/footer.jsp" %>