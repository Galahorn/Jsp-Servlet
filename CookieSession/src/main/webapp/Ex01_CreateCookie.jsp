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
	// 1. Cookie Ĵü ����
	// �Ű����� 2�� �� ("(String)��Ű �̸�", "(String)��")
	Cookie cookie = new Cookie("first_cookie", "firstcookie");

	// ��Ű�� ���� �ؽ�Ʈ�� ����
	// ����, ",", :, ; ���� Ư����ȣ�� �˺ΰ� ���� �Ұ�.
	// URL�������� ���ڵ�
	// URLEncoder ��ü�� ����ؼ� ���ڵ��� �����ؾ� ��.
	// URLEncoder.encode("���ڵ��� ���ڿ�", "���ڵ� ���")
	
	Cookie cookie2 = new Cookie("second_cookie", URLEncoder.encode("second cookie", "euc-kr"));

	// 2.���信 ��Ű�� �߰�
	//addCookie(cookie);
	response.addCookie(cookie);
	response.addCookie(cookie2);
	
%>
	<a href="Ex01_SelectCookie.jsp">��Ű Ȯ��</a>
</body>
</html>