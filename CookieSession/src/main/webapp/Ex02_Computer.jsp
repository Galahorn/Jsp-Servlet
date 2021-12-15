<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% Cookie cookie  = new Cookie("Computer_item", "컴퓨터");

	cookie.setMaxAge(60*60);
	
	response.addCookie(cookie);
%>

<p>컴퓨터에 관한 상세한 페이지 입니다.</p>
<p>모델 : 사무용 노트북</p>
<p>제품가격 : 1,590,000원</p>

<a href = "Ex02_List.jsp">제품 목록 페이지</a>
</body>
</html>