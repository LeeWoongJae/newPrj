<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
	<script>
		$(function () {
			CKEDITOR.replace('content', {
				filebrowserUploadUrl: "${pageContext.request.contextPath}/fileUpload"
			})
		});
</script>

<form action="noticeUpdate.do" method="post">
<input type="hidden" id="id" value="${id }">
		
		
번호: <span>${vo.noticeNo }</span><br>

타이틀: <span><input type="text" name="title" id="title" value="${vo.noticeTitle }"></span><br>
<c:choose>
<c:when test="${vo.userId eq id }">
내용: <span><textarea name="content" id="content" cols="60" rows="20">${vo.noticeContent }</textarea></span><br>
</c:when>

<c:otherwise>
<div>${vo.noticeContent}</div>
</c:otherwise>

</c:choose>
작성자: <span>${vo.userId }</span>

<br/>
<a href="notice.do">리스트보기</a>
<c:if test="${id.substring(0,5) eq 'admin' }">
<!-- <a href="noticeUpdate.do">수정하기</a> -->
<!-- <input type="submit" onclick="location.href='noticeUpdate.do'" value="수정">  -->
<input type="submit" value="수정">
</c:if>


</form>



    