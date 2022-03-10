<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="row mt20">
	<div class="col-6 text-center">
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
						
		</div>		
		
		<!-- color -->
		<hr class="col-12">
		<div class="row align-items-center">
			<div class="col-6">COLOR</div>
			<div class="col-6 px-0">
				<span>test - ${vo.pcolor }</span>
				<select class="form-select" name="pcolor" id="pcolor">
					<option value="">색상을 선택하세요</option>
					<c:if test="${fn:contains(vo.pcolor, '#999999') }"><option value="#FF0000">red</option></c:if>
					<c:if test="${fn:contains(vo.pcolor, '#FF0000') }"><option value="#FF0000">red</option></c:if>
					<c:if test="${fn:contains(vo.pcolor, '#00FF00') }"><option value="#00FF00" >green</option></c:if>
					<c:if test="${fn:contains(vo.pcolor, '#0000FF') }"><option value="#0000FF">blue</option></c:if>
					<c:if test="${fn:contains(vo.pcolor, '#FFFF00') }"><option value="#FFFF00">yellow</option></c:if>					
					<c:if test="${fn:contains(vo.pcolor, '#000080') }"><option value="#000080">navy</option></c:if>					
					<c:if test="${fn:contains(vo.pcolor, '#EE82EE') }"><option value="#EE82EE">violet</option></c:if>					
					<c:if test="${fn:contains(vo.pcolor, '#FFFFF0') }"><option value="#FFFFF0">ivory</option></c:if>					
					<c:if test="${fn:contains(vo.pcolor, '#F0E68C') }"><option value="#F0E68C">khaki</option></c:if>					
					<c:if test="${fn:contains(vo.pcolor, '#F5F5DC') }"><option value="#F5F5DC">beige</option></c:if>					
					<c:if test="${fn:contains(vo.pcolor, '#000000') }"><option value="#000000">black</option></c:if>					
				</select>
			</div>
		</div>
		
		<!-- size -->
		<hr class="col-12">
		<div class="row align-items-center">
			<div class="col-6">SIZE</div>
			<div class="col-6 px-0">
				<select class="form-select" name="psize" id="psize">
					<option value="">사이즈를 선택하세요</option>
					<c:if test="${fn:contains(vo.psize, 's') }"><option value="s">S</option></c:if>
					<c:if test="${fn:contains(vo.psize, 'm') }"><option value="m" >M</option></c:if>
					<c:if test="${fn:contains(vo.psize, 'l') }"><option value="x">L</option></c:if>
					<c:if test="${fn:contains(vo.psize, 'xl') }"><option value="xl">XL</option></c:if>					
				</select>
			</div>
		</div>
		
		<!-- 이곳에 상품을 출력 -->
		<form action="cartList.do" id="frm">	
			<input type="hidden" name="pcode" value="${vo.pcode }">			
			<input type="hidden" name="pname" value="${vo.pname }">			
			<input type="hidden" name="image" value="${vo.image }">			
			<input type="hidden" id="pcnt" name="pcnt" value="">			
			<input type="hidden" id="price" name="price" value="">			
			<div id="toCart">
				<!-- cart 에 담을 제품 -->			

				<!-- //cart 에 담을 제품 -->		
			</div>
		</form>	
		
		<hr>
		
		<div class="row align-items-center justify-content-end">
			<div class="col-4 orderPrice" id="orderPrice"></div>			
		</div>
		
		<hr>
		
		<div class="row align-items-center justify-content-end">
			<div class="col-4 d-grid">				
					<button class="btn btn-lg btn-primary" type="button" onclick="frmSubmit()">결제하기</button>				
			</div>		
		</div>
		
	</div>
</div>
<hr>
<div class="row">
	<div class="col-12">
		<h3>상세페이지</h3>
	</div>
</div>

<script>
	let fpcode = '';
	let fpname = '';
	let fpcolor = '';
	let fpsize = '';
	let fpprice = '';
	
	let delBtn;
	let optionCheck = '';
	let checkStr ='';

	function makeOrder(pcode, pname, pcolor, psize, pprice) {
		// order 한개
		let div = document.createElement('div');
		div.setAttribute('class', 'row align-items-center');
		
		// 정보가 들어갈 div
		let divInfo = document.createElement('div');
		divInfo.setAttribute('class', 'col-7');
		
		let pcodeLabel = document.createElement('label');	
		pcodeLabel.innerText = pcode;
		
		let pnameLabel = document.createElement('label');
		pnameLabel.innerText = pname;
		
		// 현재 입력되있는 옵션 값 불러오기
		let no = countReturn();
		
		let pcolorLabel = document.createElement('label');
		let pcolorInput = document.createElement('input');
		pcolorInput.setAttribute('type', 'hidden');
		pcolorInput.setAttribute('name', 'pcolor' + no);
		pcolorInput.value = pcolor;
		pcolorLabel.innerText = pcolor;
		
		let psizeLabel = document.createElement('label');
		let psizeInput = document.createElement('input');
		psizeInput.setAttribute('type', 'hidden');
		psizeInput.setAttribute('name', 'psize' + no);
		psizeInput.value = psize;
		psizeLabel.innerText = psize;
		
		let ppriceLabel = document.createElement('label');
		ppriceLabel.innerText = pprice;
		
		// divInfo append
		divInfo.append(pcodeLabel, pnameLabel, pcolorLabel, psizeLabel, ppriceLabel, pcolorInput, psizeInput);
		
		// quantity 버튼 생성
		let divQuantity = document.createElement('div');
		divQuantity.setAttribute('class', 'col-4 mt20');
		
		// input-group 생성
		let inputGroup = document.createElement('div');
		inputGroup.setAttribute('class', 'input-group mb-3');
		
		let inputS = document.createElement('span');
		inputS.setAttribute('class', 'input-group-text');
		inputS.innerText = '-';
		
		let inputQuantity = document.createElement('input');
		inputQuantity.setAttribute('class', 'form-control text-center countVal');
		inputQuantity.setAttribute('value', '1');
		
		let inputA = document.createElement('span');
		inputA.setAttribute('class', 'input-group-text');
		inputA.innerText = '+';
		
		// divQuantity append
		inputGroup.append(inputS, inputQuantity, inputA);
		divQuantity.append(inputGroup);
		
		// 주문 삭제 버튼
		let deleteBtn = document.createElement('div');
		deleteBtn.setAttribute('class', 'col-1 px-0')
		let btn = document.createElement('input');
		btn.setAttribute('value', 'x')
		btn.setAttribute('type', 'button')
		btn.setAttribute('class', 'btn btn-danger btn-sm deleteBtn');
		
		deleteBtn.append(btn);
		
		
		// order 생성 append
		div.append(divInfo, divQuantity, deleteBtn);
		toCart.append(div);
		
		count();
		
		// querySelector 추가
		delBtn = document.querySelectorAll('.deleteBtn');		
		delBtnFnc(delBtn);	
	}
	
	// delBtn fnc
	function delBtnFnc(delBtn) {		
		delBtn.forEach((item, idx) => {
			item.addEventListener('click', function () {
				// 문자열 체크 (해당 제품의 옵션이 들어있으면 삭제)
				let replaceValue = event.target.parentNode.parentNode.childNodes[0].childNodes[0].innerText + event.target.parentNode.parentNode.childNodes[0].childNodes[1].innerText + event.target.parentNode.parentNode.childNodes[0].childNodes[2].innerText + event.target.parentNode.parentNode.childNodes[0].childNodes[3].innerText + event.target.parentNode.parentNode.childNodes[0].childNodes[4].innerText + ' ';
				
				let check = optionCheck.replace(replaceValue, '');
				optionCheck = check;
	
				event.target.parentNode.parentNode.remove();
				count();
			})
		})		
	}
	
	function count() {
		let cnt = document.querySelectorAll('.countVal');
		console.log(cnt)
		orderPrice.innerText = cnt.length * ${vo.price};
		pcnt.value = cnt.length;
		price.value = cnt.length * ${vo.price};
		if(price.value == 0) {
			orderPrice.innerText = '';
		}
	}
	
	function countReturn() {
		let cnt = document.querySelectorAll('.countVal');		
		return cnt.length;
	}
	
	// cart 담을 상품 생성
	document.addEventListener('DOMContentLoaded', function () {
		// order 삭제버튼
		
		// 컬러값 입력
		pcolor.addEventListener('input', function () {
			fpcolor = event.target.value;
		})
		// size 입력 + 다른 옵션 입력
		psize.addEventListener('input', function () {	
			// 제품명 입력
			fpname = '${vo.pname}';
			// 제품코드 입력
			fpcode = '${vo.pcode}';
			// 색상 라벨 입력
			fpcolor = '${vo.pcolor}';
			// size 값 입력
			fpsize = event.target.value;
			// price 값 입력
			fpprice = '${vo.price}';
			
			// 옵션 체크 - 포함하면 true
			if(optionCheck == ''){
				optionCheck = optionCheck + fpcode + fpname + fpcolor + fpsize + fpprice + ' ';
				console.log(optionCheck);
				// cart 에 담을 order 만들기
				makeOrder(fpcode, fpname, fpcolor, fpsize, fpprice);
			} else {				
				let tempCheck = fpcode + fpname + fpcolor + fpsize + fpprice + ' ';
				console.log(optionCheck);	
				console.log(tempCheck);	
				if(optionCheck.includes(tempCheck)){
					alert('이미 있는 옵션!')
					return;
				}
				optionCheck = optionCheck + fpcode + fpname + fpcolor + fpsize + fpprice + ' ';
				makeOrder(fpcode, fpname, fpcolor, fpsize, fpprice);
			}			
		})				
	})
	
	function frmSubmit() {
		frm.submit();
	}

</script>

