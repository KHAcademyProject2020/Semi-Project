package board.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Board;

public class BoardService {

	public ArrayList<Board> selectBoardList() {
		Connection conn= getConnection();
		ArrayList<Board> boardList= new BoardDAO().selectBoardList(conn);
		close(conn);
		return boardList;
	
	}

}
