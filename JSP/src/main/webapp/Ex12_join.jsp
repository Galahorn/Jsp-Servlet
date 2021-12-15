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
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	
	//1. �Ķ���� ���� 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nickname = request.getParameter("nickname");
	
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
	String sql = "insert into jdbc_member values(?,?,?)";
	
	// 4. PreparedStatement ��ü �غ�
	psmt = conn.prepareStatement(sql);
	
	// 5. ���ε� ���� ä���
	psmt.setString(1, id); // (���°����ǥ����, ����� ����������)
	psmt.setString(2, pw); 
	psmt.setString(3, nickname);
	
	cnt = psmt.executeUpdate();
	// executeQuery(); : Select���϶���
	// executeUpdate(); : Update/insert/Delete���϶�
	
	// ResultSet
	// rs.next() : ���� �����Ͱ� �ִٸ� true / ������ false
	if(cnt == 1){
		response.sendRedirect("Ex12_joinTrue.jsp?nickname=" + nickname);
	}
	} catch (Exception e) {
		response.sendRedirect("Ex12_joinFalse.jsp");
	} finally {
		// jdbc ��� ���� �ݾ��ֱ�.
		// ������ ������ �ݴ�
	
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