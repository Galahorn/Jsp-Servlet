<%@page import="java.net.URLDecoder"%>
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
	//��Ű�� �޾ƿ���
	//request.getCookies();�� �̿��ؼ� ��Ű�� �޾ƿ�
	//�ش��ϴ� �����ο��� ��� ������ ��� ��Ű�� ����
	Cookie[] cookies = request.getCookies();

	// for i in list : (���̽��� for��)
	// for each��
	// for(������ �������� Ÿ��, �̸� : �迭)
	
	for(Cookie c : cookies) {
		// ��Ű �̸�
		String cookieName = c.getName();
				
		// ��Ű ��
		String cookieValue = c.getValue();
		//���ڵ� : ���ڵ��ߴ� ���ڿ��� �ٽ� ���� ���·� �ǵ����� ��
		//URLDecoder ��ü�� decode �޼��� ���.
		cookieValue = URLDecoder.decode(cookieValue, "euc-kr");
				
		//String�� contains �޼���
		//contains �޼��� : �Ű������� ���� ���ڿ��� �ȿ� �ִ��� ������ �˷���
		// booleanŸ������ ����
		//contains("���ڿ�")
				
	if(cookieName.contains("cookie") == true) {
		out.print(cookieName + " : " + cookieValue + "<br>");
		}
	}
%>

<a href="Ex01_DeleteCookie">��Ű ����</a>


</body>
</html>