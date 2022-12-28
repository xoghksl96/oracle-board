package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyMemberController
 */
@WebServlet("member/modifyMember")
public class ModifyMemberController extends HttpServlet {

	// Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view -> /WEB-INF/view/member/modifyMember.jsp
	}

	// Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// redirect ->  /member/memberOne?키값
	}

}
