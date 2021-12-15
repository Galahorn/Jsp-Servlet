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
		
		// 1. DAO��ü ����
		DAO dao = new DAO();
		
		
		// 2. DAO�� ���� SelectAll() --> ȸ�������� ���� ������ �� ��.
		// �� ���� �ƴ϶� �� ������ �� ������ -> while�� ���
		// ȸ�� �ϳ��ϳ��� ������ ���� ���� memberVO��ü�� ArrayList<memberVO> �̸� = new ArrayList();
		// ���� �߰� ArrayList.add(�߰��� ������)
		// SelectAll()�� ArrayList<memberVO>
		ArrayList<memberVO> list = dao.SelectAll();
		
		//System.out.println(list.size());
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
		rd.forward(request, response);

		
		
	}

}
