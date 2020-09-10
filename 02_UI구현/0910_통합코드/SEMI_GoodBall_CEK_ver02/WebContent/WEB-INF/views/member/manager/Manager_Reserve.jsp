<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/894c1eb86e.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$(function(){
		reservationInfo(1);	
	})
</script>
<style>

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
	
	table > thead{background-color:#03D392;}
	
	#noresult{color: black; height:500px; padding-top: 20px; margin:0;}
	
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
	<div class="reserve_div" id="reserve_div">
       <!--  <table class="table">
           <thead>
              <tr>
              	<th scope="col">No</th>
                 <th scope="col">구장이름</th>
                 <th scope="col">예약자명</th>
                 <th scope="col">예약날짜</th>
                 <th scope="col">이용시간</th>
                 <th scope="col">입금/환불상태</th>
              </tr>
         	</thead>
          	<tbody>
              <tr>
                 <td scope="row"></td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
              </tr>
           </tbody>
        </table> -->
     </div>
     <script>
     function reservationInfo(x) {
    	   var type = '1';
    	   var page = x;
    	   var userId = '<%= loginUser.getEmail()%>';
    	   var path = '<%= request.getContextPath()%>';
    	   var testEval = "";
    	   $.ajax({
    	      url: 'reservationInfo.me',
    	      data: {userId:userId, page:page},
    	      success: function(data) {
    	    	 console.log(data);
    	         if(data.pi.listCount == 0) {
    	            testEval += '<div class="reserve_div" id="reserve_div">';
    	            testEval +=	'<table class="table">';
    	            testEval +=	'<thead>';
    	            testEval += '<tr><th scope="col">No</th><th scope="col">구장이름</th><th scope="col">예약자명</th><th scope="col">예약날짜</th><th scope="col">이용시간</th><th scope="col">입금/환불상태</th></tr></thead><tbody>';
    	            testEval += '<tr><th colspan="6"><p id="noresult">예약현황이없습니다</p></th></tr></tbody></table></div><br><br>';
    	            testEval += '<div id="paging">';
   	            	testEval += '<ol class="pagination"><li class="first"><button><i class="fas fa-angle-double-left"></i></button></li>';
   	            	testEval += '<li class="prev"><button><i class="fas fa-angle-left"></i></button></li>';
   	            	testEval += '<li class="on"><button>1</button></li>';
   	            	testEval += '<li class="next"><button><i class="fas fa-angle-right"></i></button></li>';
   	            	testEval += '<li class="last"><button><i class="fas fa-angle-double-right"></i></button></li>';
   	            	testEval += '</ol></div></div>';
    	            
    	         }else {
    	            $.each(data, function(key, value) {
    	               if(key == "reservation" && key.listCount != 0) {
    	                  testEval += '<div class="reserve_div" id="reserve_div">';
    	                  testEval += '<table class="table">';
    	    	          testEval += '<thead>';
    	                  testEval += '<tr><th scope="col">No</th><th scope="col">구장이름</th><th scope="col">예약자명</th><th scope="col">예약날짜</th><th scope="col">이용시간</th><th scope="col">입금/환불상태</th></tr></thead><tbody>';
    	                  for (var i = 0; i < value.length; i++) {
    	                     testEval += '<tr><td>'+ '' + '</td><td>' + value[i].stadium_name + '</td><td>'+ value[i].reservation_email +'</td><td>'+ value[i].reservation_usage_start_date +'</td><td>'+ value[i].reservation_usage_start_time + '~' + value[i].reservation_usage_end_time +'</td><td>'+ value[i].reservation_status + '</td></tr>';
    	                     /* '</td><td><input type="button" reservation_code='+ value[i].reservation_code +' value="취소" id="acBtn"></td></tr>'; */
    	                  }
    	                  testEval += '</tbody></table></div><br><br>';
    	               } else if (key == "pi" && key.listCount != 0) {
    	                  testEval += '<div id="paging">';
    	                  testEval += '<ol class="pagination"><li class="first"><button onclick="goPage1();"><i class="fas fa-angle-double-left"></i></button></li>';
    	                  testEval += '<li class="prev"><button onclick="goPage1('+ (value.currentPage-1) +');"><i class="fas fa-angle-left"></i></button></li>';
    	                  for(var p = value.startPage; p <= value.endPage; p++) {
    	                     if(p == value.currentPage){
    	                    	 testEval += '<li class="on"><button>'+ p +'</button></li>';
    	                               
    	                     }else {
    	                    	 testEval += '<li><button onclick="goPage1('+ p +');">' +p +'</button></li>';
    	                     }
    	                            
    	                  }
    	                  brPaging += '<li class="next"><button onclick="goPage1('+ (value.currentPage+1) +');"><i class="fas fa-angle-right"></i></button></li>';
    	                  brPaging += '<li class="last"><button onclick="goPage1('+ value.maxPage +');"><i class="fas fa-angle-double-right"></i></button></li>';
    	                  brPaging += '</ol></div></div>';      
    	               } 
    	                      
    	            });
    	                   
    	         }
    	                
    	         $('#reserve_div').html(testEval);
    	      }
    	   });
    	}
     
     	function goPage1(page){
         var page = page;
         reservationInfo(page);
     	 };
     </script>
</body>
</html>