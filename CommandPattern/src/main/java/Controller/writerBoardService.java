package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.DAO;
import Model.boardVO;


@WebServlet("/writerBoardService")
public class writerBoardService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.getServletContext();
		// workspace -> 아파치 톰캣 업로드(폴더들의 위치들이 바뀜)
		// 저장할 경로
		
		String savePath = request.getServletContext().getRealPath("img");
		
		// 최대 파일 크기 (단위 : byte) : 5mb
		int maxSize = 5*1024*1024;
		// 인코딩 타입.
		String encoding = "euc-kr";
		
		// request를 대신해서 받아온 데이터를 정제해줄 MultipartRequest 객체.
		
		MultipartRequest multi = new MultipartRequest(request,
                savePath,
                maxSize,
                encoding,
                new DefaultFileRenamePolicy());

		
		// 파라미터 수집
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		// 파일을 가져올 때는 getFilesystemName("name값.")
		String filename = multi.getFilesystemName("file");
		String content = multi.getParameter("content");
		
		// DAO메소드 사용 web_board테이블에 저장
		DAO dao = new DAO();
		
		// 메소드 사용
		int cnt = dao.writeBoard(writer, title, filename, content);
		
		if(cnt > 0) {
			System.out.println("게시글 작성 완료.");
			
			// 1. request의 영역에 file의 정보를 가지고 이동 -> VO를 이용하여 묶음
			// 기존의 BoardVO 생성자는 매개변수로 6가지를 모드 받았음
			// 지금 담아갈것은 4가지 밖에 없음 --> 생성자 메소드를 만들어주면 됨.
			request.setAttribute("bvo", new boardVO( writer, title, filename, content));
			
			// request영역에 데이터를 저장해서 이동하려면 >> forward방식
			RequestDispatcher rd = request.getRequestDispatcher("viewBoard.jsp");
			rd.forward(request, response);
			
		} else {
			System.out.println("게시글 작성 실패.");
		}
	}

}
