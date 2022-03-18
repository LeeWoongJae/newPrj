<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script>
	// color 추가 / 제거
	function delColor() {
		$('#prodColorTable tr:first').remove();
		
	}
	function addColorRow(){
		// color테이블 
		const table = document.getElementById('prodColorTable');
		// 테이블 행 버튼 기입
		const btnTd = "<td><input type='button' id='delBtn' onclick='delColor()' value='-'></td>"
		
		
	//	if(table.childNode()){
		// 행 tr 을 생성
		const newRow = table.insertRow(0);
		
		// tr에 td생성
		const newCell1 = newRow.insertCell(0);
		const newCell2 = newRow.insertCell(1);
		
		// 첫번쨰TD에 적었던 color 를 기입
		newCell1.innerText = document.getElementById('addColorVal').value;
		// 두번째TD에 delete button 을 기입
		newCell2.innerHTML = btnTd;
	//	}
		
	}
	
	// Size  추가 / 제거
	function delSize() {
		$('#prodSizeTable tr:first').remove();
		
	}
	function addSizeRow(){
		// size테이블 
		const table = document.getElementById('prodSizeTable');
		// 테이블 행 버튼 기입
		const btnTd = "<td><input type='button' id='delBtn' onclick='delSize()' value='-'></td>"
		
		
	//	if(table.childNode()){
		// 행 tr 을 생성
		const newRow = table.insertRow(0);
		
		// tr에 td생성
		const newCell1 = newRow.insertCell(0);
		const newCell2 = newRow.insertCell(1);
		
		// 첫번쨰TD에 적었던 size 를 기입
		newCell1.innerText = document.getElementById('addSizeVal').value;
		// 두번째TD에 delete button 을 기입
		newCell2.innerHTML = btnTd;
	//	}
		
	}
	
	
	// 인기상품의 체크박스가 체크 되어있을경우 1을 그대로 전송 , 아닐경우 0을 전송
	if($("#cbchk").checked){
		$("#hdchk").disabled = true;
	}
	
	// selectbox 값을 가져오기
	function changeCateFc(){
		var cateFcInd = $('#cateFc').options[$('#cateFc').selectedIndex].value;
		var cateFcName = $('#cateFc').options[$('#cateFc').selectedIndex].text;
	}
	function changeCateSc(){
		var cateScInd = $('#cateSc').options[$('#cateSc').selectedIndex].value;
		var cateScName = $('#cateSc').options[$('#cateSc').selectedIndex].text;
	}
	function changeCateTc(){
		var cateTcInd = $('#cateTc').options[$('#cateTc').selectedIndex].value;
		var cateTcName = $('#cateTc').options[$('#cateTc').selectedIndex].text;
	}
	
	
	
	
</script>



<div class="container">
	<div>
	<h3>상품 수정</h3>
	</div>
	<form id="frm" name="frm" action="productUpdate.do" method="post">
	<div>
		<div>
		<table id="table1" >
	
			<tr>
			<th width="100">메인이미지</th>
			<th width="100">상품명</th>
			<th width="90">판매가</th>
			<th width="90">배송비</th>
			<th width="90">제조사 / <br/> 원산지</th>
			<th width="100">상품코드</th>
			</tr>
				
	
		

	
		<tr>
		<td>
		<img alt="" src="${product.image }">
		</td>
		<td><input name="pname" value="${product.pname }" /> </td>
		<td><input name="pname" value="${product.price }" /></td>
		<td><input name="pname" value="${product.deliveryFee }" /></td>
		<td><input name="pname" value="${product.madein }" /></td>
		<td><input name="pname" value="${product.pcode }" /> <span>${product.category }</span></td>
		
		</tr>

		
		</table>
			</div>
		</div>
		
	<div>		
	<table id="table2" >
	<tr>
		<th width="100">카테고리</th>
	</tr>
	<tr>
	<td>
	<select name="category" id="cateFc">
		<c:forEach var = "cat" items="${categoryFcList }">
			<option value="${cat.fcName }">${cat.fcName }</option>
		</c:forEach>
	</select>
	</td>
	
	<td>
	<select name="category" id="cateSc">
		<c:forEach var = "cat" items="${categoryScList }">
			<option value="${cat.scName }">${cat.scName }</option>
	</c:forEach>
	</select>
	</td>
	
	<td>
	<select name="category" id="cateTc">
		 <c:forEach var = "cat" items="${categoryTcList }"> 
			<option value="${cat.tcName }">${cat.tcName }</option>
		 </c:forEach>
		 </select>
	</td>
	</tr>
	
	</table>
	</div>	
	
	<div>
		<table id="table3">
	
			<tr>
			<th width="100">COLOR</th>
			<th width="100">SIZE</th>
			<th width="100">재고수량</th>
			<th width="100">인기상품</th>
			</tr>
			
			<tr>
			<td>
			<!-- color 옵션추가 / 제거 -->
			<table id="prodColorTable">
			
			<!-- 색상 출력 -->
			<!-- 
				
				<tr>
				<td>${color.pcolor }</td>
				<td><input type="button" id="delBtn" onclick="delColor()" value="-"></td>
				</tr>
			 -->

			<tr>
			<td><input type="text" id="addColorVal" placeholder="옵션추가"></td>
			<td><button type="button" class="addColorBtn" onclick="addColorRow()">+</button></td>
			</tr>
			</table></td>
			
			<td>
			<!-- size 옵션추가 / 제거 -->
			<table id="prodSizeTable">
			
			<!-- 

				<tr>
				<td>${size.psize }</td>
				<td><input type="button" id="delBtn" onclick="delSize()" value="-"></td>
				</tr>

			 -->
			
			<tr>
			<td><input type="text" id="addSizeVal" placeholder="옵션추가"></td>
			<td><button type="button" class="addSizeBtn" onclick="addSizeRow()">+</button></td>
			</tr>
			</table>
			</td>
			
			<!-- 
			<td>${list.stock }</td>
			 -->


			
			<td><input type="checkbox" name="popular" value="1" id="cbchk">
			<input type="hidden" name="popular" value="0" id="hdchk" >
			</td>
		</tr>
		</table>
			
		</div>
	
	</form>
	
</div>
		