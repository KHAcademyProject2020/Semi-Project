<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>my_page</title>
<style>
	body{
		text-align:center;
		height:700px;
	}

	.form-horizontal{
		width:500px;
		margin:0 auto;
		padding:0 100px;
		box-sizing:border-box;
		position:relative;
		top:50%;
		transform:translateY(-50%);
	}
	
	.form-group{
		width:300px;
		height:35px;
		margin: 10px 0 30px 0;
		position:relative;
	} 
	
	.form-group > input{
		width:100%;
		height:100%;
		border:none;
		border:2px solid #03D392;
		font-size:18px;
	}
	
	.form-group > input[type="date"]{
		font-size:12px;
	}
	
	.form-group > label{
		position:absolute;
		top:2px;
		left:15px;
		transform:translateY(-50%);
		font-size:15px;
		color:#03D392;
		padding:0px;
		background:#fff;
	}
	
	/* 라디오 */
	.radio-group{
		margin-bottom:20px;
		color:#03D392;
	}
	
	input[type=radio] + label {
	  margin: 0.2em;
	  cursor: pointer;
	  padding: 0.2em;
	}

	input[type=radio] {
	  display: none;
	}
	
	input[type=radio] + label:before {
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
	
	input[type=radio] + label:active:before {
	  transform: scale(0);
	}
	
	input[type=radio]:checked + label:before {
	  background-color: MediumSeaGreen;
	  border-color: MediumSeaGreen;
	  color: #fff;
	}

	/* hr */
	hr{
		border:0;
		height: 3px;
		background:#ccc;
	}
	
	/* 버튼 */
	.btn-groups button{
		background-color:#03D392;
		color:#fff;
		border:0;
		width:100%;
		height:40px;
	}
	
	.btn-groups > button:first-of-type {
		margin-right:10px;
	}
</style>
</head>
<body>
	<form class="form-horizontal" method="post" action="#">
		<div class="form-group">
			<label for="name">이 름</label>
			<input type="text" name="name" id="name" placeholder="변경 불가"/>
		</div>
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" placeholder="변경 불가"/>
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password"/>
		</div>
		<div class="form-group">
			<label for="password2">비밀번호 확인</label>
			<input type="password" name="password2" id="password2"/>
		</div>
		<div class="form-group">
			<label for="email">메일 주소</label>
			<input type="text" name="email" id="email" placeholder="이메일을 입력하세요"/>
		</div>
		<div class="form-group">
			<label for="phone">연락처</label>
			<input type="tel" name="phone" id="phone"/>
		</div>
		<div class="form-group">
			<label for="birth">생년월일</label>
			<input type="date" name="birth" id="birth"/>
		</div>
		<div class="radio-group">
			성별
			<input type="radio" name="gender" id="gender1" value="male"/>
			<label for="gender1">남자</label>
			<input type="radio" name="gender" id="gender2" value="female"/>
			<label for="gender2">여자</label>
		</div>
		<hr>
		<!--버튼그룹  -->
		<div class="btn-groups">
			<button type="button" class=""
				onclick="location.href = '#'">회원정보 수정</button>
		</div>
		<!-- 버튼 그룹 끝 -->
	</form>
</body>
</html>