<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>���� ����.</h1>
<%
// 1. ��ü���� x
// jsp���� ���ǰ�ü �������� -> ���尴ü
// jsp���� servlet���Ϸ� ��ȯ�ɶ� �ڵ����� ����

// 2. ���ǿ� ������ �����սô�.
// setAttribute("���� �̸�", (object)������ ��ü or ������);
session.setAttribute("first", "String");
session.setAttribute("second", 100);



%>

<a href = "Ex03_DeleteSession">���� 1�� ����</a><br>
<a href = "Ex03_DeleteAllSession">���� ���λ���</a><br>


<a href = "Ex03_SelectSession.jsp">���� Ȯ��</a><br>
</body>
</html>