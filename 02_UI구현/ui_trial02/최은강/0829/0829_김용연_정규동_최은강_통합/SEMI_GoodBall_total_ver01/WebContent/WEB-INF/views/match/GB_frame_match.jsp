<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, team.model.vo.*"%>

<%
	ArrayList<Match> matchArr = (ArrayList<Match>) request.getAttribute("matchArr");

	PageInfo pi = (PageInfo) request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<title>Good Ball (매치 페이지)</title>

   <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
        
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>


<style>
#content{
	width:100%;
	margin: 0 auto;
	text-align: center;
	/* font-size: 1.2vw; */
}
.container-for-carousel{
	width:100%;
}
.container-for-content{
		padding-top: 3%;
		margin-left: 5%;
		margin-right: 5%;
		padding-left: 10%;
		padding-right: 10%;	
		padding-bottom: 5%;
		/*내용 컴포넌트를 넣는 곳*/
		background-color: rgba(223,232,225,0.1); 
}
td{
	font-size: 1.0em;
	margin:auto 0;
	color: gray;
}
.matchSearch{
	width:300px; 
  	height:50px;
	border:3px solid #ccc;
}
.matchSearch::placeholder{
	color: gray;
	font-size: large;
	font-weight:200;
}
.acBtn {
    background-color: #33DF5E;
    display: inline-block;
    font: inherit;
    font-weight: bold;
    font-size: 15px;
    cursor: pointer;
    color: #fff;
    text-decoration: none;
    padding: 5px 10px;
    border: none;
    border-bottom: 3px solid #3f84b0;
    border-radius: 3px;
    margin-bottom: 10px;
    
}
.acBtn:hover{
	background: #36BF59;
}
.caBtn {
    background-color: #f8585b;
    display: inline-block;
    font: inherit;
    font-weight: bold;
    font-size: 15px;
    cursor: pointer;
    color: #fff;
    text-decoration: none;
    padding: 5px 10px;
    border: none;
    border-bottom: 3px solid #3f84b0;
    border-radius: 3px;
    margin-bottom: 10px;
   
}
.simple {
    display: inline-block;
    font: inherit;
    font-weight: bold;
    font-size: 20px;
    cursor: pointer;
    background-color: #5ca1cd;
    color: #fff;
    text-decoration: none;
    padding: 10px 25px;
    border: none;
    border-bottom: 3px solid #3f84b0;
    border-radius: 3px;
}
.simple:hover {background-color: #61a8d5;}
#paging {
	display: inline-block;
}
#paging .page-link {
	Color: black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/navbar.jsp"%>

	<!-- BODY 시작 -->
	<section id="content">
		<!-- container-for-carousel 시작-->
		<div class="container-for-carousel">
			<!-- carousel start -->
			<div class="carousel-container">
			
			</div>
			<!-- carousel end -->
		</div>
		<!-- .container-for-carousel 끝-->
		<!--container-for-content 시작-->
		<div class="container-for-content">
			<!-- container-for-content안에 내용을 넣어주세요~ -->
			<div class="container-content">
			<!-- container안에 들어있는 내용이 바뀜. -->
				<br><br>
		
				<br><br>
				<form action="" id="match" name="match">
					<input type="text" id="search_match_name" class="matchSearch" style="float: left;" value="" placeholder="팀이름입력">
					<button type="button" class="simple" style="float: left; margin-left:10px;" onclick="teamNameSearch();" value="">팀검색</button>
					<input type="hidden" id="search_match_gender" value="">
					<input type="hidden" id="search_match_age" value="">
					<input type="hidden" id="search_match_matchMember" value="">
					<input type="hidden" id="search_date" value="">
					<input type="hidden" id="search_startTime" value="0">
					<input type="hidden" id="search_endTime" value="0">
					<button type="button" class="simple" style="float: left; margin-left:10px;" onclick="matchSearch();">상세검색</button>
					<button type="button" id="matchRegist" style="float: right;" class="simple" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">매치등록</button>
				</form>
				<br><br>
				<div class="wrap4" id="wrap4">
					<hr>
					<h1>매치 정보 보기</h1>
					<hr>
					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th scope="row">no</th>
								<th scope="col">팀</th>
								<th scope="col">-</th>
								<th scope="col">-</th>
								<th scope="col">매치</th>
								<th scope="col">구장</th>
								<th scope="col">시간</th>
								<th scope="col">날짜</th>
								<th scope="col">이미지</th>
								<th scope="col">장소</th>
								<th scope="col">신청</th>
							</tr>
						</thead>
						<tbody>
							<% if(matchArr.isEmpty()){ %>
							<tr>
								<td colspan="11">존재하는매치가없습니다</td>
							</tr>
							<% } else { %>
							
							<%		for (int i = 0; i < matchArr.size(); i++) {%>
							<tr>
								<th scope="row"><%= matchArr.get(i).getRegist_num()%></th>
								<td><%= matchArr.get(i).getTeam_name()%></td>
								<td><%= matchArr.get(i).getTeam_gender()%></td>
								<td><%= matchArr.get(i).getTeam_age()%></td>
								<td><%= matchArr.get(i).getStadium_match_member()%></td>
								<td><%= matchArr.get(i).getStadium_name()%></td>
								<td><%= matchArr.get(i).getReservation_usage_start_time()%>:00 ~ <%= matchArr.get(i).getReservation_usage_end_time()%>:00</td>
								<td><%= matchArr.get(i).getReservation_usage_start_date()%></td>
								<td><img src="<%=request.getContextPath()%>/resources/storage/manager/<%= matchArr.get(i).getBranch_manager_email()%>/<%= matchArr.get(i).getBranch_img()%>"  width="80px" height="60px"></td>
								<td><%= matchArr.get(i).getBranch_address()%><br><%= matchArr.get(i).getBranch_num()%>지점</td>
								<td><% if(matchArr.get(i).getRegist_status().equals("Y")){%><input type="button" id="acBtn" class="acBtn" registnum="<%= matchArr.get(i).getRegist_num()%>" branchnum="<%= matchArr.get(i).getBranch_num() %>" stadiumnum="<%= matchArr.get(i).getStadium_num() %>" reservationcode="<%= matchArr.get(i).getReservation_code() %>" value="가능"><%}else{%><input type="button" id="caBtn" class="caBtn" value="불가능"><%}%></td>
							</tr>
							<%		}%>
							<%}%>
						</tbody>
					</table>
					
					<div id="paging">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<% if(pi == null){ %>
									<li class="page-item"><a class="page-link">&lt;&lt;</a></li>
									<li class="page-item"><a class="page-link">&lt;</a></li>
					 				<li class="page-item"><a class="page-link">&gt;</a></li>
									<li class="page-item"><a class="page-link">&gt;&gt;</a></li>
								<% } else { %>
									<li class="page-item"><button class="page-link"
											onclick="location.href='<%= request.getContextPath() %>/match.me?&currentPage=1'">&lt;&lt;</button></li>
									<li class="page-item"><button class="page-link"
											onclick="location.href='<%= request.getContextPath() %>/match.me?&currentPage=<%= currentPage - 1%>'"
											id="beforeBtn">&lt;</button></li>
									<% for(int p = startPage; p <= endPage; p ++) {%>
									<% if(p == currentPage){ %>
									<li class="page-item"><button class="page-link"
											id="choosen" style="color: gray;" disabled><%= p %></button></li>
									<% } else { %>
									<li class="page-item"><button class="page-link" id="numBtn"
											onclick="location.href='<%= request.getContextPath() %>/match.me?&currentPage=<%= p %>'"><%= p %></button></li>
									<% } %>
									<% } %>
									<li class="page-item"><button class="page-link"
										onclick="location.href='<%= request.getContextPath() %>/match.me?&currentPage=<%= currentPage + 1 %>'"
										id="afterBtn">&gt;</button></li>
									<li class="page-item"><button class="page-link"
										onclick="location.href='<%= request.getContextPath() %>/match.me?&currentPage=<%= maxPage %>'">&gt;&gt;</button></li>
								<%} %>
							</ul>
						</nav>
					</div>
					<% if(pi != null){ %>
					<script>
						if(<%= currentPage %> <= 1) {
							var before = $('#beforeBtn');
							before.attr('disabled', 'true');
							
						}
						if(<%= currentPage %> >= <%= maxPage%>) {
							var after = $('#afterBtn');
							after.attr('disabled', 'true');
							
						}
					</script>
					<%} %>
				</div>
			
			</div>
		</div>
		<!--container-for-content 끝-->
	</section>
	
	<!--footer  -->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	
	<!-- modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLabel">&lt;매치등록&gt;</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label"
								style="font-size: 25px;">예약코드 : </label>
							<div class="input-group input-group-lg">
								<input type="text" class="form-control input-sm" id="reservation_code"
									placeholder="예약코드입력">
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="matchRegistBtn" class="simple">매치
						등록하기</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>

</body>


<script type="text/javascript">
	
	$(document).on('click', '#acBtn', function(){
	   var registnum = $(this).attr('registnum');		
	   var branchnum = $(this).attr('branchnum');		
	   var stadiumnum = $(this).attr('stadiumnum');		
	   var reservationcode = $(this).attr('reservationcode');
	   console.log(registnum);
	   console.log(branchnum);
	   console.log(stadiumnum);
	   console.log(reservationcode);
	   var userId = '<%= loginUser%>';
	   if(userId != null) {
		   if (confirm("신청하시겠습니까?") == true){
			   $.ajax({
					 url: 'matchApplication.me',
					 data: {userId:userId, regist_num:registnum, branch_num:branchnum, stadium_num:stadiumnum, reservation_code:reservationcode},
					 success: function(data) {
						 console.log(data);
						 
						 if(data == 1) {
							 alert('자기팀에게신청불가');
						 }else if(data == 2){
							 alert('중복신청불가');							 
						 }else if(data == 3){
							 alert('신청되었습니다');							 
						 }else if(data == 4){
							 alert('팀없음');							 
						 }
					 }
				 });
			   
		   }else{
			     return false;
			     
		   }
	   }else {
		   alert('로그인후이용가능');
	   }
	});
	
	$('#matchRegist').on('show.bs.modal', function(event){});
	
	$('#matchRegistBtn').click(function() {
		var userId = '<%= loginUser.getEmail()%>';
		if(userId != null) {
			var reservation_code = $('#reservation_code').val();

			if(reservation_code == "") {
				alert('예약코드 입력해주세요');
				 $("#reservation_code").focus();
			}else {
				if (confirm("등록하시겠습니까?") == true){
					$.ajax({
						 url: 'matchRegist.me',
						 data: {userId:userId, reservation_code:reservation_code},
						 success: function(data) {
							 console.log(data);
							 
							 if(data == 1) {
								 alert('중복등록불가');
							 }else if(data == 2){
								 alert('등록되었습니다');
								 location.href = location.href;
							 }else if(data == 3){
								 alert('예약코드등록불가');
							 }else if(data == 4){
								 alert('예약코드없음');
							 }else {
								 alert('팀없음');
								 
							 }
						 }
					 });
				}else{
				     return false;
				}
			}
		}else {
			alert('로그인후이용가능');
		}
		
	});
	
	function matchSearch(){
		window.open("matchSearchBtn.me", "matchSearchForm", "width=500, height=1000");
	}
	
	function matchSearch2(x) {
		var match_name = $('#search_match_name').val();
		var match_gender = $('#search_match_gender').val();
		var match_age = $('#search_match_age').val();
		var match_matchMember = $('#search_match_matchMember').val();
		var date = $('#search_date').val();
		var startTime = $('#search_startTime').val();
		var startTime1 = startTime.split('시');
		var startTime2 = parseInt(startTime1[0]);
		var endTime = $('#search_endTime').val();
		var endTime1 = endTime.split('시');
		var endTime2 = parseInt(endTime1[0]);
		var page = x;
		var path = '<%= request.getContextPath()%>';
		var testEval = "";
		$.ajax({
			 url: 'matchSearch.me',
			 data: {match_name:match_name, match_gender:match_gender, match_age:match_age, match_matchMember:match_matchMember, date:date,
				 startTime:startTime2, endTime:endTime2, page:page},
			 success: function(data) {
				 console.log(data);
				 
				 if(data.pi.listCount == 0) {
					 alert('매치가없습니다');
					 testEval += '<div class="wrap4" id="wrap4"><hr><br><h1>매치 정보 보기</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
					 testEval += '<tr><th scope="row">no</th><th scope="col">팀</th><th scope="col">-</th><th scope="col">-</th><th scope="col">매치</th><th scope="col">구장</th><th scope="col">시간</th><th scope="col">날짜</th><th scope="col">이미지</th><th scope="col">장소</th><th scope="col">신청</th></tr></thead><tbody>';
					 testEval += '<tr><th colspan="11">존재하는매치기없습니다</th></tr></tbody></table></div><br><br>';
					 testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
					 testEval += '<li class="page-item"><a class="page-link">&lt;&lt;</a></li>';
					 testEval += '<li class="page-item"><a class="page-link">&lt;</a></li>';
					 testEval += '<li class="page-item"><a class="page-link">&gt;</a></li>';
					 testEval += '<li class="page-item"><a class="page-link">&gt;&gt;</a></li>';
				     testEval += '</ul></nav></div></div>';
					 
				 }else {
					 $.each(data, function(key, value) {
						 if(key == "match" && key.listCount != 0) {
							 testEval += '<div class="wrap4" id="wrap4"><hr><br><h1>매치 정보 보기</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
							 testEval += '<tr><th scope="row">no</th><th scope="col">팀</th><th scope="col">-</th><th scope="col">-</th><th scope="col">매치</th><th scope="col">구장</th><th scope="col">시간</th><th scope="col">날짜</th><th scope="col">이미지</th><th scope="col">장소</th><th scope="col">신청</th></tr></thead><tbody>';
							 for (var i = 0; i < value.length; i++) {
								 testEval += '<tr><th scope="row">'+ value[i].regist_num +'</th><td>'+ value[i].team_name +'</td><td>'+ value[i].team_gender +'</td><td>'+ value[i].team_age +'</td><td>'+ value[i].stadium_match_member +'</td><td>'+ value[i].stadium_name +'</td><td>'+ value[i].reservation_usage_start_time +':00 ~ '+ value[i].reservation_usage_end_time +':00</td><td>'+ value[i].reservation_usage_start_date +'</td><td><img src="'+ path +'/resources/storage/manager/'+ value[i].branch_manager_email +'/'+ value[i].branch_img +'" width="80px" height="60px"></td><td>'+ value[i].branch_address+'<br>'+ value[i].branch_num +'지점</td>';
							 	 if(value[i].regist_status == 'Y'){
							 		testEval += '<td><input type="button" id="acBtn" class="acBtn" registnum="'+ value[i].regist_num +'" branchnum="'+ value[i].branch_num +'" stadiumnum="'+ value[i].stadium_num +'" reservationcode="'+ value[i].reservation_code +'" value="가능"></td></tr>';
							 	 }else {
							 		testEval += '<td><input type="button" id="caBtn" class="caBtn" value="불가능"></td></tr>';
							 	 }
							 }
							 testEval += '</tbody></table></div><br><br>';
						 } else if (key == "pi" && key.listCount != 0) {
							 testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
							 testEval += '<li class="page-item"><button class="page-link" onclick="goPage1();">&lt;&lt;</button></li>';
							 testEval += '<li class="page-item"><button class="page-link" onclick="goPage1('+ (value.currentPage-1) +');">&lt;</button></li>';
							 for(var p = value.startPage; p <= value.endPage; p++) {
								 if(p == value.currentPage){
									 testEval += '<li class="page-item"><button class="page-link" id="choosen" style="color: gray;" disabled>'+ p +'</button></li>';
									 
								 }else {
									 testEval += '<li class="page-item"><button class="page-link" onclick="goPage1('+ p +');">'+ p +'</button></li>';
								 }
								 
							 }
							 testEval += '<li class="page-item"><button class="page-link" onclick="goPage1('+ (value.currentPage+1) +');">&gt;</button></li>'; 
							 testEval += '<li class="page-item"><button class="page-link" onclick="goPage1('+ value.maxPage +');">&gt;&gt;</button></li>';
							 testEval += '</ul></nav></div></div>';
							 
						 } else {
						 }
					 });
				 }
				 
				 $('#wrap4').html(testEval);
			 }
		 });
	}
	
	function goPage1(page) {
		var page = page;
		matchSearch2(page);
	};
	
	
	function teamNameSearch() {
		var match_num = $('#search_match_name').val();
		if(match_num == "") {
			$('#search_match_name').val('');
			$('#search_match_gender').val('');
			$('#search_match_age').val('');
			$('#search_match_matchMember').val('');
			$('#search_date').val('');
			$('#search_startTime').val('0');
			$('#search_endTime').val('0');
			matchSearch2(1);
		}else {
			$('#search_match_gender').val('');
			$('#search_match_age').val('');
			$('#search_match_matchMember').val('');
			$('#search_date').val('');
			$('#search_startTime').val('0');
			$('#search_endTime').val('0');
			matchSearch2(1);
		}
	};
	
	
</script>

</html>