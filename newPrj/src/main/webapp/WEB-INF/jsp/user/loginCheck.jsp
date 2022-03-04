<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty id }">
로그인 실패
</c:if>
<c:if test="${not empty id }">
${user.userId }
</c:if>
<a href="logOut.do">로그아웃</a>