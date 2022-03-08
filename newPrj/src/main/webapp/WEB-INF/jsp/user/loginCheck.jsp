<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- <c:if test="${frm.userId ne user.userId}">
<p>${id }</p>
로그인 실패
<a href="login.do">로그인</a>
</c:if> -->

<!-- 
<c:if test="${not empty user.userId }">
<p>로그인 성공 : ${id }</p>
 ${user.userId } 
 <P>${id }</P> 
<a href="logOut.do">로그아웃</a>
</c:if> 
-->

<!-- id : 내가 입력하는 계정의 ID -->
<!-- 테이블의 잔존한 ID 값을 가져와서 비교를 해야함 -->

<c:choose>

<c:when test="${vo.userId ne id}">
!!&nbsp;로그인 실패&nbsp;!!

<p>vo.userId : ${vo.userId}</p>
<p>id : ${id}</p>
<a href="login.do">로그인</a>

</c:when>

<c:otherwise>
<a href="logOut.do">로그아웃</a>
</c:otherwise>

</c:choose>