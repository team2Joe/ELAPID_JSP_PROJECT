<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String url = request.getHeader("referer");
		response.sendRedirect(url);
	%>
	<button onclick="test()">테스트 버튼</button>
	
		<script src="js/basic.js"></script>
</body>
</html>