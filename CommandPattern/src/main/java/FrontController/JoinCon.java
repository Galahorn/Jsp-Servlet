package FrontController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.memberVO;

public class JoinCon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 인코딩도 try/catch문 필요
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 1. 파라미터 수집
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		DAO dao = new DAO();
		
		//DAO의 join메소드 사용
		int cnt = dao.join(email, pw, tel, address);
		
		if (cnt > 0) {
			System.out.println("회원가입이 완료되었습니다.");
			// join_success.jsp
			memberVO vo = new memberVO(email, pw, tel, address);
			
			request.setAttribute("vo", vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} else {
			System.out.println("회원가입이 실패하였습니다.");
			//main
			try {
				response.sendRedirect("main.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
