package FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	// �߻�޼ҵ常 ��������.
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
