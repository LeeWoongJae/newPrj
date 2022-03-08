<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- main slider -->
<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/main/mainBanner_0.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/main/mainBanner_1.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- print products list | ajax 처리 -->
<h6>인기상품</h6>
<div class="row" id="productList">		
	<!-- 출력 -->
</div>

<!-- 공지사항 notice | ajax 처리 -->
<div>
	
</div>

<script>
	// product list
	let list = document.querySelector('#productList');
	document.addEventListener('DOMContentLoaded', function() {
		fetch('mainProductList.do', {
			method: 'post',
			headers: {'Content-type': 'application/x-www-form-urlencoded'}
		})
		.then(res => res.json())
		.then(res => {
			console.log(res)
			
			for(let i=0; i<4; i++) {
				let div = document.createElement('div');
				div.setAttribute('class', 'col-3 products_item');
				
				let a = document.createElement('a');
				a.setAttribute('href', 'productView.do?pcode='+res[i].pcode);
				let img = document.createElement('img');
				img.setAttribute('src', res[i].image);
				let name = document.createElement('p');
				name.innerText = res[i].pname;
				let price = document.createElement('p');
				price.innerText = res[i].price;
				a.append(img, name, price);
				
				div.append(a);
				
				list.append(div);				
			}			
		})
	}) 
</script>