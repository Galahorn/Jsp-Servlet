<%@page import="Model.MemberVo"%>
<%@page import="Model.DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
fieldset {
	border: "dotted";
	text-align: "center";
}
</style>
</head>
<body>

	<%
	//1. 파라미터 수집 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		DAO dao = new DAO();
		
		MemberVo vo = dao.login(id, pw);

		if(vo != null){
			response.sendRedirect("Ex12_Logintrue.jsp?id=" + id);
		} else {
			response.sendRedirect("Ex12_Loginfalse.jsp");
		}
	%>

</body>
</html>