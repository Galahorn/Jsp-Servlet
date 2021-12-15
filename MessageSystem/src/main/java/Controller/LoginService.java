package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.memberVO;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 파라미터 수집
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		// DAO객체 생성.
		DAO dao = new DAO();
		
		memberVO vo = dao.login(email, pw);
		
		//로그인 성공 실패 여부 판단.
		//vo값으로 판단. null이면 실패, 아니면 성공
		
		if(vo != null) { //성공
			System.out.println("로그인 성공.");
			//세션에 유저의 정보를 담아서 전달.
			//세션에 담을때 가장 먼저 해야하는 것.
			// 1. 세션 객체 만들기.
			HttpSession session = request.getSession();
			
			// 2. 세션에 Attribute를 추가.
			session.setAttribute("vo", vo);
			
		} else {
			System.out.println("로그인 실패.");
			
		}
		response.sendRedirect("main.jsp");
		
		
	}

}
