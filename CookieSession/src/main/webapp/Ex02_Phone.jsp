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
Cookie cookie = new Cookie("Phone_item", "핸드폰");

cookie.setMaxAge(60*60);

response.addCookie(cookie);

%>

<p>핸드폰에 대한 상세한 페이지 입니다.</p>
<p>모델 : 스마트폰</p>
<p>제품가격 : 1,397,000원</p>
<a href = "Ex02_List.jsp">제품 목록 페이지</a>
</body>
</html>