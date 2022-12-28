package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

@WebServlet("/board/modifyBoard")
public class ModifyBoardController extends HttpServlet {
	private BoardService boardService;
	
	// Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 유효성 검사
		
				int boardNo = Integer.parseInt(request.getParameter("boardNo"));
				
				this.boardService = new BoardService();
				Board board = boardService.selectBoardOneService(boardNo);
				
				request.setAttribute("board", board);
				
				request.getRequestDispatcher("WEB-INF/view/updateBoardForm.jsp").forward(request, response);
	}

	// Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		this.boardService = new BoardService();
		
		if(boardService.updateBoardService(board) != 1) {
			System.out.println("수정 실패");
			request.getRequestDispatcher("/UpdateBoardFormController").forward(request, response);
			return;
		}
		
		System.out.println("수정 성공");
		request.getRequestDispatcher("/BoardOneController").forward(request, response);
	}

}
