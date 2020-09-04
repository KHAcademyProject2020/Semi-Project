<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="member.model.vo.*, board.model.vo.Board,java.util.ArrayList"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지게시판 글작성하기</title>

<link
	href="https://fonts.googleapis.com/css2?family=Alata&family=Do+Hyeon&display=swap"
	rel="stylesheet">

<!-- jquery api-->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- bootstrap -->
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

<!-- 정적파일 css, js-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/boardWriter.css">
</head>

<body>

	<!-- navbar 삽입-->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%>

	<!-- 메인페이지 컨테이너-->
	<div class="main-content-container">
		<div class="board_writer-total-container">
			<div class="board-writer-form-container">

				<div class="board_title_box">
					<h1 class="board_title">공지사항 등록하기</h1>
					<hr>
				</div>

				<form action="<%=request.getContextPath()%>/insertBoard.bo" id="write_board_form" method="post" encType="multipart/form-data">
					<!-- 타이틀 영역박스-->
					<div class="title-container">
						<input id="board-write-title" type="text" name="title"
							placeholder="제목을 입력해주세요">
						<hr class="my-4">
					</div>

					<!-- 이미지 등록박스-->
					<div class="img-container">
						<div class="browse_img_box">
							<label> <input type="file" class="file-input"
								accept="image/*" name="img" id="board_img_file_import"
								onchange="loadImg(this);" />
							</label> <span class="filename">파일을 선택해주세요</span>

							<div class="photo-box">
								<img id="photoArea" alt="photo" width="500px" height="500px">
							</div>
						</div>

						<script>
							// 파일을 올리면, 올린 파일이름을 띄운다.
							$(document).on(	'change','.file-input',	function() {
												var $filedirs = $(this).val().split('\\');
												var $filename = $filedirs[$filedirs.length - 1];
												console.log($filename);
												if ($filename == '')
													$filename = '파일을 선택해주세요';
												$('.filename').text($filename);
							});

							function loadImg(photo) {

								$photo = $('#photoArea');
								console.log(photo.files);

								if (photo.files && photo.files[0]) {

									var reader = new FileReader();
									reader.onload = function(e) {
										$photo.css('display', 'block');
										$photo.attr('src', e.target.result);
									}
								}
								reader.readAsDataURL(photo.files[0]);
							}
						</script>
						<div></div>
					</div>

					<!--내용 영역-->
					<div class="content-container">
						<div class="content_text">
							<textarea name="content" id="board-content" style="resize: none;"
								cols=30 placeholder="내용을 입력해주세요..."
								onkeyup="countContentLength(this);"></textarea>
							<div class="content-byte-box">
								<p class="content-data-count">
									<em id="Byte">0</em>/1000 bytes
								</p>
							</div>
						</div>
						<script>
							let limitByte = 1000; //byte최대 크기
							function countContentLength(content) {
								//byte check : textarea에 입력한 길이를 여기에 출력
								let check_length = document
										.getElementById('Byte');
								let message = content.value;
								// console.log(messageLength);

								let totalByte = 0;
								for (var i = 0; i < message.length; i++) {
									var currentByte = message.charCodeAt(i);
									if (currentByte > 128)
										totalByte += 2;
									else
										totalByte++;
								}

								check_length.innerText = totalByte;

								//최대 바이트크기를 넘으면 못쓰게한다.
								if (totalByte > limitByte) {
									alert('1000Byte 이내로 작성해주세요!');
								}
							}
						</script>
					</div>
					</form>

					<!--버튼 등록-->
					<div class="button-container">
						<div class="cancel_write_board-box">
							<button class="btn btn-secondary" 
									onclick="location.href='<%=request.getContextPath()%>/showBoardList.bo'">취소</button>
						</div>
						<div></div>
						<div class="insert_write_board-box">
							<!-- button은 input:submit 과 동일함-->
							<button type="submit"  form="write_board_form" class="btn btn-primary">작성</button>
						</div>
					</div>
				
			</div>
			
		</div>
		
	</div>
	<!--footer삽입 -->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>

</body>

</html>