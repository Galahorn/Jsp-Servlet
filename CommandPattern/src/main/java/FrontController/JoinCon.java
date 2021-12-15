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
		
		// ���ڵ��� try/catch�� �ʿ�
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 1. �Ķ���� ����
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		DAO dao = new DAO();
		
		//DAO�� join�޼ҵ� ���
		int cnt = dao.join(email, pw, tel, address);
		
		if (cnt > 0) {
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
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
			System.out.println("ȸ�������� �����Ͽ����ϴ�.");
			//main
			try {
				response.sendRedirect("main.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
