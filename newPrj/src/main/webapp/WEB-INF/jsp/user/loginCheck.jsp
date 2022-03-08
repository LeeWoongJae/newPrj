<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${empty id }">
<p>${user.userName }</p>
로그인 실패
<form action="loginCheck.do" id="frm" method="post">
	<input type="email" name="userId" id="userId" required><br>
	<input type="password" name="pwd" id="pwd" required>

	<button>로그인</button>
</form>
</c:if>
