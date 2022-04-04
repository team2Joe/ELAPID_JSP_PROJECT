<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/layout/header.jsp"%>

<div class="container">
  <div class="row justify-content-md-center">
    <div class="col col-lg-1">
      1/3
    </div>
    <div class="col-md-auto" style = "text-align:center;">
    	<div style="padding-top:100px; padding-bottom:100px; width: 1000px">
	    	<h1> 회원정보 입력 </h1>
    	</div>
      	<form class="register" action="main.do" method="post">
			
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">아이디 : </label>
		    <div class="col-sm-2">
		      <input type="text" class="form-control" id="userid" onkeyup="idformcheck()">
		    </div>
		    <div class="col-sm-2">
		      <button id="idcheck" onclick="idcheck()">중복체크</button>
		    </div>
		    <div class = "col-sm-5"> 영문시작 총 6~12자 영문/숫자 혼합으로 작성해주세요.
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
		    <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Email address</label>
		    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
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
