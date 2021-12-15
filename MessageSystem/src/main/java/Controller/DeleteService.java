package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;


@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. �Ķ���� ����
		// ������Ʈ���� Ű���� getParameter�� �Ű������� �־���
		String email = request.getParameter("email");
		
		// 2. DAO��ü
		DAO dao = new DAO();
		
		// 3. dao�� �޼ҵ�.
		int cnt = dao.Delete(email);
		
		if(cnt > 0) {
			System.out.println("ȸ�� Ż�� ����.");
			
		} else {
			System.out.println("ȸ�� Ż�� ����.");
			
		}
		
		response.sendRedirect("SelectAllService");
	}

}
