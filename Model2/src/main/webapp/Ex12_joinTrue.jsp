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
MemberVO vo = (MemberVO)request.getAttribute("vo");
%>
<h1>ȸ�����Կ� �����߽��ϴ�.</h1>
<p><%= vo.getNickname() %>�� ȯ���մϴ�.</p>
<p>���Ե� ���̵�� �α��� ���ּ���<p>
<a href = "Ex12_Login.html">�α��� �������� ����</a>
</body>
</html>