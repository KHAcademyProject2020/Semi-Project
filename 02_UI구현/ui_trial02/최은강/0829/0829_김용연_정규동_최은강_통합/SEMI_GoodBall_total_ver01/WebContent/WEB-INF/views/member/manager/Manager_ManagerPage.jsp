<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String gender = loginUser.getGender();
	
	String[] check = new String[2];
	if(gender.equals("남")){
		check[0] = "checked";
	} else{
		check[1] = "checked";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_page</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	body{
		text-align:center;
		height:700px;
	}

	.form-horizontal{
		width:100%;
		margin:0 auto;
		padding:0 50px;
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
		display:inline-block;
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
		width:70%;
		height:40px;
	}
	
	p{color:red; font-size:8px;}
</style>
</head>
<body>
	<form class="form-horizontal" action="<%= request.getContextPath() %>/updateMember.me" method="post" onsubmit="return validate();">
	
		<div class="form-group">
			<label for="name">이 름</label>
			<input type="text" name="name" id="name" readonly="readonly" value="<%= loginUser.getName() %>"/>
		</div>
		<div class="form-group">
			<label for="id">이메일</label>
			<input type="email" name="id" id="id" readonly="readonly" value="<%= loginUser.getEmail() %>"/>
		</div>
		<p>*10자~12자리의 영문(대소문자)+숫자+특수문자 중 2종류 이상을 조합하여 사용할 수 있습니다.</p>
		<div class="form-group">
			<label for="password1">비밀번호</label>
			<input type="password" name="password1" id="password1"/>
		</div>
		<div class="form-group">
			<label for="password2">비밀번호 확인</label>
			<input type="password" name="password2" id="password2"/>
		</div>
		<div class="form-group">
			<label for="phone">연락처</label>
			<input type="tel" name="phone" id="phone" value="<%= loginUser.getPhone() %>"/>
		</div>
		<div class="form-group">
			<label for="birth">생년월일</label>
			<input type="date" name="birth" id="birth" value="<%= loginUser.getBirthday() %>"/>
		</div>
		<div class="radio-group">
			성별
			<input type="radio" name="gender" id="gender1" value="남" <%= check[0] %>/>
			<label for="gender1">남자</label>
			<input type="radio" name="gender" id="gender2" value="여" <%= check[1] %>/>
			<label for="gender2">여자</label>
		</div>
		<hr>
		<!--버튼그룹  -->
		<div class="btn-groups">
			<button type="submit">회원정보 수정</button>
		</div>
		<!-- 버튼 그룹 끝 -->
	</form>
	<script>
		function checkPassword() {
			var pwd = $("#password1").val();
			var check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(pwd); //영문,숫자
			var check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/
					.test(pwd); //영문,특수문자
			var check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(pwd); //특수문자, 숫자
			if (!(check1 || check2 || check3)) {
				return false;
			}
			if (/(\w)\1\1/.test(pwd)) {
				return false;
			}
			return true;
		}
	
		function validate(){
			var result = checkPassword();
			var pwd1 = $("#password1").val();
			var pwd2 = $("#password2").val();
			
			if(pwd1 === pwd2 && result == true){
				alert("수정되었습니다");
				return true;
			} else if(pwd1 == "" && pwd2 == ""){
				alert("수정되었습니다");
				return true;
			} else{
				alert("비밀번호를 확인해주세요");
				$("#password1").focus();
				return false;
			}
		}
	</script>
</body>
</html>
