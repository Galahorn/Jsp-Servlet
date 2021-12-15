package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02_ip")
public class Ex02_ip extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어온 사람에 따라서 다른 화면 보여주기
		// ip 확인하기
		
		String client = request.getRemoteHost(); 
		System.out.println("들어온 사람 : " + client);
		
		// 응답할 페이지에 대한 설정.
		response.setContentType("text/html; charset = euc-kr");
		
		//출력 스트림 열기.
		PrintWriter out = response.getWriter();
		
		if(client.equals("172.30.1.54")) {
			out.print("<h1> 낮선 곳에 오신걸 환영하오. </h1>");
			out.print("아무튼 그렇다고.<br>");
			out.print("<image src ='./img/cat.jpg'>");
		} else if(client.equals("172.30.1.43")) {
			out.print("<h1> 어서오세요 선생님. </h1>");
			out.print("환영합니다..<br>");
			out.print("<image src ='./img/cogi.jpg'>");
		} else {
			out.print("<h1> 짝궁이 아니시군요. 나가주세요 휴먼 </h1>");
			out.print("<image src ='./img/bye.jpg'>");
		}
	}

}
