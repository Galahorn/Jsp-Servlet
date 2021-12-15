package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL Mapping
@WebServlet("/Ex01_request")

//Servlet : HttpServlet�� ��� ����!
public class Ex01_request extends HttpServlet {
				// service �޼ҵ� : Java�� main�޼ҵ�� ���� ����
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							//�Ű������� 2���� ����. request, response
		// 1. request��ü : ����ڰ� ��û�� ���� �� ��û�� ���� ������ ��� �ִ� ��ü!
		// ��û�� ���� �ּ�, ����ڰ� �Է��� ����(id, pw ���)
		// �ǽ�1. ��û�� ���� ip �ּ� Ȯ���ϱ�.
		String client = request.getRemoteHost();
		System.out.println("���� ��� : " +client);
		
		// 2. response��ü : ����ڿ��� ������ ���� �� �ְ� �ϴ� ��ü
		// ex)HTML����, Text, ������ �̵�, �̹��� ��....
		// ���ڵ� ��� : euc-kr(������ü�� �ν���), utf-8(���� �ϳ��ϳ��� ������)
		response.setContentType("text/html; charset = euc-kr");
		
		// ���� ����ϱ�.
		// ����ڿ��� �����͸� ������ �� �ִ� ���
		PrintWriter out = response.getWriter();
		
		//out ��ü : ����� PrintWriter text, tag�� ȥ���ؼ� ���� ����.
//		if(client.equals("172.30.1.54")) {
//			out.print("<h1> ���� ���� ���Ű� ȯ���Ͽ�. </h1>");
//			out.print("�ƹ�ư �׷��ٰ�.<br>");
//			out.print("<image src ='./img/cat.jpg'>");
//		} else if(client.equals("172.30.1.43")) {
//			out.print("<h1> ������� ������. </h1>");
//			out.print("ȯ���մϴ�..<br>");
//			out.print("<image src ='./img/cogi.jpg'>");
//		} else {
//			out.print("<h1> ¦���� �ƴϽñ���. �����ּ��� �޸� </h1>");
//			out.print("<image src ='./img/bye.jpg'>");
//		}
		
		out.print("<h1> ������ ������ �������. </h1>");
		out.print("�ƹ�ư �׷�����.<br>");
		
		
		//�̹��� �ֱ�
		out.print("<image src ='./img/cat.jpg'>");
	}

}
