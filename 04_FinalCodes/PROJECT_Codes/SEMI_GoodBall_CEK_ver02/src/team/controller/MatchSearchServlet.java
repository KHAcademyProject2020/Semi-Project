package team.controller;

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

import team.model.service.TeamService;
import team.model.vo.Match;
import team.model.vo.PageInfo;

/**
 * Servlet implementation class StadiumSearchServlet
 */
@WebServlet("/matchSearch.me")
public class MatchSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String match_name = request.getParameter("match_name");
		String match_gender = request.getParameter("match_gender");
		String match_age = request.getParameter("match_age");
		String match_matchMember = request.getParameter("match_matchMember");
		String date = request.getParameter("date");
		int startTime = Integer.parseInt(request.getParameter("startTime"));
		int endTime = Integer.parseInt(request.getParameter("endTime"));
		System.out.println(match_name);
		System.out.println(match_gender);
		System.out.println(match_age);
		System.out.println(match_matchMember);
		System.out.println(date);
		System.out.println(startTime);
		System.out.println(endTime);
		
		String whereQuery = "SELECT * FROM MATCHREGISTLIST";
		String whereSearchQuery = "SELECT * FROM MATCHREGISTSEARCHLIST";
		String query = "CREATE OR REPLACE VIEW MATCHREGISTSEARCHLIST AS SELECT ROWNUM RNUM, DESCMATCHREGIST.* FROM (SELECT * FROM MATCHREGIST JOIN TEAM ON (REGIST_TEAM = TEAM_CODE) JOIN RESERVATION ON (REGIST_RESERVATION_CODE = RESERVATION_CODE) JOIN BRANCH ON (REGIST_BRANCH_NUM = BRANCH_NUM) JOIN STADIUM ON (REGIST_STADIUM_NUM = STADIUM_NUM) WHERE REGIST_STATUS IN ('Y','N') AND RESERVATION_STATUS='Y' AND RESERVATION_USAGE_START_DATE >= SYSDATE";
		String query2 = " ORDER BY REGIST_NUM DESC) DESCMATCHREGIST";
		
		
		
		String whereQuery2 = "SELECT COUNT(*) FROM MATCHREGISTLIST";

		if(!match_name.equals("")) {
			query += " AND TEAM_NAME LIKE '%"+ match_name +"%'";
			whereQuery2 += " WHERE TEAM_NAME LIKE '%"+ match_name +"%'";
		}
		if(!match_gender.equals("")) {
			if(match_name.equals("")) {
				query += " AND TEAM_GENDER = '"+ match_gender +"'";
				whereQuery2 += " WHERE TEAM_GENDER = '"+ match_gender +"'";
			}else {
				query += " AND TEAM_GENDER = '"+ match_gender +"'";
				whereQuery2 += " AND TEAM_GENDER = '"+ match_gender +"'";
			}
		}
		if(!match_age.equals("")) {
			if(match_name.equals("") && match_gender.equals("")) {
				query += " AND TEAM_AGE = '"+ match_age +"'";
				whereQuery2 += " WHERE TEAM_AGE = '"+ match_age +"'";
			}else {
				query += " AND TEAM_AGE = '"+ match_age +"'";
				whereQuery2 += " AND TEAM_AGE = '"+ match_age +"'";
			}
		}
		if(!match_matchMember.equals("")) {
			if(match_name.equals("") && match_gender.equals("") && match_age.equals("")) {
				query += " AND STADIUM_MATCH_MEMBER = '"+ match_matchMember +"'";
				whereQuery2 += " WHERE STADIUM_MATCH_MEMBER = '"+ match_matchMember +"'";
			}else {
				query += " AND STADIUM_MATCH_MEMBER = '"+ match_matchMember +"'";
				whereQuery2 += " AND STADIUM_MATCH_MEMBER = '"+ match_matchMember +"'";
			}
		}
		if(!date.equals("")) {
			if(match_name.equals("") && match_gender.equals("") && match_age.equals("") && match_matchMember.equals("")) {
				query += " AND RESERVATION_USAGE_START_DATE = '"+ date +"'";
				whereQuery2 += " WHERE RESERVATION_USAGE_START_DATE = '"+ date +"'";
			}else {
				query += " AND RESERVATION_USAGE_START_DATE = '"+ date +"'";
				whereQuery2 += " AND RESERVATION_USAGE_START_DATE = '"+ date +"'";
			}
		}
		if(startTime != 0) {
			if(match_name.equals("") && match_gender.equals("") && match_age.equals("") && match_matchMember.equals("") && date.equals("")) {
				query += " AND (RESERVATION_USAGE_START_TIME >= '"+ startTime +"'";
				whereQuery2 += " WHERE (RESERVATION_USAGE_START_TIME >= '"+ startTime +"'";
			}else {
				query += " AND (RESERVATION_USAGE_START_TIME >= '"+ startTime +"'";
				whereQuery2 += " AND (RESERVATION_USAGE_START_TIME >= '"+ startTime +"'";
			}
		}
		if(endTime != 0) {
			query += " AND RESERVATION_USAGE_END_TIME <= '"+ endTime +"')";
			whereQuery2 += " AND RESERVATION_USAGE_END_TIME <= '"+ endTime +"')";
		}
		
		query += query2;
		
		System.out.println(query);
		
		int listCount = 0;
		int currentPage;
		int pageLimit;	
		int boardLimit;	
		int maxPage;	
		int startPage;	
		int endPage;	
		
		listCount = new TeamService().getMatchSearchCount(whereQuery2);
		System.out.println("listCount:" + listCount);
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
		JSONArray match = null;
		JSONObject userMap = null;
		
		pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		if(match_name.equals("") && match_gender.equals("") && match_age.equals("") && match_matchMember.equals("") && date.equals("") && startTime == 0 && endTime == 0) {
			whereQuery += " WHERE RNUM BETWEEN'"+ startRow +" 'AND' "+ endRow +"'";
			ArrayList<Match> matchArr = new TeamService().selectMatchSearchList(whereQuery);
			
			match = new JSONArray();
			userMap = new JSONObject();
			for(int i = 0; i < matchArr.size(); i++) {
				userObj = new JSONObject();
				userObj.put("regist_num", matchArr.get(i).getRegist_num());
				userObj.put("regist_team", matchArr.get(i).getRegist_team());
				userObj.put("regist_reservation_code", matchArr.get(i).getRegist_reservation_code());
				userObj.put("regist_status", matchArr.get(i).getRegist_status());
				userObj.put("regist_branch_num", matchArr.get(i).getRegist_branch_num());
				userObj.put("regist_stadium_num", matchArr.get(i).getRegist_stadium_num());
				userObj.put("team_code", matchArr.get(i).getTeam_code());
				userObj.put("team_leader", matchArr.get(i).getTeam_leader());
				userObj.put("team_num", matchArr.get(i).getTeam_num());
				userObj.put("team_name", matchArr.get(i).getTeam_name());
				userObj.put("team_gender", matchArr.get(i).getTeam_gender());
				userObj.put("team_age", matchArr.get(i).getTeam_age());
				userObj.put("team_region", matchArr.get(i).getTeam_region());
				userObj.put("team_point", matchArr.get(i).getTeam_point());
				userObj.put("team_mark_img", matchArr.get(i).getTeam_mark_img());
				userObj.put("team_active_lastday", matchArr.get(i).getTeam_active_lastday());
				userObj.put("team_delete_status", matchArr.get(i).getTeam_delete_status());
				userObj.put("reservation_code", matchArr.get(i).getReservation_code());
				userObj.put("reservation_email", matchArr.get(i).getReservation_email());
				userObj.put("reservation_branch_num", matchArr.get(i).getReservation_branch_num());
				userObj.put("reservation_stadium_num", matchArr.get(i).getReservation_stadium_num());
				userObj.put("reservation_num", matchArr.get(i).getReservation_num());
				userObj.put("reservation_price", matchArr.get(i).getReservation_price());
				userObj.put("reservation_usage_start_time", matchArr.get(i).getReservation_usage_start_time());
				userObj.put("reservation_usage_time", matchArr.get(i).getReservation_usage_time());
				userObj.put("reservation_usage_end_time", matchArr.get(i).getReservation_usage_end_time());
				userObj.put("reservation_usage_start_date", matchArr.get(i).getReservation_usage_start_date());
				userObj.put("reservation_status", matchArr.get(i).getReservation_status());
				userObj.put("branch_num", matchArr.get(i).getBranch_num());
				userObj.put("branch_manager_email", matchArr.get(i).getBranch_manager_email());
				userObj.put("branch_address", matchArr.get(i).getBranch_address());
				userObj.put("branch_phone", matchArr.get(i).getBranch_phone());
				userObj.put("branch_img", matchArr.get(i).getBranch_img());
				userObj.put("branch_website", matchArr.get(i).getBranch_website());
				userObj.put("branch_point", matchArr.get(i).getBranch_point());
				userObj.put("branch_option_shower", matchArr.get(i).getBranch_option_shower());
				userObj.put("branch_option_park", matchArr.get(i).getBranch_option_park());
				userObj.put("branch_option_uniform", matchArr.get(i).getBranch_option_uniform());
				userObj.put("branch_option_shoes", matchArr.get(i).getBranch_option_shoes());
				userObj.put("branch_option_ball", matchArr.get(i).getBranch_option_ball());
				userObj.put("branch_option_inout", matchArr.get(i).getBranch_option_inout());
				userObj.put("branch_delete_status", matchArr.get(i).getBranch_delete_status());
				userObj.put("stadium_num", matchArr.get(i).getStadium_num());
				userObj.put("stadium_branch_num", matchArr.get(i).getStadium_branch_num());
				userObj.put("stadium_name", matchArr.get(i).getStadium_name());
				userObj.put("stadium_match_member", matchArr.get(i).getStadium_match_member());
				userObj.put("stadium_reservation_start_time", matchArr.get(i).getStadium_reservation_start_time());
				userObj.put("stadium_reservation_end_time", matchArr.get(i).getStadium_reservation_end_time());
				userObj.put("stadium_delete_status", matchArr.get(i).getStadium_delete_status());
				
				match.add(userObj);
				userMap.put("match", match);
				
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
		
		
		
		}else {
			new TeamService().createMatchView(query);
			whereSearchQuery += " WHERE RNUM BETWEEN'"+ startRow +" 'AND' "+ endRow +"'";		
			ArrayList<Match> matchArr = new TeamService().selectMatchSearchList(whereSearchQuery);
			
			match = new JSONArray();
			userMap = new JSONObject();
			for(int i = 0; i < matchArr.size(); i++) {
				userObj = new JSONObject();
				userObj.put("regist_num", matchArr.get(i).getRegist_num());
				userObj.put("regist_team", matchArr.get(i).getRegist_team());
				userObj.put("regist_reservation_code", matchArr.get(i).getRegist_reservation_code());
				userObj.put("regist_status", matchArr.get(i).getRegist_status());
				userObj.put("regist_branch_num", matchArr.get(i).getRegist_branch_num());
				userObj.put("regist_stadium_num", matchArr.get(i).getRegist_stadium_num());
				userObj.put("team_code", matchArr.get(i).getTeam_code());
				userObj.put("team_leader", matchArr.get(i).getTeam_leader());
				userObj.put("team_num", matchArr.get(i).getTeam_num());
				userObj.put("team_name", matchArr.get(i).getTeam_name());
				userObj.put("team_gender", matchArr.get(i).getTeam_gender());
				userObj.put("team_age", matchArr.get(i).getTeam_age());
				userObj.put("team_region", matchArr.get(i).getTeam_region());
				userObj.put("team_point", matchArr.get(i).getTeam_point());
				userObj.put("team_mark_img", matchArr.get(i).getTeam_mark_img());
				userObj.put("team_active_lastday", matchArr.get(i).getTeam_active_lastday());
				userObj.put("team_delete_status", matchArr.get(i).getTeam_delete_status());
				userObj.put("reservation_code", matchArr.get(i).getReservation_code());
				userObj.put("reservation_email", matchArr.get(i).getReservation_email());
				userObj.put("reservation_branch_num", matchArr.get(i).getReservation_branch_num());
				userObj.put("reservation_stadium_num", matchArr.get(i).getReservation_stadium_num());
				userObj.put("reservation_num", matchArr.get(i).getReservation_num());
				userObj.put("reservation_price", matchArr.get(i).getReservation_price());
				userObj.put("reservation_usage_start_time", matchArr.get(i).getReservation_usage_start_time());
				userObj.put("reservation_usage_time", matchArr.get(i).getReservation_usage_time());
				userObj.put("reservation_usage_end_time", matchArr.get(i).getReservation_usage_end_time());
				userObj.put("reservation_usage_start_date", matchArr.get(i).getReservation_usage_start_date());
				userObj.put("reservation_status", matchArr.get(i).getReservation_status());
				userObj.put("branch_num", matchArr.get(i).getBranch_num());
				userObj.put("branch_manager_email", matchArr.get(i).getBranch_manager_email());
				userObj.put("branch_address", matchArr.get(i).getBranch_address());
				userObj.put("branch_phone", matchArr.get(i).getBranch_phone());
				userObj.put("branch_img", matchArr.get(i).getBranch_img());
				userObj.put("branch_website", matchArr.get(i).getBranch_website());
				userObj.put("branch_point", matchArr.get(i).getBranch_point());
				userObj.put("branch_option_shower", matchArr.get(i).getBranch_option_shower());
				userObj.put("branch_option_park", matchArr.get(i).getBranch_option_park());
				userObj.put("branch_option_uniform", matchArr.get(i).getBranch_option_uniform());
				userObj.put("branch_option_shoes", matchArr.get(i).getBranch_option_shoes());
				userObj.put("branch_option_ball", matchArr.get(i).getBranch_option_ball());
				userObj.put("branch_option_inout", matchArr.get(i).getBranch_option_inout());
				userObj.put("branch_delete_status", matchArr.get(i).getBranch_delete_status());
				userObj.put("stadium_num", matchArr.get(i).getStadium_num());
				userObj.put("stadium_branch_num", matchArr.get(i).getStadium_branch_num());
				userObj.put("stadium_name", matchArr.get(i).getStadium_name());
				userObj.put("stadium_match_member", matchArr.get(i).getStadium_match_member());
				userObj.put("stadium_reservation_start_time", matchArr.get(i).getStadium_reservation_start_time());
				userObj.put("stadium_reservation_end_time", matchArr.get(i).getStadium_reservation_end_time());
				userObj.put("stadium_delete_status", matchArr.get(i).getStadium_delete_status());
				
				match.add(userObj);
				userMap.put("match", match);
				
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
		}
		
		System.out.println(startRow);
		System.out.println(endRow);
	
			
		
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
