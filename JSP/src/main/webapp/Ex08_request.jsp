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
	// 1. �Ķ����(�Ű�����) ����
	//request.getParameter
	String name = request.getParameter("name");
	int java = Integer.parseInt(request.getParameter("java"));
	int web = Integer.parseInt(request.getParameter("web"));
	int iot = Integer.parseInt(request.getParameter("iot"));
	int android = Integer.parseInt(request.getParameter("android"));
	
	int avg = (java + web + iot + android) / 4;
	
	String grade = "";
	
	if(avg >= 95) {
		grade = "A+";
	} else if(avg >= 90) {
		grade = "A";
	} else if(avg >= 85) {
		grade = "B+";
	} else if(avg >= 80) {
		grade = "B";
	} else {
		grade = "F";
	}
	
%>


		�̸� : <%= name %><br> 
		�ڹ����� : <%= java %><br> 
		�� ����: <%= web %><br> 
		IOT : <%= iot %><br>
		�ȵ���̵� : <%= android %><br>
		��� : <%= avg %><br>
		���� : <h1><%= grade %></h1>

</body>




</html>