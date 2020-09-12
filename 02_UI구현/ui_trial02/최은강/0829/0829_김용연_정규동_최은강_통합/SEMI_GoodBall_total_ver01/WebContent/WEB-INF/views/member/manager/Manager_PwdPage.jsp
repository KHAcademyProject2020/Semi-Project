<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_page</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	body{
		text-align:center;
		height:700px;
	}

	.form-horizontal{
		width:100%;
		margin:0 auto;
		padding:0 50px;
		box-sizing:border-box;
		position:relative;
		top:50%;
		transform:translateY(-80%);
	}
	
	.form-group{
		width:300px;
		height:35px;
		margin: 10px 0 30px 0;
		position:relative;
		display:inline-block;
	} 
	
	.form-group > input{
		width:100%;
		height:100%;
		border:none;
		border:2px solid #03D392;
		font-size:18px;
	}
	
	.form-group > label{
		position:absolute;
		top:2px;
		left:15px;
		transform:translateY(-50%);
		font-size:15px;
		color:#03D392;
		padding:0px;
		background:#fff;
	}
	
	/* hr */
	hr{
		border:0;
		height: 3px;
		background:#ccc;
	}
	
	/* 버튼 */
	.btn-groups button{
		background-color:#03D392;
		color:#fff;
		border:0;
		width:70%;
		height:40px;
	}
	
</style>
</head>
<body>
	<form class="form-horizontal" action="<%= request.getContextPath() %>/deleteMember.me" method="post" onsubmit="return deleteMember();">
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" value="<%= loginUser.getEmail() %>"/>
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label>
			<input type="password" name="encryptPwd" id="encryptPwd" placeholder="비밀번호 확인" required>
			<input type="hidden" name="originPwd" id="originPwd" value="<%= loginUser.getPwd() %>">
			
		</div>
		<hr>
		<!--버튼그룹  -->
		<div class="btn-groups">
			<button type="submit">회원 탈퇴</button>
		</div>
		<!--버튼그룹끝  -->
	</form>
	<script>
		function deleteMember(){
			
			var originPwd = $("#originPwd").val();
			
				var result = confirm("정말 탈퇴 하시겠습니까?");
				
				if(result){
					return true;
				} else{
					return false;
				}
			
			return false;
			
		}	
		
	</script>
</body>
</html>