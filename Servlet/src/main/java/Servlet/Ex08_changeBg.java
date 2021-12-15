package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex08_changeBg")
public class Ex08_changeBg extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String color = request.getParameter("color");
		
		response.setContentType("text/html; charset = euc-kr");
		
		PrintWriter out = response.getWriter();
		out.print("<body bgcolor = " + color +">" );
		out.print("<span style = 'color : white'> 내일은 토요일 예아! <span>");
		out.print("</body>" );
		
		//out.print("<html>");
		//out.print("<head>");
		//out.print("<style> body {background-color" + color + "</style>" );
		//out.print("</head>");
		//out.print("<body>");
		//out.print("</body>");
		//out.print("</html>");
	}

}
