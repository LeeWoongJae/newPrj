<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container">
	<div class="row">
		<div class="col-12 mt20 mb20">
			<!-- fc -->
			<c:if test="${not empty categoryList.fcName && empty categoryList.scName }">
				<span class="cate--detail cate__fcl">${categoryList.fcName }</span>
			</c:if>
			<c:if test="${not empty categoryList.fcName && not empty categoryList.scName }">
				<span class="cate--detail cate__fc">${categoryList.fcName } > </span>
			</c:if>
			<!-- sc -->
			<c:if test="${not empty categoryList.scName && empty categoryList.tcName }">
				<span class="cate--detail cate__scl">${categoryList.scName }</span>
			</c:if>
			<c:if test="${not empty categoryList.scName && not empty categoryList.tcName }">
				<span class="cate--detail cate__sc">${categoryList.scName } > </span>
			</c:if>
			<!-- tc -->
			<c:if test="${not empty categoryList.tcName }">
				<span class="cate--detail cate__tc">${categoryList.tcName }</span>
			</c:if>
		</div>
		<c:forEach var="vo" items="${productList }">			
			<div class="col-3 products_item">
				<a href="productView.do?pcode=${vo.pcode }">
				<img alt=""	src="${vo.image }">
					<p>${vo.pname }</p>
					<strong>${vo.price }</strong>
				</a>
			</div>			
		</c:forEach>		
	</div>
</div>

