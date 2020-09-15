<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue();">
   <b>지점 중복 검사</b>
   <br>
   <form action="<%= request.getContextPath() %>/checkBranch.br" id="checkBranchForm">
      <input type="text" id="inputBranch" name="inputBranch">
      <input type="submit" value="중복확인"/>
   </form>
   
   <br>
   <%
      if(request.getAttribute("result") != null){
         int result = (int)request.getAttribute("result");
         
         if(result > 0){   %>
            이미 사용 중인 지점명 입니다.
         <%} else {%>
            사용 가능한  지점명 입니다.
         <%}
         }%>
   
   <br>
   <br>
   
   <input type="button" id="managerBranch" value="확인" onclick="managerBranch();">
   <input type="button" id="cancel" value="취소" onclick="window.close();">
   
   <script>
      function inputValue(){

         if('<%= request.getAttribute("checkedBranch") %>'=='null'){
            document.getElementById('inputBranch').value = opener.document.registForm.branchName.value;            
         } else {
            document.getElementById('inputBranch').value = '<%= request.getAttribute("checkedBranch") %>';
         }
      }
      
      function managerBranch(){
         opener.document.registForm.branchName.value = document.getElementById('inputBranch').value;
         self.close();
      }
   </script>

</body>
</html>