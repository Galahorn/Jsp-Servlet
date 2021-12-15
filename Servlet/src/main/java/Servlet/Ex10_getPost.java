package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex10_getPost")
public class Ex10_getPost extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 방식 디코딩
		// Notion에 적어둠.
		
		// Post방식 디코딩
		//데이터에 들어있는 객체에 인코딩 방식을 지정
		
		// 항상 디코딩을 제일 먼저해야함.
		request.setCharacterEncoding("EUC-KR");
		
		String data = request.getParameter("data");
		System.out.println("입력한 data는 : " + data);
	}

}
