<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
------------------------Read!---------------------------
<product category 분류표>

001.001.001 = [대분류].[중분류].[소분류]

001 = 의복/신발/패션잡화
	|-001.001 = 남성복
	  |-001.001.001 = 상의
	  |-001.001.002 = 하의
	|-001.002 = 여성복
	  |-001.002.001 = 상의
	  |-001.002.002 = 하의
002 = 생활잡화
	|-002.001 = 패브릭
	  |-002.001.001 = 섬유
	  |-002.001.002 = 기타 상품
	|-002.002 = 가구/인테리어
	  |-002.002.001 = 목재가구
	  |-002.002.002 = 기타가구	  
--------------------------------------------------------
 -->

<!-- 
<nav class="menu" id="menu">
	<ul class="menu__list">
		<li>
			<a class="" href="productList.do">의복/신발/패션잡화</a>
			<div>
				<a href="productList.do">남성복</a>
				<a href="productList.do">여성복</a>
			</div>
		</li>
		<li>
			<a class="" href="productList.do">생활잡화</a>
			<div>
				<a href="productList.do">패브릭</a>
				<a href="productList.do">가구/인테리어</a>
			</div>
		</li>
	</ul>
</nav>
 -->

<nav class="menu" id="menu1">
	<ul class="menu__list">

	</ul>
</nav>

<script>
	let menu = document.querySelector('#menu1 > ul');
	// menu list ajax로 출력
	window.onload = function () {
		fetch('menuList.do?', {
			method: 'POST',
            headers: {'Content-type': 'application/x-www-form-urlencoded'},
            body: 'id=hi'
		})		
		.then(res => {
			console.log(res);
			return res.json();
		})
		.then(res => {			
			console.log(typeof res);
			console.log(res);
			
			// print
		  for(let i = 0; i< res.length; i++) {
			    let li = document.createElement('li');
			    if(res[i].fcName != null){
				    let a = document.createElement('a');
			    	a.innerText = res[i].fcName;
				    li.append(a);
			    }	
			    let div = document.createElement('div');
			    if(res[i].sc[0].scName != null) {
					let a = document.createElement('a');
					a.innerText = res[i].sc[0].scName;
					div.append(a);					
			    }
			    li.append(div);
				menu.append(li);
			}
		})
	}
</script>