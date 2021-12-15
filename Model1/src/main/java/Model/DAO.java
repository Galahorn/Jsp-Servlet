package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	MemberVo vo = null;
	int cnt = 0;
//==========================================================================
	
	public void connect() {
		try {// 1. 동적로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. db연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		conn = DriverManager.getConnection(url, dbid, dbpw);
		}catch (Exception e) {
			
		}
	}
//===========================================================================		
	
	public void close() {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
//===========================================================================	
	
	public MemberVo login(String id, String pw) {

		try {
			connect();
			// 3. SQL문 준비
			String sql = "select * from jdbc_member where id =? and pw = ?";

			// 4. PreparedStatement 객체 준비
			psmt = conn.prepareStatement(sql);

			// 5. 바인드 변수 채우기
			psmt.setString(1, id); // (몇번째물음표인지, 어떤값을 넣을것인지)
			psmt.setString(2, pw);

			// executeQuery(); : Select문일때만
			// executeUpdate(); : Update/insert/Delete문일때

			rs = psmt.executeQuery();
			// ResultSet
			// rs.next() : 다음 데이터가 있다면 true / 없으면 false

			if (rs.next() == true) {
				String mid = rs.getString("id"); // getString안에는 컬럼이름 or 컬럼 번호
				String mpw = rs.getString(2); // 컬럼 인덱스로 가져오기
				String nickname = rs.getString(3);

				vo = new MemberVo(mid, mpw, nickname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		close();

		}
		return vo;
	}

//=======================================================================

	public int join(String id, String pw, String nickname) {

		try {
			connect();
			
			String sql = "insert into jdbc_member values(?,?,?)";

			// 4. PreparedStatement 객체 준비
			psmt = conn.prepareStatement(sql);

			// 5. 바인드 변수 채우기
			psmt.setString(1, id); // (몇번째물음표인지, 어떤값을 넣을것인지)
			psmt.setString(2, pw);
			psmt.setString(3, nickname);

			cnt = psmt.executeUpdate();
			// executeQuery(); : Select문일때만
			// executeUpdate(); : Update/insert/Delete문일때


		} catch (Exception e) {
			// response.sendRedirect("Ex12_joinFalse.jsp");
		} finally {
			// jdbc 사용 이후 닫아주기.
			// 열었던 순서의 반대
			close();
		}
		return cnt;
	}
//=========================================================================




}
