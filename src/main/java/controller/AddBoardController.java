package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

@WebServlet("/board/addBoard")
public class AddBoardController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 유효성 검사
		
		request.getRequestDispatcher("/WEB-INF/view/insertBoardForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
