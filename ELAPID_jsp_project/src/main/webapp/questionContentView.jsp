<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<Form>


  <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlSelect1"><h6>문의 유형 분류</h6> </label>
    <select class="form-control" id="exampleFormControlSelect1" name="qc_name">
       <option selected>선택해주세요.</option>
      <option value="qinfo">회원정보</option>
      <option value="qorder">주문/결제</option>
      <option value="qcer">취소/교환/반품</option>
      <option value="qas">AS</option>
      <option value="qetc">기타</option>
    </select>
  </div>
   <br>
 <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlInput1"><h6>문의 제목</h6></label>
    <input type="text" class="form-control" id="exampleFormControlInput1" >
  </div>
   <br>
    <div class="col-sm-5 my-1" id="wrapper">
    <label for="exampleFormControlTextarea1"><h6>문의 내용</h6></label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
  </div>
  
<br>

</Form>
   <table border="0" width="600" height="10" id="wrapper">
    <tr>
    <td align=right>
     <button type="button" class="btn btn-secondary" onclick="qnaregister()" >취소하기</button></td>
     <td>
     <button type="button" class="btn btn-dark" onclick="qnaregister()">등록하기</button></td>
     </tr></table>

<script src="js/basic.js"></script>
</body>
</html>