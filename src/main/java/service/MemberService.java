package service;

import java.sql.*;

import dao.MemberDao;
import util.DBUtil;
import vo.Member;

public class MemberService {
	private DBUtil dbUtil;
	private MemberDao memberDao;
	
	// 1) 로그인 service
	public Member loginService(Member member) {
		Member resultMember = null;
		
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			resultMember = memberDao.loginDao(conn, member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultMember;
	}
	
	// 2) 회원가입 service
	public int insertMemberService(Member member) {
		int resultRow = 0;
		
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			resultRow = memberDao.insertMemberDao(conn, member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultRow;
	}
	
	// 3) 회원수정 service
	public int updateMemberService(Member member) {
		int resultRow = 0;
		
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			resultRow = memberDao.updateMemberDao(conn, member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultRow;
	}
	// 4) 회원삭제 service
	public int deleteMemberService(Member member) {
		int resultRow = 0;
		
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			resultRow = memberDao.deleteMemberDao(conn, member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultRow;
	}
}
