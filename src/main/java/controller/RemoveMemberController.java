package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveMemberController
 */
@WebServlet("/RemoveMemberController")
public class RemoveMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view -> /WEB-INF/view/member/removeMember.jsp
	}

	// Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 회원 삭제
		// 2) redirect -> /member/logout
	}

}
