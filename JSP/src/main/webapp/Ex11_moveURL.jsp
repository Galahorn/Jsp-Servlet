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
	// 1.파라미터 수집
	String name = request.getParameter("page");
	// 2. 네이버 / 다음 / 구글 구분하기
	if (name.equals("naver")) {

		response.sendRedirect("https://www.naver.com");

	} else if (name.equals("google")) {

		response.sendRedirect("https://www.google.com");

	} else if (name.equals("daum")) {

		response.sendRedirect("https://www.daum.net");
	}
	%>


</body>
</html>