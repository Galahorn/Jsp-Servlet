package FrontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *.do : ~~~.do�� �����⸸ �ϸ� �տ� ��� ���� ��� ��û�� ���⼭ �޴´�.
@WebServlet("*.do")
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ���� ��û�� �����ϰ�, ������ ��ü�� ���� �޼��带 ���
		// ���� ��ü URI�� �ʿ�
		// http://localhost:8082/CommandPattern/Login.do
		String requestURI = request.getRequestURI();
		
		// ContextPath ��������.
		// http://localhost:8082/CommandPattern
		String contextPath = request.getContextPath();
		
		// String �޼ҵ� ��� substring(); ��� : ���ڿ��� �����̽�
		// substring( intŸ�� index )
		// ��������� /Login.do�� ���Ե�.
		String command = requestURI.substring(contextPath.length());
		
		System.out.println(command);
		
		// if���� �̿��ؼ� ����
		// ������ ���ؼ� ��ü ����.
		Command exe = null;
		
		if(command.equals("/Login.do")) {
			// interface <-- LoginCon (��ĳ����)
			exe = new LoginCon();
		} else if(command.equals("/Join.do")) {
			//ȸ�� ����
			exe = new JoinCon();
		} else if(command.equals("/SelectBoard.do")) {
			exe = new SelectBoardCon();
		} else if(command.equals("/DeleteMsg.do")) {
			exe = new DeleteMsgCon();
		}
		
		// �������� �־��� ����޼��带 ����
		exe.execute(request, response);
	}

}