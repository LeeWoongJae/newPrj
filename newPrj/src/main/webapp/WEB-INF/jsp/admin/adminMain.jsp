<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 
    
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
	<script>
		$(function () {
			CKEDITOR.replace('content', {
				filebrowserUploadUrl: "${pageContext.request.contextPath}/fileUpload"
			})
		});
	</script>


</head>

<body>
<form action="noticeInsert.do" method="post">
<input type="hidden" name="writer" id="writer" value="${id }">
<table border="1">
<tr>

<th>제목</th>
<td><input type="text" name="title" id="title"></td>

</tr>

<tr>
<th>내용</th>
<td><textarea id="content" name="content" cols="60" rows="20"></textarea></td>
</tr>

<tr>
<td align="center" colspan="2">
<button type="button" onClick="location.href='noticeInsert.do'" >등록하기</button></td>

</table>

</form>

</body>
</html>
  -->