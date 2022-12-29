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


@WebServlet("/board/removeBoard")
public class RemoveBoardController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String memberId= member.getMemberId();
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setMemberId(memberId);
		
		this.boardService = new BoardService();
		
		if(boardService.deleteBoardService(board) != 1) {
			System.out.println("삭제 실패");
			request.getRequestDispatcher("/board/boardOne").forward(request, response);
			return;
		}
		
		System.out.println("삭제 성공");
		request.getRequestDispatcher("/board/boardList").forward(request, response);
	}
}
