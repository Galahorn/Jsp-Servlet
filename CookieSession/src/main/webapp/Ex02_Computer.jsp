<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% Cookie cookie  = new Cookie("Computer_item", "��ǻ��");

	cookie.setMaxAge(60*60);
	
	response.addCookie(cookie);
%>

<p>��ǻ�Ϳ� ���� ���� ������ �Դϴ�.</p>
<p>�� : �繫�� ��Ʈ��</p>
<p>��ǰ���� : 1,590,000��</p>

<a href = "Ex02_List.jsp">��ǰ ��� ������</a>
</body>
</html>