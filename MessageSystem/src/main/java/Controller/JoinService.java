package Controller;

import java.io.IOException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.memberVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 0. 받아올 파라미터들을 인코딩.
		request.setCharacterEncoding("euc-kr");

		// 1. 파라미터 수집
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		DAO dao = new DAO();
		
		//DAO의 join메소드 사용
		int cnt = dao.join(email, pw, tel, address);
		
		if (cnt > 0) {
			System.out.println("회원가입이 완료되었습니다.");
			// join_success.jsp
			memberVO vo = new memberVO(email, pw, tel, address);
			
			request.setAttribute("vo", vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
			rd.forward(request, response);
			
		} else {
			System.out.println("회원가입이 실패하였습니다.");
			//main
			response.sendRedirect("main.jsp");
		}

	}

}
