<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
	<body>
		<%@ include file="/layout/header.jsp"%>
	

			<div class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${list }" var="dto">
				  <div class="col">
				    <div class="card h-100">
				      <img src="https://www.samsonite.co.kr/dw/image/v2/AAWQ_PRD/on/demandware.static/-/Sites-Samsonite/default/dwd0c31205/images/c-lite-spinner-exp/hi-res/134679_1041_hi-res_FRONT34_1.JPG?sw=200&sh=300" class="card-img-top" alt="...">
				      <div class="card-body">
				        <h5 class="card-title">${dto.p_name }</h5>
				        <h6 class="card-price">${dto.p_discountprice } won</h6>
				        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
				      </div>
				      <div class="card-footer">
				        <small class="text-muted">Last updated 3 mins ago</small>
				      </div>
				    </div>
				  </div>
				</c:forEach>
			</div>
		
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		
		<%@ include file="/layout/footer.jsp"%>	
	</body>
</html>