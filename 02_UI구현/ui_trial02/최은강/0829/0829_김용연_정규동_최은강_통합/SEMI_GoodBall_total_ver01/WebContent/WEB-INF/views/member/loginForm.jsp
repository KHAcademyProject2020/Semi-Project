<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="member.model.vo.*"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String msg = (String)session.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Ball (로그아웃 상태)</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

<style>
body {
	background-image: url("img/gb.png"); /*용연씨 로그인 바탕화면*/
	background-size: cover;
}

.bd-placeholder-img
{
font-size
:
1.125rem;
text-anchor
:
middle;
-webkit-user-select
:
none;
-moz-user-select
:
none;
user-select
:
none;
}
@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media
(
min-width
:
768px)
{
.bd-placeholder-img-lg
{
font-size
:
3.5rem;
}
}
img {
	display: block;
	margin: 120px auto;
}


#Rememberme {
	color: white;
}

.form-control {
	width: 400px;
	margin: 0 auto;
	border-radius: 12px;
}

.btn-block {
	width: 200px;
	margin: 50px auto;
	border-radius: 20px;
}

.ship1 {
	text-align: center;
	margin: 10px;
	border: 1x;
	border-radius: 20px;
}

.ship {
	background-color: transparent;
	border: 2px solid #fff;
	color: #fff;
	line-height: 30px;
	border-radius: 12px;
	width: 180px;
	margin: 8px
}
.ship:hover {
	background-color: rgba(255, 255, 255, .2);
	#mb-4{margin:100px; }


.form-control{border-radius: 10px;}

</style>
</head>
<body>
	<div id="page">
		<!-- BODY -->
		<% if(loginUser == null){ %>
		<section id="content">
				<form class="form=signin" id="loginForm" action="<%= request.getContextPath() %>/login2.me" method="post" onsubmit="return validate();" >
					<img class="mb-4" src="img/logo.png" width="172px" height="172px">
					<br> 
					<input type="email" id="inputEmail" name="inputEmail" class="form-control"placeholder="email" width="300px"> <br> <br>
					 
					<input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="password" >
					<div class="checkbox mb-3_web-inspector-hide-shirtcut" align="center"></div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
			</form>
			</section>
				<%} else {%>
			<div id = "userInfo" align = "right">
				<label><%= loginUser.getName() %>님의 방문을 환영합니다.</label>
				<br clear = "all">
				<div class = "loginBtns">
					<input type="button" id = "myPage" value = "내정보보기" onclick="location.href='<%= request.getContextPath() %>/myPage.me'">
					<input type="button" id = "logout" value = "로그아웃" onclick="logout();">
				</div>
			</div>
		<%} %>

			<div class="ship1">
			<input type="button" class="ship" value=" 아이디 찾기" onclick=""> 
			<input type="button" class="ship" value=" 비밀번호  찾기" onclick=""> <br>
			<input type="button" class="ship" value="회원가입" onclick=" Membership()">
		

			<p class="mt-5 mb-3 text-muted" align="center">ⓒ2020-2020 Good ball</p>
			</div>
	
	</div>
	<script>
		function Membership(){
				location.href="<%= request.getContextPath() %>/memberShip";
		}
		
		function validate(){
			var email = $('#inputEmail');
			var pwd = $('#inputPassword');
			
			if(email.val().trim().length == 0){
				alert('아이디를 입력해주세요.');
				email.focus();
				
				return false;
			}
			if(pwd.val().trim().length == 0){
				alert('비밀번호를 입력해주세요.');
				pwd.focus();
				
				return false;
			}
			
			return true;
		}
	
	</script>

</body>
</html>