<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div>
	<h1>productList page</h1>
</div>

<span>${fc }</span>
<span>${sc }</span>
<span>${tc }</span>

<div class="container">
	<div class="row">
		<c:forEach var="vo" items="${productList }">			
			<div class="col-3 products_item">
				<a href="productView.do?pcode=${vo.pcode }">
				<img alt=""	src="${vo.image }">
					<p>${vo.pname }</p> <strong>${vo.price }</strong>
					<p>${vo.category }</p>
				</a>
			</div>			
		</c:forEach>'
		
	</div>

</div>