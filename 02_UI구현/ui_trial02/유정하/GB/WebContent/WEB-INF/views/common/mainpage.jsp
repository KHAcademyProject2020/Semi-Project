<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Good Ball</title>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
     <!--파비콘아이콘-->
     <link rel="icon" href="./resources/common/favicon/favicon.ico" type="image/x-icon">

     <!--웹API불러오기-->
     <script src="https://kit.fontawesome.com/09697e2134.js" corssorigin="anonymous"></script>
     <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
         integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 
     <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
         integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
         crossorigin="anonymous"></script>
 
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
         integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
         crossorigin="anonymous"></script>
 
     <!-- 구글폰트-->
     <link href="https://fonts.googleapis.com/css2?family=Alata&family=Do+Hyeon&display=swap" rel="stylesheet">
 
     <!--정적파일(css/ javascript) 불러오기-->
     <link rel="stylesheet" href="./resources/css/navbar_css.css">
     <link rel="stylesheet" href="./resources/css/main_content.css">

     <script src="./resources/js/navbar_js.js"></script>
     <script src="./resources/js/main_content.js"></script>
<style type="text/css">
:root{
    --navigation-menu-font: 'Do Hyeon', sans-serif;

}

ul.main-navigation{
    display: flex;
    flex-direction: row;
    justify-content: flex-end, space-between;
}

ul.main-navigation li{
    list-style:none;
    font-family: var(--navigation-menu-font);
}



:root{
    /*기본*/
    --nav-background-color: #272929;
    --nav-text-color: #96e0e0;
    
    /*mouse hover*/
    --hover-background-color: rgb(76,227,218);
    --hover-text-color: #272929;
    
    /*메뉴 폰트*/
    --menu-font-family: 'Do Hyeon', sans-serif;

    /*벨모양 아이콘*/
    --fa-bell-font-size: 28px;
    --fa-bell-default-color: #e9faec;
    --hamburgur-default-color: #e9faec;
    --hamburgur-hover-color: rgb(76,227,218);
    --content-background-color: #e5f8f7;
}

body{
    margin: 0;
}

a, a:hover{
    text-decoration: none;
}

.navbar, .navbar_logo, .navbar_menu, .navbar_menu2, .navbar_menu3{
    display: flex;
}

.navbar{
    background: var(--nav-background-color);
    color: var(--nav-text-color);

    justify-content: space-around;
    align-items:baseline;
    padding: 8px 12px;
}

.navbar_menu, .navbar_menu2, .navbar_menu3{
    list-style: none;
    padding-left: 0;
}

/*navbar_menu*/
.navbar_menu li{
    position: relative;
    padding: 8px 12px;
    margin: 10px;
    color: var(--nav-text-color);
    font-family: var(--menu-font-family);
}

.navbar_menu li:hover{
    background-color:var(--hover-background-color);
    color: var(--hover-text-color);
    border-radius: 23px;  
}

.navbar_menu2{
    padding-top: 20px;
    padding-left: 0;
}

.navbar_menu2 li{
    padding: 8px 12px;
}

/*알람 박스(벨버튼+벳지)*/
.alarm-box{
    position: relative;
    padding-top: 3px;
}

.fa-bell{
    font-size: var(--fa-bell-font-size);
}

.badge{
    position: relative;
    top: -10px;
    right: 10px;
}

button.login-logout{
    background: var(--nav-background-color);
    color:var(--nav-text-color); 
    border-color: transparent;
    font-family: var(--menu-font-family);
}

.alarm-box{
    color: var(--fa-bell-default-color);
}

/*알람박스 호버*/
.alarm-box:hover{
    cursor:pointer;
    color: var(--hover-background-color);
}

/*버튼 호버*/
button.login-logout:hover{
    cursor:pointer;
    background: var(--hover-background-color);
    color: var(--hover-text-color);
    border-color: transparent;  
}

/*햄버거버튼*/ 
.navbar_toggle{
    display: none;
    position: absolute;
    right: 32px;
    top: 10px;
    font-size: 30px;
    color: var(--hamburgur-default-color);
}

/*본론 내용 프레임*/
#section-container{
    background: var(--content-background-color);
    width: 100%;
    height: 100vh;
}


/*media query를 이용하여 반응형 웹 만들기*/
@media screen and (max-width: 768px){
    .navbar{
        /*세로축 중심으로 나열한다.*/
        flex-direction: column;
        align-items: flex-start;
        
    }

    .navbar_menu, .navbar_logo, .navbar_menu2{
        flex-direction:column;
        align-items: center;
        width: 100%;
    }

    .navbar_logo{
        padding-left: 20px;
    }

    .navbar_menu a, .navbar_menu li{
        width: 100%;
        text-align: center;
    }

    .navbar_menu li:hover{
        border-radius: 5px;
    }




    /*햄버거 버튼이 나타난다.*/
    .navbar_toggle{
        display:block;
    }

    .navbar_toggle:hover{
        color: var(--hover-background-color);
    }

    /*햄버거버튼을 누르기전*/
    .navbar_menu, .navbar_menu2{
        display:none;
    }

    /*햄버거 버튼을 누른 후*/
    .navbar_menu.active,
    .navbar_menu2.active{
        display: flex;

    }    
}
</style>
</head>

<body>
    <!-- navigation bar-->
    <nav class="navbar">
        <div class="navbar_logo">
            <a href="">
                <img src="<%= request.getContextPath() %>/images/logo.png" style="width:50px; height:50px;">
            </a>
        </div>

        <!-- 로그인 상태 전체 메뉴바-->
        <!--navbar_menu: 로그인 상태-->
<!--         <ul class="navbar_menu status-log-in">
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
        </ul> -->

        <!--navbar_menu2:  로그인 상태-->
        <!-- <ul class="navbar_menu2 status-log-in">

            <li>
                <ul class="navbar_menu3">
                    <li>
                        알람박스
                        <div class="alarm-box">
                            <i class="fas fa-bell"></i>
                            <span class="badge badge-pill badge-danger">10</span>
                        </div>

                    </li>

                    <li>
                        <button type="button" class="btn btn-primary login-logout">로그아웃</button>
                    </li>
                </ul>
            </li>
        </ul> -->


        <!-- 로그아웃 상태 메뉴바 전체-->
        
        <ul class="navbar_menu status-log-out">
            <a href="">
                <li><button onclick="goNotice();" >공지사항</button></li>
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

        <ul class="navbar_menu2 status-log-out">
            <li>
                <ul class="navbar_menu3">
                    <li>
                        <button type="button" class="btn btn-primary login-logout" onclick="moveToLoginPage();">로그인</button>
                    </li>

                    <li>
                        <button type="button" class="btn btn-primary login-logout">회원가입</button>
                    </li>
                </ul>
            </li>
        </ul>
        

        <!--navbar toggle버튼: 햄버거-->
        <a href="#" class="navbar_toggle">
            <i class="fas fa-bars"></i>
        </a>
    </nav>

    

    <!-- 메인페이지-->
    <div id="section-container">
        <!-- 메인화면 알림 네비게이션 -->
        <nav class="main-navigation">
            <ul class="main-navigation">
                <a href="">
                    <li>Good Ball?</li>
                </a>
    
                <a href="">
                    <li>Good Ball만의 특징</li>
                </a>
                
                <a href="">
                    <li>구현 기술 스택</li>
                </a>
                
                <a href="">
                    <li>공지사항 게시판</li>
                </a>
            </ul>
        </nav>


        <main>
            <h1>내용을 넣어주세요.</h1>
        </main>
        
    </div>

    <footer>

    </footer>
    
    <script type="text/javascript">
    	function moveToLoginPage(){
    		location.href="<%= request.getContextPath()%>/loginForm.me";
    	}
    	
    	function goNotice(){
    		location.href="<%= request.getContextPath()%>/goToNotice.no";
    	}
    	
    	
    </script>
    
</body>
</html>