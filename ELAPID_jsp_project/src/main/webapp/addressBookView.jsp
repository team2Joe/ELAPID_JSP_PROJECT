<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<script>//common/scripts.isml</script>
<script defer type="text/javascript"
	src="js/samso/main.js"></script>
<meta charset="UTF-8" />

<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
<title>My Account </title>

<link rel="preload" href="css/samso/global.css" as="style" />
<link rel="stylesheet" href="css/samso/global.css" />
<link rel="preload" href="css/samso/account/dashboard.css" as="style" />
<link rel="stylesheet" href="css/samso/account/dashboard.css" />
<link rel="preconnect" href="https://www.googletagmanager.com">
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw62e44eb6/images/favicons/favicon-196x196.png" sizes="196x196" />
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw90e8707c/images/favicons/favicon-96x96.png" sizes="96x96" />
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw320de43b/images/favicons/favicon-32x32.png" sizes="32x32" />
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw6a06a6e7/images/favicons/favicon-16x16.png" sizes="16x16" />
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw2aa3899b/images/favicons/favicon-128.png" sizes="128x128" />
<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-72704116-2"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	window.gtmObject = window.gtmObject ? window.gtmObject : {
		"currencyCode" : "KRW"
	};
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());
	gtag('config', 'UA-72704116-2', {
		"send_page_view" : false,
		"currency" : "KRW"
	});
	gtag('config', 'AW-925417941');
</script>
<script>
	(function(w, d, s, l, i) {
		w[l] = w[l] || [];
		w[l].push({
			'gtm.start' : new Date().getTime(),
			event : 'gtm.js'
		});
		var f = d.getElementsByTagName(s)[0], j = d.createElement(s), dl = l != 'dataLayer' ? '&l='
				+ l
				: '';
		j.async = true;
		j.src = 'https://www.googletagmanager.com/gtm.js?id=' + i + dl;
		f.parentNode.insertBefore(j, f);
	})(window, document, 'script', 'dataLayer', 'GTM-MQN3KMD');
</script>

<script type="text/javascript">
	/* <![CDATA[ (head-active_data.js) */
	var dw = (window.dw || {});
	dw.ac = {
		_analytics : null,
		_events : [],
		_category : "",
		_searchData : "",
		_anact : "",
		_anact_nohit_tag : "",
		_analytics_enabled : "true",
		_timeZone : "Asia/Seoul",
		_capture : function(configs) {
			if (Object.prototype.toString.call(configs) === "[object Array]") {
				configs.forEach(captureObject);
				return;
			}
			dw.ac._events.push(configs);
		},
		capture : function() {
			dw.ac._capture(arguments);
			// send to CQ as well:
			if (window.CQuotient) {
				window.CQuotient.trackEventsFromAC(arguments);
			}
		},
		EV_PRD_SEARCHHIT : "searchhit",
		EV_PRD_DETAIL : "detail",
		EV_PRD_RECOMMENDATION : "recommendation",
		EV_PRD_SETPRODUCT : "setproduct",
		applyContext : function(context) {
			if (typeof context === "object"
					&& context.hasOwnProperty("category")) {
				dw.ac._category = context.category;
			}
			if (typeof context === "object"
					&& context.hasOwnProperty("searchData")) {
				dw.ac._searchData = context.searchData;
			}
		},
		setDWAnalytics : function(analytics) {
			dw.ac._analytics = analytics;
		},
		eventsIsEmpty : function() {
			return 0 == dw.ac._events.length;
		}
	};
	/* ]]> */
// -->
</script>
<script type="text/javascript">
	/* <![CDATA[ (head-cquotient.js) */
	var CQuotient = window.CQuotient = {};
	CQuotient.clientId = 'aawq-MonoSamsoniteKR';
	CQuotient.realm = 'AAWQ';
	CQuotient.siteId = 'MonoSamsoniteKR';
	CQuotient.instanceType = 'prd';
	CQuotient.locale = 'ko_KR';
	CQuotient.fbPixelId = '__UNKNOWN__';
	CQuotient.activities = [];
	CQuotient.cqcid = '';
	CQuotient.cquid = '';
	CQuotient.cqeid = '';
	CQuotient.cqlid = '';
	/* Turn this on to test against Staging Einstein */
	/* CQuotient.useTest= true; */
	CQuotient.initFromCookies = function() {
		var ca = document.cookie.split(';');
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0) == ' ')
				c = c.substring(1, c.length);
			if (c.indexOf('cqcid=') == 0) {
				CQuotient.cqcid = c.substring('cqcid='.length, c.length);
			} else if (c.indexOf('cquid=') == 0) {
				var value = c.substring('cquid='.length, c.length);
				if (value) {
					var split_value = value.split("|", 3);
					if (split_value.length > 0) {
						CQuotient.cquid = split_value[0];
					}
					if (split_value.length > 1) {
						CQuotient.cqeid = split_value[1];
					}
					if (split_value.length > 2) {
						CQuotient.cqlid = split_value[2];
					}
				}
			}
		}
	}
	CQuotient.getCQCookieId = function() {
		if (window.CQuotient.cqcid == '')
			window.CQuotient.initFromCookies();
		return window.CQuotient.cqcid;
	};
	CQuotient.getCQUserId = function() {
		if (window.CQuotient.cquid == '')
			window.CQuotient.initFromCookies();
		return window.CQuotient.cquid;
	};
	CQuotient.getCQHashedEmail = function() {
		if (window.CQuotient.cqeid == '')
			window.CQuotient.initFromCookies();
		return window.CQuotient.cqeid;
	};
	CQuotient.getCQHashedLogin = function() {
		if (window.CQuotient.cqlid == '')
			window.CQuotient.initFromCookies();
		return window.CQuotient.cqlid;
	};
	CQuotient.trackEventsFromAC = function(/* Object or Array */events) {
		try {
			if (Object.prototype.toString.call(events) === "[object Array]") {
				events.forEach(_trackASingleCQEvent);
			} else {
				CQuotient._trackASingleCQEvent(events);
			}
		} catch (err) {
		}
	};
	CQuotient._trackASingleCQEvent = function( /* Object */event) {
		if (event && event.id) {
			if (event.type === dw.ac.EV_PRD_DETAIL) {
				CQuotient.trackViewProduct({
					id : '',
					alt_id : event.id,
					type : 'raw_sku'
				});
			} // not handling the other dw.ac.* events currently
		}
	};
	CQuotient.trackViewProduct = function(/* Object */cqParamData) {
		var cq_params = {};
		cq_params.cookieId = CQuotient.getCQCookieId();
		cq_params.userId = CQuotient.getCQUserId();
		cq_params.emailId = CQuotient.getCQHashedEmail();
		cq_params.loginId = CQuotient.getCQHashedLogin();
		cq_params.product = cqParamData.product;
		cq_params.realm = cqParamData.realm;
		cq_params.siteId = cqParamData.siteId;
		cq_params.instanceType = cqParamData.instanceType;
		cq_params.locale = CQuotient.locale;

		if (CQuotient.sendActivity) {
			CQuotient
					.sendActivity(CQuotient.clientId, 'viewProduct', cq_params);
		} else {
			CQuotient.activities.push({
				activityType : 'viewProduct',
				parameters : cq_params
				
			});
		}
	};
	/* ]]> */
// -->
	

</script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="css/basic.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
	          <%
	          	String uid =""; 
		          	uid = (String)session.getAttribute("uid");
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
	            <li><a class="dropdown-item" href="luggageList.do?ctg_middle=기내용">기내용</a></li>
	            <li><a class="dropdown-item" href="luggageList.do?ctg_middle=중형수화물">중형수화물</a></li>
	            <li><a class="dropdown-item" href="luggageList.do?ctg_middle=대형수화물">대형수화물</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" onclick="navbtnlinkbackpack()" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	백팩
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	            <li><a class="dropdown-item" href="backpackList.do?ctg_middle=비즈니스">비즈니스</a></li>
	            <li><a class="dropdown-item" href="backpackList.do?ctg_middle=캐주얼">캐주얼</a></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="navbar-nav">
	        <li class="nav-item dropdown">
	          <a class="nav-link" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	          	주요기능
	          </a>
	          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
	          	<li><h5>&nbsp&nbsp크기</h5></li>
	            <li><a class="dropdown-item" href="#">서스펜션 휠</a></li>
	            <li><a class="dropdown-item" href="#">자동제어장치</a></li>
	            <li><a class="dropdown-item" href="#">지문인식 장치</a></li>
	            <li><a class="dropdown-item" href="#">RFID</a></li>
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
	    <div class = "col-md-3" style = "text-align:right;">
	      <ul class="navbar-nav" style = "width:500px;">
	        <li class="nav-item dropdown">
	          <a class="nav-link" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            ${comment }
	          </a>
	        </li>
	        <%
	          	try{
	         	 	if(!uid.equals("")){
	          		
	        %>
	        <li class="nav-item dropdown">
	          <a href="logout.do" class="nav-link">
	          
	            <U>log out</U>
	          </a>
	        </li>
			<%
	          		}
	          	}catch(Exception e){
	          			e.printStackTrace();
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
	          		
	          		e.printStackTrace();
			  %>
	            <li><a class="dropdown-item" href="">주문내용확인</a></li>
	            <li><a class="dropdown-item" href="loginForm.do">로그인하기</a></li>
	          <%
	          	}
	          %>
	          	
	          </ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	${comment }
	<!-------------------------- END HEADER ---------------------------->
	<!-------------------------- END HEADER ---------------------------->
	<!-------------------------- END HEADER ---------------------------->
	
	<noscript>
		<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-MQN3KMD"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<div class="page" data-action="Account-Show" data-activelocale="ko_KR"
		data-querystring="">
		<div > 
			<div class="title-contain col-11" style="text-align:center; padding-top :100px;">
				<h1 >주소록</h1>
				<ul class="profile-level">

				</ul>
			</div>
		</div>
		<div class="container account-page">
			<div class="justify-content-center account-cards">
				<c:forEach var = "dto" items ="${registerdtos}">
					<div class="row order-card">
						<div class="text-card col-12 col-md-12">
							<table class="table table-borderless">
							  <tr >
							  	<td class = "col-md-2">
							  		이름 : 
							  	</td>
							  	<td class = "col-md-6">
							  		${dto.reg_name }
							  	</td>
							  	<td class = "col-md-1">
							  		<a href="registerDelete.do?add_id=${dto.add_id}" >  삭제 </a>
							  	</td>
							  </tr>
							  <tr>
							  	<td>
							  		주소 : 
							  	</td>
							  	<td>
							  		${dto.add_address }
							  	</td>
							  	<td class = "col-md-1">
							  		
							  	</td>
							  </tr>
							  <tr>
							  	<td>
							  		상세주소 : 
							  	</td>
							  	<td>
							  		${dto.reg_specificaddress }
							  	</td>
							  </tr>
							  <tr>	
							  	<td>
							  		휴대폰 : 
							  	</td>
							  	<td>
							  		${dto.reg_tel }
							  	</td>
							  	<td class = "col-md-1">
									<c:if test="${dto.reg_defaultaddress eq 1}">
								  		<a >  기본주소지 </a>
									</c:if>
									<c:if test="${dto.reg_defaultaddress eq 0}">
								  		<a href="registerSetDefault.do?add_id=${dto.add_id }">  기본주소지로 설정 </a>
									</c:if>
							  	</td>
							  </tr>
							</table>
						</div>
					</div>
				</c:forEach>
				<div style = "text-align:center; padding-top:30px">
					<button type="button" class= "btn btn-dark" onclick = "location.href='registerAddForm.do'">새 주소 추가하기</button>
				</div>
			</div>
		</div>
	</div>
		
	<div class="error-messaging"></div>
	<div class="modal-background"></div>
	
	
	
	
    <!-------------------------- START FOOTER ---------------------------->
    <!-------------------------- START FOOTER ---------------------------->
    <!-------------------------- START FOOTER ---------------------------->
	
	
  <div class="footer">
		ELAPID's Work copyright。
  </div>	
  
	<script src="https://kit.fontawesome.com/e181140022.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/samso/dwanalytics-22.2.js"
		async="async" onload="trackPage()"></script>

	<script src="js/samso/dwac-21.7.js" type="text/javascript"
		async="async"></script>
	<script src="https://cdn.cquotient.com/js/v2/gretel.min.js"
		type="text/javascript" async="async"></script>
		
	
</body>
</html>