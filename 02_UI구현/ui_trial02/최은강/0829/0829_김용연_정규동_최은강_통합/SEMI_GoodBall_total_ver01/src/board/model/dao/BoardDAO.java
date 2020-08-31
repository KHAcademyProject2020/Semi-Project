package board.model.dao;

import java.io.FileNotFoundException;
import static common.JDBCTemplate.close;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Board;

public class BoardDAO {

	private Properties prop = new Properties();

	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Board> selectBoardList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> boardList = null;
		
		String query= prop.getProperty("selectBoardList");
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			
			boardList= new ArrayList<Board>();
			while(rset.next()) {
				Board board=new Board(
					rset.getInt("BOARD_NUM"),
					rset.getString("BOARD_WRITER"),
					rset.getString("WRITER_EMAIL"),
					rset.getString("BOARD_TITLE"),
					rset.getString("BOARD_CONTENT"),
					rset.getString("BOARD_IMG"),
					rset.getDate("BOARD_DATE"),
					rset.getString("BOARD_DELETE_STATUS"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return boardList;
	}

}
