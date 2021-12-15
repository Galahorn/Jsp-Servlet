package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 파라미터 수집
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		DAO dao = new DAO();
		
		MemberVO vo = dao.login(id, pw);
		
		if (vo != null) {
			
			// 0. 데이터를 담는다? 리퀘스트 객체에!
			//request.setAttribute((String)"name", (Object) 담을값);
			// java.lang.Object : 모든 클래스가 상속받는 객체, 최상위 클래스.
			// ex) String --(업캐스팅)--> Object
			
			//forword 방식.
			request.setAttribute("vo", vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("Ex12_Logintrue.jsp");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("Ex12_Loginfalse.jsp");
		}


	}

}
