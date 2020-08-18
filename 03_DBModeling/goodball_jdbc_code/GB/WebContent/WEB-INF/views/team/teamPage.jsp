<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="team.model.vo.Team"%>
  
<%
	ArrayList<Team> teamArr = (ArrayList)request.getAttribute("teamArr");
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="./resources/css/GB_frame.css">


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
<style>
	.outer{
		width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 5%;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">팀 정보 보기</h2>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">no</th>
					<th scope="col">팀이름</th>
					<th scope="col">팀성별</th>
					<th scope="col">팀지역</th>
					<th scope="col">팀별점</th>
				</tr>
			</thead>
			<tbody>
			<%
				for(int i = 0; i < teamArr.size(); i++) {
					
			%>
				<tr onclick="location.href='<%= request.getContextPath() %>/teamInfo.me?team_code=<%= teamArr.get(i).getTeam_code()%>';">
					<th scope="row"><%= i+1%></th>
					<td><%=teamArr.get(i).getTeam_name() %></td>
					<td><%=teamArr.get(i).getTeam_gender() %></td>
					<td><%=teamArr.get(i).getTeam_region() %></td>
					<td align="center"><%=teamArr.get(i).getTeam_point() %></td>
				</tr>
				
			<%	
				}			
			%>
			
			
			</tbody>
		</table>
		<br>
			
		
	</div>
</body>
</html>