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
		// 1. �����ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. db����
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

			// 3. SQL�� �غ�
			String sql = "select * from jdbc_member where id =? and pw = ?";

			// 4. PreparedStatement ��ü �غ�
			psmt = conn.prepareStatement(sql);

			// 5. ���ε� ���� ä���
			psmt.setString(1, id); // (���°����ǥ����, ����� ����������)
			psmt.setString(2, pw);

			// executeQuery(); : Select���϶���
			// executeUpdate(); : Update/insert/Delete���϶�

			rs = psmt.executeQuery();
			// ResultSet
			// rs.next() : ���� �����Ͱ� �ִٸ� true / ������ false

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

			// 3. SQL�� �غ�
			String sql = "insert into jdbc_member values(?,?,?)";

			// 4. PreparedStatement ��ü �غ�
			psmt = conn.prepareStatement(sql);

			// 5. ���ε� ���� ä���
			psmt.setString(1, id); // (���°����ǥ����, ����� ����������)
			psmt.setString(2, pw);
			psmt.setString(3, nickname);

			cnt = psmt.executeUpdate();
			// executeQuery(); : Select���϶���
			// executeUpdate(); : Update/insert/Delete���϶�

			// ResultSet
			// rs.next() : ���� �����Ͱ� �ִٸ� true / ������ false
		} catch (Exception e) {

		} finally {
			close();
		}
		return cnt;
	}
//==================================================================================================================
}
