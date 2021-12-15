package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ex03_DeleteSession")
public class Ex03_DeleteSession extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 技记 按眉 积己
		HttpSession session = request.getSession();
		
		// 2. 技记 1俺 昏力
		// removeAttribute("技记 捞抚")
		
		session.removeAttribute("second");
		
		// 其捞瘤 捞悼 
		response.sendRedirect("Ex03_SelectSession.jsp");
	}

}
