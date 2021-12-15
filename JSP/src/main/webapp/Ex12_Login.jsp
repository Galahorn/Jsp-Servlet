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
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	//1. �Ķ���� ���� 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	/*
	// 2. id�� smhrd�̰� pw�� 1234���� ��
	if (id.equals("smhrd") && pw.equals("1234")) {
		// 3-1. �α��� ����  Ex12_loginTrue.jsp�� �̵�
		response.sendRedirect("Ex12_LoginTrue.jsp");
	} else {
		// 3-2 �α��� ����  Ex12_loginFalse.jsp�� �̵�
		response.sendRedirect("Ex12_LoginFalse.jsp");
	} */
	
	try{
	// 1. �����ε�
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// 2. db���� 
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbid = "hr";
	String dbpw = "hr";
	
	conn = DriverManager.getConnection(url, dbid, dbpw);
	
	// 3. SQL�� �غ�
	String sql = "select * from jdbc_member where id =? and pw = ?";
	
	// 4. PreparedStatement ��ü �غ�
	psmt = conn.prepareStatement(sql);
	
	// 5. ���ε� ���� ä���
	psmt.setString(1, id); // (���°����ǥ����, ����� ����������)
	psmt.setString(2, pw); 
	
	// executeQuery(); : Select���϶���
	// executeUpdate(); : Update/insert/Delete���϶�
	
	rs = psmt.executeQuery();
	// ResultSet
	// rs.next() : ���� �����Ͱ� �ִٸ� true / ������ false
	if(rs.next() == true){
		response.sendRedirect("Ex12_Logintrue.jsp?id=" + id);
	} else {
		response.sendRedirect("Ex12_Loginfalse.jsp");
	}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		// jdbc ��� ���� �ݾ��ֱ�.
		// ������ ������ �ݴ�
		if(rs != null) {
		rs.close();
		}
		if(psmt != null) {
			psmt.close();
			}
		if(conn != null) {
			conn.close();
		}
	}	
	
	%>

</body>
</html>