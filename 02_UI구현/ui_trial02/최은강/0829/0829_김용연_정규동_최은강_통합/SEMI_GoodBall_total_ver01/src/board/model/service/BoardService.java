package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.BoardAttachment;
import board.model.vo.PageInfo;

public class BoardService {

	public ArrayList<Board> selectBoardList(PageInfo pi) {
		Connection conn= getConnection();
		ArrayList<Board> boardList= new BoardDAO().selectBoardList(conn, pi);
		if(boardList!=null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return boardList;
	
	}


	public int getBoardListCount() {
		Connection conn=getConnection();
		int result=new BoardDAO().getBoardListCount(conn);
		
		close(conn);
		return result;
	}
	
	public Board selectBoard(int bId) {
		// bId에 해당하는 공지사항 게시글정보를 갖고온다.
		Connection conn=getConnection();
		
		Board board=null;
		board=new BoardDAO().selectBoard(conn, bId);
		close(conn);
		return board;
	}
	

	public BoardAttachment selectBoardAttachment(int bId) {
		// bId에 해당하는 공지사항 게시글 이미지 정보를 갖고온다.
		Connection conn=getConnection();
		BoardAttachment boardImgAttach=null;
		
		boardImgAttach=new BoardDAO().selectBoardAttachment(conn, bId);
		close(conn);
		return boardImgAttach; 
	}


	public ArrayList<Board> selectList() {
		Connection conn= getConnection();
		ArrayList<Board> list= new BoardDAO().selectList(conn);
		close(conn);
		return list;
	}
	
	

	public int insertBoard(Board board, ArrayList<BoardAttachment> fileList) {
		Connection conn =getConnection();
		BoardDAO dao= new BoardDAO();
		
		// 글만등록하기.
		int result1=dao.insertThread(conn, board);
		int result2=0;
		
		if(board.getBoardImgPath()==null) {
			System.out.println("BoardService(이미지없음) => "+ board);
			//이미지 등록안한 상태
			if(result1>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			return result1;
			
		}else{
			//이미지 등록상태- board.getBoardImgPath()!=null
			System.out.println("BoardService(이미지있음) => "+ board);
			System.out.println("fileList=> "+ fileList);
			result2=dao.insertBoardAttachment(conn, fileList);
			if(result1>0 && result2>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
		}
		return result2;
	}
	

	public int updateBoard(Board board, int bId, BoardAttachment bat) {
		Connection conn=getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		int result1=0;
		int result2=0;
	
		
		//bId에 해당하는 게시글을 수정.
		result1=bDAO.updateBoard(conn, board, bId); 
		
		if(result1>0) {
			//게시글 수정성공
			if(board.getBoardImgPath()!=null) {
				//bId에 해당하는 이미지가 존재하면
				result2=bDAO.updateBoardAttachment(conn, bat, bId); //bId에 해당하는 이미지를 수정.
			}
			
			commit(conn);
		}else {
			//게시글 수정실패
			rollback(conn);
		}
		close(conn);
		return result1+result2;
	}
}
