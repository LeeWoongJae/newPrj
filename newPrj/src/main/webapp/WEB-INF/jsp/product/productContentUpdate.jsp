<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script type="text/javascript">
	function delColor() {
		$('#pcolorDiv:last').hide();
	}
	function addColor() {
		const addVal = document.getElementById('addColorVal').value;
		const td = document.createElement("td");
		td.setAttribute('pcolor' , addVal);
		const textNode = document.createTextNode(addVal);
		td.appendChild(textNode);
		document
	    .getElementById('pcolorTr1')
	    .appendChild(td); 
	}
</script>



<div class="container">
	<div>
	<h3>상품리스트</h3>
	</div>
	<form id="frm" name="frm" action="productUpdate.do" method="post">
	<div>
		<div>
		<table class="table1">
	
			<tr>
			<th width="100">메인이미지</th>
			<th width="100">상품명</th>
			<th width="100">판매가</th>
			<th width="100">배송비</th>
			<th width="100">제조사/원산지</th>
			<th width="100">상품코드</th>
			</tr>
				
	
		
	<c:forEach var="prod" items="${prodList }">
		<tr>
		
		<td>
		<img alt="" src="${prod.image }">
		</td>
		<td>${prod.pname }</td>
		<td>${prod.price }</td>
		<td>${prod.deliveryFee }</td>
		<td>${prod.madein }</td>
		<td>${prod.pcode }</td>
		
		
	
	</c:forEach>
		
		</table>
		

			</div>
		</div>
	<div>		
	<table class="table2">
	<tr>
		<th width="100">카테고리</th>
	</tr>
	<tr>
	<td>
	<select name="category" id="category">
	<c:forEach var = "cat" items="${ category}">
	<option value="${cat.fc }">
	</c:forEach>
	</select>
	</td>
	
	<td>
	<select name="category" id="category">
	<c:forEach var = "cat" items="${ category}">
	<option value="${cat.sc }">
	</c:forEach>
	</select>
	</td>
	
	<td>
	<select name="category" id="category">
	<c:forEach var = "cat" items="${ category}">
	<option value="${cat.tc }">
	</c:forEach>
	</select>
	</td>
	</tr>
	
	</table>
	</div>	
	
	<div>
		<table class="table3">
	
			<tr>
			<th width="100">COLOR</th>
			<th width="100">SIZE</th>
			<th width="100">재고수략</th>
			<th width="100">인기상품</th>
			</tr>
			<tr>
			<td><table class="prodSizeTable">
			<c:forEach var="color" items="${prodList}">
				<tr id="pcolorTr1">
				<td id="pcolorDiv">${color.pcolor }</td>
				<td><button type="button" onclick="delColor">-</button></td>
				</tr>
			</c:forEach>
			<tr>
			<td><input type="text" id="addColorVal" placeholder="옵션추가"></td>
			<td><button type="button" onclick="addColor">+</button></td>
			</tr>
			</table>
			</td>
		</tr>
		</table>	
		</div>
	</form>
</div>
