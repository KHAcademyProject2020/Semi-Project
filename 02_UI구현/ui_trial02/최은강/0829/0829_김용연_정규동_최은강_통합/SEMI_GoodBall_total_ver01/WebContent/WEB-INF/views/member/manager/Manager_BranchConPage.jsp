<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

/* 	.table_div{
		position:relative;
		top:50%;
		transform:translateY(-70%);
	} */

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
	
	.table > thead th:nth-child(5){
		width:150px;
	}	
	
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
	
	p{
		cursor:pointer;
	}
</style>
</head>
<body>
	<div class="table_div">
        <table class="table">
           <thead>
              <tr>
              	<th scope="col"></th>
                 <th scope="col">No</th>
                 <th scope="col">대표사진</th>
                 <th scope="col">지점이름</th>
                 <th scope="col" colspan="3">정보</th>                 
                 <th scope="col"></th>
                 <th scope="col">삭제</th>
              </tr>
         	</thead>
          	<tbody>
              <tr>
              	<td><input type="checkbox"></td>
                 <td scope="row">1</td>
                 <td><img src="#"></td>
                 <td class="branchName"><a href="#">서울지점</a></td>
                 <td colspan="3">
                 	<ul>
                 		<li>위치 : asdfasdfasdfasdf</li>
                 		<li>전화번호 : </li>
                 	</ul>
                 </td>
                 <td></td>
                 <td><button type="button" class="btn">삭제</button></td>
              </tr>
              <tr class="slide_tr">
              		<td colspan="9"><p class="slide_p"><i class="fas fa-angle-double-down"></i></p></td>
              </tr>
              <tr class="hidden_tr">
              	<td></td>
              	<td colspan="6">
              		<select>
              			<option>----------- 구장 확인 -----------</option>
              			<option>구장A</option>
              			<option>구장B</option>
              		</select>
              	</td>
              	<td><button type="button" class="btn">수정</button></td>
              	<td><button type="button" class="btn">삭제</button></td>
              </tr>
           </tbody>
        </table>
     </div>
     <script>
   		$(".btn").click(function(){
   			var branchName = $(this).parent().parent().children().eq(3).text();
   			var result = confirm(branchName + " 지점을 삭제하시겠습니까?");
   		
   			if(result){
   				/* 삭제 메소드 */
   				alert(branchName + " 지점이 삭제되었습니다");
   			} else{
   				alert(branchName + " 지점 삭제를 취소합니다");
   			}
   		});
   		
   		$(".slide_p").click(function(){
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
     </script>
</body>
</html>