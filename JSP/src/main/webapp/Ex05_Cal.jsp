<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%! // ���� : Ŭ���� ������ �����ϱ� ���ؼ� �ۼ�

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
	// �ڹ� �ڵ�
	int a = Integer.parseInt(request.getParameter("num1"));
	int b = Integer.parseInt(request.getParameter("num2"));
	%>
	
	<!-- ���� ��� -->
	<%= a %> + <%= b %>  = <%= sum(a, b) %> <br>
	<%= a %> - <%= b %>  = <%= minus(a, b) %> <br>			
	<%= a %> * <%= b %>  = <%= mul(a, b) %> <br>			
	<%= a %> / <%= b %>  = <%= div(a, b) %> <br>			
	
	

</body>
</html>