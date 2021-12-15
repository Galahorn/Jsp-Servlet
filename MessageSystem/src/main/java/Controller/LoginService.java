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
		
		// 1. �Ķ���� ����
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		// DAO��ü ����.
		DAO dao = new DAO();
		
		memberVO vo = dao.login(email, pw);
		
		//�α��� ���� ���� ���� �Ǵ�.
		//vo������ �Ǵ�. null�̸� ����, �ƴϸ� ����
		
		if(vo != null) { //����
			System.out.println("�α��� ����.");
			//���ǿ� ������ ������ ��Ƽ� ����.
			//���ǿ� ������ ���� ���� �ؾ��ϴ� ��.
			// 1. ���� ��ü �����.
			HttpSession session = request.getSession();
			
			// 2. ���ǿ� Attribute�� �߰�.
			session.setAttribute("vo", vo);
			
		} else {
			System.out.println("�α��� ����.");
			
		}
		response.sendRedirect("main.jsp");
		
		
	}

}
