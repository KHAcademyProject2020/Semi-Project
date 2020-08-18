<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Calendar, java.util.ArrayList, team.model.vo.Team, team.model.vo.TeamMember, member.model.vo.Member"  %>
<%
	String loginUser = ((Member)session.getAttribute("loginUser")).getEmail();
	System.out.println(loginUser);
	Team teamInfo = (Team)request.getAttribute("teamInfo");
	ArrayList<TeamMember> teamMemberArr = (ArrayList)request.getAttribute("teamMemberArr");
	ArrayList<Member> memberArr = (ArrayList)request.getAttribute("memberArr");
	
	Calendar current = Calendar.getInstance();
	int year = current.get(Calendar.YEAR);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Ball (팀 페이지)</title>


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


<script src='https://d3js.org/d3.v3.min.js'></script>


<style>


/* d3 */

.xaxis path,
.xaxis line,
.yaxis path,
.yaxis line {
    stroke: #aaa;
    fill: none;
    shape-rendering: crispEdges;
}

.xaxis text,
.yaxis text {
    font-family: sans-serif;
    font-size: 11px;
    fill: #aaa;
}

.datapoint {
    cursor: pointer;
    stroke: #111;
    fill: rgba(0, 150, 255, .75);
    stroke-width: 7;
}

.lineChart {
    fill: none;
    stroke-width: 3;
    stroke: rgba(100,100,100, 1);
}

/* 로고 보이기 */
.carousel, .slide {
	height: 90%;
}

.d-block, .w-100 {
	height: 90%;
}


#paging {
	display: inline-block;
}

.wrap {
	width: 70%;
	margin-left: 100px;
}

.wrap3{background: rgba(223,232,225,0.1); width: 100%; height: 50px;}
   .nav-item2{
   		background: rgba(223,232,225,0.1); color: navy; text-align: center; font-weight: bold;
   		vertical-align: middle; width: 150px; height: 50px; display: table-cell;
   }
   .navy{width: 400px; margin-left: auto; margin-right: auto;}
   .nav-item2:hover{background: beige; color: orangered; font-weight: bold; cursor: pointer;}
	
#paging .page-link {
	Color: black;
}
</style>
</head>

<body>
	<div id="page">
		<!-- HEAD(고정) : 내용변경하지 마세요~ -->
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div id="home-logo">
					<a class="navbar-brand" href="#"> <img
						src="./resources/images/main_logo.png" alt="logo">
					</a>
				</div>

				<!-- 햄버거 버튼 -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarText" aria-controls="navbarText"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>


				<div class="collapse navbar-collapse" id="navbarText">
					<ul class="navbar-nav mr-auto">
						<br>

						<li class="nav-item active"><a class="nav-link" href="#">공지사항
								<span class="sr-only">(current)</span>
						</a></li>

						<li class="nav-item"><a class="nav-link" href="#">FAQ</a></li>

						<li class="nav-item"><a class="nav-link" href="#">매치</a></li>

						<li class="nav-item"><a class="nav-link" href="#">구장</a></li>

						<li class="nav-item"><a class="nav-link" href="#">용병</a></li>

						<li class="nav-item"><a class="nav-link" href="#">팀</a></li>

						<li class="nav-item"><a class="nav-link" href="#">커뮤니티</a></li>
					</ul>

				</div>
			</nav>
		</header>
		<!-- HEADER 끝-->


		<!-- BODY 시작 -->
		<section id="content">

			<!-- container-for-carousel 시작-->
			<div class="container-for-carousel">

				<!-- carousel start -->
				<div class="carousel-container">
					<div id="carouselExampleCaptions" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleCaptions" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
							<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="./resources/images/carousel_imgs/cimg1.jpg"
									class="d-block w-100" alt="이벤트이미지1">
								<div class="carousel-caption d-none d-md-block">
									<h5>First slide label</h5>
									<p>Nulla vitae elit libero, a pharetra augue mollis
										interdum.</p>
								</div>
							</div>
							<div class="carousel-item">
								<img src="./resources/images/carousel_imgs/cimg2.jpg"
									class="d-block w-100" alt="이벤트이미지2">
								<div class="carousel-caption d-none d-md-block">
									<h5>Second slide label</h5>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
								</div>
							</div>

							<div class="carousel-item">
								<img src="./resources/images/carousel_imgs/cimg3.jpg"
									class="d-block w-100" alt="이벤트이미지3">
								<div class="carousel-caption d-none d-md-block">
									<h5>Third slide label</h5>
									<p>Praesent commodo cursus magna, vel scelerisque nisl
										consectetur.</p>
								</div>
							</div>
						</div>


						<a class="carousel-control-prev" href="#carouselExampleCaptions"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
				<!-- carousel end -->
			</div>
			<!-- .container-for-carousel 끝-->

			<!--container-for-content 시작-->
			<div class="container-for-content">
				<!-- container-for-content안에 내용을 넣어주세요~ -->

				<div class="container-content">
					<!-- container안에 들어있는 내용이 바뀜. -->

					<div class="wrap">
						<br> <br>
						<div class="media" style="position: relative; left: 20px;">
							<div class="media-left">
								<input type="hidden" size="50" name="team_leader" id="team_leader" value="<%= teamInfo.getTeam_leader()%>">
								<input type="hidden" size="50" name="loginUser" id="loginUser" value="<%= loginUser%>">
								<h2><%= teamInfo.getTeam_name()%></h2>
								
								<a href="#"> <img src="./resources/images/<%= teamInfo.getTeam_mark_img()%>" width="250px" height="200px">
								</a>
							</div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div class="media-body">
								<br> <br>
								<table class="table table-striped">
									<tr>
										<th>지역</th>
										<th><%= teamInfo.getTeam_region()%></th>
									</tr>
									<tr>
										<th>성별</th>
										<td><%= teamInfo.getTeam_gender()%></td>
									</tr>
									<tr>
										<th>연령대</th>
										<td><%= teamInfo.getTeam_age()%></td>
									</tr>
									<tr>
										<th>팀별점</th>
										<td><%= teamInfo.getTeam_point()%></td>
									</tr>

								</table>
							</div>
						</div>
					</div>

					<hr>
					<div class="wrap2" id="wrap2">
						
					</div>
					<br>
					<h4 style="color: gray;">최근날짜</h4>
					<br>
					<hr>
					
					<div class="wrap3">
				   		<nav class="navy">
				   			<div class="nav-item2" onclick="teamInfo();">팀 정보</div>
				   			<div class="nav-item2" onclick="support();">용병 지원</div>
				   			<div class="nav-item2" onclick="match();">매칭 신청</div>
				   		</nav>
				   </div>
				   	
					
					<div class="wrap4" id="wrap4">
			
						<hr>
						<br>
						<h1>팀원 정보</h1>
						<hr>
						<div class="table-responsive">
							<table class="table table-hover">
								<thead class="thead-dark">
									<tr>
										<th scope="col">no</th>
										<th scope="col">이름</th>
										<th scope="col">성별</th>
										<th scope="col">연락처</th>
										<th scope="col">나이</th>
										<th scope="col">포지션</th>
									</tr>
								</thead>
								<tbody>
									<% for(int i = 0; i <memberArr.size(); i++ ) {
										
									%>
									<tr>
										<th scope="row"><%= i+1%></th>
										<td><%= memberArr.get(i).getName() %></td>
										<td><%= memberArr.get(i).getGender() %></td>
										<td><%= memberArr.get(i).getPhone() %></td>
										<td><%= memberArr.get(i).getBirthday()%></td>
										<td><%= teamMemberArr.get(i).getPosition() %></td>
									</tr>
									
									<%
										}
									%>
								</tbody>
							</table>
						</div>
						<br> <br>
						<div id="paging">
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<li class="page-item"><a class="page-link" href="#">이전</a></li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#">4</a></li>
									<li class="page-item"><a class="page-link" href="#">5</a></li>
									<li class="page-item"><a class="page-link" href="#">다음</a></li>
								</ul>
							</nav>
						</div>
						
						<div class="clear"></div>
						
					</div>


				</div>

			</div>
			<!--container-for-content 끝-->

		</section>
		<!--BODY 끝.-->



		<!-- FOOT(고정) : 내용 변경하지마세요~ -->
		<footer>
			<div class="">
				<a href="https://github.com/KHAcademyProject2020/Semi-Project"
					target="_blank">
					<h5>Good Ball</h5>
				</a>
				<p>KH Academy</p>
			</div>
		</footer>

	</div>
</body>
<% if(loginUser != null && loginUser.equals(teamInfo.getTeam_leader())) { %>

<% }%>



<script type="text/javascript">
   let w = 800;
   let h = 400;
   let padding = 25;
   let avg1 = 60/100;
   let avg2 = 40/100;
   let avg3 = 10/100;
   let avg4 = 30/100;
   let avg5 = 20/100;
   
   let dataset = [
   
      [1, 60],
      [2, 40],
      [3, 10],
      [4, 50],
      [5, 50]
   ];
   
   /*create svg element*/
   let svg = d3
      .select("#wrap2")
      .append("svg")
      .attr("width", w)
      .attr("height", h)
      .attr("id", "chart");
   
   let drag = d3.behavior
      .drag()
      .on("dragstart", dragstarted)
      .on("drag", dragged)
      .on("dragend", dragended);
   
   /*x scale*/
   let xScale = d3.scale
      .linear()
      .domain([0, d3.max(dataset, function(d) {return d[0]})])
      .range([padding, w - padding]);
   
   
   /*y scale*/
   let yScale = d3.scale
      .linear()
      .domain([0, 100])
      .range([h - padding, padding]);
      
   /*x axis*/
   let xAxis = d3.svg
      .axis()
      .scale(xScale)
      .orient("bottom");
   
   /*y axis*/
   let yAxis = d3.svg
      .axis()
      .scale(yScale)
      .orient("left");
      
   let today = new Date();   
   
   let year = today.getFullYear(); // 년도
   let month = today.getMonth() + 1;  // 월
   let date = today.getDate();  // 날짜
   let day = today.getDay();  // 요일
   
   var data=[
      {"date":new Date(year,month-1,date-5), "value": 0},
       {"date":new Date(year,month-1,date), "value": 100}
       ];
   
   var x_domain = d3.extent(data, function(d) { return d.date; }),
   y_domain = d3.extent(data, function(d) { return d.value; });
   
   
   var xScale2 = d3.time.scale()
   .domain(x_domain)    // values between for month of january
   .range([padding, w - padding]);   // map these sides of the chart, in this case 100 and 600
   
   // define the y scale  (vertical)
   var yScale2 = d3.scale.linear()
   .domain(y_domain).nice()   // make axis end in round number
   .range([h - padding, padding]);   // map these to the chart height, less padding.  In this case 300 and 100
        //REMEMBER: y axis range has the bigger number first because the y value of zero is at the top of chart and increases as you go down.
   
   var  date_format = d3.time.format('%m/%d');
   //var  date_format = d3.time.format("%d %b");
   
   var yAxis2 = d3.svg.axis()
   .orient("left")
   .scale(yScale2);
   
   // define the x axis
   var xAxis2 = d3.svg.axis()
   .orient("bottom")
   .scale(xScale2)
   .tickFormat(date_format);
   
   svg.append("g")
   .attr("class", "yaxis axis")
   .attr("transform", "translate("+padding+",0)")
   .call(yAxis2);
   
   // draw x axis with labels and move to the bottom of the chart area
   svg.append("g")
   .attr("class", "xaxis axis")  // two classes, one for css formatting, one for selection below
   .attr("transform", "translate(0," + (h - padding) + ")")
   .call(xAxis2);
   
   /* svg.append("text")
   .attr("text-anchor", "middle")  // this makes it easy to centre the text as the transform is applied to the anchor
   .attr("transform", "translate("+ (padding/2) +","+(h/2)+")rotate(0)")  // text is drawn off the screen top left, move down and out and rotate
   .text("승률");
   
   svg.append("text")
   .attr("text-anchor", "middle")  // this makes it easy to centre the text as the transform is applied to the anchor
   .attr("transform", "translate("+ (w/2) +","+(420-(padding/2))+")")  // centre below axis
   .text("최근날짜");    */
   

   
   /*define line*/
   let lines = d3.svg
      .line()
      .x(function(d) {return xScale(d[0])})
      .y(function(d) {return yScale(d[1])})
      .interpolate("monotone");
   
   
   /*append line*/
   let path = svg.append("path").attr({
      d: lines(dataset),
      'class': "lineChart"
   });
   
   console.log(path);
   
   svg
      .select(".lineChart")
      .style("opacity", 0)
      .transition()
      .duration(2500)
      .delay(1000)
      .style("opacity", 1);
   
   
   
   /*add points*/
   let points = svg
      .selectAll("circle")
      .data(dataset)
      .enter()
      .append("circle")
      .call(drag);
      
   console.log(points);
   
   /*point attributes*/
   points
      .attr("cy", 0)
      .transition()
      .duration(1500)
      .delay(function(d, i) {return i * 100 + 500})
      .ease("elastic")
      .attr({
    	 cx: function(d) {return xScale(d[0])},
         cy: function(d) {return yScale(d[1])},
         r: 7,
         'class': "datapoint",
         id: function(d, i) {return i}
   
      })
      .style("opacity", 1);
   
   
   let xMax = d3.max(dataset, function(d) {return d[0]}),
       yMax = d3.max(dataset, function(d) {return d[1]});

   function dragstarted() {
      d3.event.sourceEvent.stopPropagation();
      d3.select(this).classed("dragging datapoint", true);
   }
   
   function dragged() {
      d3.select(this).attr({
         cx: Math.max(padding, Math.min(d3.event.x, w - padding)),
         cy: Math.max(padding, Math.min(d3.event.y, h - padding))
      });
   }
   
   function dragended() {
      d3.select(this).classed("datapoint", true);
      // get id of dragged point
      let id = d3.select(this).attr("id"),
         // get new absolute position coordinates of the point
         xPos = d3.select(this).attr("cx"),
         yPos = h - d3.select(this).attr("cy");
   
      // convert absolute position coordinates relative to scales
      xPos = (xPos - padding) * (xMax / (w - padding * 2));
      yPos = (yPos - padding) * (yMax / (h - padding * 2));
      dataset[id][0] = xPos;
      dataset[id][1] = yPos;
   
      // update line
      svg
         .select(".lineChart")
         .transition()
         .duration(500)
         .attr("d", lines(dataset));
   }
   
   
   function teamInfo() {
	   
	   console.log($('#team_leader').val());
	   console.log($('#loginUser').val());
	   if($('#team_leader').val() == $('#loginUser').val()) {
		   var testEval = "";
		      
		   testEval += '<div class="wrap4" id="wrap4"><hr><br><h1>팀 정보</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
		   testEval += '<tr><th scope="col">no</th><th scope="col">이름</th><th scope="col">성별</th><th scope="col">연락처</th><th scope="col">나이</th><th scope="col">포지션</th><th scope="col"></th></tr></thead><tbody>';
		   testEval += '<tr><th scope="row">'+ 1 +'</th><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td><button>추방</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 2 +'</th><td>'+ 3 +'</td><td>'+ 3 +'</td><td>'+ 3 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td><button>추방</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 3 +'</th><td>'+ 4 +'</td><td>'+ 4 +'</td><td>'+ 4 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td><button>추방</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 4 +'</th><td>'+ 5 +'</td><td>'+ 5 +'</td><td>'+ 5 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td><button>추방</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 5 +'</th><td>'+ 6 +'</td><td>'+ 6 +'</td><td>'+ 6 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td><button>추방</button></td></tr></tbody></table></div><br> <br>';
		   testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
		   testEval += '<li class="page-item"><a class="page-link" href="#">이전</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 1 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 2 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 3 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 4 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 5 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">다음</a></li>';
	       testEval += '</ul></nav></div><div class="clear"></div></div>';
		   
		   document.getElementById('wrap4').innerHTML = testEval;
		   
	   }else {
		   var testEval = "";
		      
		   testEval += '<div class="wrap4" id="wrap4"><hr><br><h1>팀 정보</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
		   testEval += '<tr><th scope="col">no</th><th scope="col">이름</th><th scope="col">성별</th><th scope="col">연락처</th><th scope="col">나이</th><th scope="col">포지션</th></tr></thead><tbody>';
		   testEval += '<tr><th scope="row">'+ 2 +'</th><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td></tr>';
		   testEval += '<tr><th scope="row">'+ 3 +'</th><td>'+ 3 +'</td><td>'+ 3 +'</td><td>'+ 3 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td></tr>';
		   testEval += '<tr><th scope="row">'+ 4 +'</th><td>'+ 4 +'</td><td>'+ 4 +'</td><td>'+ 4 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td></tr>';
		   testEval += '<tr><th scope="row">'+ 5 +'</th><td>'+ 5 +'</td><td>'+ 5 +'</td><td>'+ 5 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td></tr>';
		   testEval += '<tr><th scope="row">'+ 6 +'</th><td>'+ 6 +'</td><td>'+ 6 +'</td><td>'+ 6 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td></tr></tbody></table></div><br> <br>';
		   testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
		   testEval += '<li class="page-item"><a class="page-link" href="#">이전</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 1 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 2 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 3 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 4 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 5 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">다음</a></li>';
	       testEval += '</ul></nav></div><div class="clear"></div></div>';
		      
		   document.getElementById('wrap4').innerHTML = testEval;
	   }
	   
   
   }   
   
   function support() {
	   
	   console.log($('#team_leader').val());
	   console.log($('#loginUser').val());
	   if($('#team_leader').val() == $('#loginUser').val()) {
		   var testEval = "";
		      
		   testEval += '<div class="wrap4" id="wrap4"><hr><br><h1>용병 신청</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
		   testEval += '<tr><th scope="col">no</th><th scope="col">이름</th><th scope="col">성별</th><th scope="col">나이</th><th scope="col">포지션</th><th scope="col">신청</th></tr></thead><tbody>';
		   testEval += '<tr><th scope="row">'+ 1 +'</th><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td><button>수락</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 2 +'</th><td>'+ 2 +'</td><td>'+ 3 +'</td><td>'+ 3 +'</td><td>'+ 3 +'</td><td><button>수락</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 3 +'</th><td>'+ 2 +'</td><td>'+ 4 +'</td><td>'+ 4 +'</td><td>'+ 4 +'</td><td><button>수락</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 4 +'</th><td>'+ 2 +'</td><td>'+ 5 +'</td><td>'+ 5 +'</td><td>'+ 5 +'</td><td><button>수락</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 5 +'</th><td>'+ 2 +'</td><td>'+ 6 +'</td><td>'+ 6 +'</td><td>'+ 6 +'</td><td><button>수락</button></td></tr></tbody></table></div><br> <br>';
		   testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
		   testEval += '<li class="page-item"><a class="page-link" href="#">이전</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 1 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 2 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 3 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 4 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 5 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">다음</a></li>';
	       testEval += '</ul></nav></div><div class="clear"></div></div>';
		      
		   document.getElementById('wrap4').innerHTML = testEval;
		   
	   }else {
		   alert('팀장만볼수있음');
	   }
	   
	   

   }
   
   
   function match() {
	   console.log($('#team_leader').val());
	   console.log($('#loginUser').val());
	   if($('#team_leader').val() == $('#loginUser').val()) {
		   var testEval = "";
		      
		   testEval += '<div class="wrap4" id="wrap4"><hr><br><h1>매칭 신청</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
		   testEval += '<tr><th scope="col">no</th><th scope="col">매치날짜</th><th scope="col">지역</th><th scope="col">평균연령</th><th scope="col">성별</th><th scope="col">팀명</th><th scope="col">상태</th><th scope="col">신청</th></tr></thead><tbody>';
		   testEval += '<tr><th scope="row">'+ 1 +'</th><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>대기중</td><td><button>수락</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 2 +'</th><td>'+ 3 +'</td><td>'+ 3 +'</td><td>'+ 3 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>수락</td><td><button>취소</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 3 +'</th><td>'+ 4 +'</td><td>'+ 4 +'</td><td>'+ 4 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>수락</td><td><button>취소</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 4 +'</th><td>'+ 5 +'</td><td>'+ 5 +'</td><td>'+ 5 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>대기중</td><td><button>수락</button></td></tr>';
		   testEval += '<tr><th scope="row">'+ 5 +'</th><td>'+ 6 +'</td><td>'+ 6 +'</td><td>'+ 6 +'</td><td>'+ 2 +'</td><td>'+ 2 +'</td><td>대기중</td><td><button>수락</button></td></tr></tbody></table></div><br> <br>';
		   testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
		   testEval += '<li class="page-item"><a class="page-link" href="#">이전</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 1 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 2 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 3 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 4 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">'+ 5 +'</a></li>';
		   testEval += '<li class="page-item"><a class="page-link" href="#">다음</a></li>';
	       testEval += '</ul></nav></div><div class="clear"></div></div>';
		      
		   document.getElementById('wrap4').innerHTML = testEval;
		   
	   }else {
		   alert('팀장만볼수있음');
	   }
	   

   }
   
   
   
</script>

</html>