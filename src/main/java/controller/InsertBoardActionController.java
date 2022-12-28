package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

@WebServlet("/InsertBoardActionController")
public class InsertBoardActionController extends HttpServlet {
	private BoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		this.boardService = new BoardService();
		
		if(boardService.insertBoardService(board) != 1) {
			System.out.println("삽입 실패");
			request.getRequestDispatcher("/InsertBoardFormController").forward(request, response);
			return;
		}
		
		System.out.println("삽입 성공");
		request.getRequestDispatcher("/BoardListController").forward(request, response);
	}
}
