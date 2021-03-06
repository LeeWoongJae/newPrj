<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeInsert.jsp</title>

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
<form action="noticeInsertCheck.do" method="post">
<input type="hidden" name="writer" id="writer" value="${id }">



<table border="1">

<tr>

<th>제목  </th>
<td><input type="text" name="title" id="title"></td>

</tr>

<tr>

<th>내용  </th>
<td width="1000"><textarea id="content" name="content" cols="60" rows="20"></textarea></td>

</tr>
</table>

<div align="center">
<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
<button type="submit">등 록</button>&nbsp;&nbsp;&nbsp;
<input type="button" value="홈가기" onclick="location.href='main.do'">
</div>



</form>

</body>
</html>