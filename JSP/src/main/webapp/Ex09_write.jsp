<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% //1. 파라미터 수집 : 받아온 값을 변수에 담아서 저장하는 행위
int number = Integer.parseInt(request.getParameter("number")); %>


	<fieldset style="width : 250px;">

		<legend>랜덤당첨작성</legend>
			<form action = "Ex09_result.jsp">

			

			<table>
				
				<tr><td>주제</td>  <td><input type = "text" name = "thema"></td></tr>
				<%for(int i = 1; i<= number; i++) { %>
				
				<tr><td>아이템<%= i%> : </td>  <td><input type = "text" name = "item"></td></tr>
				<% } %>
				<tr><td><input type = "submit" value = "시작"></td></tr>
				
				
			</table> 
			</form>
		
	</fieldset>

</body>
</html>