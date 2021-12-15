<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% String nickname = request.getParameter("nickname"); %>
<h1>회원가입에 성공했습니다.</h1>
<p><%=nickname%>님 환영합니다.</p>
<p>가입된 아이디로 로그인 해주세요<p>
<a href = "Ex12_Login.html">로그인 페이지로 가기</a>
</body>
</html>