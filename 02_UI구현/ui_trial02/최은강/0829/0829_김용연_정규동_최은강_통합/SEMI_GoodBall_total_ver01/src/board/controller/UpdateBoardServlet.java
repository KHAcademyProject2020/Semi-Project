package board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.BoardAttachment;
import common.BoardImgFileRenamePolicy;
import member.model.vo.Member;


@WebServlet("/updateBoard.bo")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result=0;
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize= 1024*1024*10; //10MB
			String root=request.getSession().getServletContext().getRealPath("/");
			String saveBoardPath=root+"/resources/storage/board_img/";
			
			MultipartRequest multiRequest=new MultipartRequest(request, saveBoardPath, maxSize, "UTF-8", new BoardImgFileRenamePolicy() );
			File file=new File(saveBoardPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			
			String saveFile=null;
			String originFile=null;
			Enumeration<String> files= multiRequest.getFileNames();
			if(files.hasMoreElements()) {
				String name= files.nextElement();
				
				if(multiRequest.getFilesystemName(name)!=null) {
					saveFile=multiRequest.getFilesystemName(name);
					originFile=multiRequest.getOriginalFileName(name);
				}
			}
			
			
			//폼에서 입력받은 값들을 모두 갖고온다.
			//게시글번호: bId
			int bId= Integer.parseInt(multiRequest.getParameter("bId"));
			
			//제목:title
			String title=multiRequest.getParameter("title");
			
			//내용: content
			String content=multiRequest.getParameter("content");
			
			//작성자 이메일, 이름.
			String email=((Member) request.getSession().getAttribute("loginUser")).getEmail();
			String name=((Member) request.getSession().getAttribute("loginUser")).getName();
			
			
			Board board=new Board();
			board.setBoardNum(bId);
			board.setBoardTitle(title);
			board.setBoardContent(content);
			board.setBoardWriter(name);
			board.setBoardWriterEmail(email);

			//수정날짜로 갱신
			Date date=new Date(new GregorianCalendar().getTimeInMillis());
			board.setBoardDate(date);
			
			//이미지: img
			BoardAttachment bat= new BoardAttachment();
			bat.setFilePath(saveBoardPath);
			bat.setOriginName(originFile);
			bat.setChangeName(saveFile);
			bat.setUpdateDate(date);
			
			//이미지 이름
			board.setBoardImgPath(originFile);
			
			result=new BoardService().updateBoard(board, bId, bat);
			
			System.out.println("bId=> "+bId);
			System.out.println("UpdateBoard/updateBoard.bo\n게시판=>"+board);
			System.out.println("게시판이미지 =>"+bat);
			
			if(result>0) {
				response.sendRedirect("detailBoard.bo?bId="+bId);
			}else {
				File failedFile=new File(saveBoardPath+ saveFile);
				failedFile.delete();
				request.setAttribute("msg", "공지사항 게시판 게시글 수정에 실패하였습니다.");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
