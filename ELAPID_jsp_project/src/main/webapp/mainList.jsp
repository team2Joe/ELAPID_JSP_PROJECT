
		<%@ include file="/layout/header.jsp"%>


			<div class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${list }" var="dto">
				  <div class="col">
				    <div class="card h-100" align="center">
			    	  <a href="detailView.do?p_id=${dto.p_id }&p_ctgmiddle=${dto.p_ctgmiddle }">
				      <img src="${dto.p_imgpath }" alt="..." align="center">
				      <div class="card-body">
				        <h5 class="card-title">${dto.p_name }</h5>
				      </a>
				        <h6 class="card-price">${dto.p_discountprice } won</h6>
				        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
				      </div>
				      <div class="card-footer">
				        <button><small class="text-muted">Last updated 3 mins ago</small></button>
				      </div>
				    </div>
				  </div>
				</c:forEach>
			</div>
		
			
		<%@ include file="/layout/footer.jsp"%>	