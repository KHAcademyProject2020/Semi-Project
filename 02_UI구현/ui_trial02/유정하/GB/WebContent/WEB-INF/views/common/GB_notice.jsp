<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Good Ball (로그아웃 상태)</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">



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

<link rel="stylesheet" href="./resources/css/GB_frame.css">


<style>
.carousel-inner, .carousel-item>img, .carousel-item:active>img {
	height: 1000px;
}

/* .container-for-content {
	display: none;
} */
.gray {
	background: #efefef;
}



#divPaging {
	clear: both;
	margin: 0 auto;
	width: 220px;
	height: 50px;
}

#divPaging>div {
	float: left;
	width: 30px;
	margin: 0 auto;
	text-align: center;
}

body>div>section>div>div>nav {
	text-align: center;
 	margin: 0;
	padding: 0;
	display: inline-block;
	
}
a.page-link{
Color: black;
}

</style>
</head>

<body>

<%@ include file="/common/mainpage.jsp" %>

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

					<!--로그인 페이지로 이동한다.-->
					<button style="margin-left: 15px;"
						class="nav-link btn btn-outline-success my-2 my-sm-0"
						type="submit">로그인</button>

				</div>
			</nav>
		</header>
		<!-- HEADER 끝-->


		<!-- BODY 시작 -->
		<section id="content">
			<div class="main_title">
			<label style="font-size: 50px; margin-top: 50px;">공지사항</label>
			</div>


			<!--본내용-->
			<!--container-for-content 시작-->
			<div class="container-for-content">
			<div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">공지 내용</th>
							<th scope="col">작성자</th>
							<th scope="col">날짜</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<td colspan="4">존재하는 공지사항이 없습니다.</td>
						</tr>
					</tbody>
				</table>
				</div>
				
				
				<div>
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


			</div>
			<!--container-for-content 끝-->

		</section>
		<!--BODY 끝.-->



		<!-- FOOT(고정) : 내용 변경하지마세요~ -->
		<footer>
			<div class>
				<a href="https://github.com/KHAcademyProject2020/Semi-Project"
					target="_blank">
					<h5>Good Ball</h5>
				</a>
				<p>KH Academy</p>
			</div>
		</footer>

	</div>
</body>

</html>