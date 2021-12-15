<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 월요병 장난 아님 </h1>
	
	<%// 자바코드 작성하는 부분 = 스크립트릿 
	int a = 1;
	int b = 2;
	System.out.println("a와 b의 합은 : " + (a+b));
	
	%>
	
	<!-- 웹에 출력하기 = 표현식 -->
	<%= a+b %>
	<br><br>
	<%= a %> + <%= b %> = <%= a+b %>
</body>
</html>