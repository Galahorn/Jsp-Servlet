package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URL Mapping
@WebServlet("/a")
// Servlet을 동작시키기 위해서 실제 경로 대신에 사용하는 문자열
// 문자열을 Servlet클래스와 Mapping시킨다
// 1. 길면 불편함
// 2. 보안상의 문제
public class Ex03_urlMapping extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	}

}
