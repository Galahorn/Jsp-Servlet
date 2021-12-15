
<%@page import="Model.DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	
	//1. 파라미터 수집 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nickname = request.getParameter("nickname");
	
	DAO dao = new DAO();
	
	int cnt = dao.join(id, pw, nickname);
	
	
	if(cnt > 0){
		response.sendRedirect("Ex12_joinTrue.jsp?nickname=" + nickname);
	} else {
		response.sendRedirect("Ex12_joinFalse.jsp");
	}
	
	%>
</body>
</html>