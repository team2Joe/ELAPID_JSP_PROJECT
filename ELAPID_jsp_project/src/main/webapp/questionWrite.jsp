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
<script type ="text/javascript">



</script>

<body>
<Form name="insertForm" action="questionWrite.do" method="post" id="qnaWriteForm" enctype="multipart/form-data" >
  <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlSelect1"><h6>문의 유형 분류</h6> </label>
    <select class="form-control" id="exampleFormControlSelect1" name="qc_name">
      <option value="선택" selected> 선택해주세요. </option>
      <option value="회원정보">회원정보</option>
      <option value="주문/결제">주문/결제</option> 
      <option value="취소/교환/반품">취소/교환/반품</option>
      <option value="AS">AS</option>
      <option value="기타">기타</option>
    </select>
  </div>
   <br>
 <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlInput1"><h6>문의 제목</h6></label>
    <input type="text" name="pq_title" class="form-control" id="exampleFormControlInput1" >
  </div>
   <br>
   <div class="col-sm-5 my-1" id="wrapper">
   	이미지 : <input type="file" name="fileName1" ><br>
   	(*.jpg , *.png, *.jpeg 파일만 업로드 가능)
   </div>
    <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlTextarea1"><h6>문의 내용</h6></label>
    <textarea class="form-control" name="pq_content" id="exampleFormControlTextarea1" rows="10"></textarea>
  </div>
  
<br>

   <table border="0" width="600" height="10" id="wrapper">
    <tr>
    <td align=right>
     <button  class="btn btn-secondary" onclick="location.href='questionList.do'" >취소하기</button></td>
     <td> 
     <button type="button" class="btn btn-dark" onclick="go()">등록하기</button></td>    <!--qnaregister()  -->
     </tr></table>
</Form>
    
    
    <br><br><br><br><br><br>
     

<script src="js/basic.js?ver=4"></script>
</body>
</html>
<%@ include file="layout/footer.jsp" %>
