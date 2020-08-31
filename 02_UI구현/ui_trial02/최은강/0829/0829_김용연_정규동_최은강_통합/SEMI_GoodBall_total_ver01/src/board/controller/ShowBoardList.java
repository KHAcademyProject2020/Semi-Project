package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

@WebServlet("/showBoardList.bo")
public class ShowBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowBoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Board> boardList= new BoardService().selectBoardList();
		String page=null;
		if(boardList!=null) {
			page="WEB-INF/views/board/boardList.jsp";
			request.setAttribute("boardLists", boardList);
		}else {
			page="WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 게시판 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
