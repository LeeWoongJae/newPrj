<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-6">
		<img alt="" src="${vo.image }">
	</div>
	<div class="col-6">
		<div class="row">
			<div class="col-12"><h2>${vo.pname }</h2></div>
			
			<div class="col-4">판매가</div>
			<div class="col-8"><span>${vo.price }</span></div>
			
			<div class="col-4">배송비</div>
			<div class="col-8"><span>${vo.deliveryFee }</span></div>
			
			<div class="col-4">제조사/원산지</div>
			<div class="col-8"><span>Made in ${vo.madein }</span></div>
			
			<div class="col-4">상품코드</div>
			<div class="col-8">${vo.pcode }</div>
			
			<hr>
			
			<div class="col-12">COLOR</div>
			<div class="col-12">
				---
			</div>
			
			<hr>
			
			<div class="col-12">SIZE</div>
			<div>
				<input type="button" value="m">
				<input type="button" value="x">
				<input type="button" value="xl">
			</div>
			
			<hr>
			
			<div class="col-6">수량선택</div>
			<div class="col-6">
				<input type="button" value="-">
				<input type="text" value="1">
				<input type="button" value="+">
			</div>
		</div>
	</div>
</div>


