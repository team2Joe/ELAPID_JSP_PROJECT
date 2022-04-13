<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%-- <%
//%@ include file="/layout/header.jsp"%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<script src="js/jquery.js"></script>
<meta name="google-signin-client_id"
	content="246093648725-rl5r5kcmpm4vh48r4k1l2rferndnjohm.apps.googleusercontent.com">

<meta charset="UTF-8">
<title>ELAPID</title>

<style type="text/css">
/* link - 아직 클릭하지 않은 경우 red 색상 설정 */
a:link {
	color: black;
	text-decoration: none;
}
/* visited - 한번 클릭하거나 전에 클릭한적 있을 경우 #c71d44 설정 */
a:visited {
	color: black;
	text-decoration: none;
}
/* hover - 마우스를 해당 링크에 위치했을 경우 #006DD7 설정 */
a:hover {
	color: #006DD7;
	text-decoration: none;
}
</style>
<!-- /*  구글 api 로그인 */ -->

</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="css/basic.css" rel="stylesheet" type="text/css" />
<body>

	<%
	String uid = "";
	uid = (String) session.getAttribute("uid");
	%>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="main.do">ELAPID</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown"
				aria-controls="navbarNavDarkDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a class="nav-link"
						onclick="navbtnlinkluggage()" id="navbarDarkDropdownMenuLink"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							캐리어 </a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
							<li><h5>&nbsp&nbsp크기</h5></li>
							<li></li>
							<li><a class="dropdown-item"
								href="middleView.do?ctg_middle=small">기내용</a></li>
							<li><a class="dropdown-item"
								href="middleView.do?ctg_middle=middle">중형수화물</a></li>
							<li><a class="dropdown-item"
								href="middleView.do?ctg_middle=large">대형수화물</a></li>
						</ul></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a class="nav-link"
						onclick="navbtnlinkbackpack()" id="navbarDarkDropdownMenuLink"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							백팩 </a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
							<li><a class="dropdown-item"
								href="backpackList.do?ctg_middle=비즈니스">비즈니스</a></li>
							<li><a class="dropdown-item"
								href="backpackList.do?ctg_middle=캐주얼">캐주얼</a></li>
							<li><a class="dropdown-item"
								href="backpackList.do?ctg_middle=other">other</a></li>
						</ul></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item dropdown">
						function전체리스트 <a class="nav-link"
						onclick="navbtnlinkfunction()" id="navbarDarkDropdownMenuLink"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							주요기능 </a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
							<li><h5>&nbsp&nbsp크기</h5></li>
							<li><a class="dropdown-item"
								href="functionList.do?p_mainf=서스펜션휠">서스펜션 휠</a></li>
							<li><a class="dropdown-item"
								href="functionList.do?p_mainf=자동제어장치">자동제어장치</a></li>
							<li><a class="dropdown-item"
								href="functionList.do?p_mainf=지문인식">지문인식 장치</a></li>
							<li><a class="dropdown-item"
								href="functionList.do?p_mainf=rfid">RFID</a></li>
						</ul>
					</li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDarkDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 트렌드 </a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDarkDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 프레스 </a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a class="nav-link"
						href="questionList.do" id="navbarDarkDropdownMenuLink"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							상품문의 </a></li>
				</ul>
			</div>
			<div class="col-md-3" style="text-align: right;">
				<ul class="navbar-nav" style="width: 500px;">
					<li class="nav-item dropdown"><a class="nav-link"
						id="navbarDarkDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">
							${sessionScope.comment } </a></li>
					<%
					try {
						if (!uid.equals("")) {
					%>
					<li class="nav-item dropdown"><a href="logout.do"
						class="nav-link"> <U>log out</U>
					</a></li>
					<%
					}
					} catch (Exception e) {
					}
					%>
					<li class="nav-item dropdown"><a class="nav-link"
						id="navbarDarkDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> 회원 </a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
							<%
							try {
								if (!uid.equals("")) {
							%>
							<li><a class="dropdown-item" href="myPage.do">마이페이지</a></li>
							<li><a class="dropdown-item" href="logout.do">로그 아웃</a></li>
							<%
							}
							%>
							<%
							} catch (Exception e) {
							%>
							<li><a class="dropdown-item" href="">주문내용확인</a></li>
							<li><a class="dropdown-item" href="loginForm.do">로그인하기</a></li>
							<%
							}
							%>

						</ul></li>
					<li class="nav-item dropdown"><a href="userCartView.do"
						class="nav-link" style="text-decoration: none"> <U>장바구니</U>
					</a></li>
				</ul>
			</div>
		</div>

		<div>
			<form class="d-flex" action="search.do" name="searchForm">
				<select name="category">
					<option value="p.p_name">상품명</option>
					<option value="p.p_size">사이즈</option>
					<option value="p.p_mainf">주요기능</option>
					<option value="s.ps_color">색상</option>
				</select> <input class="form-control me-sm-2" type="text"
					placeholder="Search" name="search" size="10">
				<buttons class="btn btn-secondary" type="submit">Search
				</button>
			</form>
		</div>

	</nav> --%>
<%@ include file="/layout/header.jsp"%>

	<!-- content에 자신의 OAuth2.0 클라이언트ID를 넣습니다. -->



	<div class="row" style="height: 700px">
		<div class="col-lg-7">
			<img alt="loginForm" src="elapid_img/loginform.jpeg" width="100%"
				height="100%">
		</div>
		<div class="col-lg-5">
			<form action="loginCheck.do" method="post">
				<div class="row"
					style="text-align: center; padding-top: 100px; padding-bottom: 100px">
					<h1>sign in</h1>
				</div>
				<div class="mb-3 row" style="text-algin: center;">
					<label style="width: 40%; height: 40px; text-align: right"
						for="inputPassword" class="col-sm-2 col-form-label">아이디 :
					</label>
					<div class="col-sm-3">
						<input type="text" name="uid" class="form-control" id="inputId"
							onkeyup="idformcheck()">
					</div>

				</div>
				<div class="mb-3 row">
					<label style="width: 40%; height: 40px; text-align: right"
						for="inputPassword" class="col-sm-2 col-form-label">비밀번호 :
					</label>
					<div class="col-sm-3">
						<input type="password" name="upassword" class="form-control"
							id="inputPassword">
					</div>
				</div>
				<div class="col-sm-6"
					style="width: 100%; height: 40px; text-align: center; padding-top: 50px">
					<input style="width: 20%; height: 40px; text-align: center;"
						type="submit" class="btn btn-dark" value="sign in">
				</div>
				<div class="col-sm-6"
					style="width: 100%; height: 40px; text-align: center; padding-top: 60px">
					<button style="width: 20%; height: 40px; text-align: center;"
						type="button" class="btn btn-dark"
						onclick="location.href='registerForm.do'">sign up</button>
					<br>
					

					

				</div>
				<div class="col-sm-6"
					style="width: 200%; height: 40px; text-align: center; padding: 100px 0px 0px 280px">
					<div class="g-signin2" style="width:250px" data-onsuccess="onSignIn"></div></div>
				</div>


			</form>
			<form action="googleLogin.do" id="gform" method='post'>
				<input type="hidden" name="gname" id="gname" value="1"> <input
					type="hidden" name="gemail" id="gemail" value="1"> <input
					type="hidden" name="gimg" id="gimg" value="1">
			</form>
		</div>
	</div>


	<%@ include file="/layout/footer.jsp"%>