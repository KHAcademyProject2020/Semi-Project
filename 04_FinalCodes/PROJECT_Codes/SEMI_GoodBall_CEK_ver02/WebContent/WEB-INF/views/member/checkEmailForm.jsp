<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 중복 검사</title>
<style>
#body{
background: #e5f8f7;
text-align: center;
}
#inputSub{
border-radius: 12px;
border: 1px solid #fff;
background: #fff;
}
#inputEmail{
 border: 1px solid #03D392;
}
.btn{
   border: 1px solid #fff;
   color: black;
   line-height: 30px;
   border-radius: 12px;
   width: 60px;
   margin: 8px;
   background: #fff;
}
#p2{
color: red;
}
</style>
</head>
<body id="body"onload="inputValue();">
	<b>이메일 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkEmail.me" id="checkEmailForm">
		<input type="email" id="inputEmail" name="inputEmail">
		<input type="submit" id="inputSub" value="중복확인"/>
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
	
	<input class="btn" type="button" id="usedEmail" value="확인" onclick="usedEmail();">
	<input class="btn" type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){

			
			if('<%= request.getAttribute("checkedEmail") %>'=='null'){
				document.getElementById('inputEmail').value = opener.document.joinForm.email.value;				
			} else {
				document.getElementById('inputEmail').value = '<%= request.getAttribute("checkedEmail") %>';
			}
			
		}
		
		function usedEmail(){
			opener.document.joinForm.email.value = document.getElementById('inputEmail').value;
			self.close();
		}
	</script>

</body>
</html>