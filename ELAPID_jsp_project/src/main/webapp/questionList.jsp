<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="layout/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<body>

<div style="text-align:center">
<br>
<h4>1:1 문의</h4>
<BR>
</div>

<table class="table w-auto" style="margin-left: auto; margin-right: auto;">
   <colgroup>
        <col width="150px"/>
        <col width="200px"/>
        <col width="400px"/>
    </colgroup>

  <thead>
    <tr>
      <th scope="col" class="text-center">번호</th>
      <th scope="col" class="text-center">카테고리</th>
      <th scope="col" class="text-center">제목</th>
      <td></td>
    </tr>
  </thead>
  <tbody>
  
   <c:forEach items="${questionList }" var ="dtos">
    <tr>
  	<td> ${dtos.pq_id}></td>
		<td> ${dtos.qc_name }</td>
		<td> ${dtos.pq_title }</td>
		<td></td>
    </tr>
   </c:forEach>
    <tr>
    <td></td>
    <td></td>
    <td></td>
    <td>
     <button type="button" class="btn btn-dark" onclick="qnawrite()" id="question" >문의하기</button>
  

</td>
    </tr>
  </tbody>
</table>


<script src="js/basic.js"></script>
</body>
</html>

<%@ include file="layout/footer.jsp" %>