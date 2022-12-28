package dao;

import java.sql.*;
import java.util.*;

import vo.Board;

public class BoardDao {
	
	// 1) BOARDLIST 조회
	public ArrayList<Board> selectBoardListDao(Connection conn, int beginRow, int endRow) throws Exception {
		ArrayList<Board> resultBoardList = new ArrayList<Board>();
		
		String sql = "SELECT board_no boardNo, board_title boardTitle, member_id memberId, updatedate, createdate"
				+ " FROM (SELECT rownum rnum, board_no, board_title, member_id, updatedate, createdate"
				+ "		FROM (SELECT board_no, board_title, member_id, updatedate, createdate"
				+ "			FROM board ORDER BY board_no DESC))"
				+ " WHERE rnum BETWEEN ? AND ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()) {
			Board board = new Board();
			board.setBoardNo(rs.getInt("boardNo"));
			board.setBoardTitle(rs.getString("boardTitle"));
			board.setMemberId(rs.getString("memberId"));
			board.setUpdatedate(rs.getString("updatedate"));
			board.setCreatedate(rs.getString("createdate"));
			
			resultBoardList.add(board);
		}
		
		return resultBoardList;
	}
	
	// 2) BOARDONE 조회
	public Board selectBoardOneDao(Connection conn, int boardNo) throws Exception {
		Board resultBoard = null;
		
		String sql = "SELECT board_no boardNo, board_title boardTitle, board_content boardContent, member_id memberId, updatedate, createdate"
				+ " FROM board";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			resultBoard = new Board();
			resultBoard.setBoardNo(rs.getInt("boardNo"));
			resultBoard.setBoardTitle(rs.getString("boardTitle"));
			resultBoard.setBoardContent(rs.getString("boardContent"));
			resultBoard.setMemberId(rs.getString("memberId"));
			resultBoard.setUpdatedate(rs.getString("updatedate"));
			resultBoard.setCreatedate(rs.getString("createdate"));
		}
		return resultBoard;
	}
	
	// 3) INSERTBOARD
	public int insertBoardDao(Connection conn, Board board) throws Exception {
		int resultLow = 0;
		
		String sql = "INSERT INTO"
				+ " board (board_no, board_title, board_content, member_id, updatedate, createdate)"
				+ " VALUES (board_seq.nextval, ?, ?, ?, sysdate, sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());
		
		resultLow = stmt.executeUpdate();
		return resultLow;
	}
	
	// 4) UPDATEBOARD
	public int updateBoardDao(Connection conn, Board board) throws Exception {
		int resultLow = 0;
		
		String sql = "UPDATE board SET board_title = ?, board_content = ?, updatedate = sysdate"
				+ " WHERE board_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		System.out.println(board.getBoardTitle());
		System.out.println(board.getBoardContent());
		System.out.println(board.getBoardNo());
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setInt(3, board.getBoardNo());
		
		resultLow = stmt.executeUpdate();
		return resultLow;
	}
	
	// 5) DELETEBOARD
	public int deleteBoardDao(Connection conn, Board board) throws Exception {
		int resultLow = 0;
		
		String sql = "DELETE"
				+ " FROM board"
				+ " WHERE board_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, board.getBoardNo());
		stmt.setString(2, board.getMemberId());
		
		resultLow = stmt.executeUpdate();
		return resultLow;
	}
}
