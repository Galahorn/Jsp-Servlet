<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>세션 확인</h1>
<%
// 쿠키 : 한번에 모든 쿠키를 가져옴
// 세션 : 하나씩

// getAttribute("저장해둔 이름")
// 만약 이름에 해당하는 세션이 없으면 null값으로 리턴해줌
// 불러올때ㅐ object타입으로 가져와진다
// 원하는 변수에 담아서 사용하려면 다운캐스팅 필요
String first = (String)session.getAttribute("first");

//int, char 같은 기본 자료형은 null값이 들어갈 수가 없음.
//int가 아니라, Integer -> int자료형의 참조형(레퍼런스)
Integer second = (Integer)session.getAttribute("second");

out.print(first);
out.print("<br>");
out.print(second);
%>
</body>
</html>