<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="board.model.vo.*, java.util.ArrayList, member.model.vo.*"
%>

<%
	//세션으로부터 로그인한 멤버를 불러온다.
	//Member loginUser= (Member) session.getAttribute("loginUser");
	
	Board board= (Board)request.getAttribute("board");
	BoardAttachment img= (BoardAttachment)request.getAttribute("img");
	
	System.out.println("공지사항- 게시판 상세보기");
 	
	System.out.println(board);
	System.out.println(img); 
	
	int fId=0;
	if(img!=null){
		fId=img.getFileId();
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판 상세보기</title>

	<!--favicon-->
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/common/favicon/favicon.ico" type="image/x-icon">

    <link href="https://fonts.googleapis.com/css2?family=Alata&family=Do+Hyeon&display=swap" rel="stylesheet">

    <!-- jquery api-->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

    <!-- bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
        
    <%--정적 파일 불러오기 css/js --%>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/boardDetail.css">
    <script src="<%=request.getContextPath()%>/resources/js/boardDetail.js"></script>
</head>
<body>
	<%--navbar추가 --%>
	<%@include file="/WEB-INF/views/common/navbar.jsp"%>
	
	<%--본내용 --%>
	<!-- navbar 추가 -->
    <div class="main-content-container" id="main-container">
        <div class="board-detail-main-container">
                <!-- 타이틀-->
                <div class="board-title-box">
                	<input type="hidden" name="bId" id="bId" value="<%=board.getBoardNum() %>" >
                    <h1 id="title"><%=board.getBoardTitle() %></h1>
                </div>

                <!-- 이미지와 내용 -->
                <div class="board-main-content-box">

                    <!-- 이미지 -->
                    <div class="board-img-box">
                    	<%if(img!=null){ 
                    		//등록한 이미지가 존재한다면..
                    	%>
                        	<img id="image" src="<%=request.getContextPath() %>/resources/storage/board_img/<%=img.getChangeName() %>" alt="게시판 이미지">
                        <%} %>
                    </div>

                    <!-- 내용 -->
                    <div class="board-content-box">
                        <textarea name="content" id="content" cols=30 style="resize:none;" readonly><%=board.getBoardContent() %></textarea>
                    </div>
                </div>

                <!-- 버튼박스 
                	목록: 모든회원 다가능한데
                	수정/삭제: 관리자(R)만 가능하다.
                -->
                <div class="board-btn-box">
                    	
                    <%if(loginUser!=null && loginUser.getMember_type().equals("R")) {
                    	//관리자 회원인경우에만 버튼을 클릭할 수 있다.
                    %>
                    	<button id="goListBoardAd" type="button" class="btn btn-secondary btn-lg"
                    		onclick="location.href='<%=request.getContextPath()%>/showBoardList.bo'">목록</button>
	                    
	                    <button id="editBoard" type="button" class="btn btn-primary btn-lg"
	                    	onclick="updateBoard();">수정</button>
	                    
	                    <button id="removeBoard" type="button" class="btn btn-danger btn-lg" 
	                    	onclick="deleteBoard();">삭제</button>
                    <%}else{ %>
                    	<button id="goListBoard" type="button" class="btn btn-secondary btn-lg"
                    		onclick="location.href='<%=request.getContextPath()%>/showBoardList.bo'">목록</button>
                    <%} %>
                	<script>
                		function updateBoard(){
                			let bId=<%=board.getBoardNum()%>;
                			location.href='<%=request.getContextPath() %>/updateBoardForm.bo?bId='+bId;
                			return true;
                		}
                	
                	
                		function deleteBoard(){
                			let bId=<%=board.getBoardNum()%>;
                			let fId=<%=fId%>;
                			
                			let result=confirm('삭제 하시겠습니까?');
                			if(result==true){
                				alert('공지사항 삭제가 완료되었습니다.');
                				
                				$.ajax({
                					url:'deleteBoard.bo',
                					type:'post',
                					data: {bId: <%=board.getBoardNum()%> , fId:<%=fId%> },
                					success:function(response){
                						let result= response['result'];
                						console.log(result);
                		
                						if(result>0){
                							//삭제 성공
                							alert('성공적으로 삭제하였습니다.');
                						}
                						return location.href='<%=request.getContextPath()%>/showBoardList.bo';
                					}
                					
                				});
                			}else{
                				alert('공지사항 삭제를 취소합니다.');
                			}
                		}
                	</script>
                </div>  
        </div>
        
  
    </div>
	
	  <%--footer추가 --%>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>