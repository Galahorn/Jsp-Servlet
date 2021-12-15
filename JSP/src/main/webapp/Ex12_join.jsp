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
	
	//1. 파라미터 수집 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nickname = request.getParameter("nickname");
	
	/*
	// 2. id가 smhrd이고 pw가 1234인지 비교
	if (id.equals("smhrd") && pw.equals("1234")) {
		// 3-1. 로그인 성공  Ex12_loginTrue.jsp로 이동
		response.sendRedirect("Ex12_LoginTrue.jsp");
	} else {
		// 3-2 로그인 실패  Ex12_loginFalse.jsp로 이동
		response.sendRedirect("Ex12_LoginFalse.jsp");
	} */
	
	try{
	// 1. 동적로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// 2. db연결 
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbid = "hr";
	String dbpw = "hr";
	
	conn = DriverManager.getConnection(url, dbid, dbpw);
	
	// 3. SQL문 준비
	String sql = "insert into jdbc_member values(?,?,?)";
	
	// 4. PreparedStatement 객체 준비
	psmt = conn.prepareStatement(sql);
	
	// 5. 바인드 변수 채우기
	psmt.setString(1, id); // (몇번째물음표인지, 어떤값을 넣을것인지)
	psmt.setString(2, pw); 
	psmt.setString(3, nickname);
	
	cnt = psmt.executeUpdate();
	// executeQuery(); : Select문일때만
	// executeUpdate(); : Update/insert/Delete문일때
	
	// ResultSet
	// rs.next() : 다음 데이터가 있다면 true / 없으면 false
	if(cnt == 1){
		response.sendRedirect("Ex12_joinTrue.jsp?nickname=" + nickname);
	}
	} catch (Exception e) {
		response.sendRedirect("Ex12_joinFalse.jsp");
	} finally {
		// jdbc 사용 이후 닫아주기.
		// 열었던 순서의 반대
	
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