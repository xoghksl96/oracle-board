package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Board;

/**
 * Servlet implementation class InsertBoardFormController
 */
@WebServlet("/InsertBoardFormController")
public class InsertBoardFormController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 유효성 검사
		
		request.getRequestDispatcher("/WEB-INF/view/insertBoardForm.jsp").forward(request, response);
	}
}
