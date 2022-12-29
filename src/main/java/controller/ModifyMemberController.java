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


@WebServlet("/member/modifyMember")
public class ModifyMemberController extends HttpServlet {
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
		
		// view -> /WEB-INF/view/member/modifyMemberForm.jsp
		request.getRequestDispatcher("/WEB-INF/view/member/modifyMemberForm.jsp").forward(request, response);
	}

	// Action
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
		
		if(memberService.updateMemberService(member) != 1) {
			System.out.println("회원수정 실패");
			response.sendRedirect(request.getContextPath()+"/member/modifymember");
			return;
		}
		
		System.out.println("회원수정 성공");
		
		// 변경된 회원의 정보르 새로 세션에 저장하기위함
		HttpSession session = request.getSession();
		Member loginMember = memberService.loginService(member);
		session.setAttribute("loginMember", loginMember);
		
		response.sendRedirect(request.getContextPath()+"/member/memberOne");
	}

}
