package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. �Ķ���� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		
		// DAO��ü ����
		DAO dao = new DAO();
		
		// DAO ���
		int cnt = dao.join(id, pw, nickname);
			
		if (cnt > 0) {
			//ȸ�� ������ ����
			//VO��ü ����
			MemberVO vo = new MemberVO(id, pw, nickname);
						
			request.setAttribute("vo", vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("Ex12_joinTrue.jsp");
			rd.forward(request, response);
			//response.sendRedirect("Ex12_joinTrue.jsp?nickname=" + nickname);
		} else {
			response.sendRedirect("Ex12_joinFalse.jsp");
		}

	}
}
