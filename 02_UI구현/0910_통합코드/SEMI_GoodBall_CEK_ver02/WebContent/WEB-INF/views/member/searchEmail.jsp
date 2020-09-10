<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import ="member.model.vo.*" %>
    <%
	Member member = (Member)request.getAttribute("Member");
	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/common/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/findEmailForm.css">
<body>
<%@include file="/WEB-INF/views/common/navbar.jsp" %>	
	<div class="wrap">
		<div id="userName">[<%= member.getName() %>]님의 아이디</div><br>
		<div id="userEmail">[<%= member.getEmail() %>]입니다.</div>
		<button id="btnF" class="btnFind" onclick="location.href='login'">로그인 하러가기</button>		
	</div>

</body>
</html>