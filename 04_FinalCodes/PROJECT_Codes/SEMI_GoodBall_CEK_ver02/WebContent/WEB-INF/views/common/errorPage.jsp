<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류페이지</title>
<style>
.body{
background: #e5f8f7;
height: 700px;
text-align: center;
}
.Top{
margin: 0 auto;
height: 400px;
}
.btn{
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
<body class="body">
		<div class="Top"></div>
	<h1 align="center"><%= msg %></h1>
	<div align="center" class="btnG">
		<button class="btn" onclick="history.back()">이전 페이지</button>
		<button class="btn" onclick="location.href='<%= request.getContextPath() %>'">홈으로 돌아가기</button>
		
	</div>
	
	
</body>
</html>