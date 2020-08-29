<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.*" %>
	
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지(매니저)</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
body {
	text-align: center;
	background-image: radial-gradient(circle, #32aa87, #16392f);
}

h1 {
	font-size: 48px;
	color: #232c3d;
	margin-bottom: 10px;
}

.wrapper {
	width: 590px;
	margin: auto;
	background-color: white;
	border-radius: 10px;
	box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.1);
}

.tabWrapper {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
}

.insideWrapper1, .insideWrapper2 {
	display: grid;
	grid-template-columns: 1fr 1fr;
	visibility: hidden;
}

.insideWrapper2 {
	position: relative;
	top: -41px;
}

button {
	letter-spacing: 3px;
	border: none;
	padding: 10px;
	background-color: #bccbe9;
	color: #232c3d;
	font-size: 18px;
	cursor: pointer;
	transition: 0.5s;
}

button:hover {
	background-color: #d5e3ff;
}

button.active {
	background-color: white;
}

.active {
	background-color: white;
}

p {
	text-align: left;
	padding: 10px;
	height: 70vh;
}

.content {
	display: none;
	padding: 0;
}

.content.active {
	display: block;
	height: 700px;
}

.buttonWrapper {
	height: 90px;
}

object {
	width: 100%;
	height: 100%;
}
</style>
</head>


<body>
	<h1>MY PAGE</h1>
	<div class="wrapper">
		<div class="buttonWrapper">
			<div class="tabWrapper">
				<button class="tab-button manager active"
					style="border-top-left-radius: 10px;" id="managerBtn">개인
					정보</button>
				<button class="tab-button branch" id="branchBtn">내 지점 정보</button>
				<button class="tab-button reservation"
					style="border-top-right-radius: 10px;" id="reserveStatusBtn">예약
					현황</button>
			</div>
			<div class="insideWrapper1">
				<button class="inside-button active" id="modifyBtn">회원 정보
					수정</button>
				<button class="inside-button" id="withdrawBtn">회원 탈퇴</button>
			</div>
			<div class="insideWrapper2">
				<button class="inside-button active" id="branchListBtn">내
					지점</button>
				<button class="inside-button" id="registBtn">지점 등록</button>
			</div>
		</div>
		<div class="contentWrapper">
			<div class="content active"></div>
		</div>
	</div>
	<script>
   		$(function(){
   			setInsideVisible1();
   			select(modifyBtn);
   			setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/managerPage.mp"></object>');
   		});
   
      const managerBtn = document.querySelector('#managerBtn');
      const branchBtn = document.querySelector('#branchBtn');
      const reserveStatusBtn = document.querySelector('#reserveStatusBtn');
      const modifyBtn = document.querySelector('#modifyBtn');
      const withdrawBtn = document.querySelector('#withdrawBtn');
      const branchListBtn = document.querySelector("#branchListBtn");
      const registBtn = document.querySelector("#registBtn");

      const buttons = [
         managerBtn,
         branchBtn,
         reserveStatusBtn,
         modifyBtn,
         withdrawBtn,
         branchListBtn,
         registBtn
      ];

      const insideWrapper1 = document.querySelector('.insideWrapper1');
      const insideWrapper2 = document.querySelector('.insideWrapper2');
      const contentBox = document.querySelector('.content');

      const activate = (target) => {
         target.classList.add('active');
      };
      
      const deactivate = (target) => {
         target.classList.remove('active');
      };
      
      const select = (target) => {
         buttons.forEach(btn => {
            if (btn === target) {
               activate(btn);
            } else {
               deactivate(btn);
            }
         });
      };
      
      const setInsideVisible1 = () => {
         insideWrapper1.style.visibility = 'visible';
      };
      
      const setInsideHidden1 = () => {
         insideWrapper1.style.visibility = 'hidden';
      };
      
      const setInsideVisible2 = () => {
          insideWrapper2.style.visibility = 'visible';
       };
       
       const setInsideHidden2 = () => {
          insideWrapper2.style.visibility = 'hidden';
       };
      
      const setContent = (content) => {
         contentBox.innerHTML = content;
      };
      
      managerBtn.onclick = e => {
         setInsideVisible1();
         setInsideHidden2();
         select(managerBtn);
      };
      branchBtn.onclick = e => {
    	 setInsideVisible2();
         setInsideHidden1();
         select(branchBtn);
      };
      
      reserveStatusBtn.onclick = e => {
         setInsideHidden1();
         setInsideHidden2();
         select(reserveStatusBtn);
         setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/managerReserve.mp"></object>');
         
      };
      
      modifyBtn.onclick = e => {
    	 select(modifyBtn);
         setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/managerPage.mp"></object>');
      };
      
      withdrawBtn.onclick = e => {
         select(withdrawBtn);
         setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/managerPwd.mp"></object>');
      };
      
      branchListBtn.onclick = e => {
          select(branchListBtn);
          setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/managerConPage.mp"></object>');
       };
      
      registBtn.onclick = e => {
          select(registBtn);
          setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/managerRegPage.mp"></object>');
       };
   </script>
</body>
</html>