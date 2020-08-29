<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_page</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
	.form-horizontal{
		width:500px;
		margin:0 auto;
		padding:0 100px;
		box-sizing:border-box;
	}

	.form-group{
		width:300px;
		height:35px;
		margin: 10px 0 30px 0;
		position:relative;
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
		padding:0 0 10px 10px;
		margin-bottom:25px;
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
		display:flex;
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
		width:100%;
		height:40px;
	}
	
	.btn-groups > button:first-of-type {
		margin-right:10px;
	}
</style>
</head>
<body>
	<form class="form-horizontal" method="post" action="#">
		<div class="form-group">
			<label for="placeName">지점명</label>
			<input type="text" name="placeName" id="placeName"/>
		</div>
		<div class="form-group">
			<label for="placeInfo">지점 한줄 소개 <span id="count1">(0 / 최대 20자)</span></label>
			<input type="text" name="placeInfo" id="placeInfo" maxlength="20"
				placeholder="사용 가능한 특수문자 : ( , ) , [ , ] , - , .(마침표), ,(쉼표)" style="font-size:12px;"/>
		</div>
		<div class="form-group form-detail">
			<label for="detailInfo">공간 소개 <span id="count2">(0 / 최대 1000자 (최소 30자))</span></label>
			<textarea rows="10" cols="36" name="detailInfo" id="detailInfo" maxlength="1000" placeholder="사용 가능한 특수문자 : ( , ) , [ , ] , - , .(마침표), ,(쉼표)"></textarea>
		</div>
		<br><br><br><br><br><br>
		<div class="form-group">
			<label for="placeTag">공간 태그(추가보류)</label>
			<input type="text" name="placeTag" id="placeTag"/>
		</div>
		<div class="radio-group">
			<label for="facility">이용가능</label><br>
			샤워실 이용
			<input type="radio" name="shower" id="shower"/>
			<label for="showerok">가능</label>
			<input type="radio" name="shower" id="gender2"/>
			<label for="showernop">불가능</label><br>
			주차 이용
			<input type="radio" name="parking" id="parking"/>
			<label for="parkingok">가능</label>
			<input type="radio" name="parking" id="parking"/>
			<label for="parkingnop">불가능</label><br>
			유니폼 대여
			<input type="radio" name="uniform" id="uniform"/>
			<label for="uniformok">가능</label>
			<input type="radio" name="uniform" id="uniform"/>
			<label for="uniformnop">불가능</label><br>
			풋살화 대여
			<input type="radio" name="shoes" id="shoes"/>
			<label for="shoesok">가능</label>
			<input type="radio" name="shoes" id="shoes"/>
			<label for="shoesnop">불가능</label><br>
			볼 대여
			<input type="radio" name="ball" id="ball"/>
			<label for="ballok">가능</label>
			<input type="radio" name="ball" id="ball"/>
			<label for="ballnop">불가능</label><br>
			실내/실외
			<input type="radio" name="place" id="inside"/>
			<label for="inside">실내</label>
			<input type="radio" name="place" id="outside"/>
			<label for="outside">실외</label><br>
		</div>	
		
		<div class="form-group">
			<label for="notes">예약시 주의사항 0자/100자</label>
			<input type="text" name="notes" id="notes"/>
		</div>
		<div class="form-group">
			<label for="sns">SNS</label>
			<input type="text" name="sns" id="sns"/>
		</div>
		<div class="form-group">
			<label for="phone">연락처</label>
			<input type="tel" name="phone" id="phone"/>
		</div>
		<div class="form-group">
			<label for="birth">생년월일</label>
			<input type="date" name="birth" id="birth"/>
		</div>
	
	<!-- 이미지 파일 -->
	<label for="confirm" class="">대표이미지 2048 *1158 권장, 최대 3MB</label>
	<div id="image_container">
		<img src="#"/>	
	</div>

	<!--파일 유형 제한하기 -->
	
	<div class="file_input">
	    <label>
	        File Attach
	     <input type="file" id="image_btn" accept=".jpg, .jpeg, .png, .gif" onchange="javascript:document.getElementById('file_route').value=this.value, upload(event)">
	    </label>
	    <input type="text" readonly="readonly" title="File Route" id="file_route" class="form-control" width=200px;>
	</div><br>
	
		<!-- 카카오 우편번호 서비스 -->
		<div class="kakao-group">
		<input type="text" id="sample4_postcode" placeholder="우편번호">
		<input type="button" onclick="sample4_execDaumPostcode()" class="addressBtn" value="우편번호 찾기"><br>
		<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
		<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" placeholder="상세주소">
		<input type="text" id="sample4_extraAddress" placeholder="참고항목">
		</div>
		<br><br><br><br>
		<hr>
		
		<!-- 버튼 그룹 -->
		<div class="btn-groups">
			<button type="button" class=""
				onclick="location.href = '#'">지점 등록</button>
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
		
		function upload(event){
			var reader = new FileReader();
			var main_img_url= document.getElementById('main-img-url');
			// main_img_url.value='가나다라';
			
			reader.onload = function(event){
				var main_img_files = document.getElementById('image_btn');
				var main_img_name= main_img_files.files[0].name;
				
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				document.querySelector("div#image_container").appendChild(img);
			
				main_img_url.value=main_img_name;
				
			};
			
			reader.readAsDataURL(event.target.files[0]);
		};
	
		function sample4_execDaumPostcode() {
    		new daum.Postcode({
        			oncomplete: function(data) {
           
            var roadAddr = data.roadAddress;
            var extraRoadAddr = '';

            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");

            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            			}
       			 	}
    			}).open();
			}
	</script>
</body>
</html>