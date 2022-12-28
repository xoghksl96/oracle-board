package dao;

import java.sql.*;

import vo.Member;

public class MemberDao {
	// 1) 로그인 dao
	public Member loginDao(Connection conn, Member member) throws Exception {
		Member resultMember = null;
		
		String sql = "SELECT member_id memberId, member_name memberName"
				+ " FROM member"
				+ " WHERE member_id = ? AND member_pw = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberName(rs.getString("memberName"));
		}
		
		rs.close();
		stmt.close();
		return resultMember;
	}
	
	// 2) 회원가입 dao
	public int insertMemberDao(Connection conn, Member member) throws Exception {
		int resultLow = 0;
		
		String sql = "INSERT INTO"
				+ " member (member_id, member_pw, member_name, updatedate, createdate)"
				+ " VALUES (?,?,?,sysdate,sysdate)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.setString(3, member.getMemberName());
		
		resultLow = stmt.executeUpdate();
		return resultLow; // 0 반환 -> 회원가입 실패, 1반환 -> 회원가입 성공
	}
	
	// 3) 회원 정보 수정 dao
	public int updateMemberDao(Connection conn, Member member) throws Exception {
		int resultLow = 0;
		
		String sql = "UPDATE member SET"
				+ " member_name = ?, updatedate = sysdate"
				+ " WHERE member_id = ? AND member_pw = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberName());
		stmt.setString(2, member.getMemberId());
		stmt.setString(3, member.getMemberPw());
		
		resultLow = stmt.executeUpdate();
		return resultLow; // 0 반환 -> 회원수정 실패, 1반환 -> 회원수정 성공
	}
	
	// 4) 회원 삭제 dao
	public int deleteMemberDao(Connection conn, Member member) throws Exception {
		int resultLow = 0;
		
		String sql = "DELETE"
				+ " FROM member"
				+ " WHERE member_id = ? AND member_pw = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		
		resultLow = stmt.executeUpdate();
		return resultLow; // 0 반환 -> 회원삭제 실패, 1반환 -> 회원삭제 성공
	}
}
