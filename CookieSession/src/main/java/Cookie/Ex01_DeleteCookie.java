package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01_DeleteCookie")
public class Ex01_DeleteCookie extends HttpServlet {
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. ��Ű ��ü �����
		Cookie cookie = new Cookie("first_cookie", "first_cookie");
		//������ ��Ű�� ���� �� ���ڿ��� ����.
		Cookie cookie2 = new Cookie("second_cookie", "");
		
		// 2. ��ȿ�Ⱓ ����
		//setMaxAge((int)�� ���� ��ȿ�Ⱓ.)
		cookie.setMaxAge(60*60*24*365);
		//���� ���������� ������ session���� ǥ�õǰ� ������ ����� �����ȴ�.
		
		// ����
		cookie2.setMaxAge(0);
		
		// ���信 ��Ű �߰�
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		// ������ �̵�
		response.sendRedirect("Ex01_SelectCookie.jsp");
	}

}
