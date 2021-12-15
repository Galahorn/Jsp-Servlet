package FrontController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.memberVO;

public class LoginCon implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
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
		// 객체에서는 페이지를 이동할때 try/catch문 사용
		try {
			response.sendRedirect("main.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
