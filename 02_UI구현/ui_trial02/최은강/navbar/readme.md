> # navbar(최종) 삽입하기

- [navbar(최종) 코드](https://github.com/KHAcademyProject2020/Semi-Project/tree/master/02_UI%EA%B5%AC%ED%98%84/ui_trial02/%EC%B5%9C%EC%9D%80%EA%B0%95/navbar/navbar%EC%B5%9C%EC%A2%85)


- ## navbar.jsp코드를  `WEB-INF/views/common` 에 넣으세요.
  - 삽입위치: WEB-INF/views/common
  - [navbar.jsp 코드로 이동](https://github.com/KHAcademyProject2020/Semi-Project/blob/master/02_UI%EA%B5%AC%ED%98%84/ui_trial02/%EC%B5%9C%EC%9D%80%EA%B0%95/navbar/navbar%EC%B5%9C%EC%A2%85/navbar.jsp)

  
<hr>

- ## resources 삽입하기
  - ### 삽입위치: `WEB-INF/resources`

<hr>

> # navbar.jsp가 잘 불러왔는지 확인하는 방법

- ## index.jsp 에서 navbar.jsp 불러오기

- ### index.jsp 파일
```jsp
<%-- index.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Ball</title>
</head>
<body>
	<%@include file="WEB-INF/views/common/navbar.jsp" %>

</body>
</html>
```

## 정상적으로 확인이 됐다면, 현재 작업한 페이지(\*.jsp)에서 navbar.jsp을 불러오기

## 링크는 아직 안걸어놔서 본인이 걸어놔야됩니다.

<br>



<br><br>
<hr>

> ## 현재 작업중인 페이지(확장자) 에서 navbar 불러오기
```jsp

<body>
	<%@ include file="WEB-INF/views/common/navbar.jsp"%>
</body>
```
