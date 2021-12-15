<%@page import="java.net.URLEncoder"%>
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
	// 1. Cookie 캑체 생성
	// 매개변수 2개 들어감 ("(String)쿠키 이름", "(String)값")
	Cookie cookie = new Cookie("first_cookie", "firstcookie");

	// 쿠키는 순수 텍스트만 저장
	// 공백, ",", :, ; 같은 특수기호중 알부가 저장 불가.
	// URL형식으로 인코딩
	// URLEncoder 객체를 사용해서 인코딩을 진행해야 함.
	// URLEncoder.encode("인코딩할 문자열", "인코딩 방식")
	
	Cookie cookie2 = new Cookie("second_cookie", URLEncoder.encode("second cookie", "euc-kr"));

	// 2.응답에 쿠키를 추가
	//addCookie(cookie);
	response.addCookie(cookie);
	response.addCookie(cookie2);
	
%>
	<a href="Ex01_SelectCookie.jsp">쿠키 확인</a>
</body>
</html>