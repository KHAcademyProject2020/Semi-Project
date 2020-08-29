<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Ball 회원가입</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
body {
	text-align: center;
	height: 700px;
}

.form-horizontal {
	width: 500px;
	margin: 0 auto;
	padding: 0 100px;
	box-sizing: border-box;
	position: relative;
	top: 50%;
	transform: translateY(-50%);
}

.form-group {
	width: 300px;
	height: 35px;
	margin: 10px 0 30px 0;
	position: relative;
}

.form-group>input {
	width: 100%;
	height: 100%;
	border: none;
	border: 2px solid #03D392;
	font-size: 18px;
}

.form-group>input[type="date"] {
	font-size: 12px;
}

.form-group>label {
	position: absolute;
	top: 2px;
	left: 15px;
	transform: translateY(-50%);
	font-size: 15px;
	color: #03D392;
	padding: 0px;
	background: #fff;
}

/* 체크박스 */
.check-group {
	margin-bottom: 20px;
	color: #03D392;
}

input[type=checkbox]+label {
	margin: 0.2em;
	cursor: pointer;
	padding: 0.2em;
}

input[type=checkbox] {
	display: none;
}

input[type=checkbox]+label:before {
	content: "\2714";
	border: 0.1em solid #03D392;
	border-radius: 0.2em;
	display: inline-block;
	width: 1em;
	height: 1em;
	padding-left: 0.2em;
	padding-bottom: 0.3em;
	margin-right: 0.2em;
	vertical-align: bottom;
	color: transparent;
	transition: .2s;
}

input[type=checkbox]+label:active:before {
	transform: scale(0);
}

input[type=checkbox]:checked+label:before {
	background-color: MediumSeaGreen;
	border-color: MediumSeaGreen;
	color: #fff;
}



.select-group>option {
	background-color: #03D392;
}

/* hr */
hr {
	border: 0;
	height: 3px;
	background: #ccc;
}

/* 버튼 */
.btn-groups button {
	background-color: #03D392;
	color: #fff;
	border: 0;
	width: 100%;
	height: 40px;
}

.btn-groups>button:first-of-type {
	margin-right: 10px;
}
</style>
</head>
<body>
<form action="<%= request.getContextPath() %>/insert" class="form-horizontal" method="post" id="joinForm" name="joinForm" onsubmit="return validate();">
		<div class="form-group">
			<label for="name">EMAIL</label> <input type="email" name="email"
				id="email" placeholder="email 입력해주세요!" />
		</div>
		<div>
			<input type="button" id="emailCheck" value="중복확인" onclick="checkEmail();">
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> 
			<input type="password" name="password" id="password"placeholder="8~12자로 영어와 숫자,!*$만 가능합니다.(영어로 시작)" />
		</div>
		<div class="form-group">
			<label for="password2">비밀번호 확인</label> 
			<input type="password" name="password2" id="password2" />
		</div>
		
		<div class="success1" id="success">비밀번호 일치하잖아 잘했잖아 .</div>
		<div class="danger1" id="danger">비밀번호 틀렸잖아 미쳤어? 다시해!.</div>
		
		<div class="form-group">
			<label for="name">이름</label> 
			<input type="text"name="name" id="name" />
		</div>
		<div class="form-group">
			<label for="birthday">생년월일</label>
			 <input type="date" name="birthday" id="birthday" />
		</div>
		<div class="form-group">
			<label for="phone">연락처</label> <input type="tel" name="phone"
				id="phone"  placeholder="(-없이)01012345678"/>
		</div>
		<div class="check-group">
			성별 
			<input type="checkbox" name="gender" id="gender1" value="남" />
			<label for="gender1">남자</label> 
			<input type="checkbox" name="gender" id="gender2" value="여" /> 
			<label for="gender2">여자</label>
		</div>
		<div class="form-group">
			<label for="address">주소</label> 
			<input type="text" name="address" id="address" />
		</div>
		<div class="check-group">
			회원 등급
			<input type="checkbox" name="member_type" id="member_type" value="G" />
			<label for="member_type">일반회원</label> 
			<input type="checkbox" name="member_type" id="member_type2" value="M" /> 
			<label for="member_type2">매니저 회원</label>
		</div>
	
	
		<hr>
		<!-- 버튼 그룹 -->
		<div class="btns" id="signUpBtns">
				<input id="signUpBtn" type="submit" value="가입하기">
				<input type="button" id="goMain" onclick="goMain();" value="메인으로">
			</div>
		<!-- 버튼 그룹 끝  -->
	</form>
	<script>
	 function checkEmail(){
		window.open("checkEmailForm.me", "checkEmailForm", "width=300, height=200");
	 }

		$(function(){		 
		 $("#success").css("display","none");
		 $("#danger").css("display","none");
		 $("input").keyup(function(){
			 var password=$("#password").val();
			 var password2=$("#password2").val();
		 	 if(password !=  "" || password2 != ""){
			 if(password == password2){
				 $("#success").css("display","block");
				 $("#danger").css("display","none");
			 }else{
				 $("#success").css("display","none");
				 $("#danger").css("display","block");
			 	}
		 	 }
		 });
	 }); 
	
	 
	
	// 주소 네임 설정
	</script>
</body>
</html>
