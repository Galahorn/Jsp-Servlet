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
//�Ķ���� ���� 
MemberVO vo = (MemberVO)session.getAttribute("vo");

//if(rs.next() == true) {
	//session.setAttribute();
	//}
// �α��� ���� -> vo == null
// vo�� null���� �ƴ��� : �α��� ���¸� �����Ҽ��ִ�.

%>
	<fieldset>

		<%if(vo != null) { 	%>

		<h1><%= vo.getId() %>�� ȯ���մϴ�.
		</h1>

		<%} else {%>
		<h1>�α��� ����</h1>
		<a href="Ex04_Login.html">��������</a>
		<%} %>
	</fieldset>

</body>
</html>