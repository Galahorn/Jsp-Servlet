<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	int result = 0;
	for(int i = 1; i < 101; i++) {
		result += i;
	}
	%>
	
	<%= result %>
</body>
</html>