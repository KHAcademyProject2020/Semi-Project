<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*, branch.model.vo.*"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String userId = loginUser.getEmail();
	Branch branch = (Branch)request.getAttribute("branch");
	String detail = branch.getDetail_Info();
	String ball = branch.getBranch_option_ball();
	String inout = branch.getBranch_option_inout();
	String park = branch.getBranch_option_park();
	String shoes = branch.getBranch_option_shoes();
	String shower = branch.getBranch_option_shower();
	String uniform = branch.getBranch_option_uniform();

	String[] check1 = new String[2];
	String[] check2 = new String[2];
	String[] check3 = new String[2];
	String[] check4 = new String[2];
	String[] check5 = new String[2];
	String[] check6 = new String[2];
	if(shower.equals("Y")){
		check1[0] = "checked";
	} else{
		check1[1] = "checked";
	}
	
	if(park.equals("Y")){
		check2[0] = "checked";
	} else{
		check2[1] = "checked";
	}
	
	if(uniform.equals("Y")){
		check3[0] = "checked";
	} else{
		check3[1] = "checked";
	}
	
	if(shoes.equals("Y")){
		check4[0] = "checked";
	} else{
		check4[1] = "checked";
	}
	
	if(ball.equals("Y")){
		check5[0] = "checked";
	} else{
		check5[1] = "checked";
	}
	
	if(inout.equals("I")){
		check6[0] = "checked";
	} else{
		check6[1] = "checked";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
	body{
		height:700px;
		text-align:center;
	}

	.form-horizontal{
		width:100%;
		margin:0 auto;
		padding:0 50px;
		box-sizing:border-box;
	}

	.form-group{
		width:300px;
		height:35px;
		margin: 10px 0 30px 0;
		position:relative;
		display:inline-block;
	} 
	
	.form-group > input{
		width:100%;
		height:100%;
		border:none;
		border:2px solid #03D392;
		font-size:18px;
	}
	
	.form-group > input[type="date"]{
		font-size:12px;
	}
	
	.form-group > label{
		position:absolute;
		top:2px;
		left:15px;
		transform:translateY(-50%);
		font-size:15px;
		color:#03D392;
		padding:0px;
		background:#fff;
	}

	.form-detail textarea{
		padding-top:10px;
	}
	
	.form-group > textarea{
		border-color:#03D392;
		border-width:2px;
	}
	
	.radio-group{
		width:300px;
		border:2px solid #03D392;
		position:relative;
		margin-bottom:25px;
		display:inline-block;
	}
	
	.radio-group > label:first-of-type{
		position:absolute;
		top:2px;
		left:15px;
		transform:translateY(-50%);
		font-size:15px;
		color:#03D392;
		padding:0px;
		background:#fff;
	}
	
	/*파일선택 버튼*/
	.file_input label{
		position:relative;
	    cursor:pointer;
	    display:inline-block;
	    vertical-align:middle;
	    overflow:hidden;
	    width:100px;
	    height:30px;
	    background:#777;
	    color:#fff;
	    text-align:center;
	    line-height:30px;
	    top:5px;
	}
	
	.file_input label input{
		position:absolute;
		display:none;
		overflow:hidden;
	}
	
	.file_input input[type=text]{
		display:inline-block;
		height:20px;
		vertical-align:middle;
		width:300px;
	}
	
	/* 카카오 */
	.kakao-group{
		width:300px;
		height:25px;
		display:inline-flex;
		flex-wrap:wrap;
		justify-content:space-between;
	} 
	
	.kakao-group > input:not(.addressBtn){
		width:45%;
		height:100%;
		border:none;
		border:2px solid #03D392;
		font-size:18px;
		margin-bottom:5px;
	}
	
	.kakao-group >.addressBtn{
		width:45%;
		height:100%;
		border:none;
		font-size:18px;
		margin-right:-10px;
	}
	
	
	/* hr */
	hr{
		border:0;
		height: 3px;
		background:#ccc;
	}
	
	/* 버튼 */
	.btn-groups{
		text-align:center;
	}
	
	.btn-groups button{
		background-color:#03D392;
		color:#fff;
		border:0;
		width:70%;
		height:40px;
	}
	
	.btn-groups > button:first-of-type {
		margin-right:10px;
	}
</style>
</head>
<body>
	<form class="form-horizontal" method="post" action="<%= request.getContextPath() %>/modifyBranch2.br" encType="multipart/form-data">
		<div class="form-group">
			<label for="placeName">지점명</label>
			<input type="text" name="branchName" id="branchName" value="<%= branch.getBranch_num() %>"/>
		</div>
		<div class="form-group">
			<label for="placeInfo">지점 한줄 소개 <span id="count1">(0 / 최대 20자)</span></label>
			<input type="text" name="placeInfo" id="placeInfo" maxlength="20" style="font-size:12px;" value="<%= branch.getBranch_Info() %>"/>
		</div>
		<div class="form-group form-detail">
			<label for="detailInfo">공간 소개 <span id="count2">(0 / 최대 1000자 (최소 30자))</span></label>
			<% if(detail == null) {%>
			<textarea rows="10" cols="36" name="detailInfo" id="detailInfo" maxlength="1000"></textarea>
			<% } else { %>
			<textarea rows="10" cols="36" name="detailInfo" id="detailInfo" maxlength="1000"><%= branch.getDetail_Info() %></textarea>
			<% } %>
		</div>
		<br><br>
		<div class="radio-group">
			<label for="facility">이용가능</label><br>
			샤워실 이용
			<input type="radio" name="shower" id="shower" value="Y" <%= check1[0] %>/>
			<label for="showerok">가능</label>
			<input type="radio" name="shower" id="gender2" value="N" <%= check1[1] %>/>
			<label for="showernop">불가능</label><br>
			주차 이용
			<input type="radio" name="parking" id="parking" value="Y" <%= check2[0] %>/>
			<label for="parkingok">가능</label>
			<input type="radio" name="parking" id="parking" value="N" <%= check2[1] %>/>
			<label for="parkingnop">불가능</label><br>
			유니폼 대여
			<input type="radio" name="uniform" id="uniform" value="Y" <%= check3[0] %>/>
			<label for="uniformok">가능</label>
			<input type="radio" name="uniform" id="uniform" value="N" <%= check3[1] %>/>
			<label for="uniformnop">불가능</label><br>
			풋살화 대여
			<input type="radio" name="shoes" id="shoes" value="Y" <%= check4[0] %>/>
			<label for="shoesok">가능</label>
			<input type="radio" name="shoes" id="shoes" value="N" <%= check4[1] %>/>
			<label for="shoesnop">불가능</label><br>
			볼 대여
			<input type="radio" name="ball" id="ball" value="Y" <%= check5[0] %>/>
			<label for="ballok">가능</label>
			<input type="radio" name="ball" id="ball" value="N" <%= check5[1] %>/>
			<label for="ballnop">불가능</label><br>
			실내/실외
			<input type="radio" name="place" id="inside" value="I" <%= check6[0] %>/>
			<label for="inside">실내</label>
			<input type="radio" name="place" id="outside" value="O" <%= check6[1] %>/>
			<label for="outside">실외</label><br>
		</div>	
		
		<div class="form-group">
			<label for="notes">예약시 주의사항 <span id="count3">(0 / 최대 100자)</span></label>
			<input type="text" name="notes" id="notes" value="<%= branch.getNotes() %>"/>
		</div>
		<div class="form-group">
			<label for="sns">SNS</label>
			<input type="text" name="sns" id="sns" value="<%= branch.getBranch_website() %>"/>
		</div>
		<div class="form-group">
			<label for="phone">연락처</label>
			<input type="tel" name="phone" id="phone" value="<%= branch.getBranch_phone() %>"/>
		</div>
		<input type="hidden" name="email" id="email" value="<%= branch.getBranch_manager_email() %>"/>
		<input type="hidden" name="num" id="num" value="<%= branch.getBranch_num() %>"/>
		
		<div class="selectCover" style="padding-left: 0;" >
		
		<%--
		<img id="cover" src="resources/storage/<%= branch.getBranch_manager_email() %>/branch_img/<%= branch.getBranch_img() %>" width="282px" height="268px"><!-- 맥 전용 코드 -->
		 --%>
		
			<img id="cover" src="<%=request.getContextPath()%>/resources/storage/<%= branch.getBranch_manager_email() %>/branch_img/<%= branch.getBranch_img() %>"><!-- 윈도우 전용 코드 --> 
		
	      </div>
	      <div class="file_input" style="margin-bottom: 20px;">
	      <input id="fileName" name="fileName" class="upload-name" value="<%= branch.getBranch_img()%>" style="width: 200px; height:25px;" readonly>
	      <!-- <input type="file" id="" multiple="multiple"> -->
	      <label style="position: relative; top: 0; background-color: rgb(239, 239, 239); color: black; font-size: 18px;">
	      	파일선택
	      <input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg1">
	      </label>
	      </div> 
	
		<!-- 카카오 우편번호 서비스 -->
		<div class="kakao-group">
			<input type="button" onclick="sample4_execDaumPostcode()" name="address" class="addressBtn" value="우편번호 찾기"><br>
			<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호">
			<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
			<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
				<span id="guide" style="color: #999; display: none"></span>
			<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
			<input type="text" id="sample4_extraAddress" name="address5" placeholder="참고항목">
		</div>
		<br> <br> <br> <br><br> <br>
		<hr>
		
		<!-- 버튼 그룹 -->
		<div class="btn-groups">
			<button type="submit">지점 수정</button>
		</div>
		<!-- 버튼 그룹 끝  -->
	</form>
	<script>
		$('#placeInfo').keyup(function (e){
		    var content = $(this).val();
		    $('#count1').html("("+content.length+" / 최대 20자)");
	
		    if (content.length > 20){
		        $(this).val(content.substring(0, 20));
		        $('#count1').html("(20 / 최대 20자)");
		    }
		});
		
		$('#detailInfo').keyup(function (e){
		    var content = $(this).val();
		    $('#count2').html("("+content.length+" / 최대 1000자 (최소 30자))");
		    
		    if (content.length > 1000){
		        alert("최대 1000자까지 입력 가능합니다.");
		        $(this).val(content.substring(0, 1000));
		        $('#count2').html("(1000 / 최대 1000자 (최소 30자))");
		    }
		});
		
		$('#notes').keyup(function (e){
			 var content = $(this).val();
			    $('#count3').html("("+content.length+" / 최대 100자)");
			    
			    if (content.length > 100){
			        $(this).val(content.substring(0, 100));
			        $('#count3').html("(100 / 최대 100자)");
			    } 
		});
	
		function sample4_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							var roadAddr = data.roadAddress;
							var extraRoadAddr = '';
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraRoadAddr += data.bname;
							}
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraRoadAddr += (extraRoadAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							if (extraRoadAddr !== '') {
								extraRoadAddr = ' (' + extraRoadAddr + ')';
							}
							document.getElementById('sample4_postcode').value = data.zonecode;
							document.getElementById("sample4_roadAddress").value = roadAddr;
							document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
							if (roadAddr !== '') {
								document.getElementById("sample4_extraAddress").value = extraRoadAddr;
							} else {
								document.getElementById("sample4_extraAddress").value = '';
							}
							var guideTextBox = document.getElementById("guide");
							if (data.autoRoadAddress) {
								var expRoadAddr = data.autoRoadAddress
										+ extraRoadAddr;
								guideTextBox.innerHTML = '(예상 도로명 주소 : '
										+ expRoadAddr + ')';
								guideTextBox.style.display = 'block';
							} else if (data.autoJibunAddress) {
								var expJibunAddr = data.autoJibunAddress;
								guideTextBox.innerHTML = '(예상 지번 주소 : '
										+ expJibunAddr + ')';
								guideTextBox.style.display = 'block';
							} else {
								guideTextBox.innerHTML = '';
								guideTextBox.style.display = 'none';
							}
						}
					}).open();
		}
		
		 function readURL(input) {
	           if (input.files && input.files[0]) {
	           var reader = new FileReader();
	           reader.onload = function (e) {
	                   $('#cover').attr('src', e.target.result);
	                   $('#fileName').val(input.files[0].name);
	                   console.log($('#fileName').val());
	               }
	             reader.readAsDataURL(input.files[0]);
	           }
	       }
	      
	      $('#thumbnailImg1').change(function() {
	         readURL(this);
	      });
	      
	      
	      var num = 1;
	      $('#detailInfo').on('blur', function(){
	    	  var count = 30;
	    	  var length = $(this).val().length;
	    	  count = length;
	          
	    	  console.log(num);
	   			  if(num % 2 == 1){
	   				if(count < 30){
	   				  alert("최소 30자 입력 해주세요.");
	               	  num += 1;
	               	  $(this).focus();
	   			  	}
	           	  
	           	} else{num += 1;}
	    
	      });
	</script>
</body>
</html>