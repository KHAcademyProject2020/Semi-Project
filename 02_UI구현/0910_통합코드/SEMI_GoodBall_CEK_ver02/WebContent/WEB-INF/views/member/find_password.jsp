<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<style>

.main-find{
		height: 150px;
		text-align: center;
}
.form-find {
   width: 550px;
   margin: 0 auto;
   position: relative;
   top: 50%;
   transform: translateY(-50%);
}

.form-group {
   width: 550px;
   height: 35px;
   margin: 10px 0 30px 0;
   position: relative;
}

.form-group>input {
   width: 100%;
   height: 100%;
   border: none;
   border: 2px solid #03D392;
   font-size: 18px;
}

.form-group>input[type="date"] {
   font-size: 12px;
}

.form-group>label {
   position: absolute;
   top: 2px;
   left: 15px;
   transform: translateY(-50%);
   font-size: 15px;
   color: #03D392;
   padding: 0px;
   background:#fff;
   
}

#findBtn{
   border: 2px solid #fff;
   color: black;
   line-height: 30px;
   border-radius: 12px;
   width: 180px;
   margin: 8px;
   background: #fff;

}

#goMain1{
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
<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/common/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/findEmailForm.css">


<body>

	<%@include file="/WEB-INF/views/common/navbar.jsp" %>
	<section>
	
	<form name="searchfrm">
		<input type="hidden" name="email">
		<input type="hidden" name="name">
	
	</form>
	
	
	<div id="main-container" class="main-content-container"> 
		<div class="member-form-container">
	<div class="main-find" ></div>
			<form action="<%=request.getContextPath()%>/FindPwd"
            class="form-find" method="post" id="joinForm" name="joinForm">
            
            <div class="emailLabei">
            	<h2 class="emailName">비밀번호 찾기</h2>
            </div>
		    <br>
			<div class="form-group" id="find-group-name">
               <label for="name">이메일</label> 
               <input type="email" name="find_email" id="find_email" placeholder="이메일을 입력해주세요!">
            </div>
            
            <div class="form-group" id="find-group-phone">
               <label for="name">이름 :</label> 
               <input type="text" name="find_name" id="find_name" placeholder="이름 입력해주세요!">
            </div>
            
            <div class="btn-find" id="submitBtn">
            	<input type="submit" id="findBtn" value="비밀번호 찾기" onclick="searchPassword();">
            	<input type="button" id="goMain1" onclick="goMain();" value="메인으로">
            </div>
			</form>
	
		</div>
	</div>
	</section>	


</body>
</html>