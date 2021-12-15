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
		// workspace -> ����ġ ��Ĺ ���ε�(�������� ��ġ���� �ٲ�)
		// ������ ���
		
		String savePath = request.getServletContext().getRealPath("img");
		
		// �ִ� ���� ũ�� (���� : byte) : 5mb
		int maxSize = 5*1024*1024;
		// ���ڵ� Ÿ��.
		String encoding = "euc-kr";
		
		// request�� ����ؼ� �޾ƿ� �����͸� �������� MultipartRequest ��ü.
		
		MultipartRequest multi = new MultipartRequest(request,
                savePath,
                maxSize,
                encoding,
                new DefaultFileRenamePolicy());

		
		// �Ķ���� ����
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		// ������ ������ ���� getFilesystemName("name��.")
		String filename = multi.getFilesystemName("file");
		String content = multi.getParameter("content");
		
		// DAO�޼ҵ� ��� web_board���̺� ����
		DAO dao = new DAO();
		
		// �޼ҵ� ���
		int cnt = dao.writeBoard(writer, title, filename, content);
		
		if(cnt > 0) {
			System.out.println("�Խñ� �ۼ� �Ϸ�.");
			
			// 1. request�� ������ file�� ������ ������ �̵� -> VO�� �̿��Ͽ� ����
			// ������ BoardVO �����ڴ� �Ű������� 6������ ��� �޾���
			// ���� ��ư����� 4���� �ۿ� ���� --> ������ �޼ҵ带 ������ָ� ��.
			request.setAttribute("bvo", new boardVO( writer, title, filename, content));
			
			// request������ �����͸� �����ؼ� �̵��Ϸ��� >> forward���
			RequestDispatcher rd = request.getRequestDispatcher("viewBoard.jsp");
			rd.forward(request, response);
			
		} else {
			System.out.println("�Խñ� �ۼ� ����.");
		}
	}

}
