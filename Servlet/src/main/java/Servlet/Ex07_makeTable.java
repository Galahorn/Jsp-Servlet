package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex07_makeTable")
public class Ex07_makeTable extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//입력한 숫자 받아오기
		int table = Integer.parseInt(request.getParameter("table"));
		
		response.setContentType("text/html;");
		
		PrintWriter out = response.getWriter();
		
		out.print("<table border = 1>");
		//1행 6열 : tr 1개, td 6개
		out.print("<tr>");
		
		for(int i = 1; i <= table; i++) {
			out.print("<td>" + i + "</td>");
		}
		
		out.print("</tr>");
		out.print("</table>");		
		
	}

}
