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
Cookie cookie = new Cookie("Phone_item", "�ڵ���");

cookie.setMaxAge(60*60);

response.addCookie(cookie);

%>

<p>�ڵ����� ���� ���� ������ �Դϴ�.</p>
<p>�� : ����Ʈ��</p>
<p>��ǰ���� : 1,397,000��</p>
<a href = "Ex02_List.jsp">��ǰ ��� ������</a>
</body>
</html>