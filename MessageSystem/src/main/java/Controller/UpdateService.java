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

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 0. 한글 인코딩
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		// 1. 파라미터 수집
		// 이메일은 세션 영역에 저장되어 있는 vo
		memberVO vo = (memberVO)session.getAttribute("vo");

		String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		DAO dao = new DAO();
		// DAO의 update메소드 사용
		int cnt = dao.update(email, pw, tel, address);


		if (cnt > 0) {
			System.out.println("회원정보가 수정되었습니다.");
			vo = new memberVO(vo.getEmail(), pw, tel, address);

			//같은 이름으로 다른 데이터를 집어넣으면 덮어쓰기!
			session.setAttribute("vo", new memberVO(email, pw, tel, address));
			
			//RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			//rd.forward(request, response);

		} else {
			System.out.println("회원정보 수정이 실패하였습니다.");
			// main
		}
		response.sendRedirect("main.jsp");
	}

}
