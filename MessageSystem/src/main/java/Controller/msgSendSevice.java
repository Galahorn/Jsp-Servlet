package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.messegeVO;
import Model.memberVO;

@WebServlet("/msgSendSevice")
public class msgSendSevice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 받아올 파라미터들을 인코딩.
		request.setCharacterEncoding("euc-kr");

		// 1. 파라미터 수집	
		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");
		
		
		DAO dao = new DAO();
		
		//DAO의 join메소드 사용
		int cnt = dao.MsgSend(send_name, receive_email, content);
		
		if (cnt > 0) {
			System.out.println("메세지 전송 성공.");
		
		} else {
			System.out.println("메세지 전송 실패.");
			
		}
		response.sendRedirect("main.jsp");

	}

}
