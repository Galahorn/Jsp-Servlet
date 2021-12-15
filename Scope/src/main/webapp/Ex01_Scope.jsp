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
	// Scope : ��ü�� ����� �� �ִ� ����
	// setAttribute0("�̸�", (object)������)
	
	// 1. page scope
	pageContext.setAttribute("page", "pageScope");

	// 2.request scope
	request.setAttribute("request", "requestScope");
	
	// 3. session Scope
	session.setAttribute("session", "sessionScope");

	// 4. application scope
	application.setAttribute("application", "applicationScope");


%>

<p><%= pageContext.getAttribute("page") %></p>
<p><%= request.getAttribute("request") %></p>
<p><%= session.getAttribute("session") %></p>
<p><%= application.getAttribute("application") %></p>


<%-- JSTL ������ --%>
<%-- jsp�� �⺻ jstl ȸ �ٸ� jstl ���̺귯���� ����Ϸ���
jar���� �����;��� taglib �����ڷ� ����  --%>
<jsp:forward page="Ex01_Request.jsp"></jsp:forward>

<%--
<%
	// forward������� ������ �̵�
	RequestDispatcher rd = request.getRequestDispatcher("Ex01_Request.jsp");
	rd.forward(request, response);
%>
 --%>


</body>
</html>