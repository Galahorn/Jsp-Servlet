<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% String nickname = request.getParameter("nickname"); %>
<h1>ȸ�����Կ� �����߽��ϴ�.</h1>
<p><%=nickname%>�� ȯ���մϴ�.</p>
<p>���Ե� ���̵�� �α��� ���ּ���<p>
<a href = "Ex12_Login.html">�α��� �������� ����</a>
</body>
</html>