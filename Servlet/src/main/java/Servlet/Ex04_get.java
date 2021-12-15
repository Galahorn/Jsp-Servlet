package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex04_get")
public class Ex04_get extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터를 받아오는 서블릿.
		//사용자가 입력한 데이터를 가져오기.
		String data = request.getParameter("data");
		
		System.out.println("내가 입력한 데이터는 : " + data);
		
		//한글로 받고싶을 때 : get방식 인코딩
		
	}

}
