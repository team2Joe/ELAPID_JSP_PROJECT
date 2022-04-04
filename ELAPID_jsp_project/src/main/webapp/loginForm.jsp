<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/layout/header.jsp"%>

<form class="register" action="main.do" method="post">

  <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-2 col-form-label">아이디 : </label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="userid">
    </div>
    <div class="col-sm-2">
      <button id="idcheck" onclick="idcheck()">중복체크</button>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호 : </label>
    <div class="col-sm-3">
      <input type="password" class="form-control" id="inputPassword">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호 확인 : </label>
    <div class="col-sm-3">
      <input type="password" class="form-control" id="inputPassword">
    </div>
  </div>
  
</form>
  
 
  
	
<%@ include file="/layout/footer.jsp"%>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="js/basic.js"></script>
	<script src="js/login.js"></script>
