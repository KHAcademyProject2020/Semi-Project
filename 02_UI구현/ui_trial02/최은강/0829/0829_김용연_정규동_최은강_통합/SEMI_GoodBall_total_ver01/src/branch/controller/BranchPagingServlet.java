package branch.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import branch.model.service.BranchService;
import branch.model.vo.Branch;
import reservation.model.service.ReservationService;
import reservation.model.vo.PageInfo;

/**
 * Servlet implementation class BranchPagingServlet
 */
@WebServlet("/branchPaging.br")
public class BranchPagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchPagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String page = request.getParameter("page");
		
		int listCount;		// 총 게시글 개수
		int currentPage;	// 현재 페이지(URL에 노출)
		int pageLimit;		// 한 페이지에서 표시될 페이징 수
		int boardLimit;		// 한 페이지에서 보일 게시글 최대 개수
		int maxPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 된 페이지 중 시작 페이지
		int endPage;		// 페이징 된 페이지 중 마지막 페이지
		
		// 1페이지에 목록에 나타내기
		//뷰에는 로우 넘버 조건절
		//생성한 뷰를 갖고와서 페이징처리.. -마이페이지에서 지점.	
		String query= "CREATE OR REPLACE VIEW BRANCHLIST AS SELECT ROWNUM RNUM, DESCBRANCH.* FROM (SELECT * FROM BRANCH WHERE BRANCH_DELETE_STATUS = 'N' AND BRANCH_MANAGER_EMAIL="+ "'"+ userId+"'" +"ORDER BY BRANCH_NUM DESC) DESCBRANCH";
		
		System.out.println(query);
		
		
		listCount = new BranchService().getBranchCount(userId);
		
		currentPage = 1;
		if(request.getParameter("page") != null) {
	         currentPage = Integer.parseInt(request.getParameter("page"));
	      }
		pageLimit = 5;
		boardLimit = 5;
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
	    startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
	    endPage = startPage + pageLimit - 1;
	    if(maxPage < endPage) {
	       endPage = maxPage;
	    }
	    
	    PageInfo pi = null;
	    JSONObject branchObj = null;
	    JSONArray branchArray = null;
	    JSONObject branchMap = null;
	    
	    new BranchService().createBranchView(query);
	    
	    pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
	    ArrayList<Branch> branchArr = new BranchService().selectBranchList(pi);
	    
	    branchArray = new JSONArray();
	    branchMap = new JSONObject();
	    for(int i = 0; i < branchArr.size(); i++) {
	    	branchObj = new JSONObject();
	    	branchObj.put("branch_num", branchArr.get(i).getBranch_num());
	    	branchObj.put("branch_manager_email", branchArr.get(i).getBranch_manager_email());
	    	branchObj.put("branch_address", branchArr.get(i).getBranch_address());
	    	branchObj.put("branch_phone", branchArr.get(i).getBranch_phone());
	    	branchObj.put("branch_img", branchArr.get(i).getBranch_img());
	    	branchObj.put("branch_website", branchArr.get(i).getBranch_website());
	    	branchObj.put("branch_point", branchArr.get(i).getBranch_point());
	    	branchObj.put("branch_option_shower", branchArr.get(i).getBranch_option_shower());
	    	branchObj.put("branch_option_park", branchArr.get(i).getBranch_option_park());
	    	branchObj.put("branch_option_uniform", branchArr.get(i).getBranch_option_uniform());
	    	branchObj.put("branch_option_shoes", branchArr.get(i).getBranch_option_shoes());
	    	branchObj.put("branch_option_ball", branchArr.get(i).getBranch_option_ball());
	    	branchObj.put("branch_option_inout", branchArr.get(i).getBranch_option_inout());
	    	branchObj.put("branch_delete_status", branchArr.get(i).getBranch_delete_status());
	    	branchObj.put("branch_Info", branchArr.get(i).getBranch_Info());
	    	branchObj.put("detail_Info", branchArr.get(i).getDetail_Info());
	    	branchObj.put("notes", branchArr.get(i).getNotes());
	    	
	    	branchArray.add(branchObj);
	    	branchMap.put("branchArray", branchArray);
	    	
	    }
	    
	    branchObj = new JSONObject();
	    branchObj.put("listCount", listCount);
	    branchObj.put("currentPage", currentPage);
	    branchObj.put("pageLimit", pageLimit);
	    branchObj.put("boardLimit", boardLimit);
	    branchObj.put("maxPage", maxPage);
	    branchObj.put("startPage", startPage);
	    branchObj.put("endPage", endPage);
	    branchMap.put("pi", branchObj);
	    
	    response.setContentType("application/json; charset=UTF-8");      
	    new Gson().toJson(branchMap, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
