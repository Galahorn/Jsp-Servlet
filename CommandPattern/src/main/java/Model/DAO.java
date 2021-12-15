package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	memberVO vo = null;
	messegeVO mvo = null;
	boardVO bvo = null;
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;

//==========================================================================================	

	public void connection() {
		try {
			// JDBC
			// 1. 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//=========================================================================================	

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

		} catch (Exception e2) {

		}
	}

//==========================================================================================

	public int join(String email, String pw, String tel, String address) {

		// try문
		// JDBC 코드는 문법이 맞더라도 실행중 발생하는 오류처리 필요.
		try {

			connection();

			// 3. sql문 준비
			String sql = "insert into web_member values (?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			// 4. 바인드 변수 채우기
			psmt.setString(1, email);
			psmt.setString(2, pw);
			psmt.setString(3, tel);
			psmt.setString(4, address);

			// 5. 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return cnt;
	}

//===========================================================================================

	public memberVO login(String email, String pw) {

		try {

			connection();

			// 3. sql문 준비
			String sql = "select * from web_member where email = ? and pw = ?";

			psmt = conn.prepareStatement(sql);

			// 4. 바인드 변수 채우기
			psmt.setString(1, email);
			psmt.setString(2, pw);

			// 5. 실행
			rs = psmt.executeQuery();

			if (rs.next() == true) {

				String userEmail = rs.getString(1);
				String userPw = rs.getString(2);
				String userTel = rs.getString(3);
				String userAddress = rs.getString(4);

				// select문의 결과를 묶어서 VO객체로 만들기
				vo = new memberVO(userEmail, userPw, userTel, userAddress);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return vo;

	}

	// ==========================================================================================

	public int update(String email, String pw, String tel, String address) {

		// try문
		// JDBC 코드는 문법이 맞더라도 실행중 발생하는 오류처리 필요.
		try {

			connection();

			// 3. sql문 준비
			String sql = "update web_member set pw = ? , tel = ?, address = ? where email = ?";

			psmt = conn.prepareStatement(sql);

			// 4. 바인드 변수 채우기
			psmt.setString(1, pw);
			psmt.setString(2, tel);
			psmt.setString(3, address);
			psmt.setString(4, email);

			// 5. 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return cnt;
	}

//==========================================================================================

	public ArrayList<memberVO> SelectAll() {

		ArrayList<memberVO> list = new ArrayList<memberVO>();

		try {

			connection();

			// 3. sql문 준비
			String sql = "select * from web_member";

			psmt = conn.prepareStatement(sql);

			// 5. 실행
			rs = psmt.executeQuery();

			// 로그인때에는 rs에 딱 1행만 있었음 --> if문 사용
			// 모든 회원정보를 가져옴 --> 몇번 반복해야 될 지 모름
			while (rs.next() == true) {

				String userEmail = rs.getString(1);
				String userPw = rs.getString(2);
				String userTel = rs.getString(3);
				String userAddress = rs.getString(4);

				// select문의 결과를 묶어서 VO객체로 만들기
				vo = new memberVO(userEmail, userPw, userTel, userAddress);
				// rs로부터 가져온 한 행의 정보를 ArrayList에 추가
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return list;
	}

//==========================================================================================

	public int Delete(String email) {

		try {

			connection();

			// 3. sql문 준비
			String sql = "delete from web_member where email = ?";

			psmt = conn.prepareStatement(sql);

			// 4. 바인드 변수 채우기
			psmt.setString(1, email);

			// 5. 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return cnt;
	}

//==============================================================================================

	public int MsgSend(String send_name, String receive_email, String content) {

		// try문
		// JDBC 코드는 문법이 맞더라도 실행중 발생하는 오류처리 필요.
		try {

			connection();

			// 3. sql문 준비
			String sql = "insert into web_messege values (msg_num_seq.nextval,?,?,?,sysdate)";

			psmt = conn.prepareStatement(sql);

			// 4. 바인드 변수 채우기
			psmt.setString(1, send_name);
			psmt.setString(2, receive_email);
			psmt.setString(3, content);

			// 5. 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return cnt;
	}

//==================================================================================

	public ArrayList<messegeVO> selectMsg(String email) {

		ArrayList<messegeVO> messeges = new ArrayList<messegeVO>();

		try {

			connection();

			// 3. sql문 준비
			String sql = "select * from web_messege where receive_email = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, email);
			// 5. 실행
			rs = psmt.executeQuery();

			// 로그인때에는 rs에 딱 1행만 있었음 --> if문 사용
			// 모든 회원정보를 가져옴 --> 몇번 반복해야 될 지 모름
			while (rs.next() == true) {

				int bnum = rs.getInt(1);
				String send_name = rs.getString(2);
				String receive_email = email;
				String content = rs.getString(4);
				String dates = rs.getString(5);

				// select문의 결과를 묶어서 VO객체로 만들기
				mvo = new messegeVO(bnum, send_name, receive_email, content, dates);
				// rs로부터 가져온 한 행의 정보를 ArrayList에 추가
				messeges.add(mvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return messeges;
	}

//==================================================================================

	public int writeBoard(String writer, String title, String filename, String content) {

		try {

			connection();

			// 3. sql문 준비
			String sql = "insert into web_board values (board_num_seq.nextval,?,?,?,?,sysdate)";

			psmt = conn.prepareStatement(sql);

			// 4. 바인드 변수 채우기
			psmt.setString(1, writer);
			psmt.setString(2, title);
			psmt.setString(3, filename);
			psmt.setString(4, content);

			// 5. 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return cnt;
	}

//==================================================================================

	public ArrayList<boardVO> selectBoard() {

		ArrayList<boardVO> boards = new ArrayList<boardVO>();

		try {

			connection();

			// 3. sql문 준비
			String sql = "select * from web_board";

			psmt = conn.prepareStatement(sql);

			// 5. 실행
			rs = psmt.executeQuery();

			// 로그인때에는 rs에 딱 1행만 있었음 --> if문 사용
			// 모든 회원정보를 가져옴 --> 몇번 반복해야 될 지 모름
			while (rs.next() == true) {

				// 글번호 작성자 제목 파일이름 내용 날짜

				int num = rs.getInt(1);
				String writer = rs.getString(2);
				String title = rs.getString(3);
				String filename = rs.getString(4);
				String content = rs.getString(5);
				String day = rs.getString(6);

				bvo = new boardVO(num, writer, title, filename, content, day);

				boards.add(bvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return boards;
	}

//========================================================================

	public boardVO SelectOne(int num) {

		boardVO bvo = null;

		try {

			connection();

			// 3. sql문 준비
			String sql = "select * from web_board where num = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, num);
			// 5. 실행
			rs = psmt.executeQuery();

			// 로그인때에는 rs에 딱 1행만 있었음 --> if문 사용
			// 모든 회원정보를 가져옴 --> 몇번 반복해야 될 지 모름
			if (rs.next() == true) {

				// 글번호 작성자 제목 파일이름 내용 날짜

				int bnum = rs.getInt(1);
				String writer = rs.getString(2);
				String title = rs.getString(3);
				String filename = rs.getString(4);
				String content = rs.getString(5);
				String day = rs.getString(6);

				bvo = new boardVO(bnum, writer, title, filename, content, day);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}

		return bvo;
	}
//========================================================================

	public int DeleteMsg(int bnum) {

		try {

			connection();

			// 3. sql문 준비
			String sql = "delete from web_messege where bnum = ?";

			psmt = conn.prepareStatement(sql);

			// 4. 바인드 변수 채우기
			psmt.setInt(1, bnum);

			// 5. 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫아주기
			close();
		}
		return cnt;
	}

//========================================================================	

}
