<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 중복 검사</title>
</head>
<body onload="inputValue();">
	<b>이메일 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkEmail.me" id="checkEmailForm">
		<input type="email" id="inputEmail" name="inputEmail">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	<%
		if(request.getAttribute("result") != null){
			int result = (int)request.getAttribute("result");
			
			if(result > 0){	%>
				이미 사용 중인 이메일 입니다.
			<%} else {%>
				사용 가능한 이메일 입니다.
			<%}
			}%>
	
	<br>
	<br>
	
	<input type="button" id="usedEmail" value="확인" onclick="usedEmail();">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){
			// openr 나를 열게 해준놈 (부모창)
//			document.getElementById('inputId').value = opener.document.joinForm.joinUserId.value;
			
			if('<%= request.getAttribute("checkedNick") %>'=='null'){
				document.getElementById('inputEmail').value = opener.document.joinForm.email.value;				
			} else {
				document.getElementById('inputEmail').value = '<%= request.getAttribute("checkedNick") %>';
			}
			
		}
		
		function usedEmail(){
			opener.document.joinForm.email.value = document.getElementById('inputEmail').value;
			self.close();
		}
	</script>

</body>
</html>