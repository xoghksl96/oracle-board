package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BoardDao;
import util.DBUtil;
import vo.Board;

public class BoardService {
	private BoardDao boardDao;
	
	// 1-1) boardList 조회 Service (검색어 X)
	public ArrayList<Board> selectBoardListService(int currentPage, int rowPerPage) {
		ArrayList<Board> resultBoardList = null;
		Connection conn = null;
		
		try {
			int beginRow = (currentPage-1)*rowPerPage+1;
			int endRow = beginRow + rowPerPage - 1;
			
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			resultBoardList = boardDao.selectBoardListDao(conn, beginRow, endRow);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return resultBoardList;
	}
	
	// 1-2) boardList 조회 Service (검색어 X)
		public ArrayList<Board> selectBoardListService(int currentPage, int rowPerPage, String searchWord) {
			ArrayList<Board> resultBoardList = null;
			Connection conn = null;
			
			try {
				int beginRow = (currentPage-1)*rowPerPage+1;
				int endRow = beginRow + rowPerPage - 1;
				
				conn = DBUtil.getConnection();
				boardDao = new BoardDao();
				resultBoardList = boardDao.selectBoardListDao(conn, beginRow, endRow, searchWord);
				conn.commit();
			} catch (Exception e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return resultBoardList;
		}
		
	// 2) boardOne 조회 Service
	public Board selectBoardOneService(int boardNo) {
		Board resultBoard = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			resultBoard = boardDao.selectBoardOneDao(conn, boardNo);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return resultBoard;
	}
	
	// 3) board 삽입 Service
	public int insertBoardService(Board board) {
		int resultRow = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			resultRow = boardDao.insertBoardDao(conn, board);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultRow;
	}
	
	// 4) board 수정 Service
	public int updateBoardService(Board board) {
		int resultRow = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			resultRow = boardDao.updateBoardDao(conn, board);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultRow;
	}
	
	// 5) board 삭제 Service
	public int deleteBoardService(Board board) {
		int resultRow = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			resultRow = boardDao.deleteBoardDao(conn, board);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultRow;
	}
	
	// 6) getBoardListRowService
	
	// 6-1) 검색어 X
	public int getBoardListRowService() {
		int resultRow = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			resultRow = boardDao.getBoardListRowDao(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultRow;
	}
	
	// 6-2) 검색어 O
	public int getBoardListRowService(String searchWord) {
		int resultRow = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			boardDao = new BoardDao();
			resultRow = boardDao.getBoardListRowDao(conn, searchWord);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultRow;
	}
	
}
