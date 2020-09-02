<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>

<%
	//로그인 유저가 있는지 확인한다.
	Member loginUser = (Member) session.getAttribute("loginUser");

	System.out.println(request.getContextPath()); // /SEMI_GoodBall_CEK
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>navbar</title>


<!--파비콘아이콘-->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/common/favicon/favicon.ico"
	type="image/x-icon">

<link rel="icon" href="<%=request.getContextPath()%>/resources/common/favicon/favicon.ico"
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
<link href="<%=request.getContextPath()%>/resources/css/navbar_css.css" type="text/css" rel="stylesheet">
<script src="./resources/js/navbar_js.js"></script>
</head>


<body>
	<nav class="navbar">
		<div class="navbar_logo">
			 <img src="./resources/common/images/logo.png"  
			 	style="width:75px; height:75px;"
			 	onclick="goHome();">	
		</div>

		<!-- 로그인 상태 전체 메뉴바-->
		<%
			if (loginUser != null) {
		%>
		<!--navbar_menu: 로그인 상태-->
		<ul class="navbar_menu status-log-in">
			<li onclick="goMyPage();">마이페이지</li>
			<li onclick="goNotice();">공지사항</li>
			<li onclick="goReservation();">구장예약</li>
			<li onclick="goMatch();">매치 찾기</li>
			<li onclick="goTeam();">팀 찾기</li>
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
						<button type="button" class="btn btn-primary login-logout"
							onclick="logout();">로그아웃</button>
					</li>
				</ul>
			</li>
		</ul>
		<%
			} else {
		%>
		<!-- 로그아웃 상태 메뉴바 전체-->
		<!--navbar_menu: 로그아웃 상태-->
		<ul class="navbar_menu status-log-out">
			<li onclick="goNotice();">공지사항</li>
			<li onclick="goReservation();">구장 예약</li>
			<li onclick="goMatch();">매치 찾기</li>
			<li onclick="goTeam();">팀 찾기</li>

		</ul>

		<!--navbar_menu2:  로그아웃 상태-->
		<ul class="navbar_menu2 status-log-out">
			<li>
				<ul class="navbar_menu3">
					<li>
						<button type="button" class="btn btn-primary login-logout"
							onclick="signIn();">로그인</button>
					</li>

					<li>
						<button type="button" class="btn btn-primary login-logout"
							onclick="signUp();">회원가입</button>
					</li>
				</ul>
			</li>
		</ul>
		<%
			}
		%>

		<!--navbar toggle버튼: 햄버거-->
		<a href="#" class="navbar_toggle"> <i class="fas fa-bars"></i>
		</a>
	</nav>
</body>
<script>
	function goHome(){
		//홈으로 이동
		location.href="<%=request.getContextPath()%>";
	}
	
	function goNotice(){
		//(유정하) / (최은강)
		//공지사항 게시판 - 리스트를 불러온다.
		//(url: /showBoardList.bo) board.controller.ShowBoardList.java
		location.href="<%=request.getContextPath()%>/showBoardList.bo";
	}
	
	function goReservation(){
		//구장게시판
	}
	
	function goMatch(){
		//매치 - (하민재 ) 매치 등록 / 매치 신청
		// (정창섭) 신청과정 (backend)
	}
	
	function goTeam(){
		//팀게시판
		//정창섭
		location.href="<%=request.getContextPath()%>/teamList.me";
	}
	
	function goMyPage(){
		//마이페이지로 이동 (로그인한 유저만)
		// 정규동
		<%if(loginUser!=null){%>
			<%
			//멤버의 유형에 따라 마이페이지이동이 달라진다.
			if(loginUser.getMember_type().equals("M")){
				//로그인한 회원 유형이 매니저회원이라면
			%>
				// 매니저회원 서블릿: member.controller.Manager_GoMyPageStartServlet.java 연결
				location.href="<%=request.getContextPath()%>/myPage_Manager_Form.me";
			<%}else{%>
				// 일반회원& 관리자 서블릿: member.controller.GoMyPageStartServlet.java
				location.href="<%=request.getContextPath()%>/myPage_General_Form.me";
			<%}%>
		<%}%>
		
	}
	
	function signIn(){
		//로그인-> 로그인 입력폼 서블릿 호출
		// 김용연(OK)
		location.href="<%=request.getContextPath()%>/login";
		
	}
	
	function signUp(){
		//회원가입 -> 회원가입 입력폼 서블릿 호출
		// 김용연(OK)
		/* 회원가입페이지 url매핑: /memberShip - MemberShipServlet.java */
		location.href="<%=request.getContextPath()%>/memberShip";
	}
	
	function logout(){
		//로그아웃
		location.href="<%=request.getContextPath()%>/logout.me";
	}
</script>
</html>