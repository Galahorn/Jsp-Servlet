<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>세션 생성.</h1>
<%
// 1. 객체생성 x
// jsp파일 세션객체 생성안함 -> 내장객체
// jsp파일 servlet파일로 변환될때 자동으로 선언

// 2. 세션에 정보를 저장합시다.
// setAttribute("세션 이름", (object)저장할 객체 or 데이터);
session.setAttribute("first", "String");
session.setAttribute("second", 100);



%>

<a href = "Ex03_DeleteSession">세션 1개 삭제</a><br>
<a href = "Ex03_DeleteAllSession">세션 전부삭제</a><br>


<a href = "Ex03_SelectSession.jsp">세션 확인</a><br>
</body>
</html>