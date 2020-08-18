<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP&Servlet</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<style>
	body{
		background:url('<%= request.getContextPath() %>/images/bg.png') no-repeat center center fixed;
		background-size: cover;
	}
	.loginArea{float: right;}
	#loginTable{text-align: right;}
	#loginTable td:nth-child(1){padding-right: 15px;}
	.loginBtns{float: right; margin-left: 5px;}
	#loginBtn, #myPage{background: #D1B2FF;}
	#joinBtn, #logout{background: #B2CCFF;}
	input[type=button], input[type=submit]{cursor: pointer; border-radius: 15px; color: white;}
	#userInfo label{font-weight: bold;}
</style>
</head>
<body>
	<h1 align="center">GB</h1>
	
	<div class="loginArea">
		<% if(loginUser == null) { %>
		<form id="loginForm" action="<%= request.getContextPath() %>/login.me" method="post" onsubmit="return validate();">
			<table id="loginTable">
				<tr>
					<td><label>EMAIL</label></td>
					<td><input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td><label>PWD</label></td>
					<td><input type="password" name="pwd" id="pwd"></td>
				</tr>
			</table>
			<div class="loginBtns">
				<input type="submit" id="loginBtn" value="로그인">
				<input type="button" id="joinBtn" value="회원가입" onclick="memberJoin();">
			</div>
		</form>
		<% } else {%>
		<div id="userInfo" align="right">
			<label><%= loginUser.getName() %>님의 방문을 환영합니다.</label>
			<br clear="all">
			<div class="loginBtns">
				<input type="button" id="myPage" value="내 정보 보기">
				<input type="button" id="logout" value="로그아웃" onclick="logout();">
			
			</div> 
		</div>
		<br>
		<br>
		<div>
			<a href="<%= request.getContextPath() %>/team.me">모든팀</a>
			
		
		</div>
		<% }%>
	</div>
	<br clear="all">
	
	<script>
		function logout() {
			location.href="<%= request.getContextPath() %>/logout.me";
		}
	
		function validate() {
			var email = $('#email');
			var pwd = $('#pwd');
			
			if(email.val().trim().length == 0){
				alert('아이디를 입력해주세요.');
				id.focus();
				
				return false;
			}
			
			if(pwd.val().trim().length == 0) {
				alert('비밀번호를 입력해주세요.');
				pwd.focus;
				
				return false;
			}
			return true;
		}
		
		function memberJoin() {
			location.href="<%= request.getContextPath() %>/signUpForm.me";
			
			
		}
		
		
	</script>
	
	
</body>
</html>