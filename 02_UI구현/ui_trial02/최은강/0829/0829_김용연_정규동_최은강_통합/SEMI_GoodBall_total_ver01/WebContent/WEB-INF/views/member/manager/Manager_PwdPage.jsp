<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Good ball 마이페이지 (매니저)</title>
<style>
	body{
		text-align:center;
		height:700px;
	}

	.form-horizontal{
		width:500px;
		margin:0 auto;
		padding:0 100px;
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
		width:100%;
		height:40px;
	}
	
</style>
</head>
<body>
	<form class="form-horizontal" method="post" action="#">
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" placeholder="변경 불가"/>
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password" placeholder="비밀번호 확인" >
		</div>
		<hr>
		<!--버튼그룹  -->
		<div class="btn-groups">
			<button type="button" class=""
				onclick="deleteMember();">회원 탈퇴</button>
		</div>
		<!--버튼그룹끝  -->
	</form>
	<script>
		function deleteMember(){
			var result = confirm("정말 삭제 하시겠습니까?");
			
			if(result === true){
				location.href="<%= request.getContextPath() %>/deleteMember.me";
				alert("정상적으로 삭제되었습니다^^");
			}
		}
	</script>
	
</body>
</html>