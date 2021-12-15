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

 %>
 
 <% // 스크립트릿 : 자바코드 작성부분
 	int a = 10;
 	int b = 5;
 	int result = sum(a, b);
 	
 	out.print(result);
 %>
 <!-- 표현식 : 웹에 출력 -->

</body>
</html>