<%@page import="java.net.URLDecoder"%>
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
	//쿠키값 받아오기
	//request.getCookies();를 이용해서 쿠키를 받아옴
	//해당하는 도메인에서 사용 가능한 모든 쿠키를 리턴
	Cookie[] cookies = request.getCookies();

	// for i in list : (파이썬의 for문)
	// for each문
	// for(꺼내올 데이터의 타입, 이름 : 배열)
	
	for(Cookie c : cookies) {
		// 쿠키 이름
		String cookieName = c.getName();
				
		// 쿠키 값
		String cookieValue = c.getValue();
		//디코딩 : 인코딩했던 문자열을 다시 원래 상태로 되돌리는 것
		//URLDecoder 객체의 decode 메서드 사용.
		cookieValue = URLDecoder.decode(cookieValue, "euc-kr");
				
		//String의 contains 메서드
		//contains 메서드 : 매개변수로 받은 문자열이 안에 있는지 없는지 알려줌
		// boolean타입으로 리턴
		//contains("문자열")
				
	if(cookieName.contains("cookie") == true) {
		out.print(cookieName + " : " + cookieValue + "<br>");
		}
	}
%>

<a href="Ex01_DeleteCookie">쿠키 삭제</a>


</body>
</html>