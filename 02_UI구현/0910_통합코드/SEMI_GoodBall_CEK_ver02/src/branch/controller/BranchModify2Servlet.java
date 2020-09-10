package branch.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import branch.model.service.BranchService;
import branch.model.vo.Branch;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class BranchModify2Servlet
 */
@WebServlet("/modifyBranch2.br")
public class BranchModify2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchModify2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getEmail();
		String root = request.getSession().getServletContext().getRealPath("/");
	     //String savePath = root + "resources/storage/"+userId;
	    String savePath = "/Users/dennis/Desktop/GB_total2/SEMI_GoodBall_CEK/WebContent/resources/storage/"+userId+"/branch_img";
	      File f = new File(savePath);
	      if(!f.exists()) {
	         f.mkdirs();
	      }
	     //String savePath2 = root + "resources/storage/"+userId+"/";
	     String savePath2 = "/Users/dennis/Desktop/GB_total2/SEMI_GoodBall_CEK/WebContent/resources/storage/"+userId+"/branch_img";
	       
	      int maxSize = 1024 * 1024 * 10;
	      MultipartRequest multiRequest = new MultipartRequest(request, savePath2, maxSize, "UTF-8", new MyFileRenamePolicy());
		
		
		String num = multiRequest.getParameter("branchName");
		String placeInfo = multiRequest.getParameter("placeInfo");
		String detailInfo = multiRequest.getParameter("detailInfo");
		String shower = multiRequest.getParameter("shower");
		String parking = multiRequest.getParameter("parking");
		String uniform = multiRequest.getParameter("uniform");
		String shoes = multiRequest.getParameter("shoes");
		String ball = multiRequest.getParameter("ball");
		String place = multiRequest.getParameter("place");
		String notes = multiRequest.getParameter("notes");
		String sns = multiRequest.getParameter("sns");
		String branch_img = multiRequest.getParameter("fileName");
		String phone = multiRequest.getParameter("phone");
		
		  String address2 = multiRequest.getParameter("address2");
	      String address3 = multiRequest.getParameter("address3");
	      String address4 = multiRequest.getParameter("address4");
	      String address5 = multiRequest.getParameter("address5");
	      
	      ArrayList<String> addressArr = new ArrayList<String>();

	      addressArr.add(address2);
	      addressArr.add(address3);
	      addressArr.add(address4);
	      addressArr.add(address5);

	      String branch_address  = "";
	      for (int i = 0; i < addressArr.size(); i++) {

	         if (i == addressArr.size() - 1) {
	            branch_address  += addressArr.get(i);

	         } else {
	            branch_address  += addressArr.get(i) + " ";

	         }
	      }      
	
		Branch branch = new Branch(num, branch_address, phone, branch_img, sns, placeInfo, detailInfo, notes, shower, parking, uniform, shoes, ball, place);
		
		int result = new BranchService().branchUpdate(branch);
		
		if(result > 0) {
			request.setAttribute("branch", branch);
			request.getRequestDispatcher("WEB-INF/views/member/manager/Manager_BranchModiPage.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "수정되지 않았습니다");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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
