<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <script type="text/javascript">
function goProdList() {
		location.href="productView.do"
}
</script>
 -->
 
<!--  상품 리스트 view -->
<div class="container">
	<div>
	<h3>상품리스트</h3>
	</div>
	
	<form id="frm" name="frm"  method="post">
	
	<div>
		<div>
		<table class="table">
	
	<tr>
	<th width="100">상품정보</th>
	<th width="100">재고</th>
	<th width="100">판매가</th>
	<th width="100">제품코드</th>
	<th width="100">상세내용</th>
	</tr>
		
	
		
	<c:forEach var="prod" items="${prodList }">
	<tr>
	
	<td>
	<img alt="" src="${prod.image }">
	</td>
	<td>${prod.pname }</td>
	<td>${prod.stock }</td>
	<td>${prod.price }</td>
	<td>${prod.pcode }</td>
	<td><button type="button" onclick="location.href='productContentUpdate.do?pcode=${prod.pcode}'">수정</button></td>
	
	</tr>
	<tr><td>Color : ${prod.pcolor }</td></tr>
	<tr><td>Size : ${prod.psize}</td></tr>
	</c:forEach>
	</table>
	
	</div>
	<button type ="button" onclick="location.href='productList.do'">전체리스트</button>
	
	</div>
	</form>
</div>

  
  