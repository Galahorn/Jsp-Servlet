package FrontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *.do : ~~~.do로 끝나기만 하면 앞에 어떤게 오든 모든 요청을 여기서 받는다.
@WebServlet("*.do")
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 들어온 요청을 구분하고, 각각의 객체의 실행 메서드를 사용
		// 먼저 전체 URI가 필요
		// http://localhost:8082/CommandPattern/Login.do
		String requestURI = request.getRequestURI();
		
		// ContextPath 가져오기.
		// http://localhost:8082/CommandPattern
		String contextPath = request.getContextPath();
		
		// String 메소드 사용 substring(); 사용 : 문자열을 슬라이싱
		// substring( int타입 index )
		// 결과적으로 /Login.do만 남게됨.
		String command = requestURI.substring(contextPath.length());
		
		System.out.println(command);
		
		// if문을 이용해서 실행
		// 실행을 위해서 객체 생성.
		Command exe = null;
		
		if(command.equals("/Login.do")) {
			// interface <-- LoginCon (업캐스팅)
			exe = new LoginCon();
		} else if(command.equals("/Join.do")) {
			//회원 가입
			exe = new JoinCon();
		} else if(command.equals("/SelectBoard.do")) {
			exe = new SelectBoardCon();
		} else if(command.equals("/DeleteMsg.do")) {
			exe = new DeleteMsgCon();
		}
		
		// 공통으로 주어진 실행메서드를 실행
		exe.execute(request, response);
	}

}
