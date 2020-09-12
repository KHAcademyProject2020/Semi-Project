<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, team.model.vo.Team, member.model.vo.Member"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	ArrayList<Team> teamArr = (ArrayList<Team>)request.getAttribute("teamArr");
	Team team = (Team)request.getAttribute("team");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_team_page</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	body{
		text-align:center;
		height:700px;
	}

	.table_div{
		position:relative;
	}

	.table{
		width:500px;
		text-align:center;
		border-collapse:collapse;
		margin: 0 auto;
	}
	
	th{
		color:#fff;
		border:2px solid #03D392;
		height:50px;
	}

	.table > thead{background-color:#03D392;}
	
	.table > thead th:nth-child(4){
		width:250px;
	}
	
	td{
		height:100px;
	}
	
	.btn{
		background:red;
		border:0;
		width: 50px;
    	height: 30px;
    	border-radius: 5px;
    	color: #fff;
	}
	
	ul{
		list-style:none;
		text-align:left;
	}
	
	.teamImg{width:50px; height:50px;}
</style>
</head>
<body>

	<div class="table_div">
        <table class="table">
           <thead>
              <tr>
                 <th scope="col">No</th>
                 <th scope="col">팀 로고</th>
                 <th scope="col">팀 이름</th>
                 <th scope="col">정보</th>
                 <th scope="col">탈퇴</th>
              </tr>
         	</thead>
         	<tbody>
         	<% if(teamArr.isEmpty() && team == null){%>
	         	
	         		<tr>
	               		<td colspan="5">조회된 리스트가 없습니다.</td>
	            	</tr>
	     
            <% } %>
         	<% if(!teamArr.isEmpty()) {%>
            	<% for(Team t : teamArr){ %>
              <tr>
                 <td scope="row"><%= t.getTeam_num() %></td>
                 <td><img class="teamImg" src="<%=request.getContextPath() %>/resources/storage/<%= t.getTeam_leader() %>/team_img/<%= t.getTeam_mark_img() %>"></td>
                 <td class="teamName"><a href="#" class="goPage" team_code="<%= team.getTeam_code() %>"><%= t.getTeam_name() %></a></td>
                 <td>
                 	<ul>
                 		<li>지역 : <%= t.getTeam_region() %></li>
                 		<li>팀장 : <%= t.getTeam_leader() %></li>
                 		<li>성별 : <%= t.getTeam_gender() %></li>
                 		<li>연령대 : <%= t.getTeam_age() %></li>
                 	</ul>
                 </td>
                 <td><button type="button" class="btn" team_code="<%= t.getTeam_code() %>">탈퇴</button></td>
              </tr>
              	<% } %>
              <% } %>
              <% if(team != null){ %>
            	<tr>
                 <td scope="row"><%= team.getTeam_num() %></td>
                 <td><img class="teamImg" src="<%=request.getContextPath() %>/resources/storage/<%= loginUser.getEmail() %>/team_img/<%= team.getTeam_mark_img() %>"></td>
                 <td class="teamName"><a href="#" class="goPage" team_code="<%= team.getTeam_code() %>"><%= team.getTeam_name() %></a></td>
                 <td>
                 	<ul>
                 		<li>지역 : <%= team.getTeam_region() %></li>
                 		<li>팀장 : <%= loginUser.getEmail() %></li>
                 		<li>성별 : <%= team.getTeam_gender() %></li>
                 		<li>연령대 : <%= team.getTeam_age() %></li>
                 	</ul>
                 </td>
                 <td><button type="button" class="btn" team_code="<%= team.getTeam_code() %>">삭제</button></td>
              </tr>
            <% } %>
           </tbody>
        </table>
     </div>
     <script>
   		$(".btn").click(function(){
   			var teamName = $(this).parent().parent().children().eq(2).text();
   			var result = confirm(teamName + "팀에서 탈퇴시겠습니까?");
   			var team_code = $(this).attr("team_code");
   			var text = $(this).text();
   			var id = "<%=" + loginUser.getEmail()+ "%>";
   			
   			console.log(team_code);
   			console.log(text);
   			
   			if(result){
   				/* 탈퇴 메소드 */
   				if(text == "삭제"){
   					location.href="<%= request.getContextPath() %>/teamDelete.tm?code=" + team_code;
   				} else{
   					location.href="<%= request.getContextPath() %>/teamWithdraw.tm?code=" + team_code + "&id=" + id;
   				}
   				alert(teamName + "팀에 탈퇴되었습니다");
   			} else{
   				alert(teamName + "팀 탈퇴를 취소합니다");
   			}
   		});
   		
   		$(".goPage").click(function(){
   			var team_code = $(this).attr("team_code");
   			
   			top.location.href="<%= request.getContextPath() %>/teamMemberInfo.me?team_code=" + team_code;
   		});
     </script>
</body>
</html>