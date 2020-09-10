<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*"%>
<%
	Member member = (Member) request.getAttribute("Member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
body {
	text-align: center;
	height: 700px;
}

.wrap {
	margin: o auto;
}

.form-horizontal {
	width: 650px;
	margin: 0 auto;
	position: relative;
	text-align: center;
}


#danger {
	color: red;
}

#success {
	color: blue;
}
</style>

<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/common/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/boardDetail.css">

</head>
<body>
	<%@include file="/WEB-INF/views/common/navbar.jsp"%>


	<div class="wrap">

		<form action="<%=request.getContextPath()%>/updatePassword"
			class="form-horizontal" method="post" id="joinForm" name="joinForm"
			onsubmit="return validate();">
			
				<input type="hidden" name="update-pwd" id="userName" value="<%=member.getEmail()%>">
		
	<div class="emailLabei">
		<h2 class="emailName">비밀번호 변경</h2>
	</div>

	<div class="newPassword">
		<div class="new-password">
			<label for="password">비밀번호</label> <input type="password"
				name="newPwd1" id="newPwd1">
		</div>
		<div>
			<label for="name">10~12자리의영문(대소문자)+숫자+특수문자 중 2종류 이상을 조합하여 사용할
				수 있습니다.</label>
		</div>
		<div class="new-password">
			<label for="password2">비밀번호 확인</label> <input type="password"
				name="newPwd2" id="newPwd2">
		</div>

		<div class="success1" id="success">비밀번호 일치하잖아 잘했잖아 .</div>
		<div class="danger1" id="danger">비밀번호 틀렸잖아! 미쳤잖아! 다시해!.</div>

	</div>
	<div class="btnGroup" id="updateBtn">
		<input id="upBtn" type="submit" value="비밀번호 변경하기"
			onclick="return newPassword();">
		<button type="button" id="btnF" class="btnFind"
			onclick="location.href='login'">로그인하러가기</button>
	</div>
	<div class="btnGroup" id="updateBtn1"></div>
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
	<script>

	
	</script>
</body>
</html>