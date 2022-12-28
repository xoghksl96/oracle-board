package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;


@WebServlet("/UpdateBoardFormController")
public class UpdateBoardFormController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 유효성 검사
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		this.boardService = new BoardService();
		Board board = boardService.selectBoardOneService(boardNo);
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("WEB-INF/view/updateBoardForm.jsp").forward(request, response);
	}
}
