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
		try {// 1. �����ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. db����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		conn = DriverManager.getConnection(url, dbid, dbpw);
		}catch (Exception e) {
			
		}
	}
//===========================================================================		
	
	public void close() {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
//===========================================================================	
	
	public MemberVo login(String id, String pw) {

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
				String mid = rs.getString("id"); // getString�ȿ��� �÷��̸� or �÷� ��ȣ
				String mpw = rs.getString(2); // �÷� �ε����� ��������
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

			// 4. PreparedStatement ��ü �غ�
			psmt = conn.prepareStatement(sql);

			// 5. ���ε� ���� ä���
			psmt.setString(1, id); // (���°����ǥ����, ����� ����������)
			psmt.setString(2, pw);
			psmt.setString(3, nickname);

			cnt = psmt.executeUpdate();
			// executeQuery(); : Select���϶���
			// executeUpdate(); : Update/insert/Delete���϶�


		} catch (Exception e) {
			// response.sendRedirect("Ex12_joinFalse.jsp");
		} finally {
			// jdbc ��� ���� �ݾ��ֱ�.
			// ������ ������ �ݴ�
			close();
		}
		return cnt;
	}
//=========================================================================




}
