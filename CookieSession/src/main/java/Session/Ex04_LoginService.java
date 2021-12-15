package Session;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberVO;

@WebServlet("/Ex04_LoginService")
public class Ex04_LoginService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

//====================================================================================		
		// ���ǰ�ü ����
		HttpSession session = request.getSession();

		// 1. �Ķ���� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {
			// 1. �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. db����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

			// 3. SQL�� �غ�
			String sql = "select * from jdbc_member where id =? and pw = ?";

			// 4. PreparedStatement ��ü �غ�
			psmt = conn.prepareStatement(sql);

			// 5. ���ε� ���� ä���
			psmt.setString(1, id); // (���°����ǥ����, ����� ����������)
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			
			if(rs.next() == true){
				// �α��� ������ ���ǿ� id�� ���.
				MemberVO vo = new MemberVO(id, pw);
				
				// ���ǿ� VO�� �������ֱ�.
				session.setAttribute("vo", vo);
				
				
				response.sendRedirect("Ex04_Logintrue.jsp");
			} else {
				response.sendRedirect("Ex04_Logintrue.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// jdbc ��� ���� �ݾ��ֱ�.
			// ������ ������ �ݴ�
			try {

				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
					// TODO Auto-generated catch block
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
