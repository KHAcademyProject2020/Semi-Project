<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="branch.model.vo.Stadium"%>
<%
	Stadium stadium = (Stadium)request.getAttribute("stadium");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	body{
		text-align:center;
		padding-top:30%;
	}

	.form-horizontal{
		width:100%;
		margin:0 auto;
		padding:0 50px;
		box-sizing:border-box;
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
	
	.form-group > div{
		width:100%;
		height:100%;
		border:none;
		border:2px solid #03D392;
		padding-top:15px;
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
	
	.btn-groups{
		text-align:center;
		display:flex;
	}
	
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
	<form>
	<div class="form-group">
		<label for="stadiumName">구장이름</label>
		<input type="text" name="stadiumName" id="stadiumName" value="<%= stadium.getStadium_name() %>"/>
	</div>
	
	
	
	<div class="form-group">
	<label for="stadium_matchMember">매치인원</label>
	<div>
	<select id="stadium_matchMember">
		<option value="">매치인원 선택</option>
		<option value="3vs3">3 vs 3</option>
		<option value="4vs4">4 vs 4</option>
		<option value="5vs5">5 vs 5</option>
		<option value="6vs6">6 vs 6</option>
		<option value="7vs7">7 vs 7</option>
		<option value="8vs8">8 vs 8</option>
	</select>
	</div>
	</div>	
	<div class="form-group">
		<label for="stadium_time">예약가능시간</label>		
		<div>			
		<select name="startTime" id="startTime">
			<option value="8">08시</option>
			<option value="9">09시</option>
			<option value="10">10시</option>
			<option value="11">11시</option>
			<option value="12">12시</option>
		</select>
		<select name="endTime" id="endTime">
			<option>18시</option>
			<option>19시</option>
			<option>20시</option>
			<option>21시</option>
			<option>22시</option>
			<option>23시</option>
			<option value="0">00시</option>
		</select>
		</div>
	</div>	
		<div class="btn-groups">
			<button type="submit" id="stadiumRegistBtn" class="simple">구장 수정</button>
			<button type="button" class="">닫기</button>
		</div>
	</form>		
</body>
</html>