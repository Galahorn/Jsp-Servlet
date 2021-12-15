package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex11_userInfo")
public class Ex11_userInfo extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String rpw = request.getParameter("rpw");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String birth = request.getParameter("birth");
		String[] sport = request.getParameterValues("sport");
		String color = request.getParameter("color");
		String tbox = request.getParameter("tbox");

		response.setContentType("text/html; charset = euc-kr");

		PrintWriter out = response.getWriter();

		out.print("id : " + id + "<br>");
		out.print("pw : " + pw + "<br>");
		out.print("rpw : " + rpw + "<br>");
		out.print("¼ºº° : " + gender + "<br>");
		out.print("blood : " + blood + "<br>");
		out.print("birth : " + birth + "<br>");
		out.print("sport : ");
		
		for (int i = 0; i < sport.length; i++) {
			
			out.print(sport[i] + "\t");
		}
		
		out.print("<br>");
		out.print("color : " + color + "<br>");
		out.print("talk : " + tbox);

	}

}
