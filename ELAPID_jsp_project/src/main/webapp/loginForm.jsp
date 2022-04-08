
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
<!DOCTYPE html>
<div class="row" style = "height:700px">
<div class = "col-lg-7" >
	<img alt="loginFormImg" src="elapid_img/loginform.jpeg" width="100%" height="100%">
</div>
<div class = "col-lg-5">
	<form action="loginCheck.do"  method="post">
	  <div class="row" style =  "text-align:center;padding-top:100px;padding-bottom:100px" >
	  	<h1 >sign in</h1>
	  </div>
	  <div class="mb-3 row" style= "text-algin:center;">
	    <label style="width:40%; height:40px; text-align:right"  for="inputPassword" class="col-sm-2 col-form-label">아이디 : </label>
	    <div class="col-sm-3">
	      <input type="text" name="uid" class="form-control" id="inputId" onkeyup="idformcheck()">
	    </div>

	  </div>
	  <div class="mb-3 row">
	    <label style="width:40%; height:40px; text-align:right" for="inputPassword" class="col-sm-2 col-form-label">비밀번호 : </label>
	    <div class="col-sm-3">
	      <input type="password" name="upassword" class="form-control" id="inputPassword">
	    </div>
	  </div>
	  <div class="col-sm-6" style="width:100%; height:40px; text-align:center; padding-top:50px" >
	  	<input style="width:20%; height:40px; text-align:center; " type="submit" class="btn btn-dark" value="sign in" >
	  </div>
	  <div class="col-sm-6" style="width:100%; height:40px; text-align:center; padding-top:60px" >
	  	<button style="width:20%; height:40px; text-align:center; " type="button" class="btn btn-dark" onclick = "location.href='registerForm.do'">sign up</button>
	  </div>
	
	</form>
</div>
</div>
  
  
	
<%@ include file="/layout/footer.jsp"%>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="js/basic.js"></script>
	