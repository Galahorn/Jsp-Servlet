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
		// ��ü������ �������� �̵��Ҷ� try/catch�� ���
		try {
			response.sendRedirect("main.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
