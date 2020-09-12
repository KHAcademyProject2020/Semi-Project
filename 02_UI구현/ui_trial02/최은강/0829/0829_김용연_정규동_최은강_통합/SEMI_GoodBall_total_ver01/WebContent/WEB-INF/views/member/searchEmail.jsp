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
<title>이메일 찾기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<style>
#body{
background: #e5f8f7;
}
.wrap {
	height: 700px;
	text-align: center;
	
}

.search-email-form {
	width: 550px;
	margin: 0 auto;
	position: relative;
	top: 50%;
	transform: translateY(-50%);
}
.search-form{
   width: 550px;
   height: 35px;
   margin: 100px 0 30px 0;
   position: relative;
   

}

#btnF{
   border: 2px solid #fff;
   color: black;
   line-height: 30px;
   border-radius: 12px;
   width: 180px;
   margin: 8px;
   background: #fff;
}

</style>

</head>

<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/common/favicon/favicon.ico"
	type="image/x-icon">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/findEmailForm.css">

<body id="body">

	<%@include file="/WEB-INF/views/common/navbar.jsp"%>

	<div class="wrap">
		<div class="search-email-form" id="mail1">
			<div class="search-form" id="find-mail">
				<div class="search-enail" id="email-mail">
					<div id="userName"><h3><%=member.getName()%>님의 아이디는</h3>
					</div>
					<br>
				</div>
				<div class="search-enail" id="na-mail">
					<div id="userEmail"><h3><%=member.getEmail()%>입니다.</h3>
					</div>
				</div>
			</div>
			<div class="search-form" id="find-btn">
				<div class="search-btn" id="find-bt">
					<button id="btnF" class="btnFind" onclick="location.href='login'">로그인
						하러가기</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>