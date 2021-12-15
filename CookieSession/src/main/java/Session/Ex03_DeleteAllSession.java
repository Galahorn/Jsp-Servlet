package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ex03_DeleteAllSession")
public class Ex03_DeleteAllSession extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 技记 按眉 积己
		HttpSession session = request.getSession();
		
		// 2. 技记 傈何昏力
		//invalidate() => 技记俊 乐绰 葛电 蔼阑 昏力
		session.invalidate();
		
		response.sendRedirect("Ex03_SelectSession.jsp");
		
		
		
		
	}

}
