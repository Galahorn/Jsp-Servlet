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
	// Scope : 객체를 사용할 수 있는 범위
	// setAttribute0("이름", (object)데이터)
	
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


<%-- JSTL 맛보기 --%>
<%-- jsp의 기본 jstl 회 다른 jstl 라이브러리를 사용하려면
jar파일 가져와야함 taglib 지시자로 선언  --%>
<jsp:forward page="Ex01_Request.jsp"></jsp:forward>

<%--
<%
	// forward방식으로 페이지 이동
	RequestDispatcher rd = request.getRequestDispatcher("Ex01_Request.jsp");
	rd.forward(request, response);
%>
 --%>


</body>
</html>