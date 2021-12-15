package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL Mapping
@WebServlet("/Ex01_request")

//Servlet : HttpServlet을 상속 받음!
public class Ex01_request extends HttpServlet {
				// service 메소드 : Java의 main메소드와 같은 역할
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							//매개변수를 2개를 받음. request, response
		// 1. request객체 : 사용자가 요청을 했을 때 요청에 대한 정보를 담고 있는 객체!
		// 요청이 들어온 주소, 사용자가 입력한 정보(id, pw 등등)
		// 실습1. 요청이 들어온 ip 주소 확인하기.
		String client = request.getRemoteHost();
		System.out.println("들어온 사람 : " +client);
		
		// 2. response객체 : 사용자에게 응답을 해줄 수 있게 하는 객체
		// ex)HTML문서, Text, 페이지 이동, 이미지 등....
		// 인코딩 방식 : euc-kr(글자자체를 인식함), utf-8(글자 하나하나를 조합함)
		response.setContentType("text/html; charset = euc-kr");
		
		// 웹에 출력하기.
		// 사용자에게 데이터를 전달할 수 있는 통로
		PrintWriter out = response.getWriter();
		
		//out 객체 : 사실은 PrintWriter text, tag를 혼합해서 전송 가능.
//		if(client.equals("172.30.1.54")) {
//			out.print("<h1> 낮선 곳에 오신걸 환영하오. </h1>");
//			out.print("아무튼 그렇다고.<br>");
//			out.print("<image src ='./img/cat.jpg'>");
//		} else if(client.equals("172.30.1.43")) {
//			out.print("<h1> 어서오세요 선생님. </h1>");
//			out.print("환영합니다..<br>");
//			out.print("<image src ='./img/cogi.jpg'>");
//		} else {
//			out.print("<h1> 짝궁이 아니시군요. 나가주세요 휴먼 </h1>");
//			out.print("<image src ='./img/bye.jpg'>");
//		}
		
		out.print("<h1> 지구의 주인은 고양이임. </h1>");
		out.print("아무튼 그런거임.<br>");
		
		
		//이미지 넣기
		out.print("<image src ='./img/cat.jpg'>");
	}

}
