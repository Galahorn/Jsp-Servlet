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
//파라미터 수집 
MemberVO vo = (MemberVO)session.getAttribute("vo");

//if(rs.next() == true) {
	//session.setAttribute();
	//}
// 로그인 실패 -> vo == null
// vo가 null인지 아닌지 : 로그인 상태를 구분할수있다.

%>
	<fieldset>

		<%if(vo != null) { 	%>

		<h1><%= vo.getId() %>님 환영합니다.
		</h1>

		<%} else {%>
		<h1>로그인 실패</h1>
		<a href="Ex04_Login.html">메인으로</a>
		<%} %>
	</fieldset>

</body>
</html>