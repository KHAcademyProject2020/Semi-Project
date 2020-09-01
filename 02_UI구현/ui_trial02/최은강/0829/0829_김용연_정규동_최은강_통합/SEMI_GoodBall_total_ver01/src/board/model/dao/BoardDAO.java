package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Board;
import board.model.vo.BoardAttachment;

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

	public int insertThread(Connection conn, Board board) {
		PreparedStatement pstmt=null;
		int result=0;
		String query=prop.getProperty("insertBoard");
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardWriterEmail());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3,  board.getBoardContent());
			pstmt.setString(4,  board.getBoardImgPath());
			pstmt.setString(5,board.getBoardWriter());
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBoardAttachment(Connection conn, ArrayList<BoardAttachment> fileList) {
		int result=0;
		PreparedStatement pstmt= null;
		
		String query= prop.getProperty("insertBoardAttachment");
		try {
			for(int i=0; i<fileList.size(); i++) {
				BoardAttachment bat= fileList.get(i);
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, bat.getOriginName());
				pstmt.setString(2, bat.getChangeName());
				pstmt.setString(3, bat.getFilePath());
				
				result+= pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
