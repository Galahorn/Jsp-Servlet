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
		
		// 0. �ѱ� ���ڵ�
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		// 1. �Ķ���� ����
		// �̸����� ���� ������ ����Ǿ� �ִ� vo
		memberVO vo = (memberVO)session.getAttribute("vo");

		String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		DAO dao = new DAO();
		// DAO�� update�޼ҵ� ���
		int cnt = dao.update(email, pw, tel, address);


		if (cnt > 0) {
			System.out.println("ȸ�������� �����Ǿ����ϴ�.");
			vo = new memberVO(vo.getEmail(), pw, tel, address);

			//���� �̸����� �ٸ� �����͸� ��������� �����!
			session.setAttribute("vo", new memberVO(email, pw, tel, address));
			
			//RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			//rd.forward(request, response);

		} else {
			System.out.println("ȸ������ ������ �����Ͽ����ϴ�.");
			// main
		}
		response.sendRedirect("main.jsp");
	}

}
