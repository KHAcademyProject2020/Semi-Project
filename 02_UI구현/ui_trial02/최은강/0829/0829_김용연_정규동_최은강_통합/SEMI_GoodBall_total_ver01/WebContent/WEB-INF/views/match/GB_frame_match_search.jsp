<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
      
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

</head>
<style>
.simple {
    display: inline-block;
    font: inherit;
    font-weight: bold;
    font-size: 20px;
    cursor: pointer;
    background-color: #5ca1cd;
    color: #fff;
    text-decoration: none;
    padding: 20px 45px;
    border: none;
    border-bottom: 3px solid #3f84b0;
    border-radius: 3px;
    width: 500px;
}
.simple:hover {background-color: #61a8d5;}
</style>
<body>
	<h4>&lt;매치 상세검색&gt;</h4>
	<br>
	<br>
	<form id="matchSearchForm">
		<div class="form-group">
			<label for="recipient-name" class="control-label"
				style="font-size: 25px;">팀이름 : </label>
			<div class="input-group input-group-lg">
				<input type="text" class="form-control input-sm" id="match_name"
					placeholder="팀이름입력">
			</div>
		</div>
		<div class="form-group">
			<div class="input-group mb-3">
				<label for="recipient-name" class="control-label"
					style="font-size: 25px;">성별 : </label> &nbsp;&nbsp;&nbsp;&nbsp; <span
					class="input-group-addon"> <i class="fa fa-user fa"
					aria-hidden="true"></i>
				</span> <select id="match_gender">
					<option value="">성별 선택</option>
					<option value="남자그룹">남자그룹</option>
					<option value="여자그룹">여자그룹</option>
					<option value="남녀그룹">남녀그룹</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group mb-3">
				<label for="recipient-name" class="control-label"
					style="font-size: 25px;">연령대 : </label> &nbsp;&nbsp;&nbsp;&nbsp; <span
					class="input-group-addon"> <i class="fa fa-user fa"
					aria-hidden="true"></i>
				</span> <select id="match_age">
					<option value="">연령 선택</option>
					<option value="10대">10대</option>
					<option value="20대">20대</option>
					<option value="30대">30대</option>
					<option value="40대">40대</option>
					<option value="50대">50대</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group mb-3">
				<label for="recipient-name" class="control-label"
					style="font-size: 25px;">매치인원 : </label> &nbsp;&nbsp;&nbsp;&nbsp; <span
					class="input-group-addon"> <i class="fa fa-user fa"
					aria-hidden="true"></i>
				</span> <select id="match_matchMember">
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
			<label for="recipient-name" class="control-label"
				style="font-size: 25px;">장소 : </label>
			<div class="input-group input-group-lg">
				<input type="text" class="form-control input-sm" id="branch_address"
					placeholder="장소입력">
			</div>
		</div>
		<div class="form-group">
			<div class="input-group mb-3">
				<label for="recipient-name" class="control-label"
					style="font-size: 25px;">이용날짜 : </label>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="input-group-addon">
					<i class="fa fa-user fa" aria-hidden="true"></i>
				</span> 
				<input type="date" id="date">
			</div>
		</div>
		<div class="form-group">
			<div class="input-group mb-3">
				<label for="recipient-name" class="control-label"
					style="font-size: 25px;">이용시간 : </label>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="input-group-addon">
					<i class="fa fa-user fa" aria-hidden="true"></i>
				</span> 
				<select name="startTime" id="startTime"></select>
				&nbsp;&nbsp;&nbsp;_&nbsp;&nbsp;&nbsp; 
				<select name="endTime" id="endTime">
					<option value="0">00시</option>
				</select>
			</div>
		</div>
	</form>
	<br>
	
	<input type="button" id="confirm" class="simple" value="매치검색" onclick="matchSearch();">
	<!-- <input type="button" id="cancel" value="취소" onclick="window.close();"> -->
	
	<script>
		
		function matchSearch(){
			opener.document.match.search_match_name.value = document.getElementById("match_name").value;
			opener.document.match.search_match_gender.value = document.getElementById("match_gender").value;
			opener.document.match.search_match_age.value = document.getElementById("match_age").value;
			opener.document.match.search_match_matchMember.value = document.getElementById("match_matchMember").value;
			opener.document.match.search_date.value = document.getElementById("date").value;
			opener.document.match.search_startTime.value = document.getElementById("startTime").value;
			opener.document.match.search_endTime.value = document.getElementById("endTime").value;
			opener.parent.matchSearch2();
			self.close();
		}
		
		$("#startTime").on("change", function(){
			var endTime = [];
			var value = "";
			var time = $(this).val();
			var endTime1 = time.split('시');
			var endTime2 = parseInt(endTime1[0]);
			for(var i =endTime2; i < 24; i++) {
				if(i < 10) {
					value = "0" + i;
				}else {
					value = i;
				}
				endTime[i] = "<option value"+ value +">"+value+"시</option>"
			}
			$('#endTime').empty();
			$('#endTime').append(endTime.join(''));
		});
		
		
		var startTime = [];
		var value = "";
		for(var i =0; i < 24; i++) {
			if(i < 10) {
				value = "0" + i;
			}else {
				value = i;
			}
			startTime[i] = "<option value"+ value +">"+value+"시</option>";
		}
		$('#startTime').append(startTime.join(''));
		
		
	</script>
</body>
</html>