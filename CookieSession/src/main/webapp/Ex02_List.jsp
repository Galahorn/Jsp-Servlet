<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>판매 제품 목록</h1>
	<ul>
		<li><a href="Ex02_Mouse.jsp">마우스</a></li>
		<li><a href="Ex02_Phone.jsp">핸드폰</a></li>
		<li><a href="Ex02_Computer.jsp">컴퓨터</a></li>
	</ul>
	<hr>
	<strong>최근 본 상품</strong>
	<br>
	<%// 상품에 대한 쿠키만 출력
	
	// 1. 전체 쿠키 가져오기
	Cookie[] cookies = request.getCookies();
	
	// 2. 쿠키 구분 해주기.(contains메서드)
	for(Cookie c : cookies) {
		String cookieName = c.getName(); //쿠키이름
		String cookieValue = c.getValue(); //쿠키값
		
		//지금은 텍스트만 사용 -> 인코딩, 디코딩 안씀.
		
		// 3. 쿠키의 값을 출력
		
		if(cookieName.contains("Mouse_item") == true) {
			
			out.print("<a href = \"Ex02_Mouse.jsp\">" + cookieValue + "</a><br>");
		
		} else if(cookieName.contains("Computer_item") == true) {
			
			out.print("<a href = \"Ex02_Computer.jsp\">" + cookieValue + "</a><br>");
		
		} else if(cookieName.contains("Phone_item") == true) {
			
 		  out.print("<a href = \"Ex02_Phone.jsp\">" + cookieValue + "</a><br>");
		
		}
	}	
		// 1. 전체 쿠키 가져오기
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