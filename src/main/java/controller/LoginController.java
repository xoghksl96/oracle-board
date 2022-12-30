package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	// Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view -> /WEB-INF/view/member/addMember.jsp
		
		// 로그인 전에만 접근가능
		HttpSession session = request.getSession();
		
		// 로그인 여부확인, 로그인 되어있을 경우 회원페이지로 이동
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember != null) {
			String target = request.getContextPath()+"/home";
			response.sendRedirect(target);
			return;
		}
		
		// 로그인 폼 View
		request.setAttribute("nowPage", "login");
		request.getRequestDispatcher("/WEB-INF/view/member/loginForm.jsp").forward(request, response);
	}

	// Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.memberService = new MemberService();
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		Member loginMember = memberService.loginService(member);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginMember);
		
		String message = "로그인 성공!";
		message = URLEncoder.encode(message, "UTF-8");
		response.sendRedirect(request.getContextPath()+"/home?message="+message);
		// redirect -> /home
		// 로그인 세션 정보 : session.setAttribute("loginMember", Member타입)
	}

}
