<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%	 String thema = request.getParameter("thema");
	 String[] item = request.getParameterValues("item");
	 	 	 
	//Collections.shuffle(Arrays.asList(item));
	 
	 
	 Random rd = new Random();
	 int num = rd.nextInt(item.length);
	 
	 %>
	 
<fieldset style="width : 250px;">
<legend>������÷���</legend>
<p><%= thema%></p>
<p><%= item[num]%></p>
	<!-- ǥ���Ŀ� item[0]�� �־��ָ� �� -->
</fieldset>


</body>
</html>