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
	//1.�Ķ���� ����
	// Attribute���� ��������
	//setAttribute�� �����Ҷ� Object Ÿ������ �����Ѵ�
	//setAttribute�� �������� Object Ÿ������ �����Ѵ�
	// ��� ����� ����ȯ (�ٿ� ĳ������ �ʿ��ϴ�)
	MemberVO vo = (MemberVO)request.getAttribute("vo");

%>
	<fieldset>

		<h1><%= vo.getNickname() %>�� ȯ���մϴ�.</h1>

	</fieldset>

</body>
</html>