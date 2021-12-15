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
		// 세션객체 생성
		HttpSession session = request.getSession();

		// 1. 파라미터 수집
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {
			// 1. 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. db연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

			// 3. SQL문 준비
			String sql = "select * from jdbc_member where id =? and pw = ?";

			// 4. PreparedStatement 객체 준비
			psmt = conn.prepareStatement(sql);

			// 5. 바인드 변수 채우기
			psmt.setString(1, id); // (몇번째물음표인지, 어떤값을 넣을것인지)
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			
			if(rs.next() == true){
				// 로그인 성공시 세션에 id를 담기.
				MemberVO vo = new MemberVO(id, pw);
				
				// 세션에 VO를 저장해주기.
				session.setAttribute("vo", vo);
				
				
				response.sendRedirect("Ex04_Logintrue.jsp");
			} else {
				response.sendRedirect("Ex04_Logintrue.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// jdbc 사용 이후 닫아주기.
			// 열었던 순서의 반대
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
