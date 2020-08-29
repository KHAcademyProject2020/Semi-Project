<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</style>
</head>
<body>
	<div class="reserve_div" id="reserve_div">
        <table class="table">
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
        </table>
     </div>
     <script>
     function reservationInfo(x) {
    	   var type = '1';
    	   var page = x;
    	  <%--  var userId = '<%= loginUser.getEmail()%>'; --%>
    	  var userId = "werty23@daum.net";
    	   var path = '<%= request.getContextPath()%>';
    	   var testEval = "";
    	   $.ajax({
    	      url: 'reservationInfo.me',
    	      data: {userId:userId, page:page},
    	      success: function(data) {
    	    	 console.log(data);
    	         if(data.pi.listCount == 0) {
    	            testEval += '<div class="reserve_div" id="reserve_div"><hr><br><h1>예약현황</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
    	            testEval += '<tr><th scope="col">No</th><th scope="col">구장이름</th><th scope="col">예약자명</th><th scope="col">예약날짜</th><th scope="col">이용시간</th><th scope="col">입금/환불상태</th></tr></thead><tbody>';
    	            testEval += '<tr><th colspan="6">예약현황이없습니다</th></tr></tbody></table></div><br><br>';
    	            testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
    	            testEval += '<li class="page-item"><a class="page-link">&lt;&lt;</a></li>';
    	            testEval += '<li class="page-item"><a class="page-link">&lt;</a></li>';
    	            testEval += '<li class="page-item"><a class="page-link">&gt;</a></li>';
    	            testEval += '<li class="page-item"><a class="page-link">&gt;&gt;</a></li>';
    	            testEval += '</ul></nav></div></div>';
    	            
    	         }else {
    	            $.each(data, function(key, value) {
    	               if(key == "reservation" && key.listCount != 0) {
    	                  testEval += '<div class="reserve_div" id="reserve_div"><hr><br><h1>예약현황</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
    	                  testEval += '<tr><th scope="col">No</th><th scope="col">구장이름</th><th scope="col">예약자명</th><th scope="col">예약날짜</th><th scope="col">이용시간</th><th scope="col">입금/환불상태</th></tr></thead><tbody>';
    	                  for (var i = 0; i < value.length; i++) {
    	                     testEval += '<tr><td>'+ '' + '</td><td>' + value[i].stadium_name + '</td><td>'+ value[i].reservation_email +'</td><td>'+ value[i].reservation_usage_start_date +'</td><td>'+ value[i].reservation_usage_start_time + '~' + value[i].reservation_usage_end_time +'</td><td>'+ value[i].reservation_status + '</td></tr>';
    	                     /* '</td><td><input type="button" reservation_code='+ value[i].reservation_code +' value="취소" id="acBtn"></td></tr>'; */
    	                  }
    	                  testEval += '</tbody></table></div><br><br>';
    	               } else if (key == "pi" && key.listCount != 0) {
    	                  testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
    	                  testEval += '<li class="page-item"><button class="page-link" onclick="goPage1();">&lt;&lt;</button></li>';
    	                  testEval += '<li class="page-item"><button class="page-link" onclick="goPage1('+ (value.currentPage-1) +');">&lt;</button></li>';
    	                  for(var p = value.startPage; p <= value.endPage; p++) {
    	                     if(p == value.currentPage){
    	                        testEval += '<li class="page-item"><button class="page-link" id="choosen" style="color: gray;" disabled>'+ p +'</button></li>';
    	                               
    	                     }else {
    	                        testEval += '<li class="page-item"><button class="page-link" onclick="goPage1('+ p +');">'+ p +'</button></li>';
    	                     }
    	                            
    	                  }
    	                  testEval += '<li class="page-item"><button class="page-link" onclick="goPage1('+ (value.currentPage+1) +');">&gt;</button></li>'; 
    	                  testEval += '<li class="page-item"><button class="page-link" onclick="goPage1('+ value.maxPage +');">&gt;&gt;</button></li>';
    	                  testEval += '</ul></nav></div></div>';
    	                         
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