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
<link rel="shortcut icon" href="/resources/common/favicon/favicon.ico"
	type="image/x-icon">

<link rel="icon" href="/resources/common/favicon/favicon.ico"
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
<style>
:root {
/*기본*/
--nav-background-color: #272929;
--nav-text-color: #96e0e0;

/*mouse hover*/
--hover-background-color: rgb(76, 227, 218);
--hover-text-color: #272929;

/*메뉴 폰트*/
--menu-font-family: 'Do Hyeon', sans-serif;
--menu-font-size: 1.7em;

/*벨모양 아이콘*/
--fa-bell-font-size: 28px;
--fa-bell-default-color: #e9faec;
--hamburgur-default-color: #e9faec;
--hamburgur-hover-color: rgb(76, 227, 218);
--content-background-color: #e5f8f7;
}

body {
  margin: 0;
  height: 100vh;
}

a,
a:hover {
  text-decoration: none;
}

.navbar,
.navbar_menu,
.navbar_menu2,
.navbar_menu3 {
  display: flex;
}

.navbar {
  background: var(--nav-background-color);
  color: var(--nav-text-color);

  justify-content: space-around;
  align-content:space-around;
  align-items: baseline;
  padding: 8px 12px;
}

.navbar_menu,
.navbar_menu2,
.navbar_menu3 {
  list-style: none;
  padding-left: 0;
}

.navbar_logo > img {
  cursor: pointer;
}

/*navbar_menu*/
.navbar_menu li {
  position: relative;
  padding: 8px 12px;
  margin: 10px;
  color: var(--nav-text-color);
  font-family: var(--menu-font-family);
  font-size: var(--menu-font-size);
}

.navbar_menu li:hover {
  background-color: var(--hover-background-color);
  color: var(--hover-text-color);
  border-radius: 23px;
  cursor: pointer;
}

.navbar_menu2 {
  padding-top: 20px;
  padding-left: 0;
  font-size: var(--menu-font-size);
}

.navbar_menu2 li {
  padding: 8px 12px;
}

/*알람 박스(벨버튼+벳지)*/
.alarm-box {
  position: relative;
  padding-top: 3px;
}

.fa-bell {
  font-size: var(--fa-bell-font-size);
}

.badge {
  position: relative;
  top: -10px;
  right: 10px;
}

button.login-logout {
  background: var(--nav-background-color);
  color: var(--nav-text-color);
  border-color: transparent;
  font-family: var(--menu-font-family);
}

.alarm-box {
  color: var(--fa-bell-default-color);
}

/*알람박스 호버*/
.alarm-box:hover {
  cursor: pointer;
  color: var(--hover-background-color);
}

/*버튼 호버*/
button.login-logout:hover {
  cursor: pointer;
  background: var(--hover-background-color);
  color: var(--hover-text-color);
  border-color: transparent;
}

/*햄버거버튼*/
.navbar_toggle {
  display: none;
  position: absolute;
  right: 32px;
  top: 10px;
  font-size: 30px;
  color: var(--hamburgur-default-color);
}



/*media query를 이용하여 반응형 웹 만들기*/
@media screen and (max-width: 768px) {
  .navbar {
    /*세로축 중심으로 나열한다.*/
    flex-direction: column;
    align-items: flex-start;
  }

  .navbar_menu,
  .navbar_logo,
  .navbar_menu2 {
    flex-direction: column;
    align-items: center;
    width: 100%;
  }

  .navbar_logo {
    padding-left: 20px;
  }

  .navbar_menu a,
  .navbar_menu li {
    width: 100%;
    text-align: center;
  }

  .navbar_menu li:hover {
    border-radius: 5px;
  }

  /*햄버거 버튼이 나타난다.*/
  .navbar_toggle {
    display: block;
  }

  .navbar_toggle:hover {
    color: var(--hover-background-color);
  }

  /*햄버거버튼을 누르기전*/
  .navbar_menu,
  .navbar_menu2 {
    display: none;
  }

  /*햄버거 버튼을 누른 후*/
  .navbar_menu.active,
  .navbar_menu2.active {
    display: flex;
  }
}
</style>


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
		//공지사항 게시판
		location.href="<%=request.getContextPath()%>/list.no";
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
		
		location.href="<%=request.getContextPath()%>/myPageForm.me";
		
		
	}
	
	function signIn(){
		//로그인-> 로그인 입력폼 서블릿 호출
		// 김용연
		location.href="<%=request.getContextPath()%>/login";
		
	}
	
	function signUp(){
		//회원가입 -> 회원가입 입력폼 서블릿 호출
		// 김용연
		location.href="<%=request.getContextPath()%>/signUpForm.me";
	}
	
	function logout(){
		//로그아웃
		location.href="<%=request.getContextPath()%>/logout.me";
	}
</script>
</html>