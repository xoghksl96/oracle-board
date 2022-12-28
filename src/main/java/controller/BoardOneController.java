package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

@WebServlet("/BoardOneController")
public class BoardOneController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 메뉴구성
		 * 1) 글 수정 (로그인 멤버 == 글 쓴 멤버)
		 * 2) 글 삭제 (로그인 멤버 == 글 쓴 멤버)
		 * */
		// 로그인 유효성 검사
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		this.boardService = new BoardService();
		Board board = boardService.selectBoardOneService(boardNo);
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("WEB-INF/view/boardOne.jsp").forward(request, response);
	}
}
