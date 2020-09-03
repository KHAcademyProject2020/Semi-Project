package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.BoardAttachment;

/**
 * Servlet implementation class UpdateBoardFormServlet
 */
@WebServlet("/updateBoardForm.bo")
public class UpdateBoardFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBoardFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bId=Integer.parseInt(request.getParameter("bId"));
		//bId에 해당하는 Board와 Attachment를 구한다.
		
		Board board= new BoardService().selectBoard(bId);
		BoardAttachment img= null;
		
		String page=null;
		if(board!=null) {
			page="WEB-INF/views/board/boardUpdateForm.jsp";
			
			//게시판과 이미지를 세팅
			request.setAttribute("board", board);
			request.setAttribute("img", img);
	
		}else {
			page="WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 수정에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
