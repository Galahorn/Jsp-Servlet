<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<p><%= pageContext.getAttribute("page") %></p>
<p><%= request.getAttribute("request") %></p>
<p><%= session.getAttribute("session") %></p>
<p><%= application.getAttribute("application") %></p>

</body>
</html>