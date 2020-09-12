<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*"%>
<%
	Member member = (Member) request.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
#body{
background: #e5f8f7;
height: 700px;
text-align: center;
}

.main{
height: 700px;
text-align: center;
margin: 0 auto;
position: relative;
  top: 50%;
   position: relative;

}



.search-pwd-form {
	width: 550px;
	margin: 0 auto;
	position: relative;
	top: 50%;
	transform: translateY(-50%);
}
.search-form{
   width: 550px;
   height: 35px;
   margin: 30px 0 30px 0;
   position: relative;
   

}

.form-group {
   width: 550px;
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
   background:#fff;
   
}


.btnFind{
   border: 2px solid #fff;
   color: black;
   line-height: 30px;
   border-radius: 12px;
   width: 180px;
   margin: 8px;
   background: #fff;
}

#danger {
	color: red;
}

#success {
	color: blue;
}
</style>
</head>

<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/common/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/boardDetail.css">

<body id="body">
	<%@include file="/WEB-INF/views/common/navbar.jsp"%>


	<div class="wrap">
	
		<form action="<%=request.getContextPath()%>/updatePassword"
			class="form-horizontal" method="post" id="joinForm" name="joinForm"
			onsubmit="return validate();">
			<input type="hidden" name="update-pwd" id="userName" value="<%=member.getEmail()%>">
			
		<div class="main">
		<div class="search-pwd-form">
	<div class="emailLabei">
		<h2 class="emailName">비밀번호 변경</h2>
	</div>
		

	<div class="newPassword">
	
	<div class="pwd-input">
	
		<div class="form-group">
			<label for="password">비밀번호</label> 
			<input type="password" name="newPwd1" id="newPwd1">
		</div><br>
		
		
		
		<div class="label-g">
			<label for="name">10~12자리의영문(대소문자)+숫자+특수문자 중 2종류 이상을 조합하여 사용할수 있습니다.</label>
		</div>
		
		<div class="form-group">
			<label for="password2">비밀번호 확인</label> 
			<input type="password"name="newPwd2" id="newPwd2">
		</div>

		
		<div class="label-g">
		<div class="success1" id="success">비밀번호 일치하잖아 잘했잖아 .</div>
		<div class="danger1" id="danger">비밀번호 틀렸잖아! 미쳤잖아! 다시해!.</div>
		</div>

	</div>
	
	<div class="btnGroup" id="updateBtn">
		<input  class="btnFind" id="upBtn" type="submit" value="비밀번호 변경하기"onclick="return newPassword();">
		<button type="button" id="btnF" class="btnFind"onclick="location.href='login'">로그인하러가기</button>
	</div>
	</div>
	
	</div>
	</div>
	
	</form>
	</div>


	<script>

		// 비밀번호 일치여부 확인
		$(function() {
			$("#success").css("display", "none");
			$("#danger").css("display", "none");
			$("input").keyup(function() {
				var newPwd1 = $("#newPwd1").val();
				var newPwd2 = $("#newPwd2").val();
				if (newPwd1 != "" || newPwd2 != "") {
					if (newPwd1 == newPwd2) {
						$("#success").css("display", "block");
						$("#danger").css("display", "none");
					} else {
						$("#success").css("display", "none");
						$("#danger").css("display", "block");
					}
				}
			});
			
		});
		
		// 비밀번호 정규식
		function newPassword(){
		      // 10자~12자리의 영문(대소문자)+숫자+특수문자 중 2종류 이상을 조합하여 사용할 수 있습니다.

		         var mbrPwd = $("#newPwd1").val();  // pw 입력

		         var check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(mbrPwd);   //영문,숫자

		         var check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(mbrPwd);  //영문,특수문자

		         var check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(mbrPwd);  //특수문자, 숫자

		         if(!(check1||check2||check3)){

		            alert("사용할 수 없은 조합입니다.\n패스워드 설정안내를 확인해 주세요.");

		            return false;

		         }

		         if(/(\w)\1\1/.test(mbrPwd)){

		            alert('같은 문자를 3번 이상 사용하실 수 없습니다.\n패스워드 설정안내를 확인해 주세요.');

		            return false;

		         }
		         
		         return true; 
		 }
		
		
	</script>

</body>
</html>