<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
//%@ include file="/layout/header.jsp"%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta name ="google-signin-client_id" content="246093648725-rl5r5kcmpm4vh48r4k1l2rferndnjohm.apps.googleusercontent.com">

<meta charset="UTF-8">

<title>ELAPID</title>

<style type="text/css">
 /* link - 아직 클릭하지 않은 경우 red 색상 설정 */
 a:link { color: black; text-decoration: none;}	
 /* visited - 한번 클릭하거나 전에 클릭한적 있을 경우 #c71d44 설정 */
 a:visited { color: black; text-decoration: none;}	
 /* hover - 마우스를 해당 링크에 위치했을 경우 #006DD7 설정 */
 a:hover { color: #006DD7; text-decoration: none;}
</style>
<script type="text/javascript">
	
	function searchNullCheck(){
		
		var search = document.getElementById("searchForm").value;
		
		if(search == ''){
			alert('검색어를 입력해주세요')
			
			return false;
		}else{
			search.submit()
		}
	}


</script>
</head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="css/basic.css" rel="stylesheet" type="text/css" />
<body>

	          <%
	          	String uid =""; 
		          	uid = (String)session.getAttribute("uid");
		        String gresult = "";
		        	gresult = (String)session.getAttribute("gresult");
		        if(session.getAttribute("gresult") == null){
		        	gresult = "";
		        }
		      %>
		      
		      

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="main.do">ELAPID</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" onclick="navbtnlinkluggage()" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            캐리어
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	            <li><h5>&nbsp&nbsp크기</h5></li>
	            <li></li>
	            <li><a class="dropdown-item" href="middleView.do?ctg_middle=small">기내용</a></li>
	            <li><a class="dropdown-item" href="middleView.do?ctg_middle=middle">중형수화물</a></li>
	            <li><a class="dropdown-item" href="middleView.do?ctg_middle=large">대형수화물</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" onclick="navbtnlinkbackpack()" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	백팩
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	            <li><a class="dropdown-item" href="middleView.do?ctg_middle=business">비즈니스</a></li>
	            <li><a class="dropdown-item" href="middleView.do?ctg_middle=casual">캐주얼</a></li>
	            <li><a class="dropdown-item" href="middleView.do?ctg_middle=other">other</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	        								<%-- function전체리스트 --%>
	          <a class="nav-link" onclick="navbtnlinkfunction()" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	주요기능
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	          	<li><h5>&nbsp&nbsp크기</h5></li>
	            <li><a class="dropdown-item" href="functionList.do?p_mainf=서스펜션휠">서스펜션 휠</a></li>
	            <li><a class="dropdown-item" href="functionList.do?p_mainf=자동제어장치">자동제어장치</a></li>
	            <li><a class="dropdown-item" href="functionList.do?p_mainf=지문인식">지문인식 장치</a></li>
	            <li><a class="dropdown-item" href="functionList.do?p_mainf=rfid">RFID</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	트렌드
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	            <li><a class="dropdown-item" href="#">Action</a></li>
	            <li><a class="dropdown-item" href="#">Another action</a></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	프레스
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	            <li><a class="dropdown-item" href="#">Action</a></li>
	            <li><a class="dropdown-item" href="#">Another action</a></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" onclick="location.href='questionList.do'" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	상품문의
	          </a>
	        </li>
	      </ul>
	    </div>
	    <div class = "col-md-3" style = "text-align:right;">
	      <ul class="navbar-nav" style = "width:500px;">
	        <li class="nav-item dropdown">
	          <a class="nav-link" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            ${sessionScope.comment }
	          </a>
	        </li>
	        <%
	          	try{
	          		if(!uid.equals("") && gresult.equals("1")){
	          		
	        %>
	        <li class="nav-item dropdown">
	          <a onclick = "signOut();" class="nav-link">
	          
	            <U>log out</U>
	          </a>
	        </li>
			<%
	          		}else if(!uid.equals("") && gresult.equals("")){
	          			
	         %>
	        <li class="nav-item dropdown">
	          <a href="logout.do" class="nav-link">
	            <U>log out</U>
	          </a>
	        </li> 			
	          			
	          			
	          			<%
	          		}
	          	}catch(Exception e){
	          	}
	          			
			%>
	        <li class="nav-item dropdown">
	          <a class="nav-link" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            회원
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
		      <%
	          	try{
	         	 	if(!uid.equals("")){
	          		
	          %>
	            <li><a class="dropdown-item" href="myPage.do">마이페이지</a></li>
	            <li><a class="dropdown-item" href="logout.do">로그 아웃</a></li>
			  <%
	          		}
			  %>	          		
			  <%
	          	}catch(Exception e){
	          		
			  %>
	            <li><a class="dropdown-item" href="">주문내용확인</a></li>
	            <li><a class="dropdown-item" href="loginForm.do">로그인하기</a></li>
	          <%
	          	}
	          %>
	          	
	          </ul>
	        </li>

	        <li class="nav-item dropdown">
	          <a href="userCartView.do" class="nav-link" style="text-decoration:none">
	            <U>장바구니</U>
	          </a>
	        </li>
	      </ul>
	    </div>
	  </div>

	  <div>
	  <form class="d-flex" action="search.do" >
	  	<select name="category">
	  		<option value="p.p_name">상품명</option>
	  		<option value="p.p_size">사이즈</option>
	  		<option value="p.p_mainf">주요기능</option>
	  		<option value="s.ps_color">색상</option>
	  	</select>
        <input class="form-control me-sm-2" type="text" placeholder="Search" name="search" id="searchForm" size="10">
        <button class="btn btn-secondary" onclick="return searchNullCheck()">Search</button>
      </form>
    </div>

	</nav>


