package dao;

import java.sql.*;
import java.util.*;

import oracle.jdbc.proxy.annotation.Pre;
import vo.Board;

public class BoardDao {
	
	// 1-1) BOARDLIST 조회(검색어 X)
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
		
		rs.close();
		stmt.close();
		return resultBoardList;
	}
	
	// 1-2) BOARDLIST 조회(검색어 O)
	public ArrayList<Board> selectBoardListDao(Connection conn, int beginRow, int endRow, String searchWord) throws Exception {
		ArrayList<Board> resultBoardList = new ArrayList<Board>();
		System.out.println("검색어 : " + searchWord);
		String sql = "SELECT board_no boardNo, board_title boardTitle, member_id memberId, updatedate, createdate"
				+ " FROM (SELECT rownum rnum, board_no, board_title, member_id, updatedate, createdate"
				+ "		FROM (SELECT board_no, board_title, member_id, updatedate, createdate"
				+ "			FROM board"
				+ "			ORDER BY board_no DESC))"
				+ " WHERE rnum BETWEEN ? AND ? AND board_title LIKE ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		stmt.setString(3, "%"+searchWord+"%");
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
		
		rs.close();
		stmt.close();
		return resultBoardList;
	}
	
	// 2) BOARDONE 조회
	public Board selectBoardOneDao(Connection conn, int boardNo) throws Exception {
		Board resultBoard = null;
		
		String sql = "SELECT board_no boardNo, board_title boardTitle, board_content boardContent, member_id memberId, updatedate, createdate"
				+ " FROM board"
				+ " WHERE board_no = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);

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
		
		rs.close();
		stmt.close();
		return resultBoard;
	}
	
	// 3) INSERTBOARD
	public int insertBoardDao(Connection conn, Board board) throws Exception {
		int resultRow = 0;
		
		String sql = "INSERT INTO"
				+ " board (board_no, board_title, board_content, member_id, updatedate, createdate)"
				+ " VALUES (board_seq.nextval, ?, ?, ?, sysdate, sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());
		
		resultRow = stmt.executeUpdate();
		stmt.close();
		return resultRow;
	}
	
	// 4) UPDATEBOARD
	public int updateBoardDao(Connection conn, Board board) throws Exception {
		int resultRow = 0;
		
		String sql = "UPDATE board SET board_title = ?, board_content = ?, updatedate = sysdate"
				+ " WHERE board_no = ? AND member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setInt(3, board.getBoardNo());
		stmt.setString(4, board.getMemberId());
		
		resultRow = stmt.executeUpdate();
		stmt.close();
		return resultRow;
	}
	
	// 5) DELETEBOARD
	public int deleteBoardDao(Connection conn, Board board) throws Exception {
		int resultRow = 0;
		
		String sql = "DELETE"
				+ " FROM board"
				+ " WHERE board_no = ? AND member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, board.getBoardNo());
		stmt.setString(2, board.getMemberId());
		
		resultRow = stmt.executeUpdate();
		stmt.close();
		return resultRow;
	}
	
	// 6) boardList 개수 구하기
	
	// 6-1) 검색어 X
	public int getBoardListRowDao(Connection conn) throws Exception {
		int resultRow = 0;
		
		String sql = "SELECT COUNT(*)"
				+ " FROM board";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			resultRow = rs.getInt("COUNT(*)");
		}
		
		rs.close();
		stmt.close();
		return resultRow;
	}
	// 6-2) 검색어 O
	public int getBoardListRowDao(Connection conn, String searchWord) throws Exception {
		int resultRow = 0;
		
		String sql = "SELECT COUNT(*)"
				+ " FROM board"
				+ " WHERE board_title LIKE ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+searchWord+"%");
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			resultRow = rs.getInt("COUNT(*)");
		}
		
		rs.close();
		stmt.close();
		return resultRow;
	}
}
