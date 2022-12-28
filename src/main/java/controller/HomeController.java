package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 메뉴 구성 (로그인 전/후 따라 분기)
		// 로그인 전
		// 1) 회원가입
		// 2) 로그인
		
		// 로그인 후
		// 1) 로그아웃
		// 2) 회원정보 상세보기
		// 3) 게시판 리스트
		// forward -> /WEB-INF/view/home.jsp
	}
}
