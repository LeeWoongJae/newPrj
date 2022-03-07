<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${frm.userId ne vo.userId}">
<p>${id }</p>
로그인 실패
<a href="login.do">로그인</a>
</c:if>



<!--  <c:choose >~ <c:when> ~ 써보기 -->

<c:if test="${not empty vo.userId }">
<p>로그인 성공 : ${id }</p>
<!-- ${user.userId } -->
<!-- <P>${id }</P> -->
<a href="logOut.do">로그아웃</a>
</c:if>