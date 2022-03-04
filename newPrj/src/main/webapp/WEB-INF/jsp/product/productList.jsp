<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    


<div>
	<h1>productList page</h1>
</div>
<form id="frm" name="frm" action="productList.do" method="post"></form>
<div>
	<div id="prodList">
	<ul>
	
	<c:forEach var="vo" items="${productList }">
	<li>
	<div class="photo_zone">
	
	<a href="#"></a>
	</div>
	
	<div class="info">
	
	<div class="content">
	<p>${vo.pname }</p>
	</div>
	<div class="price">
	<strong title="정상가">${vo.price }</strong>
	</div>
	
	</div>
	</li>
	
	</c:forEach>
	
	</ul>
	</div>
	
</div>