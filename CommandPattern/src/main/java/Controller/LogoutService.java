package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그아웃 기능.
		// vo가 null인지 아닌지 판단. -> session영역에 저장.
		// 세션 지우기

		// 1. 세션 객체 생성하기
		HttpSession session = request.getSession();
		
		// 2. 세션 삭제
		// .removeAttribute : 세션 하나 삭제
		// .invalidate : 세션 전부 삭제
		session.removeAttribute("vo");
		
		// 3.페이지 이동
		response.sendRedirect("main.jsp");
		
	}

}
