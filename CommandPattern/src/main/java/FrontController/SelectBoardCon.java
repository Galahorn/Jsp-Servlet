package FrontController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.boardVO;

public class SelectBoardCon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			
			//1. �Ķ���� ����.
			int num = Integer.parseInt(request.getParameter("num"));
			
			//2. DAO��ü����.
			DAO dao = new DAO();
			
			//3. DAO �޼ҵ� ���. BoardVO �޾ƿ���
			boardVO bvo = dao.SelectOne(num);
			
			//4. BoardVO�� request�� ������ �����ϰ�
			request.setAttribute("bvo", bvo);
			
			//5. Forward������� viewBoard�� ������.
			RequestDispatcher rd = request.getRequestDispatcher("viewBoard.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			
		}

	}

}
