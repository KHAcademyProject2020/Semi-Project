package reservation.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import reservation.model.service.ReservationService;
import reservation.model.vo.ReservationInfo;
import reservation.model.vo.Review;
import team.model.vo.PageInfo;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/review.me")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch_num = request.getParameter("branch_num");
		int listCount = 0;
		int currentPage;
		int pageLimit;	
		int boardLimit;	
		int maxPage;	
		int startPage;	
		int endPage;	
		
		listCount = new ReservationService().getReviewCount(branch_num);
		
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
		JSONObject userObj = null;
		JSONArray review = null;
		JSONObject userMap = null;
		
		pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		ArrayList<Review> reviewArr = new ReservationService().branchReview(branch_num, pi);
		
		review = new JSONArray();
		userMap = new JSONObject();
		for(int i = 0; i < reviewArr.size(); i++) {

			userObj = new JSONObject();
			userObj.put("review_num", reviewArr.get(i).getReview_num());
			userObj.put("review_email", reviewArr.get(i).getReview_email());
			userObj.put("review_branch_num", reviewArr.get(i).getReview_branch_num());
			userObj.put("review_content", reviewArr.get(i).getReview_content());
			userObj.put("review_point", reviewArr.get(i).getReview_point());
			userObj.put("review_date", reviewArr.get(i).getReview_date());
			userObj.put("review_delete_status", reviewArr.get(i).getReview_delete_status());
			userObj.put("email", reviewArr.get(i).getEmail());
			userObj.put("pwd", reviewArr.get(i).getPwd());
			userObj.put("name", reviewArr.get(i).getName());
			userObj.put("birthday", reviewArr.get(i).getBirthday());
			userObj.put("gender", reviewArr.get(i).getGender());
			userObj.put("phone", reviewArr.get(i).getPhone());
			userObj.put("address", reviewArr.get(i).getAddress());
			userObj.put("member_kakao", reviewArr.get(i).getMember_kakao());
			userObj.put("member_type", reviewArr.get(i).getMember_type());
			userObj.put("member_delete_status", reviewArr.get(i).getMember_delete_status());
			
			review.add(userObj);
			userMap.put("review", review);
			
		}
		userObj = new JSONObject();
		userObj.put("listCount", listCount);
		userObj.put("currentPage", currentPage);
		userObj.put("pageLimit", pageLimit);
		userObj.put("boardLimit", boardLimit);
		userObj.put("maxPage", maxPage);
		userObj.put("startPage", startPage);
		userObj.put("endPage", endPage);
		userMap.put("pi", userObj);
			
		response.setContentType("application/json; charset=UTF-8");		
		new Gson().toJson(userMap, response.getWriter());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
