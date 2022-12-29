package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

@WebServlet("/board/boardList")
public class BoardListController extends HttpServlet {
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.boardService = new BoardService();
		
		// 로그인 유효성 검사
		HttpSession session = request.getSession();
		
		// 로그인 여부확인, 로그인 되어있을 경우 회원페이지로 이동
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null) {
			String target = request.getContextPath()+"/home";
			response.sendRedirect(target);
			return;
		}
		
		// 현재 페이지
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이지당 노출할 게시글 개수
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		// 총 게시글 개수
		int boardListRow = 0;
		// boardList
		ArrayList<Board> boardList = null;

		String searchWord = request.getParameter("searchWord");
		if(searchWord != null) { // 검색어가 있을 경우
			boardListRow = boardService.getBoardListRowService(searchWord);
			boardList = boardService.selectBoardListService(currentPage, rowPerPage, searchWord);
		} else { // 검색어가 없을 경우
			boardListRow = boardService.getBoardListRowService();
			boardList = boardService.selectBoardListService(currentPage, rowPerPage);
		}
		
		// 마지막 페이지
		int endPage = boardListRow / rowPerPage + 1;
		if(boardListRow % rowPerPage == 0) {
			endPage--;
		}
		
		System.out.println("rowPerPage :" + rowPerPage);
		System.out.println("currentPage : " + currentPage);
		System.out.println("endPage : " + endPage);
		System.out.println("boardListRow : " + boardListRow);

		request.setAttribute("boardList", boardList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("searchWord", searchWord);
		
		request.setAttribute("nowPage", "board");
		request.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(request, response);
		
	}
}
