<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container">
	<div class="row">
		<c:if test="${not empty categoryList.fcName }">
			<div class="col-12">${categoryList.fcName }</div>
		</c:if>
		<c:if test="${not empty categoryList.scName }">
			<div class="col-12">${categoryList.scName }</div>
		</c:if>
		<c:if test="${not empty categoryList.tcName }">
			<div class="col-12">${categoryList.tcName }</div>
		</c:if>
		<c:forEach var="vo" items="${productList }">			
			<div class="col-3 products_item">
				<a href="productView.do?pcode=${vo.pcode }">
				<img alt=""	src="${vo.image }">
					<p>${vo.pname }</p> <strong>${vo.price }</strong>
					<p>${vo.category }</p>
				</a>
			</div>			
		</c:forEach>		
	</div>
</div>

