package FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	// 추상메소드만 생성가능.
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
