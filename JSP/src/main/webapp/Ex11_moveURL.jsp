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
	// 1.�Ķ���� ����
	String name = request.getParameter("page");
	// 2. ���̹� / ���� / ���� �����ϱ�
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