package team.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class FIleUploadServlet
 */
@WebServlet("/fileUpload.me")
public class FIleUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FIleUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxSize = 1024 * 1024 * 10;
		String root = request.getSession().getServletContext().getRealPath("/");
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getEmail();
		String savePath = root + "resources/storage/general/" + userId + "/";
//		System.out.println(savePath);
		
		File f = new File(savePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		ArrayList<String> saveFiles = new ArrayList<String>();		// 바뀐 파일의 이름을 저장할 ArrayList
		ArrayList<String> originFiles = new ArrayList<String>(); 	// 원본 파일의 이름을 저장할 ArrayList
		
		Enumeration<String> files = multiRequest.getFileNames(); // getFileName() : 폼에서 전송된 File의 name반환
		while(files.hasMoreElements()) {
			String name = files.nextElement();
			
			if(multiRequest.getFilesystemName(name) != null) { // getFilesystemName(): RenamePolicy의 rename()에서 작성한대로 rename된 파일 명
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
			}
		}
		
		for (int i = 0; i < saveFiles.size(); i++) {
			File failedFile = new File(savePath + saveFiles.get(i));
			failedFile.delete();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
