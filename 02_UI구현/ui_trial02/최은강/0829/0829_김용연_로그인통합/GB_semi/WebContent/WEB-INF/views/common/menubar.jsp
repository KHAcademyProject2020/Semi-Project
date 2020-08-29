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
		background:url('<%= request.getContextPath() %>/img/fb.PNG') no-repeat center center fixed;
		background-size: cover;
	}
	.loginArea{float: right;}
	

	#joinBtn, #logout{background-color: transparent;
	border: 2px solid #ffff;
	color: #000000;
	line-height: 30px;
	border-radius: 12px;
	width: 180px;
	margin: 8px
}}
	input[type=button], input[type=submit]{cursor: pointer; border-radius: 15px; color: white;}
	#userInfo label{font-weight: bold;}
	
	.wrap{background-color: #ffffff;
       	  background-color: rgba( 255, 255, 255, 0.0 ); width: 100%; height: 50px;}
	.menu{
		background-color: #ffffff;
        background-color: rgba( 255, 255, 255, 0.0 ); color: navy; font-weight: bold;
		vertical-align: middle; width: 150px; height: 50px; display: table-cell;
	}
	nav{width: 600px; margin-left: auth; margin-right: auth;  text-align: center; margin: 0 auto;}
	.menu:hover{background: rgba(76, 227, 218); color: black; font-weight: bold; cursor: pointer;}
</style>
</head>
<body>
	<h1 align="center">Welcome Good Ball</h1>
	
	<div class="loginArea">
		<% if(loginUser == null) { %>
			<div class="loginBtns">
				
				<input type="button" id="joinBtn" value="로그인" onclick="memberJoin();">
			</div>
		
		<% } else {%>
		<div id="userInfo" align="right">
			<label><%= loginUser.getName() %> 환영합니다.</label>
			<br clear="all">
			<div class="loginBtns">
				<input type="button" id="myPage" value="내 정보 보기">
				<input type="button" id="logout" value="로그아웃" onclick="logout();">
			
			</div> 
		</div>
		<br>
		<br>
		<% }%>
	</div>
	<br clear="all">
		
	
	<br>
	
	<div class="wrap">
		<nav>
			<div class="menu" onclick="goHome();">HOME</div>
			<div class="menu" onclick="goNotice();">공지사항</div>
			<div class="menu" onclick="goBoard();">게시판</div>
			<div class="menu" onclick="goThumbnail();">사진게시판</div>
		</nav>
	</div>
	

	
	
	
<!-- 	<footer>
	<p class="footer" align="center">ⓒ2020-2020 Good ball</p>
	</footer> -->
	
	<script>
		function logout() {
			location.href="<%= request.getContextPath() %>/logout.me";
		}
		
		function memberJoin() {
			location.href="<%= request.getContextPath() %>/login";
			
			
		}
		
		
	</script>
	
	
</body>
</html>