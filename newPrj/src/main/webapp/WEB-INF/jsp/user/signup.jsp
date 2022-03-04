<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="signUpCheck.do" id="frm" method="get">
	<input type="text" name="userId" id="userId" required>
	<span> @ </span>
	<input type="text" value="" name="mailVal" id="mailVal">
	<select name="mail" id="mail">
		<option value="">직접입력</option>
		<option value="naver.com">naver.com</option>
		<option value="daum.com">daum.com</option>
	</select><br>
	<input type="password" name="pwd" id="pwd" required><br>
	<input type="text" name="tel" id="tel"><br>
	<input type="text" name="address" id="address"><br>
	<input type="text" name="userName" id="userName">	

	<button>회원가입</button>
</form>

<script>
	// 아이디 주소값 입력
	// 주소 선택시 mailVal 값 수정 불가하게 attribute 속성 추가 or class 추가
	frm.mail.addEventListener('click', function() {
		if (frm.mail.value != '') {
			frm.mailVal.value = event.target.value;
		} else {
			frm.mailVal.value = '';
		}
	})
	// 제출 전 확인 func
</script>