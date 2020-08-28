<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Good Ball(시작 페이지)</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	
	<!--파비콘아이콘-->
	<link rel="shortcut icon"
		href="<%=request.getContextPath()%>/resources/common/favicon/favicon.ico"
		type="image/x-icon">
	
	<link rel="icon"
		href="<%=request.getContextPath()%>/resources/common/favicon/favicon.ico"
		type="image/x-icon">
	
	<!--정적파일(css/ javascript) 불러오기-->
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/resources/css/index_main.css">
	<script src="<%=request.getContextPath()%>/resources/js/index_main.js"></script>

</head>
<body>
	<!-- navbar호출  -->
	<%@include file="WEB-INF/views/common/navbar.jsp"%>

	<!-- header: carousel-->
	<header>
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
					<img src="./resources/common/images/cimg1.jpg"
						class="d-block w-100">
					<div class="carousel-caption d-none d-md-block">
						<h5>Good Ball에 오신걸 환영합니다</h5>
						<p>더 편리하고, 즐거운 풋살 환경을 제공해드립니다</p>
					</div>
				</div>

				<div class="carousel-item">
					<img src="./resources/common/images/cimg4.jpg"
						class="d-block w-100">
					<div class="carousel-caption d-none d-md-block">
						<h5>오늘 풋살을 해볼까?</h5>
						<p>팀을 구해보고, 다른 팀들과 매치를 해봅시다!</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./resources/common/images/cimg2.jpg"
						class="d-block w-100">
					<div class="carousel-caption d-none d-md-block">
						<h5>풋살장 예약을 하고 즐거운 시간을 보내보자!</h5>
						<p>Praesent commodo cursus magna, vel scelerisque nisl
							consectetur.</p>
					</div>
				</div>
			</div>


			<!-- 이전버튼-->
			<a class="carousel-control-prev" href="#carouselExampleCaptions"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a>

			<!-- 다음버튼-->
			<a class="carousel-control-next" href="#carouselExampleCaptions"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>

		</div>
	</header>


	<!-- main sections -->
	<div class="main-container" id="main-container">

		<div class="main-content-container">
			<main>
				<!-- scroll-spy navigation bar-->
				<div class="container scrollspy-container">
					<nav class="scrollspy-navigation">
						<ul class="scrollspy-navigation">
							<a href="#goodball-info">
								<li>Good Ball?</li>
							</a>


							<a href="#latest-notices">
								<li>공지사항 게시판</li>
							</a>
						</ul>
					</nav>
				</div>


				<!--section:  Good ball 만의 차별점.-->
				<section id="goodball-info" class="section">

					<div class="goodball-info-box">
						<h1 class="info-title">Good Ball?</h1>

						<div class="info-box">
							<div class="info-wrapper-detail">
								<div class="info-detail-content-box">
									<h1>풋살장 예약 및 대관</h1>
									<div class="info-detail-img-box">
										<img src="./resources/common/images/infod1.jpg"
											class="info-img">
										<hr>
									</div>


									<p>
										Good Ball은 풋살을 사용하는 모든 회원들은<br> 풋살장을 편리하게 예약하고 대관할 수
										있습니다!<br> 풋살장 주인은 풋살장을 등록할 수 있습니다.
									</p>
								</div>
							</div>


							<div class="info-wrapper-detail">
								<div class="info-detail-content-box">
									<h1>남녀노소 누구나!</h1>
									<div class="info-detail-img-box">
										<img src="./resources/common/images/infod2.jpg"
											class="info-img">
										<hr>
									</div>

									<p>
										Good Ball은 성별, 나이 상관없이<br> 모두가 풋살을 즐길 수 있도록 장려합니다!
									</p>
								</div>
							</div>

							<div class="info-wrapper-detail">
								<div class="info-detail-content-box">
									<h1>소속 팀 전적관리</h1>
									<div class="info-detail-img-box">
										<img src="./resources/common/images/infod3.jpg"
											class="info-img">
										<hr>
									</div>

									<p>
										Good Ball의 모든 회원들은 최대 3개의 팀에 가입을 할 수 있습니다!<br> 매치 결과를 통해서
										팀의 전적을 확인할 수 있습니다!
									</p>
								</div>
							</div>

							<div class="info-wrapper-detail">
								<div class="info-detail-content-box">
									<h1>팀 별점과 풋살장 이용 리뷰</h1>
									<div class="info-detail-img-box">
										<img src="./resources/common/images/infod4.jpg"
											class="info-img">
										<hr>
									</div>

									<p>
										풋살장 매니저는 대관하는 팀의 에티켓점수를 평가할 수 있고<br> 풋살을 이용한 팀은 풋살장의
										이용후기를 남길 수 있습니다!
									</p>
								</div>
							</div>

						</div>
					</div>
				</section>

				<!-- section: Good Ball 공지사항-최근 공지사항 게시판
			                    가장 최근의 공지사항 10개를 서블릿을 통해서 불러온다.
                -->
				<section id="latest-notices" class="section">
					<h1 class="info-title">공지사항 게시판</h1>
				</section>
			</main>
		</div>

		<!-- footer호출 -->
		<%@include file="WEB-INF/views/common/footer.jsp"%>

		<!-- 맨위로 -->
		<div id="on-top">
			<i class="fas fa-arrow-up"></i>
		</div>
	</div>

</body>
<script>
	
</script>
</html>