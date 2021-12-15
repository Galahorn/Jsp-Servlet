<%@page import="Model.MemberVO"%>
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
	//1.파라미터 수집
	// Attribute값을 가져오기
	//setAttribute로 저장할때 Object 타입으로 저장한다
	//setAttribute로 꺼낼때때 Object 타입으로 리턴한다
	// 고로 명시적 형변환 (다운 캐스팅이 필요하다)
	MemberVO vo = (MemberVO)request.getAttribute("vo");

%>
	<fieldset>

		<h1><%= vo.getNickname() %>님 환영합니다.</h1>

	</fieldset>

</body>
</html>