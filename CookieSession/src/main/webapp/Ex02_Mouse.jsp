<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%	// ��Ű ��ü ����
	Cookie cookie = new Cookie("Mouse_item", "���콺");

	// ��Ű�� ��ȿ�Ⱓ ����
	cookie.setMaxAge(60*60);

	// ���信 ��Ű�߰�
	response.addCookie(cookie);
	

%>


<p>���콺�� ���� ���� ������ �Դϴ�.</p>
<p>�� : ������ ���̹� ���콺</p>
<p>��ǰ���� : 21,900��</p>
<a href = "Ex02_List.jsp">��ǰ ��� ������</a>

</body>
</html>