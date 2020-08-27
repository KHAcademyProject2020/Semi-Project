> # navbar(최종) 삽입하기

- [navbar(최종) 코드](https://github.com/KHAcademyProject2020/Semi-Project/tree/master/02_UI%EA%B5%AC%ED%98%84/ui_trial02/%EC%B5%9C%EC%9D%80%EA%B0%95/navbar/navbar%EC%B5%9C%EC%A2%85)


- ## navbar.jsp코드를  `WEB-INF/views/common` 에 넣으세요.
  - 삽입위치: WEB-INF/views/common
  - [navbar.jsp 코드로 이동](https://github.com/KHAcademyProject2020/Semi-Project/blob/master/02_UI%EA%B5%AC%ED%98%84/ui_trial02/%EC%B5%9C%EC%9D%80%EA%B0%95/navbar/navbar%EC%B5%9C%EC%A2%85/navbar.jsp)

  
<hr>

- ## resources 삽입하기
  - ### 삽입위치: `WEB-INF/resources`

<hr>

- ## index.jsp 에서 navbar.jsp 불러오기

- ### index.jsp 파일
```html
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
