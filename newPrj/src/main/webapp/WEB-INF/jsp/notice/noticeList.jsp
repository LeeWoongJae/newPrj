<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
<c:forEach var="vo" items="${noticeList }">
	<div class="col-12">
		<a href="noticeView.do?noticeNo=${vo.noticeNo }">
			<span>${vo.noticeNo }</span>
			<span>${vo.userId }</span>
			<span>${vo.noticeTitle }</span>
			<span>${vo.noticeContent }</span>
		</a>
	</div>
</c:forEach>
</div>


