<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="member.model.vo.*, board.model.vo.Board,java.util.ArrayList"%>

<%
	System.out.println("공지사항게시판 입장");

	//현재 로그인한 회원이 관리자인지?
	Member loginMember = (Member) session.getAttribute("loginUser");
	System.out.println("현재 로그인 회원 정보 => " + loginMember);

	//로그인 회원 유형과 관계없이 공지사항을 모두 갖고온다.
	ArrayList<Board> boardLists = (ArrayList<Board>) request.getAttribute("boardLists");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Ball (공지사항 게시판)</title>

<!--파비콘아이콘-->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/common/favicon/favicon.ico"
	type="image/x-icon">

<!-- api : bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>

<!-- api: font-awesome -->
<script src="https://kit.fontawesome.com/09697e2134.js"
	crossorigin="anonymous"></script>

<link href="<%=request.getContextPath()%>/resources/css/boardList.css"
	type="text/css" rel="stylesheet">

</head>

<body>

	<%-- navbar을 호출 --%>
	<%@include file="/WEB-INF/views/common/navbar.jsp"%>

	<!-- main sections -->
	<div class="main-container" id="main-container">
		<div class="notice-main-container">

			<div class="notice_total_container">
				<div class="notice_title_box">
					<h1 class="notice-title">공지사항</h1>
					<hr>
				</div>

				<!-- button_box는 관리자회원만 볼 수있다.-->

				<div class="notice_button_box">
					<%
						if (loginMember != null && loginMember.getMember_type().equals("R")) {
							//loginMember이 null이 아니면서, 멤버유형이 R(관리자)이라면
					%>
					<div></div>
					<button type="button" class="btn btn-primary" id="insertBtn"
						onclick="location.href='insertBoardForm.bo'">등록하기</button>
						<%-- 
							insertBoardForm.bo와 url매핑된 서블릿
							board.controller.InsertBoardFormServlet.java 를 호출한다.
							연결된 서블릿은 게시판 보드를 등록하는 페이지 boardWriter.jsp를 불러온다.
						--%>

					<%
						}
					%>
				</div>



				<!-- 테이블 형식으로 구성되어있다. -->
				<div class="notice_table_container">
					<table class="table table-hover">
						<thead class="thead-dark">
							<!-- table attributes -->
							<tr>
								<th scope="col">No</th>
								<th scope="col">작성날짜</th>
								<th scope="col" colspan=2>공지내용</th>
								<th scope="col">작성자</th>
							</tr>
						</thead>
						<tbody>

							<!-- jsp로 데이터 삽입-->
							<%
								if (boardLists.isEmpty()) {
									//noticeLists가 비어있다면
							%>
							<tr>
								<td colspan="5">공지사항이 없습니다!</td>
							</tr>
							<%
								} else {
							%>
							<%
								for (Board board : boardLists) {
							%>
							<tr>
								<th scope="row"><%=board.getBoardNum()%></th>
								<!--번호-->

								<td><%=board.getBoardDate()%></td>
								<!--작성날짜 -->

								<td colspan=2><%=board.getBoardTitle()%></td>
								<!-- 제목 -->

								<td><%=board.getBoardWriter()%></td>
								<!-- 작성자 -->

							</tr>
							<%
								}
							%>
							<%
								}
							%>

						</tbody>
					</table>

				</div>

				<!-- pagenation을 담는 컨테이너이다. -->
				<div class="notice_pagenation">
					<nav aria-label="Page navigation example">
						<ul class="pagination">

							<%-- 가장처음버튼 --%>
							<li class="page-item"><a id="initial_previous"
								class="page-link" href="#"> &lt;&lt;</i>
							</a></li>

							<%-- 이전버튼 --%>
							<li class="page-item"><a id="previous" class="page-link"
								href="#"> &lt;</i>
							</a></li>

							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>


							<%-- 다음버튼 --%>
							<li class="page-item"><a id="next" class="page-link"
								href="#">&gt; </a></li>

							<%-- 가장마지막 버튼 --%>
							<li class="page-item"><a id="last_next" class="page-link"
								href="#">&gt;&gt; </a></li>

						</ul>
					</nav>
				</div>

			</div>
		</div>
		<%-- footer을 호출 --%>
		<%@include file="/WEB-INF/views/common/footer.jsp"%>

	</div>

</body>
<script>
	
</script>
</html>