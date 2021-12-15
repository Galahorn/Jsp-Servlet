package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	MemberVO vo = null;
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
//==========================================================================
	
	public void connect() {
		// 1. 동적로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. db연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//============================================================================

	public void close() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//===============================================================================

	public MemberVO login(String id, String pw) {

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
				String uid = rs.getString("id");
				String upw = rs.getString("pw");
				String unick = rs.getString("nickname");

				vo = new MemberVO(uid, upw, unick);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
//==================================================================================================================

	public int join(String id, String pw, String nickname) {

		try {
			connect();

			// 3. SQL문 준비
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

			// ResultSet
			// rs.next() : 다음 데이터가 있다면 true / 없으면 false
		} catch (Exception e) {

		} finally {
			close();
		}
		return cnt;
	}
//==================================================================================================================
}
