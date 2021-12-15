package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex05_getData")
public class Ex05_getData extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		response.setContentType("text/html; charset = euc-kr");
		
		PrintWriter out = response.getWriter();
		
		out.print("제 이름은 " + name + "입니다.<br>");
		out.print("제 나이는 " + age + "살 입니다.");
		
		//형변환~
		//Integer.parseInt(age);
	}

}
