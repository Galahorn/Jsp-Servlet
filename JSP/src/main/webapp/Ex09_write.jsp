<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% //1. �Ķ���� ���� : �޾ƿ� ���� ������ ��Ƽ� �����ϴ� ����
int number = Integer.parseInt(request.getParameter("number")); %>


	<fieldset style="width : 250px;">

		<legend>������÷�ۼ�</legend>
			<form action = "Ex09_result.jsp">

			

			<table>
				
				<tr><td>����</td>  <td><input type = "text" name = "thema"></td></tr>
				<%for(int i = 1; i<= number; i++) { %>
				
				<tr><td>������<%= i%> : </td>  <td><input type = "text" name = "item"></td></tr>
				<% } %>
				<tr><td><input type = "submit" value = "����"></td></tr>
				
				
			</table> 
			</form>
		
	</fieldset>

</body>
</html>