<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�Ǹ� ��ǰ ���</h1>
	<ul>
		<li><a href="Ex02_Mouse.jsp">���콺</a></li>
		<li><a href="Ex02_Phone.jsp">�ڵ���</a></li>
		<li><a href="Ex02_Computer.jsp">��ǻ��</a></li>
	</ul>
	<hr>
	<strong>�ֱ� �� ��ǰ</strong>
	<br>
	<%// ��ǰ�� ���� ��Ű�� ���
	
	// 1. ��ü ��Ű ��������
	Cookie[] cookies = request.getCookies();
	
	// 2. ��Ű ���� ���ֱ�.(contains�޼���)
	for(Cookie c : cookies) {
		String cookieName = c.getName(); //��Ű�̸�
		String cookieValue = c.getValue(); //��Ű��
		
		//������ �ؽ�Ʈ�� ��� -> ���ڵ�, ���ڵ� �Ⱦ�.
		
		// 3. ��Ű�� ���� ���
		
		if(cookieName.contains("Mouse_item") == true) {
			
			out.print("<a href = \"Ex02_Mouse.jsp\">" + cookieValue + "</a><br>");
		
		} else if(cookieName.contains("Computer_item") == true) {
			
			out.print("<a href = \"Ex02_Computer.jsp\">" + cookieValue + "</a><br>");
		
		} else if(cookieName.contains("Phone_item") == true) {
			
 		  out.print("<a href = \"Ex02_Phone.jsp\">" + cookieValue + "</a><br>");
		
		}
	}	
		// 1. ��ü ��Ű ��������
//		Cookie[] cookies = request.getCookies();
//		
//		for(int i = 0; i < cookies.length; i++) {
//			Cookie cookie = cookies[i];
//			
//			if(cookie.getName().contains("item")) {
//				out.print("<br>" + cookie.getValue());
//			}
//		}
		
	
	
	%>
</body>
</html>