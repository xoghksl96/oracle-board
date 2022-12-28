package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;


@WebServlet("/board/removeBoard")
public class RemoveBoardController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		
		this.boardService = new BoardService();
		
		if(boardService.deleteBoardService(board) != 1) {
			System.out.println("삭제 실패");
			request.getRequestDispatcher("/BoardOneController").forward(request, response);
			return;
		}
		
		System.out.println("삭제 성공");
		request.getRequestDispatcher("/BoardListController").forward(request, response);
	}
}
