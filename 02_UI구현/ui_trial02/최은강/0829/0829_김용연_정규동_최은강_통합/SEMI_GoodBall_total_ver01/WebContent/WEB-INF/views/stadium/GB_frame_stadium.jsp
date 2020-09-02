<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page
   import="java.util.ArrayList, team.model.vo.*, reservation.model.vo.*"%>

<%

   ArrayList<Stadium> stadiumArr = (ArrayList<Stadium>) request.getAttribute("stadiumArr");

   team.model.vo.PageInfo pi = (team.model.vo.PageInfo) request.getAttribute("pi");
   
   int listCount = pi.getListCount();
   int currentPage = pi.getCurrentPage();
   int maxPage = pi.getMaxPage();
   int startPage = pi.getStartPage();
   int endPage = pi.getEndPage();
   
   System.out.println("구장 예약 페이지 입장");
%>
<!DOCTYPE html>
<html>
<head>
<title>Good Ball (팀 페이지)</title>

   <link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
   
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
        
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>


<style>
#content{
   width:100%;
   margin: 0 auto;
   text-align: center;
   /* font-size: 1.2vw; */
}
.container-for-carousel{
   width:100%;
}
.container-for-content{
      padding-top: 3%;
      margin-left: 5%;
      margin-right: 5%;
      padding-left: 10%;
      padding-right: 10%;   
      padding-bottom: 5%;
      /*내용 컴포넌트를 넣는 곳*/
      background-color: rgba(223,232,225,0.1); 
}
td{
   font-size: 1.4em;
   margin:auto 0; 
   color: gray;
}
.branchSearch{
   width:300px; 
     height:50px;
   border:3px solid #ccc;
}
.branchSearch::placeholder{
   color: gray;
   font-size: large;
   font-weight:200;
}
.simple {
    display: inline-block;
    font: inherit;
    font-weight: bold;
    font-size: 20px;
    cursor: pointer;
    background-color: #5ca1cd;
    color: #fff;
    text-decoration: none;
    padding: 10px 25px;
    border: none;
    border-bottom: 3px solid #3f84b0;
    border-radius: 3px;
}
.simple:hover {background-color: #61a8d5;}
#paging {
   display: inline-block;
}
#paging .page-link {
   Color: black;
}
</style>
<title>Insert title here</title>
</head>
<body>
   <%-- <%@ include file="../common/navbar.jsp"%> --%>
   <%@include file="/WEB-INF/views/common/navbar.jsp"%>
   
   <!-- BODY 시작 -->
   <section id="content">
      <!-- container-for-carousel 시작-->
      <div class="container-for-carousel">
         <!-- carousel start -->
         <div class="carousel-container">
         
         </div>
         <!-- carousel end -->
      </div>
      <!-- .container-for-carousel 끝-->
      <!--container-for-content 시작-->
      <div class="container-for-content">
         <!-- container-for-content안에 내용을 넣어주세요~ -->
         <div class="container-content">
         <!-- container안에 들어있는 내용이 바뀜. -->
            
            <br><br>
            <form action="" id="stadium" name="stadium">
               <input type="text" id="search_branch_num" class="branchSearch" style="float: left;" value="" placeholder="지점이름입력">
               <button type="button" class="simple" style="float: left; margin-left:10px;" onclick="branchNameSearch();" value="">검색</button>
               <input type="hidden" id="search_branch_address" value="">
               <input type="hidden" id="search_stadium_matchMember" value="">
               <input type="hidden" id="search_startTime" value="0">
               <input type="hidden" id="search_endTime" value="0">
               <button type="button" class="simple" style="float: left; margin-left:10px;" onclick="stadiumSearch();">상세검색</button>
               <button type="button" id="stadiumRegist" style="float: right;" class="simple" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">구장등록</button>
            </form>
            <br><br>
            
            <div class="wrap4" id="wrap4">
               
               <hr>
               <h1>구장 정보 보기</h1>
               <hr>
               <table class="table table-hover">
                  <thead class="thead-dark">
                     <tr>
                        <th scope="row">no</th>
                        <th scope="col">이미지</th>
                        <th scope="col">장소</th>
                        <th scope="col">구장</th>
                        <th scope="col">매치</th>
                        <th scope="col">예약가능</th>
                        <th scope="col">전화번호</th>
                     </tr>
                  </thead>
                  <tbody>
                     <% if(stadiumArr.isEmpty()){ %>
                     <tr>
                        <td colspan="8">존재하는구장이없습니다</td>
                     </tr>
                     <% } else { %>
                     
                     <%      for (int i = 0; i < stadiumArr.size(); i++) {%>
                     <tr
                        onclick="location.href='<%=request.getContextPath()%>/reservation.me?stadium_num=<%= stadiumArr.get(i).getStadium_num()%>&stadium_branch_num=<%= stadiumArr.get(i).getBranch_num()%>';">
                        <th scope="row"><%= stadiumArr.get(i).getStadium_num()%></th>
                        <td><img src="<%=request.getContextPath()%>/resources/storage/manager/<%= stadiumArr.get(i).getBranch_manager_email()%>/<%= stadiumArr.get(i).getBranch_img()%>" width="150px" height="100px"></td>
                        <td><%= stadiumArr.get(i).getBranch_address()%><br><%= stadiumArr.get(i).getBranch_num()%>지점</td>
                        <td><%= stadiumArr.get(i).getStadium_name()%></td>
                        <td><%= stadiumArr.get(i).getStadium_match_member()%></td>
                        <td><%= stadiumArr.get(i).getStadium_reservation_start_time()%>:00 ~ <%= stadiumArr.get(i).getStadium_reservation_end_time() %>:00</td>
                        <td><%= stadiumArr.get(i).getBranch_phone()%></td>
                     </tr>
                     <%      }%>
                     <%}%>
                  </tbody>
               </table>
               
               <div id="paging">
                  <nav aria-label="Page navigation example">
                     <ul class="pagination">
                        <% if(pi == null){ %>
                           <li class="page-item"><a class="page-link">&lt;&lt;</a></li>
                           <li class="page-item"><a class="page-link">&lt;</a></li>
                            <li class="page-item"><a class="page-link">&gt;</a></li>
                           <li class="page-item"><a class="page-link">&gt;&gt;</a></li>
                        <% } else { %>
                           <li class="page-item"><button class="page-link"
                                 onclick="location.href='<%= request.getContextPath() %>/stadium.me?&currentPage=1'">&lt;&lt;</button></li>
                           <li class="page-item"><button class="page-link"
                                 onclick="location.href='<%= request.getContextPath() %>/stadium.me?&currentPage=<%= currentPage - 1%>'"
                                 id="beforeBtn">&lt;</button></li>
                           <% for(int p = startPage; p <= endPage; p ++) {%>
                           <% if(p == currentPage){ %>
                           <li class="page-item"><button class="page-link"
                                 id="choosen" style="color: gray;" disabled><%= p %></button></li>
                           <% } else { %>
                           <li class="page-item"><button class="page-link" id="numBtn"
                                 onclick="location.href='<%= request.getContextPath() %>/stadium.me?&currentPage=<%= p %>'"><%= p %></button></li>
                           <% } %>
                           <% } %>
                           <li class="page-item"><button class="page-link"
                              onclick="location.href='<%= request.getContextPath() %>/stadium.me?&currentPage=<%= currentPage + 1 %>'"
                              id="afterBtn">&gt;</button></li>
                           <li class="page-item"><button class="page-link"
                              onclick="location.href='<%= request.getContextPath() %>/stadium.me?&currentPage=<%= maxPage %>'">&gt;&gt;</button></li>
                        <%} %>
                     </ul>
                  </nav>
               </div>
               <% if(pi != null){ %>
               <script>
                  if(<%= currentPage %> <= 1) {
                     var before = $('#beforeBtn');
                     before.attr('disabled', 'true');
                     
                  }
                  if(<%= currentPage %> >= <%= maxPage%>) {
                     var after = $('#afterBtn');
                     after.attr('disabled', 'true');
                     
                  }
               </script>
               <%} %>
            </div>
         
         </div>
      </div>
      <!--container-for-content 끝-->
   </section>
   <%-- <%@include file="../common/footer.jsp"%> --%>
   <%@include file="/WEB-INF/views/common/footer.jsp"%>
   
   
   <!-- modal -->
   <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title" id="exampleModalLabel">&lt;구장등록&gt;</h4>
            </div>
            <div class="modal-body">
               <form>
                  <div class="form-group">
                     <label for="recipient-name" class="control-label"
                        style="font-size: 25px;">구장이름 : </label>
                     <div class="input-group input-group-lg">
                        <input type="text" class="form-control input-sm" id="stadium_name"
                           placeholder="구장이름입력">
                     </div>
                  </div>

                  <div class="form-group">
                     <div class="input-group mb-3">
                        <label for="recipient-name" class="control-label"
                           style="font-size: 25px;">지점선택 : </label>
                        &nbsp;&nbsp;&nbsp;&nbsp; <span class="input-group-addon">
                           <i class="fa fa-user fa" aria-hidden="true"></i>
                        </span> 
                        <select name="branch_num" id="branch_num">
                           <option value="">------</option>
                        
                        </select>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" id="branchBtn" class="simple">지점조회</button>
                        
                     </div>
                  </div>
                  
                  <div class="form-group">
                     <div class="input-group mb-3">
                        <label for="recipient-name" class="control-label"
                           style="font-size: 25px;">매치인원 : </label>
                        &nbsp;&nbsp;&nbsp;&nbsp; <span class="input-group-addon">
                           <i class="fa fa-user fa" aria-hidden="true"></i>
                        </span> <select id="stadium_matchMember">
                           <option value="">매치인원 선택</option>
                           <option value="3vs3">3 vs 3</option>
                           <option value="4vs4">4 vs 4</option>
                           <option value="5vs5">5 vs 5</option>
                           <option value="6vs6">6 vs 6</option>
                           <option value="7vs7">7 vs 7</option>
                           <option value="8vs8">8 vs 8</option>
                        </select>
                     </div>
                  </div>
                  <div class="form-group">
                     <div class="input-group mb-3">
                        <label for="recipient-name" class="control-label"
                           style="font-size: 25px;">예약가능시간 : </label>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="input-group-addon">
                           <i class="fa fa-user fa" aria-hidden="true"></i>
                        </span>
                        <select name="startTime" id="startTime">
                        </select>
                        &nbsp;&nbsp;&nbsp;_&nbsp;&nbsp;&nbsp; 
                        <select name="endTime" id="endTime">
                           <option value="0">00시</option>
                        </select>
                     </div>
                  </div>
                  
               </form>
            </div>
            <div class="modal-footer">
               <button type="button" id="stadiumRegistBtn" class="simple">구장
                  등록하기</button>
               <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
            </div>
         </div>
      </div>
   </div>

</body>


<script type="text/javascript">
   
   $('#satdiumRegist').on('show.bs.modal', function(event){});
   
   $('#stadiumRegistBtn').click(function() {
      var userId = '<%= userId%>';
      if(userId != null) {
         var stadium_name = $('#stadium_name').val();
         var branch_num = $('#branch_num').val();
         var branch_num1 = branch_num.split('지점');
         var branch_num2 = branch_num1[0];
         var stadium_matchMember = $('#stadium_matchMember').val();
         var startTime = $('#startTime').val();
         var startTime1 = startTime.split('시');
         var startTime2 = startTime1[0];
         var endTime = $('#endTime').val();
         var endTime1 = endTime.split('시');
         var endTime2 = endTime1[0];
         console.log(userId);
         console.log(stadium_name);
         console.log(branch_num2);
         console.log(stadium_matchMember);
         console.log(startTime2);
         console.log(endTime2);
   
         if(stadium_name == "") {
            alert('구장이름 입력해주세요');
             $("#stadium_name").focus();
         }else if(branch_num == ""){
            alert('지점번호 선택해주세요');
             $("#branch_num").focus();
         }else if(stadium_matchMember == ""){
            alert('매치인원 선택해주세요');
             $("#stadium_matchMember").focus();
         }else if(startTime == "시간선택"){
            alert('시간 선택해주세요');
             $("#startTime").focus();
         }else if(endTime == "시간선택"){
            alert('시간 선택해주세요');
             $("#endTime").focus();
         }else {
            if (confirm("등록하시겠습니까?") == true){
               $.ajax({
                   url: 'stadiumRegist.me',
                   data: {userId:userId, stadium_name:stadium_name, branch_num:branch_num2,
                      stadium_matchMember:stadium_matchMember, startTime:startTime2, endTime:endTime2},
                   success: function(data) {
                      console.log(data);
                      
                      if(data == 1) {
                         alert('구장이름중복');
                      }else if(data == 2){
                         alert('구장등록되었습니다');
                         location.href = location.href;
                      }else {
                         
                      }
                   }
                });
            }else{
                 return false;
            }
         }
      }else {
         alert('로그인후이용가능');
      }
      
   });
   
   $("#startTime").on("change", function(){
      var endTime = [];
      var value = "";
      var time = $(this).val();
      var endTime1 = time.split('시');
      var endTime2 = parseInt(endTime1[0]);
      for(var i =endTime2; i < 24; i++) {
         if(i < 10) {
            value = "0" + i;
         }else {
            value = i;
         }
         endTime[i] = "<option value"+ value +">"+value+"시</option>"
      }
      $('#endTime').empty();
      $('#endTime').append(endTime.join(''));
   });
   
   
   var startTime = [];
   var value = "";
   for(var i =0; i < 24; i++) {
      if(i < 10) {
         value = "0" + i;
      }else {
         value = i;
      }
      startTime[i] = "<option value"+ value +">"+value+"시</option>";
   }
   $('#startTime').append(startTime.join(''));
   
   
   $('#branchBtn').click(function(){
      var userId = '<%= userId%>';
      if(userId != null) {
         var branchArr = [];
         $.ajax({
             url: 'branchCheck.me',
             data: {userId:userId},
             success: function(data) {
                console.log(data);
                if(data != null) {
                   alert('조회되었습니다');
                   $('#branch_num').empty();
                   $.each(data, function(key, value) {
                      branchArr[i] += "<option value"+ value.branch_num +">"+ value.branch_num +"지점</option>";
                      
                   });
                }else if(data == null){
                   alert('지점이없습니다');
                   
                }else {
                   
                }
                $('#branch_num').append(branchArr.join(''));
             }
          });
         
      }else {
         alert('로그인후이용가능');
      }
   });
   
   function stadiumSearch(){
      window.open("stadiumSearchBtn.me", "stadiumSearchForm", "width=500, height=600");
   }
   
   function stadiumSearch2(x) {
      var branch_num = $('#search_branch_num').val();
      var branch_address = $('#search_branch_address').val();
      var stadium_matchMember = $('#search_stadium_matchMember').val();
      var startTime = $('#search_startTime').val();
      var startTime1 = startTime.split('시');
      var startTime2 = parseInt(startTime1[0]);
      var endTime = $('#search_endTime').val();
      var endTime1 = endTime.split('시');
      var endTime2 = parseInt(endTime1[0]);
      var page = x;
      var path = '<%= request.getContextPath()%>';
      var testEval = "";
      $.ajax({
          url: 'stadiumSearch.me',
          data: {branch_num:branch_num, branch_address:branch_address, stadium_matchMember:stadium_matchMember,
             startTime:startTime2, endTime:endTime2, page:page},
          success: function(data) {
             console.log(data);
             
             if(data.pi.listCount == 0) {
                alert('구장이없습니다');
                testEval += '<div class="wrap4" id="wrap4"><hr><br><h1>구장 정보 보기</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
                testEval += '<tr><th scope="row">no</th><th scope="col">이미지</th><th scope="col">장소</th><th scope="col">구장</th><th scope="col">매치</th><th scope="col">예약가능</th><th scope="col">전화번호</th></tr></thead><tbody>';
                testEval += '<tr><th colspan="7">존재하는구장이없습니다</th></tr></tbody></table></div><br><br>';
                testEval += '<div id="paging"><nav aria-label="Page navigation example"><ul class="pagination">';
                testEval += '<li class="page-item"><a class="page-link">&lt;&lt;</a></li>';
                testEval += '<li class="page-item"><a class="page-link">&lt;</a></li>';
                testEval += '<li class="page-item"><a class="page-link">&gt;</a></li>';
                testEval += '<li class="page-item"><a class="page-link">&gt;&gt;</a></li>';
                 testEval += '</ul></nav></div></div>';
                
             }else {
                $.each(data, function(key, value) {
                   if(key == "stadium" && key.listCount != 0) {
                      testEval += '<div class="wrap4" id="wrap4"><hr><br><h1>구장 정보 보기</h1><hr><div class="table-responsive"><table class="table table-hover"><thead class="thead-dark">';
                      testEval += '<tr><th scope="row">no</th><th scope="col">이미지</th><th scope="col">장소</th><th scope="col">구장</th><th scope="col">매치</th><th scope="col">예약가능</th><th scope="col">전화번호</th></tr></thead><tbody>';
                      for (var i = 0; i < value.length; i++) {
                         testEval += '<tr onclick="goLocation('+ value[i].stadium_num +', '+ "'" +''+ value[i].branch_num +''+ "'" +');"><th scope="row">'+ value[i].stadium_num +'</th><td><img src="'+ path +'/resources/storage/manager/'+ value[i].branch_manager_email +'/'+ value[i].branch_img +'" width="150px" height="100px"></td><td>'+ value[i].branch_address +'<br>'+ value[i].branch_num +'지점</td><td>'+ value[i].stadium_name +'</td><td>'+ value[i].stadium_match_member +'</td><td>'+ value[i].stadium_reservation_start_time +':00 ~ '+ value[i].stadium_reservation_end_time +':00</td><td>'+ value[i].branch_phone +'</td></tr>';
                      
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
                      
                   } else {
                   }
                });
             }
             $('#wrap4').html(testEval);
             
          }
       });
   }
   
   function goPage1(page) {
      var page = page;
      stadiumSearch2(page);
   };
   
   function goLocation(sn,bn) {
      var sn = sn;
      var bn = bn;
      console.log(sn);
      console.log(bn);
      var path = '<%= request.getContextPath()%>';
      location.href=""+ path +"/reservation.me?stadium_num="+ sn +"&stadium_branch_num="+ bn +"";
   };
   
   function branchNameSearch() {
      var branch_num = $('#search_branch_num').val();
      if(branch_num == "") {
         $('#search_branch_num').val('');
         $('#search_branch_address').val('');
         $('#search_stadium_matchMember').val('');
         $('#search_startTime').val('0');
         $('#search_endTime').val('0');
         stadiumSearch2(1);
      }else {
         $('#search_branch_address').val('');
         $('#search_stadium_matchMember').val('');
         $('#search_startTime').val('0');
         $('#search_endTime').val('0');
         stadiumSearch2(1);
      }
   };
   
   
</script>

</html>