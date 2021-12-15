<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>이동할 페이지</h1>
	<h1>네이버</h1>

	<%
	//response 역시 내장객체 > 객체 생성할 필요없이 바로 사용
	//sendRedirect("이동하고자하는 페이지의 URL");
	response.sendRedirect("https://www.naver.com");
	%>

</body>
</html>