package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class AddMemberController
 */
@WebServlet("/member/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	
	// 회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 전에만 접근가능
		HttpSession session = request.getSession();
		
		// 로그인 여부확인, 로그인 되어있을 경우 회원페이지로 이동
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember != null) {
			String target = request.getContextPath()+"/home";
			response.sendRedirect(target);
			return;
		}
		
		// view -> /WEB-INF/view/member/addMember.jsp
		request.setAttribute("nowPage", "addMember");
		request.getRequestDispatcher("/WEB-INF/view/member/addMemberForm.jsp").forward(request, response);
	}

	// 회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		this.memberService = new MemberService();
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		System.out.println(memberId);
		System.out.println(memberPw);
		System.out.println(memberName);
		if(memberService.insertMemberService(member) != 1) {
			System.out.println("회원가입 실패");
			response.sendRedirect(request.getContextPath()+"/member/addmember");
			return;
		}
		
		System.out.println("회원가입 성공");
		response.sendRedirect(request.getContextPath()+"/home");
	}

}
