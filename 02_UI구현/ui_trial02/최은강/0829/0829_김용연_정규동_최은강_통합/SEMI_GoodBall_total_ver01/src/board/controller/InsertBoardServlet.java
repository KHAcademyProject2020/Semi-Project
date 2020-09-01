package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/insertBoard.bo")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize=1024*1024*10; //10MB;
			String root= request.getSession().getServletContext().getRealPath("/"); // \WebContent\
			String saveBoardPath= root+"/resources/storage/board_img/"; //공지사항 게시판 파일 저장소
			
			// BoardImgFileRenamePolicy() => 공지사항게시판 이미지 이름 변경 방법.
			MultipartRequest multiRequest= new MultipartRequest(request, saveBoardPath, maxSize,"UTF-8", new BoardImgFileRenamePolicy() );
			File file=new File(saveBoardPath);
			
			// saveBoadPath에 해당하는 디렉토리가 존재하지 않는다면
			if(!file.exists()) {
				file.mkdirs();
			}
			
			//바뀐 파일이름을 저장하는 ArrayList
			ArrayList<String> saveFiles = new ArrayList<String>();
			
			//원본파일이름을 저장하는 ArrayList
			ArrayList<String> originFiles= new ArrayList<String>();
			
			//getFileName(): 폼에서 전송된 File의 이름을 위의 규정대로 변환
			Enumeration<String> files= multiRequest.getFileNames();
			while(files.hasMoreElements()) {
				String name= files.nextElement();
				
				if(multiRequest.getFilesystemName(name)!=null) {
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
				}
			}
			
			// 입력한 데이터를 String 형태로 변환
			//제목 "title"
			String title= multiRequest.getParameter("title"); //제목-title - BOARD_TITLE
			String content= multiRequest.getParameter("content"); //내용-content - BOARD_CONTENT
			String email=((Member) request.getSession().getAttribute("loginUser")).getEmail();
			String name=((Member)request.getSession().getAttribute("loginUser")).getName(); //이름- BOARD_WRITER
			
			Board board= new Board();
			board.setBoardTitle(title);
			board.setBoardWriter(name);
			board.setBoardContent(content);
			board.setBoardWriterEmail(email);
			
			
			
			ArrayList<BoardAttachment> fileList= new ArrayList<BoardAttachment>();
			for(int i=originFiles.size()-1; i>=0; i--) {
				BoardAttachment bat= new BoardAttachment();
				bat.setFilePath(saveBoardPath);
				bat.setOriginName(originFiles.get(i));
				bat.setChangeName(saveFiles.get(i));
				
				//이미지이름
				board.setBoardImgPath(originFiles.get(i));
				
				fileList.add(bat);
			}
			
			System.out.println(board);
			
			int result= new BoardService().insertBoard(board, fileList);
			if(result>0) {
				response.sendRedirect("showBoardList.bo");
			}else {
				for(int i=0; i<saveFiles.size(); i++) {
					File failedFile=new File(saveBoardPath+saveFiles.get(i));
					failedFile.delete();
				}
				
				request.setAttribute("msg", "공지 게시판 게시글 등록에 실패하였습니다.");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
			
		}else {
			request.setCharacterEncoding("UTF-8");
			String title=request.getParameter("title");
			String email=((Member)request.getSession().getAttribute("loginUser")).getEmail();
			String content= request.getParameter("content");
			String name=((Member)request.getSession().getAttribute("loginUser")).getName();
			
			Board board= new Board();
			board.setBoardContent(content);
			board.setBoardTitle(title);
			board.setBoardWriter(name);
			board.setBoardWriterEmail(email);
			
			int result=new BoardService().insertBoard(board, null);
			if(result>0) {
				response.sendRedirect("showBoardList.bo");
				
			}else {
				request.setAttribute("msg", "공지사항 등록에 실패하였습니다.");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
				view.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
