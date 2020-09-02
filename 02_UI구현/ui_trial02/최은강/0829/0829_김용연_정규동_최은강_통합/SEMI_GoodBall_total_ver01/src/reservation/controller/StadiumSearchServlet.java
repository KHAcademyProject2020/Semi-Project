package reservation.controller;

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

import reservation.model.service.ReservationService;
import reservation.model.vo.Stadium;
import team.model.vo.PageInfo;

@WebServlet("/stadiumSearch.me")
public class StadiumSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StadiumSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branch_num = request.getParameter("branch_num");
		String branch_address = request.getParameter("branch_address");
		String stadium_matchMember = request.getParameter("stadium_matchMember");
		int startTime = Integer.parseInt(request.getParameter("startTime"));
		int endTime = Integer.parseInt(request.getParameter("endTime"));
		System.out.println(branch_num);
		System.out.println(branch_address);
		System.out.println(stadium_matchMember);
		System.out.println(startTime);
		System.out.println(endTime);
		
		String whereQuery = "SELECT * FROM STADIUMLIST";
		String whereQuery2 = "SELECT COUNT(*) FROM STADIUMLIST";

		if(!branch_num.equals("")) {
			whereQuery += " WHERE STADIUM_BRANCH_NUM LIKE '%"+ branch_num +"%'";
			whereQuery2 += " WHERE STADIUM_BRANCH_NUM LIKE '%"+ branch_num +"%'";
		}
		if(!branch_address.equals("")) {
			if(branch_num.equals("")) {
				whereQuery += " WHERE BRANCH_ADDRESS LIKE '%"+ branch_address +"%'";
				whereQuery2 += " WHERE BRANCH_ADDRESS LIKE '%"+ branch_address +"%'";
			}else {
				whereQuery += " AND BRANCH_ADDRESS LIKE '%"+ branch_address +"%'";
				whereQuery2 += " AND BRANCH_ADDRESS LIKE '%"+ branch_address +"%'";
			}
		}
		if(!stadium_matchMember.equals("")) {
			if(branch_num.equals("") && branch_address.equals("")) {
				whereQuery += " WHERE STADIUM_MATCH_MEMBER = '"+ stadium_matchMember +"'";
				whereQuery2 += " WHERE STADIUM_MATCH_MEMBER = '"+ stadium_matchMember +"'";
			}else {
				whereQuery += " AND STADIUM_MATCH_MEMBER = '"+ stadium_matchMember +"'";
				whereQuery2 += " AND STADIUM_MATCH_MEMBER = '"+ stadium_matchMember +"'";
			}
		}
		if(startTime != 0) {
			if(branch_num.equals("") && branch_address.equals("") && stadium_matchMember.equals("")) {
				whereQuery += " WHERE (STADIUM_RESERVATION_START_TIME >= '"+ startTime +"'";
				whereQuery2 += " WHERE (STADIUM_RESERVATION_START_TIME >= '"+ startTime +"'";
			}else {
				whereQuery += " AND (STADIUM_RESERVATION_START_TIME >= '"+ startTime +"'";
				whereQuery2 += " AND (STADIUM_RESERVATION_START_TIME >= '"+ startTime +"'";
			}
		}
		if(endTime != 0) {
			whereQuery += " AND STADIUM_RESERVATION_END_TIME <= '"+ endTime +"')";
			whereQuery2 += " AND STADIUM_RESERVATION_END_TIME <= '"+ endTime +"')";
		}
		
		int listCount = 0;
		int currentPage;
		int pageLimit;	
		int boardLimit;	
		int maxPage;	
		int startPage;	
		int endPage;	
		
		listCount = new ReservationService().getStadiumSearchCount(whereQuery2);
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
		JSONArray stadium = null;
		JSONObject userMap = null;
		
		pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		if(branch_num.equals("") && branch_address.equals("") && stadium_matchMember.equals("") && startTime == 0 && endTime == 0) {
			whereQuery += " WHERE RNUM BETWEEN'"+ startRow +" 'AND' "+ endRow +"'";
		}else {
			whereQuery += " AND RNUM BETWEEN'"+ startRow +" 'AND' "+ endRow +"'";			
		}
		
		ArrayList<Stadium> stadiumArr = new ReservationService().selectStadiumSearchList(whereQuery);
		System.out.println(stadiumArr);
		
		stadium = new JSONArray();
		userMap = new JSONObject();
		for(int i = 0; i < stadiumArr.size(); i++) {
			userObj = new JSONObject();
			userObj.put("stadium_num", stadiumArr.get(i).getStadium_num());
			userObj.put("branch_num", stadiumArr.get(i).getBranch_num());
			userObj.put("stadium_name", stadiumArr.get(i).getStadium_name());
			userObj.put("stadium_match_member", stadiumArr.get(i).getStadium_match_member());
			userObj.put("stadium_reservation_start_time", stadiumArr.get(i).getStadium_reservation_start_time());
			userObj.put("stadium_reservation_end_time", stadiumArr.get(i).getStadium_reservation_end_time());
			userObj.put("branch_manager_email", stadiumArr.get(i).getBranch_manager_email());
			userObj.put("branch_address", stadiumArr.get(i).getBranch_address());
			userObj.put("branch_phone", stadiumArr.get(i).getBranch_phone());
			userObj.put("branch_img", stadiumArr.get(i).getBranch_img());
			userObj.put("branch_website", stadiumArr.get(i).getBranch_website());
			userObj.put("branch_point", stadiumArr.get(i).getBranch_point());
			userObj.put("branch_option_shower", stadiumArr.get(i).getBranch_option_shower());
			userObj.put("branch_option_park", stadiumArr.get(i).getBranch_option_park());
			userObj.put("branch_option_uniform", stadiumArr.get(i).getBranch_option_uniform());
			userObj.put("branch_option_shoes", stadiumArr.get(i).getBranch_option_shoes());
			userObj.put("branch_option_ball", stadiumArr.get(i).getBranch_option_ball());
			userObj.put("branch_option_inout", stadiumArr.get(i).getBranch_option_inout());
			
			stadium.add(userObj);
			userMap.put("stadium", stadium);
			//userMap.put("teamMember-" + teamMember.getEmail(), userObj);
			
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
		//JSONObject result = new JSONObject();
		//result.put("memberArr", memberArr);
			
		
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
