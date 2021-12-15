package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02_ip")
public class Ex02_ip extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� ����� ���� �ٸ� ȭ�� �����ֱ�
		// ip Ȯ���ϱ�
		
		String client = request.getRemoteHost(); 
		System.out.println("���� ��� : " + client);
		
		// ������ �������� ���� ����.
		response.setContentType("text/html; charset = euc-kr");
		
		//��� ��Ʈ�� ����.
		PrintWriter out = response.getWriter();
		
		if(client.equals("172.30.1.54")) {
			out.print("<h1> ���� ���� ���Ű� ȯ���Ͽ�. </h1>");
			out.print("�ƹ�ư �׷��ٰ�.<br>");
			out.print("<image src ='./img/cat.jpg'>");
		} else if(client.equals("172.30.1.43")) {
			out.print("<h1> ������� ������. </h1>");
			out.print("ȯ���մϴ�..<br>");
			out.print("<image src ='./img/cogi.jpg'>");
		} else {
			out.print("<h1> ¦���� �ƴϽñ���. �����ּ��� �޸� </h1>");
			out.print("<image src ='./img/bye.jpg'>");
		}
	}

}
