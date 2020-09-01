package board.model.service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.BoardAttachment;

public class BoardService {

	public ArrayList<Board> selectBoardList() {
		Connection conn= getConnection();
		ArrayList<Board> boardList= new BoardDAO().selectBoardList(conn);
		close(conn);
		return boardList;
	
	}

	public int insertBoard(Board board, ArrayList<BoardAttachment> fileList) {
		Connection conn =getConnection();
		BoardDAO dao= new BoardDAO();
		
		// 글만등록하기.
		int result1=dao.insertThread(conn, board);
		int result2=0;
		
		if(fileList==null && board.getBoardImgPath()==null) {
			//이미지 등록안한 상태
			if(result1>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			return result1;
			
		}else{
			//이미지 등록상태- board.getBoardImgPath()!=null
			result2=dao.insertBoardAttachment(conn, fileList);
			if(result1>0 && result2>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}
		return result2;
	}

}
