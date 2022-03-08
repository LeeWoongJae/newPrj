<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="row text-center justify-content-center align-items-center hDisplay">
	<div class="col-7">
		<div class="card">
			<div class="card-body">
				<h3>회원가입</h3>
				<hr>
				<form action="signUpCheck.do" id="frm" method="get">
					<!-- id -->
					<div class="form-group">
						<div class="row align-items-center">
							<div class="col-4">
								<input type="text" placeholder="id ..." name="userId" id="userId" class="form-control" required>
							</div>					
							<div class="col-1"><span>@</span></div>
							<div class="col-4">
								<input type="text" value=""	name="mailVal" class="form-control" id="mailVal">
							</div>				
							<div class="col-3">
								<select	name="mail" id="mail">
									<option value="">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="daum.com">daum.com</option>
								</select>
							</div>
						</div>				 
					</div>
					<div class="form-group mt8">
						<input type="password" name="pwd" id="pwd" placeholder="password ..." class="form-control" required>
					</div>
					<div class="form-group mt8">
						<input type="text" name="tel" id="tel" placeholder="phone number ..." class="form-control">
					</div>
					<div class="form-group mt8">
						<input type="text" name="address" id="address" placeholder="address ..." class="form-control">
					</div>
					<div class="form-group mt8">
						<input type="text" name="userName" id="userName" placeholder="your name ..." class="form-control">
					</div>

					<!-- <button class="btn btn-secondary mt20">취소</button> -->
					<button class="btn btn-primary mt20">회원가입</button>
				</form>
			</div>
		</div>
	</div>
	<div class="col-2">&nbsp;</div>
</div>




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