<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Ball 회원가입</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
   src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
body {
   text-align: center;
   height: 700px;
}

.form-horizontal {
   width: 650px;
   margin: 0 auto;
   position: relative;
   top: 50%;
   transform: translateY(-50%);
}

.form-group {
   width: 650px;
   height: 35px;
   margin: 10px 0 30px 0;
   position: relative;
}

.form-group>input {
   width: 100%;
   height: 100%;
   border: none;
   border: 2px solid #03D392;
   font-size: 18px;
}

.form-group>input[type="date"] {
   font-size: 12px;
}

.form-group>label {
   position: absolute;
   top: 2px;
   left: 15px;
   transform: translateY(-50%);
   font-size: 15px;
   color: #03D392;
   padding: 0px;
   background:#fff;
}

/* 체크박스 */
.check-group {
   width: 650px;
   margin-bottom: 20px;
   color: #03D392;
}

input[type=checkbox]+label {
   margin: 0.2em;
   cursor: pointer;
   padding: 0.2em;
}

input[type=checkbox] {
   display: none;
}

input[type=checkbox]+label:before {
   content: "\2714";
   border: 0.1em solid #03D392;
   border-radius: 0.2em;
   display: inline-block;
   width: 1em;
   height: 1em;
   padding-left: 0.2em;
   padding-bottom: 0.3em;
   margin-right: 0.2em;
   vertical-align: bottom;
   color: transparent;
   transition: .2s;
}

input[type=checkbox]+label:active:before {
   transform: scale(0);
}

input[type=checkbox]:checked+label:before {
   background-color: MediumSeaGreen;
   border-color: MediumSeaGreen;
   color: #fff;
}

.select-group>option {
   background-color: #03D392;
}

/* hr */
hr {
   border: 0;
   height: 3px;
   background: #ccc;
}

/* 버튼 */


/* 카카오 */
.kakao-group {
   width: 650px;
   height: 25px;
   display: flex;
   flex-wrap: wrap;
   justify-content: space-between;
}

.kakao-group>input:not(.addressBtn) {
   width: 45%;
   height: 100%;
   border: none;
   border: 2px solid #03D392;
   font-size: 18px;
   margin-bottom: 5px;
}

.kakao-group>.addressBtn {
   width: 45%;
   height: 100%;
   border: none;
   font-size: 18px;
   margin-right: -10px;
}
#joinForm{
   text-align: center;
}
#nav123{
   height: 200px;
}
.hr_group{
width: 650px;
}
#emailCheck{
width: 250px;
height: 30px;
background-color: #fff;

}


#danger{
color:red;
}
#success{
color:blue;
}
.phone_1{
display: inline;
}
.menu{
text-align: left;
border: 2px solid #03D392;
color:#03D392;
}
.phone{
border: 0px solid ;
width: 180px;
text-align: center;

}
.phone_1{

color:black;

}
#signUpBtn{
   border: 2px solid #fff;
   color: black;
   line-height: 30px;
   border-radius: 12px;
   width: 180px;
   margin: 8px;
   background: #fff;
}

#goMain{
   border: 2px solid #fff;
   color: black;
   line-height: 30px;
   border-radius: 12px;
   width: 180px;
   margin: 8px;
   background: #fff;

}

#emailCheck{
   border: 2px solid #fff;
   color: black;
   line-height: 30px;
   border-radius: 12px;
   width: 180px;
   margin: 8px;
   background: #fff;
}


.member-form-container{
   justify-content: space-between;
   width: 100%;
   height: 100vh;
   
}

.menu{
   display: flex;
   flex-direction: column;
   justify-content: space-around;
}

.tel-gender-address-role-con{
   display: flex;
   flex-direction:column;
   align-items: space-around;
}

.tel-form{
   display: flex;
   flex-direction: row;
   justify-content: center;
    padding: 5px;
}

.tel-fieldset{
   
}
#phone_12{
width: 75px;
}


</style>
<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/common/favicon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/boardDetail.css">

</head>
<body>

   <%@include file="/WEB-INF/views/common/navbar.jsp" %>
   
   
   <div id="main-container" class="main-content-container">
      <div class="member-form-container">
         <form action="<%=request.getContextPath()%>/insert"
            class="form-horizontal" method="post" id="joinForm" name="joinForm"
            onsubmit="return validate();">
            <div class="form-group" id="emailG">
               <label for="name">EMAIL</label> 
               <input type="email" name="email"id="email" placeholder="email 입력해주세요!">
            </div>
            <div class="checkE">
               <input type="button" id="emailCheck" value="중복확인" onclick="checkEmail();">
            </div>
            <br>
            
            <div class="form-group">
               <label for="password">비밀번호</label> 
               <input type="password"name="password" id="password" >
            </div>
            <div> 
               <label for="name">10~12자리의영문(대소문자)+숫자+특수문자 중 2종류 이상을 조합하여 사용할 수 있습니다.</label> 
            </div>
            <div class="form-group">
               <label for="password2">비밀번호 확인</label> 
               <input type="password" name="password2" id="password2" >
            </div>
            
            <div class="success1" id="success">비밀번호 일치하잖아 잘했잖아 .</div>
            <div class="danger1" id="danger">비밀번호 틀렸잖아! 미쳤잖아! 다시해!.</div>
      
            <div class="form-group">
               <label for="name">이름</label> 
               <input type="text" name="name" id="name">
            </div>
            <div class="form-group">
               <label for="birthday">생년월일</label> 
               <input type="date" name="birthday"id="birthday">
            </div>
            
            
            <!--연락처 / 성별 / 주소 / 역할 컨테이너 -->
            <div class="tel-gender-address-role-con">
            
               <!-- 연락처  -->
               <<div class="form-group">
			<label for="phone">연락처</label>
			<input type="tel" name="phone1" id="phone1" />
				</div>
 
               
               <!--  성별 -->
               <div class="check-group">
                	  성별 
                  <input type="checkbox" name="gender" id="gender1" value="남" onclick="genderClick(this)"> 
                  <label for="gender1">남자</label>
                  <input type="checkbox" name="gender" id="gender2" value="여" onclick="genderClick(this)"> 
                  <label for="gender2">여자</label>
               </div>
               
               <!-- 카카오 우편번호 서비스 -->
               <div class="ka">
               <div class="kakao-group" id="address">
               
                  <input type="button" onclick="sample4_execDaumPostcode()"name="address" class="addressBtn" value="우편번호 찾기"><br>
                  <input type="text" id="sample4_postcode" name="address1"placeholder="우편번호"> 
                  <input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
                  <input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소"> 
                  <span id="guide"style="color: #999; display: none"></span> 
                  <input type="text"id="sample4_detailAddress" name="address4" placeholder="상세주소">
                  <input type="text" id="sample4_extraAddress" name="address5" placeholder="참고항목">
               </div>
               </div>
               <br>
               <br>
               <br>
               <!-- 회원등급 -->
               <div class="check-group1">
               <hr class="hr_group">
                 	 회원 등급 
                  <input type="checkbox" name="member_type" id="member_type"value="G"onclick="memberClick(this)"> 
                  <label for="member_type">일반회원</label> 
                  <input type="checkbox" name="member_type" id="member_type2" value="M"onclick="memberClick(this)">
                  <label for="member_type2">매니저 회원</label>
               </div>
               <hr class="hr_group">
               
               
            </div>
      
            <!-- 버튼 그룹 -->
            <div class="btns" id="signUpBtns">
               <input id="signUpBtn" type="submit" value="가입하기" onclick="return chekPassword();"> 
               <input type="button" id="goMain"  value="메인으로" onclick="return goHome();">
            </div>
            <!-- 버튼 그룹 끝  -->
         </form>
      </div>
   </div>
   
   
   <script>

   		
  		// 이메일 중복확인
      function checkEmail() {
         window.open("checkEmailForm.me", "checkEmailForm",
               "width=300, height=200");
      }
      
      // 비밀번호 일치여부 확인
      $(function() {
         $("#success").css("display", "none");
         $("#danger").css("display", "none");
         $("input").keyup(function() {
            var password = $("#password").val();
            var password2 = $("#password2").val();
            if (password != "" || password2 != "") {
               if (password == password2) {
                  $("#success").css("display", "block");
                  $("#danger").css("display", "none");
               } else {
                  $("#success").css("display", "none");
                  $("#danger").css("display", "block");
               }
            }
         });
      });
      
      //카카오 주소 값 받아와서 입력
      $(function(){

		    $("#phone1").on('keydown', function(e){
		       // 숫자만 입력받기
		        var trans_num = $(this).val().replace(/-/gi,'');
			var k = e.keyCode;
						
			if(trans_num.length >= 11 && ((k >= 48 && k <=126) || (k >= 12592 && k <= 12687 || k==32 || k==229 || (k>=45032 && k<=55203)) ))
			{
		  	    e.preventDefault();
			}
		    }).on('blur', function(){ // 포커스를 잃었을때 실행합니다.
		        if($(this).val() == '') return;

		        // 기존 번호에서 - 를 삭제합니다.
		        var trans_num = $(this).val().replace(/-/gi,'');
		      
		        // 입력값이 있을때만 실행합니다.
		        if(trans_num != null && trans_num != '')
		        {
		            // 총 핸드폰 자리수는 11글자이거나, 10자여야 합니다.
		            if(trans_num.length==11 || trans_num.length==10) 
		            {   
		                // 유효성 체크
		                var regExp_ctn = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/;
		                if(regExp_ctn.test(trans_num))
		                {
		                    // 유효성 체크에 성공하면 하이픈을 넣고 값을 바꿔줍니다.
		                    trans_num = trans_num.replace(/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?([0-9]{3,4})-?([0-9]{4})$/, "$1-$2-$3");                  
		                    $(this).val(trans_num);
		                }
		                else
		                {
		                alert("유효하지 않은 전화번호 입니다.");
		                    $(this).val("");
		                    $(this).focus();
		                }
		            }
		            else 
		            {
		                alert("유효하지 않은 전화번호 입니다.");
		                $(this).val("");
		                $(this).focus();
		            }
		      }
		  });  
		});
      
			// 카카오 주소
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

      
      //gender 중복 체크 방지  
      function genderClick(chk) {
         var obj = document.getElementsByName("gender");
         for (var i = 0; i < obj.length; i++) {
            if (obj[i] != chk) {
               obj[i].checked = false;
            }
         }
      }
      //member_type 중복 체크 방지
      function memberClick(chk) {
         var obj = document.getElementsByName("member_type");
         for (var i = 0; i < obj.length; i++) {
            if (obj[i] != chk) {
               obj[i].checked = false;
            }
         }
   
      }
   
      	// 비밀번호 정규식 표현
    function chekPassword(){
      // 10자~12자리의 영문(대소문자)+숫자+특수문자 중 2종류 이상을 조합하여 사용할 수 있습니다.

         var mbrPwd = $("#password").val();  // pw 입력

         var check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(mbrPwd);   //영문,숫자

         var check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(mbrPwd);  //영문,특수문자

         var check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(mbrPwd);  //특수문자, 숫자

         if(!(check1||check2||check3)){

            alert("사용할 수 없은 조합입니다.\n패스워드 설정안내를 확인해 주세요.");

            return false;

         }

         if(/(\w)\1\1/.test(mbrPwd)){

            alert('같은 문자를 3번 이상 사용하실 수 없습니다.\n패스워드 설정안내를 확인해 주세요.');

            return false;

         }

         return true; 

      } 
      

   </script>
</body>
</html>