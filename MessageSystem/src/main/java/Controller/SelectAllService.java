package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.memberVO;


@WebServlet("/SelectAllService")
public class SelectAllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. DAO객체 생성
		DAO dao = new DAO();
		
		
		// 2. DAO가 가진 SelectAll() --> 회원정보를 전부 가지고 올 것.
		// 한 행이 아니라 몇 행인지 알 수없음 -> while문 사용
		// 회원 하나하나의 정보를 묶기 위해 memberVO객체를 ArrayList<memberVO> 이름 = new ArrayList();
		// 정보 추가 ArrayList.add(추가할 데이터)
		// SelectAll()은 ArrayList<memberVO>
		ArrayList<memberVO> list = dao.SelectAll();
		
		//System.out.println(list.size());
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
		rd.forward(request, response);

		
		
	}

}
