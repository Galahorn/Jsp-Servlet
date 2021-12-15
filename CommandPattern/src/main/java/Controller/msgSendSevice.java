package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.messegeVO;
import Model.memberVO;

@WebServlet("/msgSendSevice")
public class msgSendSevice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. �޾ƿ� �Ķ���͵��� ���ڵ�.
		request.setCharacterEncoding("euc-kr");

		// 1. �Ķ���� ����	
		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");
		
		
		DAO dao = new DAO();
		
		//DAO�� join�޼ҵ� ���
		int cnt = dao.MsgSend(send_name, receive_email, content);
		
		if (cnt > 0) {
			System.out.println("�޼��� ���� ����.");
		
		} else {
			System.out.println("�޼��� ���� ����.");
			
		}
		response.sendRedirect("main.jsp");

	}

}
