<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>마이 페이지</title>
   <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
   <style>
      body {
         text-align: center;
         background-image:radial-gradient(circle, #32aa87, #16392f);
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

      .insideWrapper {
         display: grid;
         grid-template-columns: 1fr 1fr;
         visibility: hidden;
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
         height:700px;
      }
      
      .buttonWrapper{
      	height:90px;
      }
      
      object{
      	width:100%;
      	height:100%;
      }
   </style>
</head>

<body>
   <%@include file="/WEB-INF/views/common/navbar.jsp" %>
   
   <div class="wrapper">
      <div class="buttonWrapper">
         <div class="tabWrapper">
            <button class="tab-button personal active" style="border-top-left-radius: 10px;" id="personalBtn">개인
               정보</button>
            <button class="tab-button team" id="teamBtn">팀 정보</button>
            <button class="tab-button reservation" style="border-top-right-radius: 10px;" id="reserveStatusBtn">예약
               현황</button>
         </div>
         <div class="insideWrapper">
            <button class="inside-button active" id="modifyBtn">회원 정보 수정</button>
            <button class="inside-button" id="withdrawBtn">회원 탈퇴</button>
         </div>
      </div>
      <div class="contentWrapper">
         <div class="content active"></div>
      </div>
   </div>
   <script>
      const personalBtn = document.querySelector('#personalBtn');
      const teamBtn = document.querySelector('#teamBtn');
      const reserveStatusBtn = document.querySelector('#reserveStatusBtn');
      const modifyBtn = document.querySelector('#modifyBtn');
      const withdrawBtn = document.querySelector('#withdrawBtn');
      
      const buttons = [
         personalBtn,
         teamBtn,
         reserveStatusBtn,
         modifyBtn,
         withdrawBtn,
      ];

      const insideWrapper = document.querySelector('.insideWrapper');
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
      const setInsideVisible = () => {
         insideWrapper.style.visibility = 'visible';
      };
      const setInsideHidden = () => {
         insideWrapper.style.visibility = 'hidden';
      };
      const setContent = (content) => {
         contentBox.innerHTML = content;
      }
      personalBtn.onclick = e => {
         setInsideVisible();
         select(personalBtn);
      };
      teamBtn.onclick = e => {
         setInsideHidden();
         select(teamBtn);
         setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/generalTeam.mp"></object>');
      };
      reserveStatusBtn.onclick = e => {
         setInsideHidden();
         select(reserveStatusBtn);
         setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/managerReserve.mp"></object>');
      };
      modifyBtn.onclick = e => {
    	 select(modifyBtn);
    	 setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/generalPage.mp"></object>');
      };
      withdrawBtn.onclick = e => {
         select(withdrawBtn);
         setContent('<object type="text/jsp" data="<%=request.getContextPath()%>/managerPwd.mp"></object>');
      }
   </script>
</body>
</html>