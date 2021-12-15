<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%! // 선언문 : 클래스 영역에 선언하기 위해서 작성

	public int sum(int a, int b) {
		int result = a + b;
		return result;
}
 

	public int minus(int a, int b) {
		int result = a - b;
		return result;
}
 

	public int mul(int a, int b) {
		int result = a * b;
		return result;
}
 

	public int div(int a, int b) {
		int result = a / b;
		return result;
}
 %>

	<%
	// 자바 코드
	int a = Integer.parseInt(request.getParameter("num1"));
	int b = Integer.parseInt(request.getParameter("num2"));
	%>
	
	<!-- 웹에 출력 -->
	<%= a %> + <%= b %>  = <%= sum(a, b) %> <br>
	<%= a %> - <%= b %>  = <%= minus(a, b) %> <br>			
	<%= a %> * <%= b %>  = <%= mul(a, b) %> <br>			
	<%= a %> / <%= b %>  = <%= div(a, b) %> <br>			
	
	

</body>
</html>