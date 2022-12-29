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


@WebServlet("/member/removeMember")
public class RemoveMemberController extends HttpServlet {
	private MemberService memberService;
    
	// Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 후에만 접근가능
		HttpSession session = request.getSession();

		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		
		request.setAttribute("nowPage", "member");
		// view -> /WEB-INF/view/member/removeMember.jsp
		request.getRequestDispatcher("/WEB-INF/view/member/removeMemberForm.jsp").forward(request, response);
	}

	// Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		this.memberService = new MemberService();
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		if(memberService.deleteMemberService(member) != 1) { // 1) 회원 삭제
			System.out.println("회원탈퇴 실패");
			response.sendRedirect(request.getContextPath()+"/member/removemember");
			return;
		}
		
		System.out.println("회원탈퇴 성공");
		// 2) redirect -> /member/logout
		response.sendRedirect(request.getContextPath()+"/member/logout");
	}
}
