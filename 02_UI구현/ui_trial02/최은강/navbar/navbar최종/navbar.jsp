<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import ="member.model.vo.*"	
%>
	
<%
	//로그인 유저가 있는지 확인한다.
	Member loginUser= (Member)session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Good Ball</title>

<!--파비콘아이콘-->
<link rel="icon" href="./resources/common/favicon/favicon.ico"
	type="image/x-icon">

<!--웹API불러오기-->
<script src="https://kit.fontawesome.com/09697e2134.js"
	corssorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>

<!-- 구글폰트-->
<link
	href="https://fonts.googleapis.com/css2?family=Alata&family=Do+Hyeon&display=swap"
	rel="stylesheet">

<!--정적파일(css/ javascript) 불러오기-->

<!-- ./resources/css/navbar_css.css  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/navbar_css.css">
<script src="<%=request.getContextPath() %>/resources/js/navbar_js.js"></script>
</head>


<body>
	<nav class="navbar">
		<div class="navbar_logo">
			<a href=""> <img src="./resources/common/images/logo.png"
				style="width: 50px; height: 50px;">
			</a>
		</div>

		<!-- 로그인 상태 전체 메뉴바-->
		<%if(loginUser!=null){ %>
			<!--navbar_menu: 로그인 상태-->
			<ul class="navbar_menu status-log-in">
				<a href="">
					<li>마이페이지</li>
				</a>
	
				<a href="">
					<li>공지사항</li>
				</a>
				<a href="">
					<li>구장예약</li>
				</a>
				<a href="">
					<li>매치 찾기</li>
				</a>
				<a href="">
					<li>팀 찾기</li>
				</a>
				<a href="">
					<li>커뮤니티</li>
				</a>
			</ul>
	
			<!--navbar_menu2:  로그인 상태-->
			<ul class="navbar_menu2 status-log-in">
	
				<li>
					<ul class="navbar_menu3">
						<li>
							<!-- 알람박스-->
							<div class="alarm-box">
								<i class="fas fa-bell"></i> <span
									class="badge badge-pill badge-danger">10</span>
							</div>
	
						</li>
	
						<li>
							<button type="button" class="btn btn-primary login-logout">로그아웃</button>
						</li>
					</ul>
				</li>
			</ul>
		<%}else{ %>
			<!-- 로그아웃 상태 메뉴바 전체-->
			<!--navbar_menu: 로그아웃 상태-->
			<ul class="navbar_menu status-log-out">
				<a href="">
					<li>공지사항</li>
				</a>
				<a href="">
					<li>구장예약</li>
				</a>
				<a href="">
					<li>매치 찾기</li>
				</a>
				<a href="">
					<li>팀 찾기</li>
				</a>
				<a href="">
					<li>커뮤니티</li>
				</a>
			</ul>
	
			<!--navbar_menu2:  로그아웃 상태-->
			<ul class="navbar_menu2 status-log-out">
				<li>
					<ul class="navbar_menu3">
						<li>
							<button type="button" class="btn btn-primary login-logout">로그인</button>
						</li>
	
						<li>
							<button type="button" class="btn btn-primary login-logout">회원가입</button>
						</li>
					</ul>
				</li>
			</ul>
		<%} %>

		<!--navbar toggle버튼: 햄버거-->
		<a href="#" class="navbar_toggle"> <i class="fas fa-bars"></i>
		</a>
	</nav>

</body>
</html>
