<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ELAPID</title>
</head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="css/basic.css" rel="stylesheet" type="text/css" />
<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	

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
	            <li><a class="dropdown-item" href="middleView.do?p_ctgmiddle=small">기내용</a></li>
	            <li><a class="dropdown-item" href="middleView.do?p_ctgmiddle=middle">중형수화물</a></li>
	            <li><a class="dropdown-item" href="middleView.do?p_ctgmiddle=large">대형수화물</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" onclick="nnavbtnlinkbackpack()" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	백팩
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	            <li><a class="dropdown-item" href="middleView.do?p_ctgmiddle=business">비즈니스</a></li>
	            <li><a class="dropdown-item" href="middleView.do?p_ctgmiddle=casual">캐주얼</a></li>
	            <li><a class="dropdown-item" href="middleView.do?p_ctgmiddle=other">기타</a></li>
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
	          <a class="nav-link" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	상품문의
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	            <li><a class="dropdown-item" href="#">Action</a></li>
	            <li><a class="dropdown-item" href="#">Another action</a></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div>

	    <div>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            회원
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	            <li><a class="dropdown-item" href="">주문내용확인</a></li>
	            <li><a class="dropdown-item" href="">마이페이지</a></li>
	            <li><a class="dropdown-item" href="loginForm.do">로그인하기</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
    <div>
    	
   		<form class="d-flex" action="search.do">
        <input class="form-control me-sm-2" type="text" placeholder="Search" name="search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>