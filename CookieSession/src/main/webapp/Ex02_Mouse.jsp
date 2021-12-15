<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%	// 쿠키 객체 생성
	Cookie cookie = new Cookie("Mouse_item", "마우스");

	// 쿠키의 유효기간 설정
	cookie.setMaxAge(60*60);

	// 응답에 쿠키추가
	response.addCookie(cookie);
	

%>


<p>마우스에 대한 상세한 페이지 입니다.</p>
<p>모델 : 로지텍 게이밍 마우스</p>
<p>제품가격 : 21,900원</p>
<a href = "Ex02_List.jsp">제품 목록 페이지</a>

</body>
</html>