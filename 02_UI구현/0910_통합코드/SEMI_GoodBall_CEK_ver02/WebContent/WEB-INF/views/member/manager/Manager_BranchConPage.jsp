<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_team_page</title>
<script src="https://kit.fontawesome.com/894c1eb86e.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	body{
		text-align:center;
		height:700px;
	}

	.table_div{
		position:relative;
		top:20px;
	}

	.table{
		width:500px;
		text-align:center;
		border-collapse:collapse;
		margin: 0 auto;
	}
	
	th{
		color:#fff;
		border:2px solid #03D392;
		height:50px;
	}

	.table > thead{background-color:#03D392;}
	
	td{
		height:100px;
	}
	
	.btn{
		background:red;
		border:0;
		width: 50px;
    	height: 30px;
    	border-radius: 5px;
    	color: #fff;
	}
	
	ul{
		list-style:none;
		text-align:left;
	}
	
	select{
		width:90%;
		text-align-last:center; 
	}
	
	.hidden_tr{
		display:none;  
	}
	
	.hidden_tr > td{
		padding:0;
		height:0px;
	}
	
	.branch_tr > td{
		padding:0;
		height:0px;
	}
	
	#branchInfo{
		font-size:12px;
	}
	
	p{
		cursor:pointer;
		margin:0;
	}
	
	.slide_tr > td{
		height:0px;
	}
	
	#paging{
		position:fixed;
		bottom:10px;
		width:590px;
		display: flex;
    	justify-content: center;
    	left:-1px;
	}
	
	.pagination{list-style:none; padding:0; margin:0;}
	
	.page-item{float:left;}
	
	.page-link{cursor:pointer;}
	
	#noresult{color: black; height:500px; padding-top: 20px;}
	
	/* 페이징 버튼 */
	.pagination{text-align:center; font-size:0;}
	.pagination li{display:inline-block; vertical-align:middle;}
	.pagination li button{display:block; width:32px; height:32px; line-height:32px; color:gray; font-size:16px; border: none;
    background: white;}
	.pagination li.on button,
	.pagination li button:hover{color:#ff5a20; text-decoration:underline;}
	.pagination li.first button, .paging li.prev button, .paging li.next button, .paging li.last button{overflow:hidden; margin:0 2px; width:30px; height:30px; border:1px solid #ebeae9;}
	.pagination li.prev button{margin-right:23px;}
	.pagination li.next button{margin-left:23px;}
	
</style>
</head>
<body>
	<div class="table_div" id="table_div">
     </div>
     <script>
     	$(document).on('click', '#branchDeleteBtn', function(){ // 지점삭제
     		var branch_num = $(this).attr('branch_num'); 
     		
   			var result = confirm(branch_num + " 지점을 삭제하시겠습니까?");
   		
   			if(result){
   				location.href="<%= request.getContextPath() %>/deleteBranch.br?name=" + branch_num;
   				alert(branch_num + " 지점이 삭제되었습니다");
   			} else{
   				alert(branch_num + " 지점 삭제를 취소합니다");
   			}
     	 
     	 });
     	
    	$(document).on('click', '#modifyBranchBtn', function(){ // 지점수정
     		var branch_num = $(this).attr("branch_num");
     		
     		location.href="<%= request.getContextPath() %>/branchModify.br?num=" + branch_num;
     		
     		/* location.href="search.jsp?type="+type+"&type2=type"+type2; */
     	 });
    	
    		var checked_stadium_name;
    		var checked_branch_num;
    	 $(document).on('change', '#stadiumSelect', function(){ // 구장수정
     		/* var stadium_num = $(this).parent().prev().find("#stadiumSelect").val(); */
     		checked_stadium_name = $(this).children("option:selected").text();
     		checked_branch_num = $(this).attr("branch_num");
     	 });
    	 
    	 $(document).on('click', '#modifyStadiumBtn', function(){ // 구장수정
    		 if(checked_stadium_name != null){
    		 	location.href="<%= request.getContextPath() %>/branchStadiumModify.br?branch_num=" + checked_branch_num + "&stadium_name=" + checked_stadium_name;    			 
    		 }
    	 });
    	 
    	 $(document).on('click', '#stadiumDeleteBtn', function(){ // 구장삭제
    		 var result = confirm(checked_stadium_name + "구장을 삭제하시겠습니까?");
    		 if(result && checked_stadium_name != null){
        		location.href="<%= request.getContextPath() %>/branchStadiumDelete.br?branch_num=" + checked_branch_num + "&stadium_name=" + checked_stadium_name;
        		alert(checked_stadium_name + " 구장이 삭제되었습니다");
    		 } else{
    			 alert(checked_stadium_name + " 구장 삭제를 취소합니다");
    		 }
    		 
    	 })
     		
     	$(document).on('click', '.slide_p', function(){
     		var hidden = $(this).parent().parent().next();
   			var i = $(this).children().eq(0);
   			if(hidden.css("display") == "none"){
   				hidden.css("display", "table-row");
   	   			i.removeClass("fas fa-angle-double-down");
   	   			i.addClass("fas fa-angle-double-up");
   			} else{
   				hidden.css("display", "none");
   	   			i.removeClass("fas fa-angle-double-up");
   	   			i.addClass("fas fa-angle-double-down");
   			}
     	}); 
     	
     	$(document).on('click', '#slide_i, #stadiumSelect', function(){
     		var branch_num = $(this).attr("branch_num");
     		var path = '<%= request.getContextPath() %>';
     		var stPaging = "";
     		
     		$.ajax({
	    	      url: 'branchStadium.br',
	    	      data: {branch_num:branch_num},
	    	      success: function(data) {
	    	    	  if(data == null){
	    	    		 /*  stadiumArr[0] += '<option>----------- 구장 없음 -----------</option>'; */
	    	    		 stPaging += '<option>----------- 구장 없음 -----------</option>';
	    	    	  } else {
	    	    		$.each(data, function(key, value){
	    	    				stPaging += '<option>----------- 구장 확인 -----------</option>';
		    	    		  for (var i = 0; i < value.length; i++) {
		    	    		 	/* stadiumArr[i]  += '<option id="stadiumOption" name="'+value[i].stadium_num+'" value="'+value[i].stadium_num+'" stadium_num="'+value[i].stadium_num+'">'+ value[i].stadium_name +'</option>'; */
		    	    			  stPaging += '<option id="stadiumOption" name="'+value[i].stadium_num+'" value="'+value[i].stadium_num+'" stadium_num="'+value[i].stadium_num+'">'+ value[i].stadium_name +'</option>';
		    	    		  }
	    	    		});
	    	    	  }
	    	    	  
		     		/* $("select[name="+"'"+ branch_num +"'"+"]").html(stadiumArr.join('')); */
	    	    	  $("select[name="+"'"+ branch_num +"'"+"]").html(stPaging);
	    	      }
	    	   	});
     	 });
     	
	     function branchInfo(x) {
	    	   var type = '1';
	    	   var page = x;
	    	   var userId = '<%= loginUser.getEmail()%>';
	    	   var path = '<%= request.getContextPath()%>';
	    	   var brPaging = "";
	    	   $.ajax({
	    	      url: 'branchPaging.br',
	    	      data: {userId:userId, page:page},
	    	      success: function(data) {
	    	    	  if(data.pi.listCount == 0){
	    	    		  brPaging += '<div class="table_div"><table class="table"><thead>';
	    	    		  brPaging += '<tr><th scope="col" colspan="2">대표사진</th><th scope="col" colspan="2">지점이름</th><th scope="col" colspan="3">정보</th><th scope="col">수정</th><th scope="col">삭제</th></tr></thead>';
	    	    		  brPaging += '<tbody><tr class="branch_tr"><td colspan="9"><p id="noresult">등록된 지점이 없습니다</p></td></tr></tbody>';
	    	    		  brPaging += '</table></div>';
	    	    		  brPaging += '<div id="paging">';
	    	    		  brPaging += '<ol class="pagination"><li class="first"><button><i class="fas fa-angle-double-left"></i></button></li>';
	    	    		  brPaging += '<li class="prev"><button><i class="fas fa-angle-left"></i></button></li>';
	    	    		  brPaging += '<li class="on"><button>1</button></li>';
	    	    		  brPaging += '<li class="next"><button><i class="fas fa-angle-right"></i></button></li>';
    	                  brPaging += '<li class="last"><button><i class="fas fa-angle-double-right"></i></button></li>';
	    	    		  brPaging += '</ol></div></div>';
	    	    	  } else {
	    	    		$.each(data, function(key, value){
	    	    			if(key == 'branchArray' && key.listCount != 0){
	  	    	    		  brPaging += '<div class="table_div"><table class="table"><thead>';
		    	    		  brPaging += '<tr><th scope="col" colspan="2">대표사진</th><th scope="col" colspan="2">지점이름</th><th scope="col" colspan="3">정보</th><th scope="col">수정</th><th scope="col">삭제</th></tr></thead><tbody>';
		    	    		 
		    	    		  for (var i = 0; i < value.length; i++) {
		    	    		  	brPaging += '<tr class="branch_tr"><td colspan="2"><img src=""></td>';
		    	    		  	/* resources/storage/"'+value[i].branch_manager_email+'"/branch_img/"'+value[i].branch_img+' */
		    	    		  	brPaging += '<td class="branchName" colspan="2">' + value[i].branch_num + '</a></td>';
		    	    		  	brPaging += '<td colspan="3" id="branchInfo"><ul><li>위치 : ' + value[i].branch_address + '</li><li>전화번호 : ' + value[i].branch_phone + '</li></ul></td>';
		    	    		  	brPaging += '<td><button type="button" class="btn" id="modifyBranchBtn" branch_num="'+value[i].branch_num+'">수정</button></td><td><button type="button" class="btn" id="branchDeleteBtn" branch_num="'+ value[i].branch_num +'">삭제</button></td></tr>';
		    	    		  	// 밑에게 화살
		    	    		  	brPaging += '<tr class="slide_tr"><td colspan="9"><p class="slide_p"><i class="fas fa-angle-double-down" id="slide_i" branch_num="'+ value[i].branch_num +'"></i></p></td></tr>';
		    	    		 	// 밑에게 셀렉트 있는 tr
		    	    		  	brPaging += '<tr class="hidden_tr"><td colspan="7">';
		    	    		 	brPaging += '<select id="stadiumSelect" name="'+value[i].branch_num+'" branch_num="'+value[i].branch_num+'">/select></td>';
		    	    		  	brPaging += '<td><button type="button" class="btn" id="modifyStadiumBtn">수정</button></td><td><button type="button" class="btn" id="stadiumDeleteBtn">삭제</button></td></tr>'; 		
		    	    		  }
		    	    		  brPaging += '</tbody></table>';

	    	    			} else if (key == "pi" && key.listCount != 0) {
	    	    				brPaging += '<div id="paging">';
	    	    				brPaging += '<ol class="pagination"><li class="first"><button onclick="goPage1();"><i class="fas fa-angle-double-left"></i></button></li>';
	    	    				brPaging += '<li class="prev"><button onclick="goPage1('+ (value.currentPage-1) +');"><i class="fas fa-angle-left"></i></button></li>';
	    	                  for(var p = value.startPage; p <= value.endPage; p++) {
	    	                     if(p == value.currentPage){
	    	                    	 brPaging += '<li class="on"><button>'+ p +'</button></li>';
	    	                               
	    	                     }else {
	    	                    	brPaging += '<li><button onclick="goPage1('+ p +');">' +p +'</button></li>';
	    	                     }
	    	                            
	    	                  }
	    	                  brPaging += '<li class="next"><button onclick="goPage1('+ (value.currentPage+1) +');"><i class="fas fa-angle-right"></i></button></li>';
	    	                  brPaging += '<li class="last"><button onclick="goPage1('+ value.maxPage +');"><i class="fas fa-angle-double-right"></i></button></li>';
	    	                  brPaging += '</ol></div></div>';
	    	                         
	    	               }
	    	    		});  
	    	    	  }
	    	    	  
	    	    	  $('#table_div').html(brPaging);
	    	      }
	    	   	});
	    	  }
	 	
	     function goPage1(page){
	         var page = page;
	         branchInfo(page);
	     };

	   		$(function(){
	   			branchInfo(1);	
	   		});
     </script>
</body>
</html>