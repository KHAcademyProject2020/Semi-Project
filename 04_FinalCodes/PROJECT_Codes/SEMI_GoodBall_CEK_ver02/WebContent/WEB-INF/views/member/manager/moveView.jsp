<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
		$(function(){
			top.location.href="<%= request.getContextPath() %>/myPage_Manager_Form.me";
		});
	
</script>
</head>
<body>

</body>
</html>