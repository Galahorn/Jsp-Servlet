package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex10_getPost")
public class Ex10_getPost extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get ��� ���ڵ�
		// Notion�� �����.
		
		// Post��� ���ڵ�
		//�����Ϳ� ����ִ� ��ü�� ���ڵ� ����� ����
		
		// �׻� ���ڵ��� ���� �����ؾ���.
		request.setCharacterEncoding("EUC-KR");
		
		String data = request.getParameter("data");
		System.out.println("�Է��� data�� : " + data);
	}

}
